<%@page import="Model.User"%>
<jsp:useBean class="Model.User" id="curUser" scope="session"/>
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
        <div>
            <jsp:include page="menubar.jsp"/>
        </div>

        <!-- Page Content -->
        <div class="container">
            <br/><br/>
            <!--FORM --> 
            <form action="userinfo" method="POST">
                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Username:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=session.getAttribute("username")%>" name="editusername" id="username" disabled="true" >
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-search-input" class="col-xs-2 col-form-label">First Name:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=session.getAttribute("firstname")%>" name="editfirstname" id="firstname" disabled="true">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-email-input" class="col-xs-2 col-form-label">Last Name:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=session.getAttribute("lastname")%>" name="editlastname" id="lastname" disabled="true">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-url-input" class="col-xs-2 col-form-label">Age:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=session.getAttribute("age")%>" name="editage" id="age" disabled="true">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-url-input" class="col-xs-2 col-form-label">Email:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=session.getAttribute("email")%>" name="editemail" id="email" disabled="true">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-tel-input" class="col-xs-2 col-form-label">Gender:</label>
                    <div class="col-xs-10">
                        <input class="form-control" type="text" value="<%=session.getAttribute("gender")%>" name="editgender" id="gender" disabled="true">
                    </div>
                </div>

                <!--categories checkbox --> 
                <div style="background-color:#E5E4E2 !important;" class="jumbotron">
                    <fieldset>
                        <div class="custom-control-input">
                            <input id="movies" name="checkeditmovies"  type="checkbox" disabled="true">
                            <label>
                                Movies
                            </label>
                        </div>

                        <div class="custom-control-input">
                            <input id="sports" name="checkeditsports" checked="" type="checkbox" disabled="true">
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
                            <input id="news" name="checkeditnews" checked="<%=session.getAttribute("news")%>"type="checkbox" disabled="true">
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
