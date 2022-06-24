<%@ page import="com.admin.process.*" %>
<%@ page import="com.admin.comman.*" %>
<%@ page import="java.sql.*" %>
<%
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
    %>
<html><head><title></title>


<%

String status=null;

status=(String)hs.getAttribute("status");

if(status!=null)
{
%>
	<script type="text/javascript">
		alert('<%=status%>');
	</script>
<%
}	


%>
<script type="text/javascript">
function noBack(){window.history.forward();}
</script>
<script language="JavaScript" type="text/javascript">
window.history.forward(1);
</script>

<style type="text/css">

#header
{ 	
	width:100px;
	height:10%;
	color: #000000; 
	

}
#menu
{
	position: absolute;
	font-size: 25px;
}



</style>
</head>

<body onload="noBack();" onpageshow="if(event.persisted)noBack();">

 <div id="header" >
				<font color="brown" size="5px" >ExclusiveBuy.com</font>
				<%
	ResultSet rs1=CL_Connection_Request.connections(UserName);
	while(rs1.next())
	{
		
	
%>
				<div id="menu">
					
					<a href="<%=request.getContextPath() %>/JSP/user_logout.jsp?c_no=<%=rs1.getInt(1) %>&s_no=<%=rs1.getInt(6) %>&a_no=<%=rs1.getInt(7) %>&ip=<%=rs1.getString(5) %>" target="_top" ><font color=black size="4px">Home</font></a> &nbsp; 
						
					
				</div>
				<%} %>
				
			</div>
	
			
</body>

</html>
 