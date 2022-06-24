<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.admin.process.CL_Applications"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.admin.comman.Global"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
		 
        <title>Dynamic Cloud</title>
      
        
        <link rel="stylesheet" type="text/css" href="CSS/style.css" />
        
	<link rel="stylesheet" href="./style.css" type="text/css" />
        <script src="js/modernizr.custom.63321.js"></script>
     
		<style>
			body
			{
				background-image: url('images/3.jpg');
				background-repeat: repeat-x;
			}
			a
			{
				font-size: 18px;
				font-weight: bold;
				color: brown;
			}
		</style>
    </head>
    <body >
     <div id="st">&nbsp;&nbsp;
	
	<%
		ResultSet rs=null;
		rs=CL_Applications.applications();
	%>
	
	<div id="content">
	<div class="menu">
		<ul class="primary-menu">
		&nbsp;&nbsp;&nbsp;<li><a class="social-item" href="<%=request.getContextPath() %>/index.jsp"><img src="<%=request.getContextPath() %>/images/Home.png" height="60" width="60"></a><span class="social-span">Home</span></li>
		<%	while(rs.next())
		{%>
				<li><a class="social-item" href="<%=request.getContextPath() %>/GetRequest?appid=<%=rs.getInt(1)%>&ip=<%=request.getRemoteAddr()%>"><img src="<%=request.getContextPath() %>/images/<%=rs.getString(4)%>" height="60" width="60"></a><span class="social-span"><%=rs.getString(2)%></span></li>
			
		<%}
	%>
		</ul>
	</div>
	
</div>
	
	<div style="position:absolute;top:15px;left:800px">
		<a href="<%=request.getContextPath() %>/JSP/login.jsp"><font color="#D8D8D8">Admin Login</font></a>
	</div>	
 </div>
   
    </body>
</html>