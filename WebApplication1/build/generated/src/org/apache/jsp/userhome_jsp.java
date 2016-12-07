package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Website;
import java.util.ArrayList;

public final class userhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      Model.CategoryList ctList = null;
      synchronized (session) {
        ctList = (Model.CategoryList) _jspx_page_context.getAttribute("ctList", PageContext.SESSION_SCOPE);
        if (ctList == null){
          ctList = new Model.CategoryList();
          _jspx_page_context.setAttribute("ctList", ctList, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
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
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"logo.png\"/>\n");
      out.write("        <title>Home</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menubar.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <ul>\n");
      out.write("            ");

                ArrayList<String> categories = ctList.getCategories();
                for (int ii = 0; ii < categories.size(); ii++) {
                    out.println("<fielset><legend> " + categories.get(ii) + "</legend>");
                    int pos = ii + 1;
                    ArrayList<Website> websites = websiteList.getCategoryWebsites(pos);

                    for (int jj = 0; jj < websites.size(); jj++) {
                        int posJJ = jj + 1;
                        out.println("<div align=\"middle\">");
                        out.println("<p>" + posJJ + ". </p>");
                        out.println("<p> Site: " + websites.get(jj).getSiteTitle() + "</p>");
                        out.println("<p> Link: <a href=\"https://" + websites.get(jj).getHyperLink() + "\" style=\"color:blue;\">"
                                + websites.get(jj).getSiteTitle() + "</a></p>");
                        out.println("<p> Ads: " + websites.get(jj).getAdCount() + "</p>");
                        out.println("<p> Rating: " + websites.get(jj).getRating() + "</p>");
                    }
                    
                    out.println("</div></fieldset>");
                }
            
      out.write("\n");
      out.write("        </ul>\n");
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
