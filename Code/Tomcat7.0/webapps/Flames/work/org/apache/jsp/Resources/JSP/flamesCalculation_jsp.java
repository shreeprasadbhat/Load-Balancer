package org.apache.jsp.Resources.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class flamesCalculation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Flames World</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body background=\"");
      out.print(request.getContextPath());
      out.write("/Resources/Images/Flames1.jpg\" >\r\n");
      out.write("\r\n");


int no=(Integer)request.getAttribute("totsblen");
	
	if(no==19 ||no==1)
	{

      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<h3><font class=\"font-style\">Just for fun only\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.print(request.getAttribute("Firstname") );
      out.write('\r');
      out.write('\n');
out.print(" and "); 
      out.write('\r');
      out.write('\n');
      out.print(request.getAttribute("Secondname") );
      out.write(" are Brother and sister </font></h3>\r\n");
      out.write("<center><img src=\"");
      out.print( request.getContextPath() );
      out.write("/Resources/Images/Sister.png\" height=\"500\" width=\"500\"></center>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
}else if(no==2 ||no==4 ||no==9||no==7){
      out.write("\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<h3><font class=\"font-style\">Just for fun only\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.print(request.getAttribute("Firstname") );
      out.write('\r');
      out.write('\n');
out.print(" and "); 
      out.write('\r');
      out.write('\n');
      out.print(request.getAttribute("Secondname") );
      out.write(" are Enemies</font></h3>\r\n");
      out.write("<center><img src=\"");
      out.print( request.getContextPath() );
      out.write("/Resources/Images/Enemy.png\" height=\"500\" width=\"500\"></center>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
}else if(no==14 || no==16 || no==18 ||no==3||no==5){ 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<h3><font class=\"font-style\">Just for fun only\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.print(request.getAttribute("Firstname") );
      out.write('\r');
      out.write('\n');
out.print(" and "); 
      out.write('\r');
      out.write('\n');
      out.print(request.getAttribute("Secondname") );
      out.write("  are Friend </font></h3>\r\n");
      out.write("<center><img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/Friends.gif\" /></center>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
}else if(no==6||no==11 ||no==15){ 
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<h3><font class=\"font-style\">Just for fun only\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.print(request.getAttribute("Firstname") );
      out.write('\r');
      out.write('\n');
out.print(" and "); 
      out.write('\r');
      out.write('\n');
      out.print(request.getAttribute("Secondname") );
      out.write(" are getting married</font></h3>\r\n");
      out.write("<center><img src=\"");
      out.print( request.getContextPath() );
      out.write("/Resources/Images/Marriage.jpg\" ></center>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
}else if(no==8||no==13||no==17||no==20){ 
      out.write("\r\n");
      out.write("<center> \r\n");
      out.write("<h3>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<font class=\"font-style\">Just for fun only\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.print(request.getAttribute("Firstname") );
      out.write('\r');
      out.write('\n');
out.print(" and "); 
      out.write('\r');
      out.write('\n');
      out.print(request.getAttribute("Secondname") );
      out.write(" are getting Affection</font></h3>\r\n");
      out.write("<br>\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/Images/Affection.jpg\"/>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
}else if(no==10){ 
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<h3><font class=\"font-style\">Just for fun only\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.print(request.getAttribute("Firstname") );
      out.write('\r');
      out.write('\n');
out.print(" and "); 
      out.write('\r');
      out.write('\n');
      out.print(request.getAttribute("Secondname") );
      out.write(" are following love </font></h3>\r\n");
      out.write("<center><img src=\"");
      out.print( request.getContextPath() );
      out.write("/Resources/Images/Lovers.jpg\" height=\"500\" width=\"500\"/></center>\r\n");
      out.write("</center>\r\n");
}else {
      out.write("\r\n");
      out.write("out.println(\"Bye\");\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");
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
