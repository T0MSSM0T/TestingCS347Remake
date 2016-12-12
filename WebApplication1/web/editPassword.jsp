<%-- 
    Document   : editPassword
    Created on : Dec 11, 2016, 6:47:12 PM
    Author     : hirstrb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Password</title>

        <script type="text/JavaScript">

                function validatePassword()
                {
                var match = true
                var password = get('password').value
                var passwordConfirm = get('passwordcnfm').value
                get('passwordcnfmerr').innerHTML = ''

                if (password != passwordConfirm){
                get('passwordcnfmerr').innerHTML = 'Passwords do not match'
                match = false
                }

                return match
                }

                function get(id) { return document.getElementById(id) }

            </script>
    </head>
    <body>
        <div>
            <jsp:include page="menubar.jsp"/>
        </div>
        <!-- Page Content -->
        <div class="container">
            <br/><br/>

            <!--FORM --> 
            <form action="PasswordServlet" method="POST" onsubmit="return validatePassword()">

                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">New Password:</label>
                    <div class="col-xs-6">
                        <input class="form-control" type="password" name="password" id="password">
                    </div>
                </div>
                
                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Confirm Password:</label>
                    <div class="col-xs-6">
                        <input class="form-control" type="password" name="passwordcnfm" id="passwordcnfm">
                        <span id="passwordcnfmerr" class="errmsg"> </span>
                    </div>
                </div>
                
                <input type="submit" class="btn btn-primary btn-lg btn-group-vertical" name="action" value="Save"/>

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
