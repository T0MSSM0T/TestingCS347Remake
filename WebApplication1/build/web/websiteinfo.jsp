<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="shortcut icon" href="logo.png"/>
    <title>User Info</title>

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
                        <a href="userhome.jsp">Home</a>
                    </li>
                    <li>
                         <a href="userinfo.jsp">Profile</a>
                    </li>
                    <li>
                           <a href="#" style="background-color: #00B8E6;">Shuffle</a>
                    </li>
                     <li>
                           <a href="favorites.jsp">Favorites</a>
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
<form action="websiteinfo" method="POST">
    <div class="form-group row">
        <label for="example-text-input" class="col-xs-2 col-form-label">Title:</label>
        <div class="col-xs-10">
          <input class="form-control" name="sitetitle" type="text" id="title" readonly>
        </div>
      </div>
    
      <div class="form-group row">
        <label for="example-search-input" class="col-xs-2 col-form-label">Link:</label>
        <div class="col-xs-10">
          <input class="form-control" name="sitelink" type="text" id="link" readonly>
        </div>
      </div>
    
      <div class="form-group row">
        <label for="example-email-input" class="col-xs-2 col-form-label">Info:</label>
        <div class="col-xs-10">
          <input class="form-control" name="siteinfo" type="text" id="info" readonly>
        </div>
      </div>
    
      <div class="form-group row">
        <label for="example-url-input" class="col-xs-2 col-form-label">Rating:</label>
        <div class="col-xs-10">
          <input class="form-control" name="siterating" type="text" id="rating" readonly>
        </div>
      </div>
    
    <div class="form-group row">
        <div class="col-xs-10">
          <button id="comment" name="comment" class="btn btn-primary btn-lg">Comment</button>
        </div>
    </div>
    
    </form>   
  
 
<!--/.FORM -->  

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.js"></script>

</body>

</html>
