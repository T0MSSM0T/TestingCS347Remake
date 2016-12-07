<%-- 
    Document   : shuffle
    Created on : Dec 2, 2016, 1:59:51 PM
    Author     : hirstrb
--%>

<%@page import="Model.Website"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="Model.Website" id="websiteList" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <link href="css/website.css" rel="stylesheet">
        <link rel="shortcut icon" href="logo.png"/>
        <title>Random Shuffle</title>
    </head>
    <body>
        <div>
            <jsp:include page="menubar.jsp"/>
        </div>
        

        <div class="shuffle-style">
            <%
                Random rand = new Random();
                ArrayList<Website> sites = websiteList.getWebsites();
                Integer randomInt = rand.nextInt(sites.size());
                Website chosen = sites.get(randomInt);
                out.print("<iframe height=\"600\" width=\"100%\" align=\"middle\" src=\"https://" + chosen.getIFrame() + "\">" + "</iframe>");
                out.print("<label style=\"padding-top: 1%;\">Random Int:</label>" + " " + randomInt);
                out.print("<hr>");
                out.print("<label>Website:</label>" + " " + chosen.getSiteTitle());
                out.print("<hr>");
                out.print("<label>Ad Count:</label>" + " " + chosen.getAdCount());
                out.print("<hr>");
                out.print("<label>Rating:</label>" + " " + chosen.getRating());    
                out.print("<hr>");
                out.print("<label>Category:</label>" + " " + chosen.getCategoryIDLink());
                out.print("<hr>");
                out.print("<label style=\"padding-bottom: 3%;\">Link:</label>" + " " + "<a href=\"http://"+ chosen.getHyperLink() + "\"style=\"color: blue;\">" + chosen.getSiteTitle() + "</a>");
            %>
        </div>
    </body>
</html>
