/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends Forwarder {

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

        nextView = "/index.jsp";
        String username = request.getParameter("regusername");
        String password = request.getParameter("regpassword");
        String password2 = request.getParameter("regcnfmpassword");
        String firstname = request.getParameter("regfirstname");
        String lastname = request.getParameter("reglastname");
        String email = request.getParameter("regemail");
        String age = request.getParameter("regage");
        String gender = request.getParameter("reggender");
        User register = new User(username, password, password2, firstname, lastname, email, age, gender);
        try {
            register.insertRegister();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        forwardTo(nextView, request, response);
    }
}
