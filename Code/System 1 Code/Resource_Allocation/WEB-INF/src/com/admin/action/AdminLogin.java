/**
 * Author Name : KanagaNagaraj
Project Name : Cloud_Dynamic
Program Name : AdminLogin.Java
Creation Date : 04- July - 2013
 */
package com.admin.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.comman.Global;
import com.admin.process.CL_Admin;


public class AdminLogin extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("  username :"+username+" password :"+password);
		try 
		{
			boolean result=CL_Admin.checkAdmin(username,password);
			if(result)
			{
				request.setAttribute("name", username);
				response.sendRedirect("JSP/home.jsp");
			}
			else
			{	
				RequestDispatcher rd;
				request.setAttribute(Global.ADMIN_LOGIN_STATUS, Global.ADMIN_INVALID_MESSAGE);
				rd = request.getRequestDispatcher("JSP/login.jsp");
				rd.forward(request, response);
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Exception in AdminLogin Servlet : "+e);
		}
	}
}
