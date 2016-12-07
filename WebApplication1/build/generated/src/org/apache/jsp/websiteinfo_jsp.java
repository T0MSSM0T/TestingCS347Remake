package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class websiteinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <link rel=\"shortcut icon\" href=\"logo.png\"/>\n");
      out.write("        <title>User Info</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menubar.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- Page Content -->\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <br/><br/>\n");
      out.write("\n");
      out.write("            <!--FORM --> \n");
      out.write("            <form action=\"websiteinfo\" method=\"POST\">\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-text-input\" class=\"col-xs-2 col-form-label\">Title:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" name=\"sitetitle\" type=\"text\" id=\"title\" readonly>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-search-input\" class=\"col-xs-2 col-form-label\">Link:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" name=\"sitelink\" type=\"text\" id=\"link\" readonly>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-email-input\" class=\"col-xs-2 col-form-label\">Info:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" name=\"siteinfo\" type=\"text\" id=\"info\" readonly>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-url-input\" class=\"col-xs-2 col-form-label\">Rating:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" name=\"siterating\" type=\"text\" id=\"rating\" readonly>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <button id=\"comment\" name=\"comment\" class=\"btn btn-primary btn-lg\">Comment</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </form>   \n");
      out.write("\n");
      out.write("\n");
      out.write("            <!--/.FORM -->  \n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container -->\n");
      out.write("\n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap Core JavaScript -->\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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
