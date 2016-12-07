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
        <title>Login</title>
        
        <script type="text/javascript">
            function sendPassword() {
                var msg = alert("An email has been set with a link to reset your password.");
            }
        </script>
        
    </head>
    
    <body>
        <div>
            <jsp:include page="navigationbar.jsp"/>
        </div>
        <!-- Page Content -->
        <div class="container">
            <br/><br/>

            <div class="form-group row">
                <div class="col-xs-6">
                    <h4>
                        To reset your password, enter the email address you used to register
                        and click "Send Password." A temporary password will then be sent to
                        that email address and may be used to login and set a new password.
                    </h4>
                    <hr class="intro-divider">
                </div>
            </div>

            <!--FORM --> 
            <form action="controller" method="POST">

                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Email:</label>
                    <div class="col-xs-6">
                        <input class="form-control" type="text" name="pwdresetemail" id="username">
                    </div>
                </div>

                <input type="submit" class="btn btn-primary btn-lg btn-group-vertical" value="Send Password" name="action" onclick="sendPassword()"/>

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
