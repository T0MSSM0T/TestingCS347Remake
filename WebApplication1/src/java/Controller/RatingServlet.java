/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Rating;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author hirstrb
 */
@WebServlet(name = "RatingServlet", urlPatterns = {"/RatingServlet"})
public class RatingServlet extends Forwarder  {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        
        String nextView = "/websiteinfo.jsp";
        
        int ratingID = 1;
        int siteID = (int) session.getAttribute("siteid");
        
        String username = (String) session.getAttribute("username");
        
        int rateVal = Integer.parseInt(request.getParameter("starRating"));
        
        Rating rating = new Rating(ratingID, siteID, username, rateVal);
        try {
            rating.insertRating();
        } catch (SQLException ex) { 
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        forwardTo(nextView, request, response);
    }
}
