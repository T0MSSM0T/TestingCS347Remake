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

    <body>
        <div>
            <jsp:include page="menubar.jsp"/>
        </div>
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
