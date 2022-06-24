<%@ page import="com.admin.process.*" %>
<%@ page import="com.admin.comman.*" %>
<%@ page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Out</title>
<%-- JAVA SCRIPT FOR NO BACK BUTTON --%>


</head>
<body bgcolor=#111111>
<%
// Set to expire far in the past.
//response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
// Set standard HTTP/1.1 no-cache headers.
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
// Set standard HTTP/1.0 no-cache header.
response.setHeader("Pragma", "no-cache");
%>
<%
	int c_no=Integer.parseInt(request.getParameter("c_no"));
	int s_no=Integer.parseInt(request.getParameter("s_no"));
   int a_no=Integer.parseInt(request.getParameter("a_no"));	
   String ip=request.getParameter("ip");
   int con=Serv_Configuration.removeConnection(s_no);
  
  
  	CL_Connection_Request.deleteConnection(c_no);
   
   HttpSession hs = request.getSession();
   hs.invalidate();
   request.setAttribute("Message","logged out successfully");
   String path1=request.getContextPath()+"/index.jsp";
   response.sendRedirect(path1);
%>
</body>
</html>