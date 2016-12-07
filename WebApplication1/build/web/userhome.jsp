<%@page import="Model.Website"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean class="Model.CategoryList" id="ctList" scope="session"/>
<jsp:useBean class="Model.Website" id="websiteList" scope="session"/>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="logo.png"/>
        <title>Home</title>
    </head>

    <body>
        <div>
            <jsp:include page="menubar.jsp"/>
        </div>

        <ul>
            <%
                ArrayList<String> categories = ctList.getCategories();
                ArrayList<Website> websites = websiteList.getWebsites();
                for (int ii = 0; ii < categories.size(); ii++) {
                    out.println("<fielset class=\"toggleAble\"><legend> " + categories.get(ii) + "</legend>");
                    
                    for (int jj = 0; jj < websites.size(); jj++) {
                        out.println("<div>");
                        out.println("<p> Website: " + websites.get(jj).getSiteTitle() + "</p>");
                        out.println("<p> Rating: " + websites.get(jj).getRating() + "</p>");
                    }
                    out.println("</div></fieldset>");
                }
            %>
        </ul>
    </body>
</html>
