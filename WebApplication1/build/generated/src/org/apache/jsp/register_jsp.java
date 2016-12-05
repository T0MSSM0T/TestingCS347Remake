package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Register</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap Core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/small-business.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("         <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("         <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("         <![endif]-->\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\"  >\n");
      out.write("                    <ul class=\"nav nav-justified\" >\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"index.jsp\"><img src=\"logo.png\" alt=\"\" style=\"width:90px; height:50px\"></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"index.jsp\">Back</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.navbar-collapse -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.container -->\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <!-- Page Content -->\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <br/><br/>\n");
      out.write("\n");
      out.write("            <script type=\"text/JavaScript\">\n");
      out.write("\n");
      out.write("                function validatePassword()\n");
      out.write("                {\n");
      out.write("                var match = true\n");
      out.write("                var password = get('password').value\n");
      out.write("                var passwordConfirm = get('passwordcnfm').value\n");
      out.write("                get('passwordcnfmerr').innerHTML = ''\n");
      out.write("\n");
      out.write("                if (password != passwordConfirm){\n");
      out.write("                get('passwordcnfmerr').innerHTML = 'Passwords do not match'\n");
      out.write("                match = false\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                return match\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function get(id) { return document.getElementById(id) }\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("            <!--FORM -->\n");
      out.write("            <form action=\"controller\" method=\"POST\"  onsubmit=\"return validatePassword()\">\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-text-input\" class=\"col-xs-2 col-form-label\">Username:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" name=\"regusername\" id=\"username\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-text-input\" class=\"col-xs-2 col-form-label\">Password:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" type=\"password\" name=\"regpassword\" id=\"password\">\n");
      out.write("                        <span id=\"passworderr\" class=\"errmsg\"> </span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-text-input\" class=\"col-xs-2 col-form-label\">Confirm Password:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" type=\"password\" name=\"regcnfmpassword\" id=\"passwordcnfm\">\n");
      out.write("                        <span id=\"passwordcnfmerr\" class=\"errmsg\"> </span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-search-input\" class=\"col-xs-2 col-form-label\">First Name:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" name=\"regfirstname\" id=\"firstname\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-email-input\" class=\"col-xs-2 col-form-label\">Last Name:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" name=\"reglastname\" id=\"lastname\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-text-input\" class=\"col-xs-2 col-form-label\">Email:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" name=\"regemail\" id=\"email\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-url-input\" class=\"col-xs-2 col-form-label\">Age:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" name=\"regage\" id=\"age\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"example-tel-input\" class=\"col-xs-2 col-form-label\">Gender:</label>\n");
      out.write("                    <div class=\"col-xs-10\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" name=\"reggender\" id=\"gender\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <br/>\n");
      out.write("                <!--CATEGORIES -->\n");
      out.write("                <h2>Select Categories of Interest</h2>\n");
      out.write("                <div style=\"background-color:#E5E4E2 !important;\" class=\"jumbotron\">\n");
      out.write("                    <fieldset>\n");
      out.write("                        <div class=\"custom-control-input\">\n");
      out.write("                            <input id=\"movies\" name=\"checkmovies\" type=\"checkbox\" >\n");
      out.write("                            <label>\n");
      out.write("                                Movies\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"custom-control-input\">\n");
      out.write("                            <input id=\"sports\" name=\"checksports\" type=\"checkbox\" >\n");
      out.write("                            <label>\n");
      out.write("                                Sports\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"custom-control-input\">\n");
      out.write("                            <input id=\"technology\" name=\"checktech\" type=\"checkbox\" >\n");
      out.write("                            <label for=\"technology\">\n");
      out.write("                                Technology\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"custom-control-input\">\n");
      out.write("                            <input id=\"news\" name=\"checknews\" type=\"checkbox\" >\n");
      out.write("                            <label>\n");
      out.write("                                News\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"custom-control-input\">\n");
      out.write("                            <input id=\"innovative\" name=\"checkinnovative\" type=\"checkbox\" >\n");
      out.write("                            <label>\n");
      out.write("                                Innovative\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"custom-control-input\">\n");
      out.write("                            <input id=\"streaming\" name=\"checkstreaming\" type=\"checkbox\" >\n");
      out.write("                            <label>\n");
      out.write("                                Streaming\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </fieldset>\n");
      out.write("                </div><!--jumbotron-->\n");
      out.write("                <input type=\"submit\" class=\"btn btn-primary btn-lg btn-block\" name=\"action\" value=\"Register\"/>\n");
      out.write("\n");
      out.write("            </form> \n");
      out.write("            <!--/.FORM -->   \n");
      out.write("\n");
      out.write("        </div><!--container--> \n");
      out.write("        <!--/.CATEGORIES --> \n");
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
