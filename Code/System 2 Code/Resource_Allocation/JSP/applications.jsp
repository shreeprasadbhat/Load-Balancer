<%@page import="com.admin.service.CL_DAO"%>
<%@ page import="com.admin.process.*" %>
<%@ page import="com.admin.comman.*" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>     
<%@include file="admin_link.jsp" %> 
<html>

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
<title></title>

<style type="text/css">
#p 
{
	border-style:solid;
	border-width:10px;
	border-color:#112EA1;
}
</style>
<script language="javascript">
	function check()
	{
		if(document.f1.app_name.value.length==0 || document.f1.desc.value.length==0 || document.f1.app_image.value.length==0)
		{
			window.location.href = 'applications.jsp?no=1&no1=10';
			return false;      
		}
	}
	function check1()
	{
		if(document.f1.app_name.value.length==0 || document.f1.desc.value.length==0 || document.f1.app_image.value.length==0)
		{
			window.location.href = 'applications.jsp?no=3&no1=10';
			return false;      
		}
	}
</script>
</head>
<body>
<div id="featured" >
     <div class="feat_left">
<%int no=convert(request.getParameter("no"));
int no1=convert(request.getParameter("no1"));
if(no==1)
{
	ResultSet rs3=Serv_Configuration.Servers();
%>

   <form name="f1" method="post" action="<%=request.getContextPath() %>/AddApplication" enctype="multipart/form-data" >
	<table  border="2" cellpadding="5" cellspacing="10" align="center">
		<tr bgcolor="#D2FE48" bordercolor="blue" width="10">
			<th rowspan="1">Application Name</th>
			<th rowspan="1">Server Name</th>
			<th rowspan="1">Application Image</th>
		</tr>
							
		<tr bgcolor="white">
			<td><input type="text" name="app_name" size="20"></td>
			<td><select name="serv_no" size="1">
			<option>----Select Location----</option>
		<%
			while(rs3.next())
			{
		%>
				<option value="<%=rs3.getInt(1)%>"><%=rs3.getString(2)%></option>
			<%
				}
			%>
			</select></td>	
			<td><input type="file" name="app_image" size="20"></td>
		</tr>
		</table>
		<br></br>
	  <center><input type="submit" value="Add Application" name="Add_App" onclick="return check();"></input></center>
	  </form>

	  </div>
<div style="position:absolute;top:245px;left:375px;color:red;background:">
<%
if(request.getAttribute(Global.ADMIN_LOGIN_STATUS) != null){
	if(request.getAttribute(Global.ADMIN_LOGIN_STATUS).toString().equals(Global.ADMIN_INVALID_MESSAGE)){
%>
	<font color="red" size="3"><b>Error oucrred while adding application </b></font>
<%
	}
}
%>
</div>
<%}
else if(no==2)
{
int app_no=convert(request.getParameter("a_no"));	
String app_name=request.getParameter("app_name");
String serv_no=request.getParameter("serv_no");
String app_image=request.getParameter("app_image");
System.out.println(app_no+"-"+app_name+"-"+serv_no+"-"+app_image);
ResultSet rs2=Serv_Configuration.config();
%>
	
     <div class="feat_left" >
	<form name="f1" method="post" action="<%=request.getContextPath() %>/EditApplication">
	<table  border="2" cellpadding="5" cellspacing="10" align="center">
		<tr bgcolor="#D2FE48" bordercolor="blue" width="10">
			<th rowspan="1">Application Name</th>
			<th rowspan="1">Server Name</th>
			<th rowspan="1">Application Image</th>
			
		</tr>
							
		<tr bgcolor="white">
			<input type="hidden" name="app_no" value="<%=app_no%>" size="10">
			<td><input type="text" name="app_name" value="<%=app_name%>" size="20"></td>
			<<td><select name="serv_no" size="1">
			<option>----Select Location----</option>
		<%
			while(rs2.next())
			{
		%>
				<option value="<%=rs2.getInt(1)%>"><%=rs2.getString(2)%></option>
			<%
				}
			%>
			</select></td>	
			<td><input type="file" name="app_image" value="<%=app_image%>" size="20"></td>
			
		</tr>
		</table>
		<br></br>
	  <center><input type="submit" value="Update Application" onclick="return check1();"></input></center>
	  </form>
	  </div>
	  <div style="position:absolute;top:200px;left:375px;color:red;background:">
<%
if(request.getAttribute(Global.ADMIN_LOGIN_STATUS) != null){
	if(request.getAttribute(Global.ADMIN_LOGIN_STATUS).toString().equals(Global.ADMIN_INVALID_MESSAGEE)){
%>
	<font color="red" size="3"><b>Error occered while updating application </b></font>
<%
	}
}
%>
</div>
<%}

else
{%>
	

     <div class="feat_left">
	<table  border="2"  cellpadding="5" cellspacing="10" align="center">
		<tr bgcolor="#D2FE48" id="div1" >
			<th rowspan="1">Application No</th>
			<th rowspan="1">Application Name</th>
			<th rowspan="1">Server Name</th>
			<th rowspan="1">Application Image</th>
			<th rowspan="1">Edit</th>
			<th rowspan="1">Delete</th>
		</tr>
	<%
	Connection con=null;
	Statement st=null;
	ResultSet rs=CL_Applications.applications();
	while(rs.next())
	{%>
		<tr bgcolor="white" id="div2">
			<td><%=rs.getInt(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=Serv_Configuration.getName(rs.getInt(3))%></td>
			<td><%=rs.getString(4) %></td>
			<td bgcolor="white"><a href="<%=request.getContextPath() %>/JSP/applications.jsp?no=2&a_no=<%=rs.getInt(1)%>&app_name=<%=rs.getString(2)%>&serv_no=<%=rs.getInt(3)%>">
				<img src="<%=request.getContextPath() %>/images/edit.jpg" height="30" width="30"></img></a></td>
			<td bgcolor="white"><a href="<%=request.getContextPath() %>/DeleteApplication?a_no=<%=rs.getInt(1) %>"><img src="<%=request.getContextPath() %>/images/Delete.png" height="30" width="30"></img></a></td>
		</tr>
	<%}CL_DAO.closeConnection(con, st, rs);%>
	</table>
	<center style="padding-top: 20px;"><input type="button"  value="Add Application" onclick="window.location.href='<%=request.getContextPath() %>/JSP/applications.jsp?no=1'" ></input></center>
	</div>

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
<%}%>
<br>
<%if(no1==10)
{%>
<table border="0" width="45%" cellpadding="5" cellspacing="10" align="center">
	<tr bgcolor="#9CBA7F">
	<th rowspan="2"><pre>OOP'S......! You haven't filled up all the fields.....</pre></th>
	</tr>
	</table>
<%}%>
<%if(no1==11)
{%>
<table border="0" width="45%" cellpadding="5" cellspacing="10" align="center">
	<tr bgcolor="#9CBA7F">
	<th rowspan="2"><pre>Successfully Added new application.....</pre></th>
	</tr>
	</table>
<%}%>
<%if(no1==12)
{%>
<table border="0" width="45%" cellpadding="5" cellspacing="10" align="center">
	<tr bgcolor="#9CBA7F">
	<th rowspan="2"><pre>Successfully updated the application.....</pre></th>
	</tr>
	</table>
<%}%>
<%if(no1==13)
{%>
<table border="0" width="45%" cellpadding="5" cellspacing="10" align="center">
	<tr bgcolor="#9CBA7F">
	<th rowspan="2"><pre><font color="red">Successfully deleted the application.....</font></pre></th>
	</tr>
	</table>
<%}%>
</body>
</html>