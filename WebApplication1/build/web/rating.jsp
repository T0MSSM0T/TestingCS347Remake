<%-- 
    Document   : rating
    Created on : Dec 11, 2016, 8:08:16 PM
    Author     : hirstrb
--%>

<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/landing-page.css" rel="stylesheet">
        <title>Rating Page</title>
    </head>
    <body>
        <%
            try {
                Boolean loggedIn = (Boolean) session.getAttribute("logged_in");
                if (loggedIn == null || !loggedIn) {
                    response.sendRedirect(request.getContextPath());   // go to the home page
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        %>

    <body>
        <div class="intro-header">
            <div class="container">
                <form action="RatingServlet" method="POST">
                    <select name="starRating" style="color:black;">
                        <option value="1">1 Stars</option>
                        <option value="2">2 Stars</option>
                        <option value="3">3 Stars</option>
                        <option value="4">4 Stars</option>
                        <option value="5">5 Stars</option>
                    </select> 
                    <input type="submit" name="action" value="Rate" class="btn btn-primary btn-lg btn-block" />
                </form>
            </div>
        </div>
    </body>
</body>
</html>
