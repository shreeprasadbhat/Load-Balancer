
<%@page import="com.admin.process.Socket_Config"%>
<%@page import="com.admin.algorithm.GreenComputing"%>
<%@page import="com.admin.socket.GetServerDet"%>
<%@page import="com.admin.process.CL_Connection_Request"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />

<link href="<%=request.getContextPath()%>/CSS/admin.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/init.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
$(document).ready(function(){
  $("a").click(function(){
    $("#div1").fadeOut("fast");
    $("#div2").fadeOut("slow");
   
  
  });
});
</script>
<script type="text/JavaScript">
<!--
function timedRefresh(timeoutPeriod) 
{
	
	setTimeout("location.reload(true);",timeoutPeriod);
	<%  
		GetServerDet.Sendserverreq();
	
	%>
}
//   -->
</script>
<style>
			body
			{
				background-image: url('../images/3.jpg');
				background-repeat: repeat-x;
			}
		</style>
<script type="text/javascript">
function noBack(){window.history.forward();}
</script>
</head>
<%
ResultSet rs1=CL_Connection_Request.connections();
int count=0;
while(rs1.next())
{
	count=count+1;
}
%>
<body  onpageshow="if(event.persisted)noBack();" onload="JavaScript:timedRefresh(40000);noBack();" >

<%

String status=null;

status=Socket_Config.GreenComput_Msg();


if(status!=null)
{
%>
	<script type="text/javascript">
		alert('By using Green computing algorithm, we are going to shutdown <%=status%> server.');
	</script>
<%
}	
%>
<div id="main_container" class="clear">
  <div style="padding-top: 12px;padding-left: 12px;">
    <div id="logo" class="logo_link" > </div>
    </div>
   	<div style="position:absolute;top:100px;left:720px">
    <h4 style="font-style: Forte;font-family: fantasy;font-size: 12px; padding-top: 10px; color:blue;">Welcome,&nbsp;Admin&nbsp;<a href="<%=request.getContextPath() %>/JSP/admin_logout.jsp" target="_top">[Logout] </a>&nbsp; Current Users,&nbsp;[<%=count%>]&nbsp; </h4>
    	<div style="position:absolute;top:30px;left:30px">
    		
    	</div>
    </div>
     <div class="menu">
         <a href="<%=request.getContextPath()%>/JSP/server_config.jsp" >Server</a>
    	 <a href="<%=request.getContextPath()%>/JSP/applications.jsp"  >Application</a>
   
         <a href="<%=request.getContextPath()%>/JSP/server_det.jsp" >Server Monitoring</a>
         <a href="<%=request.getContextPath()%>/JSP/active_con.jsp">Active connections</a>
          <a href="<%=request.getContextPath()%>/JSP/server_spot.jsp" >Server Spot</a>
         <a href="<%=request.getContextPath()%>/JSP/change_pass.jsp" >Change Password</a>
    </div>
   
    </div>
</body>
</html>
