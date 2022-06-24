/**
Author Name : KanagaNagaraj

Project Name : Cloud_Dynamic
Program Name : AddServer.Java
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


public class AddServer extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String server_name=request.getParameter("server_name");
		String url=request.getParameter("url");
		String ipaddress=request.getParameter("ipaddress");
		String port=request.getParameter("port");
		
		System.out.println(server_name+"-"+url+"-"+ipaddress+"-"+port);
		try
		{
			RequestDispatcher rd;
			boolean result=Serv_Configuration.addServer(server_name, url,ipaddress,port);
			if(result)
			{
				response.sendRedirect("JSP/server_config.jsp?no=0&no1=11");
			}
			else
			{	
				request.setAttribute(Global.ADMIN_LOGIN_STATUS, Global.ADMIN_INVALID_MESSAGE);
				rd = request.getRequestDispatcher("JSP/server_config.jsp?no=1");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in AddServer Servlet : "+e);
		}
	}
}
