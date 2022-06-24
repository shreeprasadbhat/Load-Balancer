package com.action;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Flames extends HttpServlet
{
	

	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			int i,j;
			RequestDispatcher rd;
			
			int totlen;
		String str1=req.getParameter("name1");        
		String str2=req.getParameter("name2");
		str1=str1.toUpperCase();
		str2=str2.toUpperCase();
		req.setAttribute("Firstname", str1);
		req.setAttribute("Secondname", str2);
		System.out.println(str1);
		String str3="FLAMES";
		StringBuffer sb1=new StringBuffer(str1);
		StringBuffer sb2=new StringBuffer(str2);
		StringBuffer sb3 = null;
		StringBuffer sb4 = null;
		StringBuffer sb5=new StringBuffer(str3);
		StringBuffer sb6=null;
		
		System.out.println(str1);
		System.out.println(str2);
		
		
							for(i=0;i<sb1.length();i++)
							{
								for(j=0;j<sb2.length();j++)
								{
									if(sb1.charAt(i)==sb2.charAt(j))
									{
										sb3=sb1.deleteCharAt(i);
										sb4=sb2.deleteCharAt(j);
										
										j=sb2.length();
										
										
									}	
								}		
							}	
							
					for(i=0;i<sb3.length();i++)
					{
						for(j=0;j<sb4.length();j++)
						{
							if(sb3.charAt(i)==sb4.charAt(j))
							{
							sb3=sb1.deleteCharAt(i);
							sb4=sb2.deleteCharAt(j);
							}
						}
					}
			System.out.println("sb 3 "+sb3);
			System.out.println("sb 4 "+sb4);
			totlen = str1.length()+str2.length();
			System.out.println("Totlen "+totlen);
			int totsblen=sb3.length()+sb4.length();
			System.out.println("totsblen "+totsblen);
			
			req.setAttribute("totsblen", totsblen);
			rd = req.getRequestDispatcher("/Resources/JSP/flamesCalculation.jsp");
			rd.forward(req, res);
			
	
	}
		catch(Exception e)	
		{
			e.printStackTrace();
		}
}

}
