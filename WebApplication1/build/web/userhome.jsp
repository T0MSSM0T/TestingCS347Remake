<%@page import="java.io.IOException"%>
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
                try {
                    Boolean loggedIn = (Boolean) session.getAttribute("logged_in");
                    if (loggedIn == null || !loggedIn) {
                        response.sendRedirect(request.getContextPath());   // go to the home page
                    } else {
                        ArrayList<String> categories = ctList.getCategories();
                        for (int ii = 0; ii < categories.size(); ii++) {
                            out.println("<fielset><legend> " + categories.get(ii) + "</legend>");
                            int pos = ii + 1;
                            ArrayList<Website> websites = websiteList.getCategoryWebsites(pos);

                            for (int jj = 0; jj < websites.size(); jj++) {
                                int posJJ = jj + 1;
                                out.println("<div align=\"middle\">");
                                out.println("<p>" + posJJ + ". </p>");

                                out.println("<p><a href=" + "\"websiteinfo.jsp\"" + "style=\"color:blue;\" >" + websites.get(jj).getSiteTitle() + "</a></p>");
                                out.print("<iframe height=\"400\" width=\"50%\" align=\"middle\" src=\"https://" + websites.get(jj).getIFrame() + "\">" + "</iframe>");
                                out.println("<p> Link: <a href=\"https://" + websites.get(jj).getHyperLink() + "\" style=\"color:blue;\">"
                                        + websites.get(jj).getSiteTitle() + "</a></p>");
                                out.println("<p> Ads: " + websites.get(jj).getAdCount() + "</p>");
                                out.println("<p> Rating: " + websites.get(jj).getRating() + "</p>");
                                
                                out.println("<a href=\"WebsiteServlet?title="+websites.get(jj).getSiteTitle()
                                         + "&link="+websites.get(jj).getHyperLink()+"&rating="+websites.get(jj).getRating()+""
                                         + "&id="+websites.get(jj).getSiteID()+"&notes="+websites.get(jj).getNotes()+""
                                         + "  \"><button class = \"btn btn-primary btn-lg active\">Info Site</button></a>"); 
                            }

                            out.println("</div></fieldset>");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            %>
        </ul>
    </body>
</html>
