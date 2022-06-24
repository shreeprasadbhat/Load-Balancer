<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.admin.service.CL_DAO"%>

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

<script language="javascript">
	function check()
	{
		if(document.f1.server_name.value.length==0 || document.f1.url.value.length==0 || document.f1.totalB.value.length==0 || document.f1.per_conn.value.length==0)
		{
			window.location.href = 'server_config.jsp?no=1&no1=10';
			return false;      
		}
	}
	function check1()
	{
		if(document.f1.server_name.value.length==0 || document.f1.url.value.length==0 || document.f1.totalB.value.length==0 || document.f1.per_conn.value.length==0)
		{
			window.location.href = 'server_config.jsp?no=3&no1=10';
			return false;      
		}
	}
</script>

</head>
<body>
<script type="text/javascript">
$(function() {
$("#featured").tabs({ fx: { height: 'toggle', opacity: 'toggle' } }); });  
</script>
	<div id="featured" >
     <div class="feat_left">
     <%int no=convert(request.getParameter("no"));
int no1=convert(request.getParameter("no1"));
if(no==1)
{
	
%>

    <form name="f1" method="post" action="<%=request.getContextPath() %>/AddServer">
	<table border="2" cellpadding="2" cellspacing="10" align="center">
		<tr bgcolor="#D2FE48" bordercolor="blue" width="10">
			<th rowspan="1">Server Name</th>
			<th rowspan="1">URL</th>
			<th rowspan="1">IP Address</th>
			<th rowspan="1">Port</th>
		</tr>
			
				
		<tr bgcolor="white">
			<td><input type="text" name="server_name" size="10"></td>
			<td><input type="text" name="url" size="15"></td>
			<td><input type="text" name="ipaddress" size="15"></td>
			<td><input type="text" name="port" size="15"></td>
		
		</tr>
		</table>
		<br></br>
	  <center><input type="submit" value="Add Server" onclick="return check();"></input></center>
	  </form>
	  
	  </div>
	  
<div style="position:absolute;top:245px;left:375px;color:red;background:">
<%
if(request.getAttribute(Global.ADMIN_LOGIN_STATUS) != null){
	if(request.getAttribute(Global.ADMIN_LOGIN_STATUS).toString().equals(Global.ADMIN_INVALID_MESSAGE))
	{
%>
	<font color="red" size="3"><b>Error occurred while adding server </b></font>
<%
	}
}
%>
</div>
<%}
else if(no==2)
{
int server_no=convert(request.getParameter("s_no"));	
String server_name=request.getParameter("s_name");
String url=request.getParameter("s_url");
String ipaddress=request.getParameter("s_ipaddress");
int port=convert(request.getParameter("s_port"));
System.out.println(server_no+"-"+server_name+"-"+url+"-"+port);
%>
 <div class="feat_left">

	<form name="f1" method="post" action="<%=request.getContextPath() %>/EditServer">
	<table  border="2" cellpadding="5" cellspacing="10" align="center">
		<tr bgcolor="#D2FE48" bordercolor="blue" width="10">
			<th rowspan="1">Server Name</th>
			<th rowspan="1">URL</th>
			<th rowspan="1">IP Address</th>
			<th rowspan="1">Port</th>
			
		</tr>
			
				
		<tr bgcolor="white">
			<input type="hidden" name="server_no" value="<%=server_no%>" size="10">
			<td><input type="text" name="server_name" value="<%=server_name%>" size="10"></td>
			<td><input type="text" name="url" value="<%=url%>" ></td>
			<td><input type="text" name="ipaddress" value="<%=ipaddress%>" ></td>
			<td><input type="text" name="port" value="<%=port%>" ></td>
		</tr>
		</table>
		<br></br>
	  <center><input type="submit" value="Update Server" onclick="return check1();"></input></center>
	  </form>
	  </div>
	  <div style="position:absolute;top:200px;left:375px;color:red;background:">
<%
if(request.getAttribute(Global.ADMIN_LOGIN_STATUS) != null){
	if(request.getAttribute(Global.ADMIN_LOGIN_STATUS).toString().equals(Global.ADMIN_INVALID_MESSAGEE)){
%>
	<font color="red" size="3"><b>Error occurred while updating server </b></font>
<%
	}
}
%>
</div>
<%}
else
{%>
	
	
     
     <div class="feat_left">
    <table  border="2" cellpadding="5" cellspacing="10" align="center">
		<tr bgcolor="#D2FE48" bordercolor="blue" id="div1">
			<th rowspan="1">Server No</th>
			<th rowspan="1">Server Name</th>
			<th rowspan="1">URL</th>
			<th rowspan="1">Current Connections</th>
			<th rowspan="1">Status</th>
			<th rowspan="1">Ipaddress</th>
			<th rowspan="1">Port</th>
			<th rowspan="1">Edit</th>
			<th rowspan="1">Delete</th>
		</tr>
		
		
		
	<%
	Connection con=null;
	Statement st=null;
	ResultSet rs=Serv_Configuration.config();
	
	while(rs.next())
	{%>
		<tr bgcolor="white" id="div2">
			<td><%=rs.getInt(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getInt(4) %></td>
			<td><%=rs.getString(5) %></td>
			<td><%=rs.getString(6) %></td>
			<td><%=rs.getInt(7)%></td>
			<td bgcolor="white"><a href="<%=request.getContextPath() %>/JSP/server_config.jsp?no=2&s_no=<%=rs.getInt(1)%>&s_name=<%=rs.getString(2)%>&s_url=<%=rs.getString(3)%>&s_ipaddress=<%=rs.getString(6)%>&s_port=<%=rs.getInt(7)%>">
				<img src="<%=request.getContextPath() %>/images/edit.jpg" height="30" width="30"></img></a></td>
			<td bgcolor="white"><a href="<%=request.getContextPath() %>/DeleteServer?server_no=<%=rs.getInt(1) %>"><img src="<%=request.getContextPath() %>/images/Delete.png" height="30" width="30"></img></a></td>
		</tr>
	<%}
	CL_DAO.closeConnection(con, st, rs);
	%>
	
	</table>
	
	<center style="padding-top: 20px;"><input type="button" id="div3"  value="Add Server" onclick="window.location.href='<%=request.getContextPath() %>/JSP/server_config.jsp?no=1'" ></input></center>
	
	
	 </div>
	<div style="position:absolute;top:10px;left:375px;color:red;background:">
<%
if(request.getAttribute(Global.ADMIN_LOGIN_STATUS) != null){
	if(request.getAttribute(Global.ADMIN_LOGIN_STATUS).toString().equals(Global.ADMIN_INVALID_MESSAGED)){
%>
	<font color="red" size="3"><b>Error occered while deleting server </b></font>
<%
	}
}
%>
</div>
<%}%><br>
<%if(no1==10)
{%>
<table border="0" width="45%" cellpadding="5" cellspacing="10" align="center">
	<tr bgcolor="#9CBA7F">
	<th rowspan="2"><pre>OOP'S......! You have't filled up all the fields.....</pre></th>
	</tr>
	</table>
<%}%>
<%if(no1==11)
{%>
<table border="0" width="45%" cellpadding="5" cellspacing="10" align="center">
	<tr bgcolor="#9CBA7F">
	<th rowspan="2"><pre>Succeefully Added new server.....</pre></th>
	</tr>
	</table>
<%}%>
<%if(no1==12)
{%>
<table border="0" width="45%" cellpadding="5" cellspacing="10" align="center">
	<tr bgcolor="#9CBA7F">
	<th rowspan="2"><pre>Successfully updated the server.....</pre></th>
	</tr>
	</table>
<%}%>
<%if(no1==13)
{%>
<table border="0" width="45%" cellpadding="5" cellspacing="10" align="center">
	<tr bgcolor="#9CBA7F">
	<th rowspan="2"><pre><font color="red">Successfully deleted the server.....</font></pre></th>
	</tr>
	</table>
<%}%>
</body>
	
	</div>
     </div>
   </div>
     
      
     
</body>
</html>
