/**
 * 
 */
package com.admin.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.comman.Global;
import com.admin.process.CL_Applications;


public class DeleteApplication extends HttpServlet 
{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		int a_no=Integer.parseInt(request.getParameter("a_no"));
		System.out.println("App no to delete--------"+a_no);
		try
		{
			boolean result=CL_Applications.deleteApplication(a_no);
			
			RequestDispatcher rd;
			if(result)
			{
				response.sendRedirect("JSP/applications.jsp?no=0&no1=13");
			}
			else
			{	
				request.setAttribute(Global.ADMIN_LOGIN_STATUS, Global.ADMIN_INVALID_MESSAGED);
				rd = request.getRequestDispatcher("JSP/application.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in DeleteApplication Servlet : "+e);
		}
	}
}
