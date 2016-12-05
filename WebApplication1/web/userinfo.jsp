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
    <script type="text/javascript">
        function enable()
        {
            document.getElementById("username").disabled = false;
            document.getElementById("firstname").disabled = false;
            document.getElementById("lastname").disabled = false;
            document.getElementById("age").disabled = false;
            document.getElementById("email").disabled = false;
            document.getElementById("gender").disabled = false;
            document.getElementById("movies").disabled = false;
            document.getElementById("sports").disabled = false;
            document.getElementById("technology").disabled = false;
            document.getElementById("innovative").disabled = false;
            document.getElementById("streaming").disabled = false;


        }
    </script>
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
            <form action="userinfo" method="POST">
                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Username:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=request.getAttribute("username")%>" name="editusername" id="username" disabled="true" >
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-search-input" class="col-xs-2 col-form-label">First Name:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=request.getAttribute("firstname")%>" name="editfirstname" id="firstname" disabled="true">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-email-input" class="col-xs-2 col-form-label">Last Name:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=request.getAttribute("lastname")%>" name="editlastname" id="lastname" disabled="true">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-url-input" class="col-xs-2 col-form-label">Age:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=request.getAttribute("age")%>" name="editage" id="age" disabled="true">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-url-input" class="col-xs-2 col-form-label">Email:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=request.getAttribute("email")%>" name="editemail" id="email" disabled="true">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-tel-input" class="col-xs-2 col-form-label">Gender:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=request.getAttribute("gender")%>" name="editgender" id="gender" disabled="true">
                    </div>
                </div>

                <!--categories checkbox --> 
                <div style="background-color:#E5E4E2 !important;" class="jumbotron">
                    <fieldset>
                        <div class="custom-control-input">
                            <input id="movies" name="checkeditmovies" type="checkbox" disabled="true">
                            <label>
                                Movies
                            </label>
                        </div>

                        <div class="custom-control-input">
                            <input id="sports" name="checkeditsports" type="checkbox" disabled="true">
                            <label>
                                Sports
                            </label>
                        </div>

                        <div class="custom-control-input">
                            <input id="technology" name="checkedittech" type="checkbox" disabled="true">
                            <label for="technology">
                                Technology
                            </label>
                        </div>

                        <div class="custom-control-input">
                            <input id="news" name="checkeditnews" type="checkbox" disabled="true">
                            <label>
                                News
                            </label>
                        </div>

                        <div class="custom-control-input">
                            <input id="innovative" name="checkeditinnovative" type="checkbox" disabled="true">
                            <label>
                                Innovative
                            </label>
                        </div>

                        <div class="custom-control-input">
                            <input id="streaming" name="checkeditstreaming" type="checkbox" disabled="true">
                            <label>
                                Streaming
                            </label>
                        </div>

                    </fieldset>
                </div><!--jumbotron-->

                <button type="button" onclick="enable()" value="" class="btn btn-primary btn-lg">Edit</button>
                <button type="button" value="" class="btn btn-primary btn-lg">Save</button>
                <button type="button" value="" class="btn btn-primary btn-lg">Cancel</button>
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
