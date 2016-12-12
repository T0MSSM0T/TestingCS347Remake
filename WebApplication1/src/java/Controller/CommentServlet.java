/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Comment;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hirstrb
 */
@WebServlet(name = "CommentServlet", urlPatterns = {"/CommentServlet"})
public class CommentServlet extends Forwarder {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        /**
         * String nextView = "/websiteinfo.jsp"; Website site = (Website)
         * session.getAttribute("website");
         * session.setAttribute("websitetitle",site.getSiteTitle());
         * session.setAttribute("websitelink",site.getHyperLink());
         * //session.setAttribute("websitetitle",site.);get info idk
         * session.setAttribute("websiterating",site.getRating());
         * session.setAttribute("siteid", site.getSiteID());
         *
         */
        // forwardTo(nextView, request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        String nextView = "/websiteinfo.jsp";

        int commentID = 1;
        int siteID = (int) session.getAttribute("siteid");

        String username = (String) session.getAttribute("username");

        String comMade = request.getParameter("commentText");

        Comment comment = new Comment(commentID, siteID, username, comMade);
        try {
            comment.insertComment();
        } catch (SQLException ex) {
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        forwardTo(nextView, request, response);
    }
}
