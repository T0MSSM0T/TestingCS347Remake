<%-- 
    Document   : login
    Created on : Nov 28, 2016, 4:01:24 PM
    Author     : perezcx
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="shortcut icon" href="logo.png"/>
        <title>Logged Out</title>
    </head>
    <body>
        <div>
            <jsp:include page="navigationbar.jsp"/>
        </div>
        <!-- Page Content -->
        <div class="container">
            <h1>Successfully Logged out</h1>
            <%
               request.getSession().invalidate();
            %>
         

        </div><!--container--> 
        <!--/.CATEGORIES --> 

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.js"></script>
    </body>
</html>
