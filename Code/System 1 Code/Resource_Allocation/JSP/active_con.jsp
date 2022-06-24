<%@ page import="com.admin.process.*" %>
<%@ page import="com.admin.comman.*" %>
<%@ page import="java.sql.*" %>
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
  <div style="position:absolute;top:0px;left:<%=150 %>px;">
	<%
	int c=0;
	ResultSet rs=CL_Connection_Request.connections();
	while(rs.next())
	{c++;
	%>
	<div style="position:absolute;top:200px;left:<%=c*130 %>px;">
	<b><%=c %></b>
	<div style="position:absolute;top:20px;left:-25px">
		<img src="<%=request.getContextPath() %>/images/con1.png" height="60" width="60"></img>
		<div style="position:absolute;top:-5px;left:18px">
			<img src="<%=request.getContextPath() %>/images/on.gif" height="25" width="25"></img>
			<div style="position:absolute;top:75px;left:-35px;width:100px">
				<img src="<%=request.getContextPath() %>/images/date.png" height="50%" width="100%"></img>
				<div style="position:absolute;top:5px;left:0px;width:100px">
				 	<%=rs.getString(5) %>
				 	<div style="position:absolute;top:20px;left:0px;width:100px">
				 		<%=rs.getTime(3) %>
				 		<div style="position:absolute;top:00px;left:0px;width:100px">
				 			<%--<%=rs.getTime(4) %> --%>
				 			<div style="position:absolute;top:10px;left:0px;width:100px">
				 				<br>Cloud <%=rs.getInt(6) %>
				 				<div style="position:absolute;top:20px;left:0px;width:100px">
				 					<br>App <%=rs.getInt(7) %>
				 				</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<%}%>
	</div>
	<div style="position:absolute;top:10px;left:375px;color:red;background:">
	<%
	if(request.getAttribute(Global.ADMIN_LOGIN_STATUS) != null){
		if(request.getAttribute(Global.ADMIN_LOGIN_STATUS).toString().equals(Global.ADMIN_INVALID_MESSAGED)){
	%>
		<font color="red" size="3"><b>Error occurred while deleting server </b></font>
	<%
		}
	}
	%>
	</div>
</div>
	</div>

</body>
</html>