/**
Author Name : KanagaNagaraj
Project Name : Cloud_Partitioning
Program Name : GetRequest.Java
Creation Date : 06- July - 2013
 * 
 */
package com.admin.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;

import javax.servlet.http.*;

import com.admin.algorithm.Skewness;
import com.admin.comman.Global;
import com.admin.process.*;
import com.admin.service.CL_DAO;




public class GetRequest extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String ip=request.getParameter("ip");
			String appid=request.getParameter("appid");
			System.out.println("..."+ip+"...."+appid);	
			int a_no=Integer.parseInt(appid);
			
			if(ip!=null)
			{
				String url_det=Skewness.System_status(appid);
				HttpSession httpSession = request.getSession(true);
				String u1[]=url_det.split("~");
				httpSession.setAttribute("status", " By using Skewness Algorithm selected Server is "+u1[3]+" .Status of Server spot is "+u1[4]+".");
				
				int	serv_no=Integer.parseInt(u1[0]);
				String	url=u1[2];
				String app_name=CL_Applications.getName(a_no);
				url=url+app_name;
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat dateFormatter=new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat timeFormatter=new SimpleDateFormat("HH:mm:ss");
				String date = dateFormatter.format(currentDate.getTime());
				String time = timeFormatter.format(currentDate.getTime());
				CL_Connection_Request.addConnection(date, time, ip, serv_no, a_no ,"LIVE");
				Serv_Configuration.addConnection(serv_no);
				
				httpSession.setAttribute(Global.USER_SESSION_STATUS, Global.USER_SESSION_VALUE);
				httpSession.setAttribute(Global.USER_ID, ip);
				response.sendRedirect("JSP/user_set.jsp?url="+url);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in GetRequest Servlet : "+e);
		}
		finally
		{
			CL_DAO.closeConnection(con, st, rs);
		}
	}
	
	
}
