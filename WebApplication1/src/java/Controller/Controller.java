/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        String action = request.getParameter("action");

        String nextView = "/";

        if (action == null) {

        } else {
            if (action.equals("Register")) {
                nextView = "/index.jsp";
                String username = request.getParameter("regusername");
                String password = request.getParameter("regpassword");
                String password2 = request.getParameter("regcnfmpassword");
                String firstname = request.getParameter("regfirstname");
                String lastname = request.getParameter("reglastname");
                String email = request.getParameter("regemail");
                String age = request.getParameter("regage");
                String gender = request.getParameter("reggender");
                Register register = new Register(username, password, password2, firstname, lastname, email, age, gender);
                try {
                    register.insertRegister();
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (action.equals("Login")) {
                nextView = "/index.jsp";
            } else if (action.equals("Send Password")) {
                nextView = "/index.jsp";
            }
            else {
                nextView = "/login.jsp";
            }
            // forward to w/e View component
            forwardTo(nextView, request, response);
        }

    }

    /**
     * Clean input by removing quotes, and optionally blanks.
     *
     * @param input The input to be cleaned
     * @param removeBlanks If true, all blanks are removed from the input
     * @return A cleaned version of the input
     */
    private String filter(String input, boolean removeBlanks) {
        if (input != null) {
            input = input.replace("'", "").replace("\"", "");
            if (removeBlanks) {
                input = input.replace(" ", "");
            }
        }
        return input;
    }

    /**
     * Forward a request to another component.
     *
     * @param url The url of the component to forward to
     * @param request The HttpRequest object
     * @param response The HttpResponse object
     */
    private void forwardTo(String url, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
