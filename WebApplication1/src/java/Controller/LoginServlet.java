/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Authentication;
import Model.Credentials;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author schieftg
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends Forwarder {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nextView = "/";
        String userid = request.getParameter("loginusername");
        String password = request.getParameter("loginpassword");
        Authentication authentication = new Authentication(userid, password);
        try {
            if (authentication.authenticate()) {
                System.out.println("Succes");
                nextView = "/userinfo.jsp";
                Credentials credential = authentication.getCredentials();
                request.setAttribute("username", credential.getUsername());
                request.setAttribute("firstname", credential.getFirstname());
                request.setAttribute("lastname", credential.getLastname());
                request.setAttribute("age", credential.getAge());
                request.setAttribute("email", credential.getEmail());
                request.setAttribute("gender", credential.getGender());

            } else {
                System.out.println("fail"); //Handle here if login fails
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        forwardTo(nextView, request, response);
    }
}