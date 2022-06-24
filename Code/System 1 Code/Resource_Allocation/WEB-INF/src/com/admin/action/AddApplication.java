/**
 * 
 */
package com.admin.action;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.admin.comman.Global;
import com.admin.process.CL_Applications;

public class AddApplication extends HttpServlet
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String app_name="";
		String serv_no="";
		String app_image="";
		String fileName = "";

		String filepath = "";
		boolean flag = false;
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&7"+app_name+"-"+serv_no+"-"+app_image);
		try
		{
			RequestDispatcher rd;
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			System.out.println("------------------------------------------ boolean "+isMultipart);
			if(isMultipart)
 			{
 				FileItemFactory factory = new DiskFileItemFactory();
 	            ServletFileUpload upload = new ServletFileUpload(factory);
 	            
 	            try 
 	            {
 	            	List items = upload.parseRequest(request);
  	                Iterator iterator = items.iterator();
  	                while (iterator.hasNext()) 
  	                {
  	                	FileItem item = (FileItem) iterator.next();
  	                	
  	                	
	                    if (item.isFormField()) 
	                    {
	                    	 String name = item.getFieldName();
	                         String value = item.getString();
	                         if(name.equals("app_name"))
	                         {
	                        	 app_name=value;
	                         }
	                         if(name.equals("serv_no"))
	                         {
	                        	 serv_no=value;
	                         }
	                    
	                    }
	                    else 
	                    {
	                    	 fileName = item.getName();
	                    	   //filepath = request.getRealPath("")+"\\Files\\Encryption\\"+fileName;
	                    	 filepath = request.getRealPath("")+"\\Files\\Image\\"+fileName;
			  	             File f1=new File(filepath);
			  	             item.write(f1);
			  	             flag = true;
			  	             System.out.println("File Uploaded Successfully......");
			  	            
	                    }
	                        
  	                }
  	              if(flag)
  				{
  					
  	            	boolean result=CL_Applications.addApplication(app_name, serv_no,fileName);
	  	  			if(result)
	  	  			{
	 	  				response.sendRedirect("JSP/applications.jsp?no=0&no1=11");
	  	  			}
	  	  			else
	 	  			{	
	  	  				request.setAttribute(Global.ADMIN_LOGIN_STATUS, Global.ADMIN_INVALID_MESSAGE);
	  	  				rd = request.getRequestDispatcher("JSP/applications.jsp?no=1");
	  	  				rd.forward(request, response);
	  	  			}
  				}
  				else
  				{
  					System.out.println("Opps,Something Went While Uploading The File!");
  				}
  	                
//  	                encKey = list.get(0).toString();
//  	                System.out.println("Image Encryption Key : " + encKey);
				}
 	            catch (Exception e)
 	            {
					System.out.println("Opps,Exception While Uploading The File : " );
					e.printStackTrace();
				}
 			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in AddApplication Servlet : "+e);
		}
		
		
		
	}
}
