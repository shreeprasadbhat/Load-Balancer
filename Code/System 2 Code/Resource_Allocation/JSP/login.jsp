<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.admin.comman.Global"%>
<html>
<head>
 <title>Dynamic Cloud</title>
      
        
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/style.css" />
        <script src="<%=request.getContextPath() %>/js/modernizr.custom.63321.js"></script>
     
		<style>
			body {
				background:  url(../images/3.jpg);
				background-repeat: repeat-x;
			}
		</style>

</head>
<body>
	 <div style="position:absolute;top:155px;left:335px;">
        <div class="container" >
		
				<div class="main">
		
					<form class="form-2" action="<%=request.getContextPath()%>/AdminLogin" method="post">
					<h1><span class="log-in">Log in</span> or <span class="sign-up">sign up</span></h1>
					<p class="float">
						<label for="login"><i class="icon-user"></i>Username</label>
						<input type="text" name="username" placeholder="Username or email">
					</p>
					<p class="float">
						<label for="password"><i class="icon-lock"></i>Password</label>
						<input type="password" name="password" placeholder="Password" class="showpassword">
					</p>
					<p class="clearfix"> 
					<input type="submit" name="submit" value="Login">
						<input type="reset" class="log-twitter" ></input>    
						
					</p>
				</form>
			</div>
			
        </div>
        </div>
        
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script type="text/javascript">
			$(function(){
			    $(".showpassword").each(function(index,input) {
			        var $input = $(input);
			        $("<p class='opt'/>").append(
			            $("<input type='checkbox' class='showpasswordcheckbox' id='showPassword' />").click(function() {
			                var change = $(this).is(":checked") ? "text" : "password";
			                var rep = $("<input placeholder='Password' type='" + change + "' />")
			                    .attr("id", $input.attr("id"))
			                    .attr("name", $input.attr("name"))
			                    .attr('class', $input.attr('class'))
			                    .val($input.val())
			                    .insertBefore($input);
			                $input.remove();
			                $input = rep;
			             })
			        ).append($("<label for='showPassword'/>").text("Show password")).insertAfter($input.parent());
			    });

			    $('#showPassword').click(function(){
					if($("#showPassword").is(":checked")) {
						$('.icon-lock').addClass('icon-unlock');
						$('.icon-unlock').removeClass('icon-lock');    
					} else {
						$('.icon-unlock').addClass('icon-lock');
						$('.icon-lock').removeClass('icon-unlock');
					}
			    });
			});
		</script>
		<div style="position:absolute;top:145px;left:375px;color:red;">
<%
if(request.getAttribute(Global.ADMIN_LOGIN_STATUS) != null)
{
	if(request.getAttribute(Global.ADMIN_LOGIN_STATUS).toString().equals(Global.ADMIN_INVALID_MESSAGE))
	{
%>
	<font color="red" size="4"><b>The username or password you entered is incorrect</b></font>
<%
	}
}
%>

<%
if(request.getAttribute(Global.IPADDRESS) != null)
{
	if(request.getAttribute(Global.IPADDRESS).toString().equals(Global.IPADDRESS_INVALID_MESSAGE))
	{
%>
	<font color="red" size="4"><b>Sorry,your IP Address is not Valid</b></font>
<%	}
}
%>

<%
if(request.getAttribute(Global.USER_IPADDRESS) != null)
{
	if(request.getAttribute(Global.USER_IPADDRESS).toString().equals(Global.USER_IPADDRESS_INVALID_MESSAGE))
	{
%>
	<font color="red" size="4"><b>Sorry You are already using .....</b></font>
<%	}
}
%>	
<%
if(request.getAttribute(Global.USER_LOGIN_STATUS) != null)
{
	if(request.getAttribute(Global.USER_LOGIN_STATUS).toString().equals(Global.USER_INVALID_MESSAGE))
	{
%>
	<font color="red" size="4"><b>Server is too busy to handle your request</b></font>
<%	}
}
%>
</div>	
</body>
</html>