/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.35
 * Generated at: 2016-05-06 01:30:08 UTC
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
import com.admin.process.Socket_Config;
import com.admin.algorithm.GreenComputing;
import com.admin.socket.GetServerDet;
import com.admin.process.CL_Connection_Request;
import java.sql.ResultSet;

public final class active_005fcon_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
	} 

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/JSP/admin_link.jsp", Long.valueOf(1454588700325L));
  }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/CSS/admin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/init.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\">\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("  $(\"a\").click(function(){\r\n");
      out.write("    $(\"#div1\").fadeOut(\"fast\");\r\n");
      out.write("    $(\"#div2\").fadeOut(\"slow\");\r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("  });\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/JavaScript\">\r\n");
      out.write("<!--\r\n");
      out.write("function timedRefresh(timeoutPeriod) \r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("\tsetTimeout(\"location.reload(true);\",timeoutPeriod);\r\n");
      out.write("\t");
  
		GetServerDet.Sendserverreq();
	
	
      out.write("\r\n");
      out.write("}\r\n");
      out.write("//   -->\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("\t\t\tbody\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tbackground-image: url('../images/3.jpg');\r\n");
      out.write("\t\t\t\tbackground-repeat: repeat-x;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function noBack(){window.history.forward();}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");

ResultSet rs1=CL_Connection_Request.connections();
int count=0;
while(rs1.next())
{
	count=count+1;
}

      out.write("\r\n");
      out.write("<body  onpageshow=\"if(event.persisted)noBack();\" onload=\"JavaScript:timedRefresh(40000);noBack();\" >\r\n");
      out.write("\r\n");


String status=null;

status=Socket_Config.GreenComput_Msg();


if(status!=null)
{

      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\talert('By using Green computing algorithm, we are going to shutdown ");
      out.print(status);
      out.write(" server.');\r\n");
      out.write("\t</script>\r\n");

}	

      out.write("\r\n");
      out.write("<div id=\"main_container\" class=\"clear\">\r\n");
      out.write("  <div style=\"padding-top: 12px;padding-left: 12px;\">\r\n");
      out.write("    <div id=\"logo\" class=\"logo_link\" > </div>\r\n");
      out.write("    </div>\r\n");
      out.write("   \t<div style=\"position:absolute;top:100px;left:720px\">\r\n");
      out.write("    <h4 style=\"font-style: Forte;font-family: fantasy;font-size: 12px; padding-top: 10px; color:blue;\">Welcome,&nbsp;Admin&nbsp;<a href=\"");
      out.print(request.getContextPath() );
      out.write("/JSP/admin_logout.jsp\" target=\"_top\">[Logout] </a>&nbsp; Current Users,&nbsp;[");
      out.print(count);
      out.write("]&nbsp; </h4>\r\n");
      out.write("    \t<div style=\"position:absolute;top:30px;left:30px\">\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("     <div class=\"menu\">\r\n");
      out.write("         <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/server_config.jsp\" >Server</a>\r\n");
      out.write("    \t <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/applications.jsp\"  >Application</a>\r\n");
      out.write("   \r\n");
      out.write("         <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/server_det.jsp\" >Server Monitoring</a>\r\n");
      out.write("         <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/active_con.jsp\">Active connections</a>\r\n");
      out.write("          <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/server_spot.jsp\" >Server Spot</a>\r\n");
      out.write("         <a href=\"");
      out.print(request.getContextPath());
      out.write("/JSP/change_pass.jsp\" >Change Password</a>\r\n");
      out.write("    </div>\r\n");
      out.write("   \r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<title>Green Computing</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/CSS/admin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"js/init.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"featured\" >\r\n");
      out.write("  <div class=\"feat_left\">\r\n");
      out.write("  <div style=\"position:absolute;top:0px;left:");
      out.print(150 );
      out.write("px;\">\r\n");
      out.write("\t");

	int c=0;
	ResultSet rs=CL_Connection_Request.connections();
	while(rs.next())
	{c++;
	
      out.write("\r\n");
      out.write("\t<div style=\"position:absolute;top:200px;left:");
      out.print(c*130 );
      out.write("px;\">\r\n");
      out.write("\t<b>");
      out.print(c );
      out.write("</b>\r\n");
      out.write("\t<div style=\"position:absolute;top:20px;left:-25px\">\r\n");
      out.write("\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/con1.png\" height=\"60\" width=\"60\"></img>\r\n");
      out.write("\t\t<div style=\"position:absolute;top:-5px;left:18px\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/on.gif\" height=\"25\" width=\"25\"></img>\r\n");
      out.write("\t\t\t<div style=\"position:absolute;top:75px;left:-35px;width:100px\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/date.png\" height=\"50%\" width=\"100%\"></img>\r\n");
      out.write("\t\t\t\t<div style=\"position:absolute;top:5px;left:0px;width:100px\">\r\n");
      out.write("\t\t\t\t \t");
      out.print(rs.getString(5) );
      out.write("\r\n");
      out.write("\t\t\t\t \t<div style=\"position:absolute;top:20px;left:0px;width:100px\">\r\n");
      out.write("\t\t\t\t \t\t");
      out.print(rs.getTime(3) );
      out.write("\r\n");
      out.write("\t\t\t\t \t\t<div style=\"position:absolute;top:00px;left:0px;width:100px\">\r\n");
      out.write("\t\t\t\t \t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t \t\t\t<div style=\"position:absolute;top:10px;left:0px;width:100px\">\r\n");
      out.write("\t\t\t\t \t\t\t\t<br>Cloud ");
      out.print(rs.getInt(6) );
      out.write("\r\n");
      out.write("\t\t\t\t \t\t\t\t<div style=\"position:absolute;top:20px;left:0px;width:100px\">\r\n");
      out.write("\t\t\t\t \t\t\t\t\t<br>App ");
      out.print(rs.getInt(7) );
      out.write("\r\n");
      out.write("\t\t\t\t \t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
}
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"position:absolute;top:10px;left:375px;color:red;background:\">\r\n");
      out.write("\t");

	if(request.getAttribute(Global.ADMIN_LOGIN_STATUS) != null){
		if(request.getAttribute(Global.ADMIN_LOGIN_STATUS).toString().equals(Global.ADMIN_INVALID_MESSAGED)){
	
      out.write("\r\n");
      out.write("\t\t<font color=\"red\" size=\"3\"><b>Error occurred while deleting server </b></font>\r\n");
      out.write("\t");

		}
	}
	
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
