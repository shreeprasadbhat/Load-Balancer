/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.35
 * Generated at: 2016-05-06 01:40:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.admin.process.*;
import com.admin.comman.*;
import java.sql.*;

public final class user_005fheader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

   String UserName = "";
   HttpSession hs = request.getSession();
   
    if(hs==null)
    {
      response.sendRedirect("Error.jsp");
    }
    else
    {
      if(hs.getAttribute(Global.USER_SESSION_STATUS).equals(Global.USER_SESSION_VALUE))
      {
       UserName = (String)hs.getAttribute(Global.USER_ID);
      }
      else
      {
       response.sendRedirect("Error.jsp");
      }
    }
    System.out.println("--------"+UserName);
    
      out.write("\r\n");
      out.write("<html><head><title></title>\r\n");
      out.write("\r\n");
      out.write("\r\n");


String status=null;

status=(String)hs.getAttribute("status");

if(status!=null)
{

      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\talert('");
      out.print(status);
      out.write("');\r\n");
      out.write("\t</script>\r\n");

}	



      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function noBack(){window.history.forward();}\r\n");
      out.write("</script>\r\n");
      out.write("<script language=\"JavaScript\" type=\"text/javascript\">\r\n");
      out.write("window.history.forward(1);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("#header\r\n");
      out.write("{ \t\r\n");
      out.write("\twidth:100px;\r\n");
      out.write("\theight:10%;\r\n");
      out.write("\tcolor: #000000; \r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("#menu\r\n");
      out.write("{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tfont-size: 25px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"noBack();\" onpageshow=\"if(event.persisted)noBack();\">\r\n");
      out.write("\r\n");
      out.write(" <div id=\"header\" >\r\n");
      out.write("\t\t\t\t<font color=\"brown\" size=\"5px\" >ExclusiveBuy.com</font>\r\n");
      out.write("\t\t\t\t");

	ResultSet rs1=CL_Connection_Request.connections(UserName);
	while(rs1.next())
	{
		
	

      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/JSP/user_logout.jsp?c_no=");
      out.print(rs1.getInt(1) );
      out.write("&s_no=");
      out.print(rs1.getInt(6) );
      out.write("&a_no=");
      out.print(rs1.getInt(7) );
      out.write("&ip=");
      out.print(rs1.getString(5) );
      out.write("\" target=\"_top\" ><font color=black size=\"4px\">Home</font></a> &nbsp; \r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write(" ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
