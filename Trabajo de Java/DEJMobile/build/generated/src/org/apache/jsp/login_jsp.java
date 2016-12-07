package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"CSS/style.css\"/>\n");
      out.write("\n");
      Modelo.Clientes usuario = null;
      synchronized (session) {
        usuario = (Modelo.Clientes) _jspx_page_context.getAttribute("usuario", PageContext.SESSION_SCOPE);
        if (usuario == null){
          usuario = new Modelo.Clientes();
          _jspx_page_context.setAttribute("usuario", usuario, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("usuario"), request);
      out.write('\n');
      out.write('\n');

    HttpSession se = request.getSession();
    String error="";
    if(se.getAttribute("error")!=null){
        error = se.getAttribute("error").toString();
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"banner\">\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col s2\">\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col s5\">\n");
      out.write("                        <h1>Dej Mobile</h1>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col s5\">\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"row\">\n");
      out.write("            \n");
      out.write("            <div class=\"col s4 col offset-s4\">\n");
      out.write("                \n");
      out.write("            <h4 class=\"col s10 offset-s1 center\">Bienvenido</h4>\n");
      out.write("                <form action=\"./LoginServlet\" method=\"POST\" id=\"formLogin\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"input-field col s10 offset-s1\">\n");
      out.write("                            Rut\n");
      out.write("                            <input id=\"rut\" type=\"text\" class=\"validate\" name=\"rut\" placeholder=\"Rut\">\n");
      out.write("                          </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"input-field col s10 offset-s1\">\n");
      out.write("                            Contraseña\n");
      out.write("                            <input id=\"clave\" type=\"password\" class=\"validate\" name=\"clave\" placeholder=\"Contraseña\">\n");
      out.write("                            \n");
      out.write("                          </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col s6 offset-s3 center\">\n");
      out.write("                        <input type=\"button\" class=\"waves-effect waves-light btn \" id=\"btnLogin\" value=\"Ingresar\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <a href=\"registro.jsp\" class=\"col s6 offset-s3 center\">Registrate</a>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        if(error.equals("1")){
                            out.println("<blockquote>La información ingresada es incorrecta. Favor verificar.</blockquote> ");
                        }
                    
      out.write("\n");
      out.write("                      \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script\n");
      out.write("  src=\"https://code.jquery.com/jquery-3.1.1.min.js\"\n");
      out.write("  integrity=\"sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=\"\n");
      out.write("  crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("        $(document).ready(function(){\n");
      out.write("   $('#btnLogin').click(function(){\n");
      out.write("            var ok=0;\n");
      out.write("      \n");
      out.write("            var rut=$('input[name=\"rut\"]').val();\n");
      out.write("            var pass=$('input[name=\"clave\"]').val();\n");
      out.write("            if(rut.length<1){\n");
      out.write("                $('input[name=\"rut\"]').css('border-color','red');\n");
      out.write("            }else{\n");
      out.write("                $('input[name=\"rut\"]').css('border-color','green');\n");
      out.write("                ok++;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            if(pass.length<1){\n");
      out.write("                $('input[name=\"clave\"]').css('border-color','red');\n");
      out.write("            }else{\n");
      out.write("                $('input[name=\"clave\"]').css('border-color','green');\n");
      out.write("                ok++;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            if(ok===2){\n");
      out.write("                $('#formLogin').submit();\n");
      out.write("            }\n");
      out.write("       }); \n");
      out.write("});\n");
      out.write("\n");
      out.write("\n");
      out.write("            </script>\n");
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
