<%@page import="com.admin.service.CL_DAO"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.admin.process.Socket_Config"%>
<%@page import="com.admin.comman.Global"%>
<%@page import="com.admin.process.Serv_Configuration"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>     
<%@include file="admin_link.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%! 
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
%>
<head>
<title>Green Computing</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link href="<%=request.getContextPath()%>/CSS/admin.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/init.js" type="text/javascript"></script>


</head>
<body>

	<div id="featured" >
     
     
     <div class="feat_left">
    <table  border="2" cellpadding="3" cellspacing="12" align="center">
		<tr bgcolor="#D2FE48" id="div1">
			<th rowspan="1">Server No</th>
			<th rowspan="1">Server Name</th>
			<th rowspan="1">Ip Address</th>
			<th rowspan="1">Server Spot</th>
			<th rowspan="1">Server Status</th>
		</tr>
		
		
	<%
	Connection con=null;
	Statement st=null;
	ResultSet rs=CL_Connection_Request.server_spot();
	while(rs.next())
	{%>
		<tr bgcolor="white" id="div2">
			<td><%=rs.getInt(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getString(4) %></td>
			<td><%=rs.getString(5) %></td>
		</tr>
	<%} CL_DAO.closeConnection(con, st, rs);%>
	</table>
	
	 </div>
	
</div>


</body>

</html>
