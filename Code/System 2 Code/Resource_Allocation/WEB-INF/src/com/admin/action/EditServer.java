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
import com.admin.process.Serv_Configuration;


public class EditServer extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int server_no=Integer.parseInt(request.getParameter("server_no"));	
		String server_name=request.getParameter("server_name");
		String url=request.getParameter("url");
		String ipaddress=request.getParameter("ipaddress");
		int port=Integer.parseInt(request.getParameter("port"));	
		
		System.out.println("---in Servlet"+server_no+"-"+server_name+"-"+url+"-"+"-"+ipaddress+"-"+port);
		try
		{
			boolean result=Serv_Configuration.editServer(server_no, server_name, url,ipaddress,port);
			RequestDispatcher rd;
			if(result)
			{
				response.sendRedirect("JSP/server_config.jsp?no=0&no1=12");
			}
			else 
			{	
				request.setAttribute(Global.ADMIN_LOGIN_STATUS, Global.ADMIN_INVALID_MESSAGEE);
				rd = request.getRequestDispatcher("JSP/server_config.jsp?no=2&s_no="+server_no+"&s_name="+server_name+"&s_url="+url+"&s_ipaddress="+ipaddress+"&port="+port+"    ");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in EditServer Servlet : "+e);
		}
	}
}
