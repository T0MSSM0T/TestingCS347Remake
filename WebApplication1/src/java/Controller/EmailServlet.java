/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GMailAuthenticator;
import Model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hirstrb
 */
@WebServlet(name = "Controller", urlPatterns = {"/control"})
public class EmailServlet extends Forwarder {

    /**
     * Handles forgotpassoword.jsp and recover the password based on email 
     * @param request The HTTP request object
     * @param response The HTTP response object
     */
    public void service(HttpServletRequest request,
            HttpServletResponse response) throws IOException,
            ServletException {
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");

        String nextView = "/";

        if (action == null) {

        } // register 
        else {
            if (action.equals("Register")) {

            } // login 
            else if (action.equals("Login")) {

            } // forgot password 
            else if (action.equals("Send Password")) {
                String to = request.getParameter("pwdresetemail");
                String from = "easyefo@gmail.com";
                Properties properties = System.getProperties();
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.user", "easyefo@gmail.com"); // User name
                properties.put("mail.smtp.password", "compscience"); // password
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.auth", "true");
                Session session = Session.getInstance(properties, new GMailAuthenticator("easyefo@gmail.com", "compscience"));

                try {
                    User emailUser = new User();
                    emailUser.setEmail(to);
                    Random ran = new Random();
                    int randomint = ran.nextInt(999999999);
                    emailUser.resetPassword(encodePassword(String.valueOf(randomint)));
                    
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    message.setSubject("Password Recovery");
                    BodyPart messageBodyPart = new MimeBodyPart();
                    messageBodyPart.setText("You have requested a password reset. Your password is: " + randomint);
                    Multipart multipart = new MimeMultipart();
                    multipart.addBodyPart(messageBodyPart);
                    message.setContent(multipart);
                    Transport.send(message);
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                } catch (SQLException ex) {
                    Logger.getLogger(EmailServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                nextView = "/index.jsp";
            } else {
                nextView = "/login.jsp";
            }
            // forward to w/e View component
            forwardTo(nextView, request, response);
        }

    }
    
    private static String encodePassword(String password) {
        try {
            byte[] bytes = password.getBytes("UTF-8");
            bytes = MessageDigest.getInstance("MD5").digest(bytes);
            Formatter f = new Formatter();
            for (byte b : bytes) {
                f.format("%02x", b);
            }
            return f.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
