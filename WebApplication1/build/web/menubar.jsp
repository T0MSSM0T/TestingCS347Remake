<%-- 
    Document   : NavigationBar
    Created on : Dec 5, 2016, 6:35:23 PM
    Author     : hirstrb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/small-business.css" rel="stylesheet">
        <script type="text/javascript">
            function logout() {
                var msg = alert("You have successfully logged out.");
            }
        </script>
    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"  >
                    <ul class="nav nav-justified" >
                        <li>
                            <a href="userhome.jsp"><img src="logo.png" alt="" style="width:90px; height:50px"></a>
                        </li>
                        <li>
                            <a href="userhome.jsp" style="background-color: #00B8E6;">Home</a>
                        </li>
                        <li>
                            <a href="userinfo.jsp" style="background-color: #00B8E6;">Profile</a>
                        </li>
                        <li>
                            <a href="shuffle.jsp" style="background-color: #00B8E6;">Shuffle</a>
                        </li>
                        <li>
                            <a href="favorites.jsp" style="background-color: #00B8E6;">Favorites</a>
                        </li>
                        <li>
                            <form action="LogoutServlet" method="GET">
                                <input type="submit" style="background-color: #00B8E6;" class="btn btn-primary btn-lg btn-group-vertical" name="action" value="Logout" onclick="logout()"/>
                            </form>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
    </body>
</html>