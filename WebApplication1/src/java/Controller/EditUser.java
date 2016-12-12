/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CategoryList;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author perezcx
 */
@WebServlet(name = "edituser", urlPatterns = {"/edituser"})
public class EditUser extends Forwarder {

    /**
     * Gets attributes from userinfo.jsp and updates the table with the new
     * information 
     * Edit the categories associated withe the user 
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

        session.setAttribute("firstname", firstname);
        session.setAttribute("lastname", lastname);
        session.setAttribute("email", email);
        session.setAttribute("age", age);
        session.setAttribute("gender", gender);

        CategoryList obj = new CategoryList();
        ArrayList<String> catList = new ArrayList<String>();

        ArrayList<Integer> categories = new ArrayList<Integer>();
        try {
            catList = obj.getCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < catList.size(); i++) {
            if (request.getParameter("checkedit" + catList.get(i)) == null) {
                categories.add(0);
                session.setAttribute(catList.get(i), false);
            } else {
                categories.add(1);
                session.setAttribute(catList.get(i), true);
            }
        }

        User edituser = new User(username, firstname, lastname, email, age, gender, categories);
        try {
            edituser.editRegister();
        } catch (SQLException ex) {
            Logger.getLogger(EditUser.class.getName()).log(Level.SEVERE, null, ex);
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
