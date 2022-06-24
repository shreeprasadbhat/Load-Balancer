/**
Author Name : KanagaNagaraj
Project Name : Cloud_Partitioning
Program Name : ChangePass.Java
Creation Date : 04- July - 2013
 * 
 */
package com.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.comman.Global;
import com.admin.process.CL_Admin;


public class ChangePass extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String pass=request.getParameter("pass");
			System.out.println("Your new password - "+pass);
			boolean result = CL_Admin.changePass(pass);
			RequestDispatcher rd;
			if(result)
			{
				response.sendRedirect("JSP/change_pass.jsp?no=1");
			}
			else
			{	
				request.setAttribute(Global.ADMIN_LOGIN_STATUS, Global.ADMIN_INVALID_MESSAGE);
				rd = request.getRequestDispatcher("JSP/change_pass?no=0");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
