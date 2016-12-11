
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
        <title>Username Taken</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/small-business.css" rel="stylesheet">
    </head>

    <body>
        <div>
            <jsp:include page="navigationbar.jsp"/>
        </div>
        
        <div class="container">
            
            <div div class="form-group row" style="padding-top: 5%; padding-left: 20%;">
                <label for="example-text-input" class="col-xs-1 col-form-label" ><img src="img/error.png" alt="" style="width:60px; height:60px; padding-top: 2%;"></label>
                    <div class="col-xs-9">
                       <h2 for="example-text-input" class="col-xs-5 col-form-label">Username taken.</h2>
                    </div>
            </div>
            
            <p style="padding-left: 20%;"><a href="register.jsp" style="color: blue;">Back to register</a></p>
        </div>

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.js"></script>

    </body>

</html>