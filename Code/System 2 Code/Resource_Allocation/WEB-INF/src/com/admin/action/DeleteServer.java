/**
Author Name : KanagaNagaraj
Project Name : Cloud_Partitioning
Program Name : DeleteServer.Java
Creation Date : 05- July - 2013
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
import com.admin.process.Serv_Configuration;


public class DeleteServer extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int server_no=Integer.parseInt(request.getParameter("server_no"));
		System.out.println("server no to delete--------"+server_no);
		try
		{
		
			boolean result=Serv_Configuration.deleteServer(server_no);
	
			RequestDispatcher rd;
			if(result)
			{
				response.sendRedirect("JSP/server_config.jsp?no=0&no1=13");
			}
			else
			{	
				request.setAttribute(Global.ADMIN_LOGIN_STATUS, Global.ADMIN_INVALID_MESSAGED);
				rd = request.getRequestDispatcher("JSP/server_config.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in DeleteServer Servlet : "+e);
		}
	}
}
