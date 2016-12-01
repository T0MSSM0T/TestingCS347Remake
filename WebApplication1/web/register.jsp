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
                        <a href="index.jsp">Back</a>
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
        
<!--FORM --> 
<form action="controller" method="POST">
    <div class="form-group row">
        <label for="example-text-input" class="col-xs-2 col-form-label">Username!!:</label>
        <div class="col-xs-10">
          <input class="form-control" type="text" name="regusername" id="username">

        </div>
      </div>
    
     <div class="form-group row">
        <label for="example-text-input" class="col-xs-2 col-form-label">Password:</label>
        <div class="col-xs-10">
          <input class="form-control" type="password" name="regpassword" id="password">
        </div>
      </div>
    
     <div class="form-group row">
        <label for="example-text-input" class="col-xs-2 col-form-label">Confirm Password:</label>
        <div class="col-xs-10">
          <input class="form-control" type="password" name="regcnfmpassword" id="password">
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
        <div class="custom-control-input">
            <input id="movies" name="checkmovies" type="checkbox" >
            <label>
                Movies
            </label>
        </div>
        
        <div class="custom-control-input">
            <input id="sports" name="checksports" type="checkbox" >
            <label>
                Sports
            </label>
        </div>
        
        <div class="custom-control-input">
            <input id="technology" name="checktech" type="checkbox" >
            <label for="technology">
                Technology
            </label>
        </div>
        
        <div class="custom-control-input">
            <input id="news" name="checknews" type="checkbox" >
            <label>
                News
            </label>
        </div>
        
         <div class="custom-control-input">
            <input id="innovative" name="checkinnovative" type="checkbox" >
            <label>
                Innovative
            </label>
        </div>
        
        <div class="custom-control-input">
            <input id="streaming" name="checkstreaming" type="checkbox" >
            <label>
                Streaming
            </label>
        </div>
        
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
