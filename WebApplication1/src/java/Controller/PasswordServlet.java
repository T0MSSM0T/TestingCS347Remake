/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hirstrb
 */
@WebServlet(name = "PasswordServlet", urlPatterns = {"/PasswordServlet"})
public class PasswordServlet extends Forwarder {
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nextView = "/userinfo.jsp";
        
        try {
            HttpSession session = request.getSession();
            String username = session.getAttribute("username").toString();
            
            String newPass = request.getParameter("confPass");
            
            User user = new User();
            user.setUsername(username);
            user.editPassword(encodePassword(newPass));
        } catch (SQLException ex) {
            Logger.getLogger(PasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        forwardTo(nextView, request, response);
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
