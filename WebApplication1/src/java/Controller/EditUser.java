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
import java.util.ArrayList;
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
 * @author perezcx
 */
@WebServlet(name = "edituser", urlPatterns = {"/edituser"})
public class EditUser extends Forwarder {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String nextView = "/";

        nextView = "/userinfo.jsp";

        String username = (String) session.getAttribute("username");
        String firstname = request.getParameter("editfirstname");
        String lastname = request.getParameter("editlastname");
        String email = request.getParameter("editemail");
        String age = request.getParameter("editage");
        String gender = request.getParameter("editgender");
        ArrayList<Integer> categories = new ArrayList<>();

        if (request.getParameter("checkeditmovies") == null) {
            categories.add(0);
        } else {
            categories.add(1);
        }
        if (request.getParameter("checkeditsports") == null) {
            categories.add(0);
        } else {
            categories.add(1);
        }
        if (request.getParameter("checkedittech") == null) {
            categories.add(0);
        } else {
            categories.add(1);
        }
        if (request.getParameter("checkeditnews") == null) {
            categories.add(0);
        } else {
            categories.add(1);
        }
        if (request.getParameter("checkeditstreaming") == null) {
            categories.add(0);
        } else {
            categories.add(1);
        }
        User edituser = new User(username, firstname, lastname, email, age, gender, categories);
        try {
            edituser.editRegister();
        } catch (SQLException ex) {
            Logger.getLogger(EditUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        for (Integer category : categories) {
            System.out.println(category);
        }*/
        forwardTo(nextView, request, response);
    }

}
