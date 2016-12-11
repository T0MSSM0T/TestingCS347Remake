<%@page import="java.util.ArrayList"%>
<%@page import="Model.CategoryList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="shortcut icon" href="logo.png"/>
        <title>EasyEfo</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/landing-page.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    </head>
    <%
        /**
         * Retrives Categories and set a new empty session 
         */
        CategoryList obj = new CategoryList();
        ArrayList<String> catList = obj.getCategories();
        session.setAttribute("username", "");
        session.setAttribute("firstname", "");
        session.setAttribute("lastname", "");
        session.setAttribute("age", "");
        session.setAttribute("email", "");
        session.setAttribute("gender", "");

        for (int i = 0; i < catList.size(); i++) {
            session.setAttribute(catList.get(i), "");
        }
    %>
    <body>

        <!-- Header -->
        <a name="about"></a> 
        <div class="intro-header">
            <div class="container">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">
                            <img src="logo.png" alt="" style="width:170px; height:110px; padding-bottom:20px">
                            <h1>EasyEfo</h1>
                            <hr class="intro-divider">
                            <ul class="list-inline intro-social-buttons">
                                <li>
                                    <a href="login.jsp" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Login</span></a>
                                </li>
                                <li>
                                    <a href="register.jsp" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Register</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </div>
        <!-- /.intro-header -->

        <!-- Page Content -->

        <!-- /.banner -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.js"></script>
    </body>
</html>
