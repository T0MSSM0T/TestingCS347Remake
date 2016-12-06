<%-- 
    Document   : login
    Created on : Nov 28, 2016, 4:01:24 PM
    Author     : smithdjt
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
        <title>Login Changed</title>
    </head>
    <body>
        <div>
            <jsp:include page="navigationbar.jsp"/>
        </div>
        <!-- Page Content -->
        <div class="container">
            <br/><br/>

            <!--FORM --> 
            <form action="LoginServlet" method="GET">
                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Username:</label>
                    <div class="col-xs-6">
                        <input class="form-control" type="text" name="loginusername" id="username">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Password:</label>
                    <div class="col-xs-6">
                        <input class="form-control" type="password" name="loginpassword" id="password">
                    </div>
                </div>

                <input type="submit" class="btn btn-primary btn-lg btn-group-vertical" name="action" value="Login"/>
                <p style="padding-top: 15px;"><a href="forgotpassword.jsp" style="color: black;">Forgot Password?</a></p>

            </form> 
            <!--/.FORM -->   

        </div><!--container--> 
        <!--/.CATEGORIES --> 

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.js"></script>
    </body>
</html>
