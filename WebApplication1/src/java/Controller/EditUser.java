/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author perezcx
 */
@WebServlet(name = "edituser", urlPatterns = {"/edituser"})
public class EditUser extends HttpServlet {

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
    
         String nextView = "/";

        nextView = "/userinfo.jsp";
        String username = request.getParameter("editusername");
        String firstname = request.getParameter("editfirstname");
        String lastname = request.getParameter("editlastname");
        String email = request.getParameter("editemail");
        String age = request.getParameter("editage");
        String gender = request.getParameter("editgender");
    }

 

}
