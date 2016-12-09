<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<jsp:useBean class="Model.User" id="curUser" scope="session"/>
<jsp:useBean class="Model.CategoryList" id="CL" scope="session"/>
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

    <%
        out.print("<script type=\"text/javascript\">");
        //out.print("var clicked = false");
        out.print("function enable(){");
        //out.print("clicked = true");
        out.print("document.getElementById(\"firstname\").disabled = false;");
        out.print("document.getElementById(\"lastname\").disabled = false;");
        out.print("document.getElementById(\"age\").disabled = false;");
        out.print("document.getElementById(\"email\").disabled = false;");
        out.print("document.getElementById(\"gender\").disabled = false;");

        ArrayList<String> list = CL.getCategories();
        for (int i = 0; i < list.size(); i++) {
            out.print("document.getElementById(\"" + list.get(i) + "\").disabled = false;");
        }
        out.print("}</script>");
    %>



    <body>
        <div>
            <jsp:include page="menubar.jsp"/>
        </div>

        <!-- Page Content -->
        <div class="container">
            <br/><br/>
            <!--FORM --> 
            <form action="edituser" method="POST">
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
                        <%
                            for (int i = 0; i < list.size(); i++) {
                                out.println("<div class=\"custom-control-input\">");
                                out.print("\t<input id=\"" + list.get(i) + "\" ");
                                out.print("name=\"checkedit" + list.get(i) + "\" ");
                                if ((Boolean) session.getAttribute(list.get(i))) {
                                    out.print("checked ");
                                }
                                out.println("type=\"checkbox\" disabled=\"true\"");
                                out.println("\t<label>");
                                out.println("\t\t" + list.get(i));
                                out.println("\t</label>");
                                out.println("</div>");
                            }
                        %>
                    </fieldset>
                </div><!--jumbotron-->

                <button type="button" onclick="enable()" value="" class="btn btn-primary btn-lg">Edit</button>
                <button type="submit" value="" class="btn btn-primary btn-lg">Save</button>
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
