/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Website;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "WebsiteServlet", urlPatterns = {"/WebsiteServlet"})
public class WebsiteServlet  extends Forwarder  {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Gets the particular web site information and forward it to websiteinfo.jsp
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nextView = "/websiteinfo.jsp";
        
        String title = request.getParameter("title");
        String link = request.getParameter("link"); 
        int rating = Integer.parseInt(request.getParameter("rating")); 
        int id = Integer.parseInt(request.getParameter("id")); 
        String notes = request.getParameter("notes"); 
         
        session.setAttribute("websitetitle",title);
        session.setAttribute("websitelink",link);
        session.setAttribute("websitenotes",notes);
        session.setAttribute("websiterating",rating);
        session.setAttribute("siteid", id);

        forwardTo(nextView, request, response);
    }

}
