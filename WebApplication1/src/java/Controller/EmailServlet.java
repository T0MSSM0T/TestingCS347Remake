/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GMailAuthenticator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
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
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }

                nextView = "/index.jsp";
            } else {
                nextView = "/login.jsp";
            }
            // forward to w/e View component
            forwardTo(nextView, request, response);
        }

    }
}
