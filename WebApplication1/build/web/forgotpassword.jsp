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

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/small-business.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                </button>
             
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"  >
                <ul class="nav nav-justified" >
                    <li>
                        <a href="index.jsp"><img src="logo.png" alt="" style="width:90px; height:50px"></a>
                    </li>
                    <li>
                        <a href="login.jsp">Back</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

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
    
    <input type="submit" class="btn btn-primary btn-lg btn-group-vertical" value="Send Password" name="action"/>
    
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
