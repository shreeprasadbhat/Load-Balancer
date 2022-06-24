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
<%
int no=convert(request.getParameter("no"));
int no1=convert(request.getParameter("no1"));
if(no==0)
{
%>
<head><title></title>
<script language="javascript">
	function check()
	{
		if(document.f1.pass.value.length==0)
		{
			window.location.href = 'change_pass.jsp?no=0&no1=2';
			return false;      
		}
	}
</script>
</head>
<body>
<div style="padding-top: 100px;padding-left: 100px;">
	<table id="p" border="0"   align="center">
		
		<tr>
			<td bgcolor="#D2FE48"><font size="4px;"><b>Enter Your new Password</b></font></td>
			<td>     </td>
			<td><form name="f1" method="post" action="<%=request.getContextPath() %>/ChangePass">
					<input type="text" name="pass"></input>
					
				</form>
			</td>
		</tr>
			
		</table>
		<div style="padding-left: 400px; padding-top: 40px;">
			<input type="submit" value="Update" onclick="return check();"></input>
		</div>
		
</div>
<%
if(no1==2)
{%>
<table id="p" border="0" width="45%" cellpadding="5" cellspacing="10" align="center">
	<tr bgcolor="#A9D2FB" bordercolor="blue">
	<th rowspan="2"><pre>OOP'S......! Please enter your new password</pre></th>
	</tr>
	</table>
<%}}
else
{%>
	<table id="p" border="0" width="45%" cellpadding="5" cellspacing="10" align="center">
		<tr bgcolor="#A9D2FB" bordercolor="blue">
			<th rowspan="2">Your Password has been changed successfully</th>
		</tr>
	</table>
<%}%>
</body>
</html>