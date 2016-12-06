<%-- 
    Document   : shuffle
    Created on : Dec 2, 2016, 1:59:51 PM
    Author     : hirstrb
--%>

<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean class="Model.Website" id="websiteList" scope="session" />
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
                ArrayList<String> websites = websiteList.getWebsites();
                Random rand = new Random();
                Integer randomInt = rand.nextInt(websites.size());
                String chosen = websites.get(randomInt);
                out.print("<p>"+"Random Int is: "+ randomInt + "</p>");
                out.print("<a href=\"http://"+ chosen + "\">" + chosen + "</a>");
            %>
        </div>
    </body>
</html>
