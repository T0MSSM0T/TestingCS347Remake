<%@page import="java.io.IOException"%>
<%@page import="Model.Website"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean class="Model.CategoryList" id="categoryList" scope="session" />
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
        <title>Favorites</title>

    </head>
    <script type="text/javascript">
            function getsite() {
                
            }
        </script>
    <body>
        <div>
            <jsp:include page="menubar.jsp"/> 
           
        </div>
       
        <%
            try {
                Boolean loggedIn = (Boolean) session.getAttribute("logged_in");
                if (loggedIn == null || !loggedIn) {
                    response.sendRedirect(request.getContextPath());   // go to the home page
                } else {
                    ArrayList<String> catList = categoryList.getCategories();
                    ArrayList<String> items = new ArrayList<>();
                    for (int ii = 0; ii < catList.size(); ii++) {
                        items.add(session.getAttribute(catList.get(ii)).toString());

                        int pos = ii + 1;
                        if (items.get(ii).equals("true")) {
                            ArrayList<Website> websites = websiteList.getCategoryWebsites(pos);

                            for (int jj = 0; jj < websites.size(); jj++) {
                                int posJJ = jj + 1;
                                //out.println("<form action=\"CommentServlet\" method=\"POST\">"); 
                                out.println("<div align=\"middle\">");
                                out.println("<p>" + posJJ + ". </p>");
                                out.println("<p> Site: " + websites.get(jj).getSiteTitle() + "</p>");
                                out.print("<iframe height=\"400\" width=\"50%\" align=\"middle\" src=\"http://" + websites.get(jj).getIFrame() + "\">" + "</iframe>");
                                out.println("<p> Link: <a href=\"https://" + websites.get(jj).getHyperLink() + "\" style=\"color:blue;\">"
                                        + websites.get(jj).getSiteTitle() + "</a></p>");
                                out.println("<p> Ads: " + websites.get(jj).getAdCount() + "</p>");
                                out.println("<p> Rating: " + websites.get(jj).getRating() + "</p>");
                                
                                //session.setAttribute(websites.get(jj).getSiteTitle(), websites.get(jj));
                                session.setAttribute(jj+"",websites.get(jj));
                                //out.println("<form>");
                                 out.println("<a href=\"WebsiteServlet?title="+websites.get(jj).getSiteTitle()
                                         + "&link="+websites.get(jj).getHyperLink()+"&rating="+websites.get(jj).getRating()+""
                                         + "&id="+websites.get(jj).getSiteID()+"&notes="+websites.get(jj).getNotes()+""
                                         + "  \"><button class = \"btn btn-primary btn-lg active\">Info Site</button></a>"); 
                                //out.println("<button type=\"submit\" onClick=\"getsite()\">Info</button> ");
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        %>
    </body>
</html>
