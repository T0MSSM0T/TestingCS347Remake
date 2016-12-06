<%@page import="java.util.ArrayList"%>
<jsp:useBean class="Model.CategoryList" id="ctList" scope="session"/>
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

        <script type="text/javascript">
            $(function () {
                $('legend').click(function () {
                    $(this).parent().find('.toggle').slideToggle("slow");
                });
            });
        </script>
    </head>

    <body>
        <div>
            <jsp:include page="menubar.jsp"/>
        </div>

        <ul>
            <%
                ArrayList<String> categories = ctList.getCategories();
                for (int ii = 0; ii < categories.size(); ii++) {
                    out.println("<fielset><legend> " + categories.get(ii) + "</legend>");
                    out.println("<div class=\"toggle\">this<br /></div>");
                    out.println("</fieldset>");
                }
            %>
        </ul>
    </body>
</html>
