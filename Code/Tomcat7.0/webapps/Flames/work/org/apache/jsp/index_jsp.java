package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Flames Welcomes to you!!!</title>\r\n");
      out.write("<style>\r\n");
      out.write(".textbox {\r\n");
      out.write("\tbackground: transparent\r\n");
      out.write("\t\turl(http://cdn2.editmysite.com/images/util/ui-form/shaded-input-bg.jpg)\r\n");
      out.write("\t\trepeat-x;\r\n");
      out.write("\tborder: 1px solid #999;\r\n");
      out.write("\toutline: 0;\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\twidth: 275px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button {\r\n");
      out.write("\tborder-top: 1px solid #96d1f8;\r\n");
      out.write("\tbackground: #65a9d7;\r\n");
      out.write("\tbackground: -webkit-gradient(linear, left top, left bottom, from(#3e779d),\r\n");
      out.write("\t\tto(#65a9d7) );\r\n");
      out.write("\tbackground: -webkit-linear-gradient(top, #3e779d, #65a9d7);\r\n");
      out.write("\tbackground: -moz-linear-gradient(top, #3e779d, #65a9d7);\r\n");
      out.write("\tbackground: -ms-linear-gradient(top, #3e779d, #65a9d7);\r\n");
      out.write("\tbackground: -o-linear-gradient(top, #3e779d, #65a9d7);\r\n");
      out.write("\tpadding: 5px 10px;\r\n");
      out.write("\t-webkit-border-radius: 8px;\r\n");
      out.write("\t-moz-border-radius: 8px;\r\n");
      out.write("\tborder-radius: 8px;\r\n");
      out.write("\t-webkit-box-shadow: rgba(0, 0, 0, 1) 0 1px 0;\r\n");
      out.write("\t-moz-box-shadow: rgba(0, 0, 0, 1) 0 1px 0;\r\n");
      out.write("\tbox-shadow: rgba(0, 0, 0, 1) 0 1px 0;\r\n");
      out.write("\ttext-shadow: rgba(0, 0, 0, .4) 0 1px 0;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tfont-family: Georgia, serif;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tvertical-align: middle;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button:hover {\r\n");
      out.write("\tborder-top-color: #28597a;\r\n");
      out.write("\tbackground: #28597a;\r\n");
      out.write("\tcolor: #ccc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button:active {\r\n");
      out.write("\tborder-top-color: #1b435e;\r\n");
      out.write("\tbackground: #1b435e;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<SCRIPT type=\"text/javascript\">\r\n");
      out.write("    window.history.forward();\r\n");
      out.write("    function noBack() { window.history.forward(); }\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("</head>\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/Flames1.jpg\" onload=\"noBack();\"\r\n");
      out.write("    onpageshow=\"if (event.persisted) noBack();\" onunload=\"\">\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath() );
      out.write("/Flames\" method=\"post\">\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/love-flames-1-b-512x250.jpg\" height=\"215\" width=\"1010\"></img>\r\n");
      out.write("<center>\r\n");
      out.write("<table>\r\n");
      out.write("\r\n");
      out.write("\t<tr style=\"height:  80px;\">\r\n");
      out.write("\t\t<td ><b><font style=\"text-shadow: \">Name:</font></b></td>\r\n");
      out.write("\t\t<td ><input class=\"textbox\" type=\"text\" name=\"name1\"></td>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr >\r\n");
      out.write("\t\t<td><b><font style=\"text-shadow: \">Partner Name:</font></b></td>\r\n");
      out.write("\t\t<td><input class=\"textbox\" type=\"text\" name=\"name2\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<tr style=\"height:  50px;\"> \r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<center><input class=\"button\" type=\"submit\" name=\"Submit\"></center>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("<tr style=\"height:  50px;\"> \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<center><input class=\"button\" type=\"Reset\" name=\"reset\"></center>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</center>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
