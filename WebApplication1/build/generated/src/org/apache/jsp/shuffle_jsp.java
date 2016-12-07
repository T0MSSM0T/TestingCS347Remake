package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Website;
import java.util.Random;
import java.util.ArrayList;

public final class shuffle_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      Model.Website websiteList = null;
      synchronized (session) {
        websiteList = (Model.Website) _jspx_page_context.getAttribute("websiteList", PageContext.SESSION_SCOPE);
        if (websiteList == null){
          websiteList = new Model.Website();
          _jspx_page_context.setAttribute("websiteList", websiteList, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <link href=\"css/website.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"logo.png\"/>\n");
      out.write("        <title>Random Shuffle</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menubar.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <div class=\"shuffle-style\">\n");
      out.write("            ");

                Random rand = new Random();
                ArrayList<Website> sites = websiteList.getWebsites();
                Integer randomInt = rand.nextInt(sites.size());
                Website chosen = sites.get(randomInt);
                out.print("<iframe height=\"600\" width=\"100%\" align=\"middle\" src=\"https://" + chosen.getIFrame() + "\">" + "</iframe>");
                out.print("<label style=\"padding-top: 1%;\">Random Int:</label>" + " " + randomInt);
                out.print("<hr>");
                out.print("<label>Website:</label>" + " " + chosen.getSiteTitle());
                out.print("<hr>");
                out.print("<label>Ad Count:</label>" + " " + chosen.getAdCount());
                out.print("<hr>");
                out.print("<label>Rating:</label>" + " " + chosen.getRating());    
                out.print("<hr>");
                out.print("<label>Category:</label>" + " " + chosen.getCategoryIDLink());
                out.print("<hr>");
                out.print("<label style=\"padding-bottom: 3%;\">Link:</label>" + " " + "<a href=\"http://"+ chosen.getHyperLink() + "\"style=\"color: blue;\">" + chosen.getSiteTitle() + "</a>");
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
