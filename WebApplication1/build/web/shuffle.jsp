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

        <link rel="shortcut icon" href="logo.png"/>
        <title>Random Shuffle</title>
    </head>
    <body>
        <div>
            <jsp:include page="menubar.jsp"/>
        </div>
        

        <div>
            <%
                Random rand = new Random();
                ArrayList<Website> sites = websiteList.getWebsites();
                Integer randomInt = rand.nextInt(sites.size());
                Website chosen = sites.get(randomInt);
                out.print("<iframe height=\"600\" width=\"600\" align=\"middle\" src=\"https://" + chosen.getIFrame() + "\">" + "</iframe>");
                out.print("<p>"+"Random Int is: "+ randomInt + "</p>");
                out.print("<p>"+"Website: "+ chosen.getSiteTitle() + "</p>");
                out.print("<p>"+"Ad Count: "+ chosen.getAdCount() + "</p>");
                out.print("<p>"+"Rating "+ chosen.getRating() + "</p>");                
                out.print("<p>"+"Category: "+ chosen.getCategoryIDLink() + "</p>");
                out.print("<p><a href=\"http://"+ chosen.getHyperLink() + "\">" + chosen.getSiteTitle() + "</a></p>");
            %>
        </div>
    </body>
</html>
