/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import Model.CategoryList;
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

        nextView = "/login.jsp";
        String username = request.getParameter("regusername");
        String password = request.getParameter("regpassword");
        String password2 = request.getParameter("regcnfmpassword");

        String firstname = request.getParameter("regfirstname");
        String lastname = request.getParameter("reglastname");
        String email = request.getParameter("regemail");
        String age = request.getParameter("regage");
        String gender = request.getParameter("reggender");
        CategoryList category = new CategoryList();
        ArrayList<String> list;
        ArrayList<Integer> fav = new ArrayList<Integer>();
        try {
            list = category.getCategories();
            for (int i = 0; i < list.size(); i++) {
                if (request.getParameter("check" + list.get(i)) == null || request.getParameter("check" + list.get(i)).equals("false")) {
                    fav.add(0);
                } else {
                    fav.add(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        String hash = encodePassword(password);
        User register = new User(username, hash, hash, firstname, lastname, email, age, gender, fav);
        try {
            register.insertRegister();
        } catch (SQLException ex) {
            Logger.getLogger(EmailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
