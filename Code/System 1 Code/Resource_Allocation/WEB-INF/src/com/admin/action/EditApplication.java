/**
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
import com.admin.process.CL_Applications;


public class EditApplication extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int a_no=Integer.parseInt(request.getParameter("app_no"));
		String a_name=request.getParameter("app_name");
		String serv_no=request.getParameter("serv_no");
		String app_image=request.getParameter("app_image");
		System.out.println("---in Servlet"+a_no+"-"+a_name+"-"+serv_no+"-"+app_image);
		try
		{
			boolean result=CL_Applications.editApplication(a_no, a_name, serv_no,app_image);
			RequestDispatcher rd;
			if(result)
			{
				response.sendRedirect("JSP/applications.jsp?no=0&no1=12");
			}
			else
			{	
				request.setAttribute(Global.ADMIN_LOGIN_STATUS, Global.ADMIN_INVALID_MESSAGEE);
				rd = request.getRequestDispatcher("JSP/applications.jsp?no=2&app_no="+a_no+"&app_name="+a_name+"&desc="+serv_no+"&app_image="+app_image+"");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in EditApplication Servlet : "+e);
		}
	}
}
