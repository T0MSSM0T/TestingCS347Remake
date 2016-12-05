/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.GMailAuthenticator;
import Model.Credentials;
import Model.Authentication;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author perezcx
 */
@WebServlet(name = "Controller", urlPatterns = {"/control"})
public class Controller extends HttpServlet {

    /**
     * Handle an HTTP POST transaction for a drop or add.
     *
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
                String to = "hirstrb@dukes.jmu.edu";
                String from = "easyefo@gmail.com";
                Properties properties = System.getProperties();
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.user", "rmbh4211995@gmail.com"); // User name
                properties.put("mail.smtp.password", "H@Lo4211995"); // password
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.auth", "true");
                Session session = Session.getInstance(properties, new GMailAuthenticator("rmbh4211995@gmail.com", "H@Lo4211995"));

                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    message.setSubject("Password Recovery");
                    BodyPart messageBodyPart = new MimeBodyPart();
                    messageBodyPart.setText("You have requested a password reset. Your password is:  ");
                    Multipart multipart = new MimeMultipart();
                    multipart.addBodyPart(messageBodyPart);
                    message.setContent(multipart);
                    Transport.send(message);
                    System.out.println("Email sent successfully.");
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }

                nextView = "/index.jsp";
            } else {
                nextView = "/login.jsp";
            }
            // forward to w/e View component

        }

    }
}
