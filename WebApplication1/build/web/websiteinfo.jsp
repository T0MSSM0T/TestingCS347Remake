<%@page import="Model.Rating"%>
<%@page import="Model.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.IOException"%>
<%@page import="Model.Website"%>
<jsp:useBean class="Model.Website" id="websiteList" scope="session"/>
<jsp:useBean class="Model.Comment" id="commentList" scope="session"/>
<jsp:useBean class="Model.Rating" id="ratingList" scope="session"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Website Info</title>

        <link rel="shortcut icon" href="logo.png"/>
    </head>

    <body>
        <div>
            <jsp:include page="menubar.jsp"/>
        </div>

        <%
            try {
                Boolean loggedIn = (Boolean) session.getAttribute("logged_in");
                if (loggedIn == null || !loggedIn) {
                    response.sendRedirect(request.getContextPath());   // go to the home page
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        %>

        <div class="container">
            <br/><br/>
            <form action="CommentServlet" method="GET">
                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Title:</label>
                    <div class="col-xs-10">
                        <input class="form-control" value="<%=session.getAttribute("websitetitle")%>" name="sitetitle" type="text" id="title" readonly>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-search-input" class="col-xs-2 col-form-label">Link:</label>
                    <div class="col-xs-10">
                        <input class="form-control" value="<%=session.getAttribute("websitelink")%>" name="sitelink" type="text" id="link" readonly>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="example-email-input" class="col-xs-2 col-form-label">Info:</label>
                    <div class="col-xs-10">
                        <input class="form-control" value="<%=session.getAttribute("websitenotes")%>" name="siteinfo" type="text" id="info" readonly>
                    </div>
                </div>

                <!--
                   rating bar 
                -->
                <div class="form-group row">
                    <div class="col-xs-10">
                        <div>
                            <jsp:include page="ratingBar.jsp"/>
                        </div>
                        
                        <a style="color:blue;" href="./rating.html">Rate this website</a>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-xs-10">
                        <form action="CommentServlet" method="GET">
                            <textarea class="form-control" rows="8" cols="40" name ="commentText"></textarea>
                            <input type="submit" value="Comment" name="action" class="btn btn-primary btn-lg btn-block"/>
                        </form>
                    </div>
                </div>
                  
                    
                <%
                    // comments 
                    ArrayList<Comment> comments = commentList.getCommentsBySite((int) session.getAttribute("siteid"));
                    for (int ii = 0; ii < comments.size(); ii++) {
                        int pos = ii + 1;
                        out.println("<fieldset><legend>" +  "Comment #" + pos);
                        out.println("<p>" + comments.get(ii).getUsername()+"</p>");
                        out.println("<p>" + comments.get(ii).getCommentMade() + "</p>");
                        out.println("</legend></fieldset>");
                    }
                %>
            </form>   
        </div>

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>

    </body>

</html>
