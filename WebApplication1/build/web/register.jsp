
<%@page import="java.util.ArrayList"%>
<jsp:useBean class="Model.CategoryList" id="CL" scope="application" />
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="shortcut icon" href="logo.png"/>
        <title>Register</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/small-business.css" rel="stylesheet">
    </head>

    <body>
        <div>
            <jsp:include page="navigationbar.jsp"/>
        </div>

        <!-- Page Content -->
        <div class="container">
            <br/><br/>

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

            <!--FORM -->
            <form action="RegisterServlet" method="GET"  onsubmit="return validatePassword()">
                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Username:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" name="regusername" id="username">

                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Password:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="password" name="regpassword" id="password">
                        <span id="passworderr" class="errmsg"> </span>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Confirm Password:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="password" name="regcnfmpassword" id="passwordcnfm">
                        <span id="passwordcnfmerr" class="errmsg"> </span>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-search-input" class="col-xs-2 col-form-label">First Name:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" name="regfirstname" id="firstname">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-email-input" class="col-xs-2 col-form-label">Last Name:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" name="reglastname" id="lastname">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Email:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" name="regemail" id="email">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-url-input" class="col-xs-2 col-form-label">Age:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" name="regage" id="age">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-tel-input" class="col-xs-2 col-form-label">Gender:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" name="reggender" id="gender">
                    </div>
                </div>

                <br/>
                <!--CATEGORIES -->
                <h2>Select Categories of Interest</h2>
                <div style="background-color:#E5E4E2 !important;" class="jumbotron">
                    <fieldset>
                        <%
                            ArrayList<String> list = CL.getCategories();
                            for (int i = 0; i < list.size(); i++) {
                                out.print("<div class=\"custom-control-input\">");
                                out.print("<input id=\"" + list.get(i) + "\" name=\"check" + list.get(i) + "\" type=\"checkbox\" >");
                                out.print("<label>" + list.get(i) + "</label></div>");
                            }
                        %>
                    </fieldset>
                </div><!--jumbotron-->
                <input type="submit" class="btn btn-primary btn-lg btn-block" name="action" value="Register"/>

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
