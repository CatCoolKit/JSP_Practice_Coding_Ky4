package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/tlds/TagTest.tld");
    _jspx_dependants.add("/WEB-INF/tlds/tagCustom.tld");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login Page</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container mt-3\">\n");
      out.write("            <h1 id=\"header_1\">Login your account</h1>\n");
      out.write("            <h5 id=\"header_1\">");
      if (_jspx_meth_tagtest_XuLy_0(_jspx_page_context))
        return;
      out.write("</h5>\n");
      out.write("            ");
      if (_jspx_meth_tagcustom_custom_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                <p>Login for services, enter your id and password below. Then, click on the Submit button.</p>\n");
      out.write("\n");
      out.write("                <form action=\"login\" method=\"post\">\n");
      out.write("                    <div class=\"mb-3 mt-3\">\n");
      out.write("                        <label class=\"userID\">UserId: </label>\n");
      out.write("                        <input type=\"text\" name=\"userID\" id=\"userID\" value=\"\" required><br>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label class=\"password\">PassWord:</label>\n");
      out.write("                        <input type=\"password\" name=\"password\" id=\"password\" value=\"\" required><br>\n");
      out.write("                        <span id=\"passwordError\" style=\"color: red;\"></span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-check mb-3\">\n");
      out.write("                        <label class=\"form-check-label\">\n");
      out.write("                            <input class=\"form-check-input\" type=\"checkbox\" name=\"remember\"> Remember me\n");
      out.write("                        </label>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" name=\"action\" value=\"loginUser\" class=\"btn btn-primary\" onclick=\"validateForm(event)\">Submit</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        ");

            if (session != null) {
                // Lấy giá trị của thuộc tính loginStatus từ HttpSession
                String loginStatus = (String) session.getAttribute("loginStatus");
                // Kiểm tra nếu loginStatus bằng "failed" thì in ra thông báo đăng nhập thất bại
                if ("failed".equals(loginStatus)) {
        
      out.write("\n");
      out.write("        <div class=\"container mt-3\">\n");
      out.write("            <span class=\"badge rounded-pill bg-secondary\">You have failed to log in ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.loginAttempts}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" times. If you fail to log in more than 5 times, you will be locked out for 10 minutes.</span>\n");
      out.write("        </div>\n");
      out.write("        ");

                }
            }
            // Các trường hợp khác có thể được xử lý tại đây

      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function validateForm(event) {\n");
      out.write("                console.log(\"validateForm is called\");\n");
      out.write("                var passwordInput = document.getElementById(\"password\");\n");
      out.write("                var passwordError = document.getElementById(\"passwordError\");\n");
      out.write("\n");
      out.write("                // Kiểm tra xem mật khẩu chỉ chứa số hay không\n");
      out.write("                if (!/^\\d+$/.test(passwordInput.value)) {\n");
      out.write("                    passwordError.innerHTML = \"Password must only be entered in numbers.\";\n");
      out.write("                    event.preventDefault(); // Ngăn chặn form được gửi đi\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    passwordError.innerHTML = \"\"; // Xóa thông báo lỗi nếu có\n");
      out.write("                    return true; // Cho phép form được gửi đi\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("//            function showMessage() {\n");
      out.write("//                alert(\"Welcom to we page!\");\n");
      out.write("//            }\n");
      out.write("//            document.addEventListener(\"DOMContentLoaded\", function () {\n");
      out.write("//                showMessage();\n");
      out.write("//            });\n");
      out.write("        </script>\n");
      out.write("\n");
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

  private boolean _jspx_meth_tagtest_XuLy_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tagtest:XuLy
    tags.XuLy _jspx_th_tagtest_XuLy_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(tags.XuLy.class) : new tags.XuLy();
    _jspx_th_tagtest_XuLy_0.setJspContext(_jspx_page_context);
    _jspx_th_tagtest_XuLy_0.doTag();
    return false;
  }

  private boolean _jspx_meth_tagcustom_custom_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tagcustom:custom
    tags.custom _jspx_th_tagcustom_custom_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(tags.custom.class) : new tags.custom();
    _jspx_th_tagcustom_custom_0.setJspContext(_jspx_page_context);
    _jspx_th_tagcustom_custom_0.setTextColor("red");
    _jspx_th_tagcustom_custom_0.setJspBody(new index_jspHelper( 0, _jspx_page_context, _jspx_th_tagcustom_custom_0, null));
    _jspx_th_tagcustom_custom_0.doTag();
    return false;
  }

  private class index_jspHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public index_jspHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      out.write("Button");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
