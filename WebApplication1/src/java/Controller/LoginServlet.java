/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Authentication;
import Model.CategoryList;
import Model.Credentials;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession(true);
        String nextView = "/";
        String userid = request.getParameter("loginusername");
        String password = request.getParameter("loginpassword");
        Authentication authentication = new Authentication(userid, password);
        try {
            if (authentication.authenticate()) {
                nextView = "/userinfo.jsp";

                session.setAttribute("logged_in", true);
                Credentials credential = authentication.getCredentials();
                CategoryList obj = new CategoryList();
                ArrayList<String> catList = obj.getCategories();

                session.setAttribute("username", credential.getUsername());
                session.setAttribute("firstname", credential.getFirstname());
                session.setAttribute("lastname", credential.getLastname());
                session.setAttribute("age", credential.getAge());
                session.setAttribute("email", credential.getEmail());
                session.setAttribute("gender", credential.getGender());

                for (int i = 0; i < catList.size(); i++) {
                    session.setAttribute(catList.get(i), credential.getCategories().get(i));
                }
            } else {
                System.out.println("fail"); //Handle here if login fails
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        forwardTo(nextView, request, response);
    }
}
