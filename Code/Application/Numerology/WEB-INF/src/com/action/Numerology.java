package com.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Numerology extends HttpServlet 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			int number = 0, sum = 0, rem;

			String str = req.getParameter("name");
			String b="";
		
			str=str.toUpperCase();
			
			System.out.println(str);
			int i;
			RequestDispatcher rd;
			String c="";
			for (i = 0; i < str.length(); i++)
			{
				String a = "" + str.charAt(i);
				if (a.equals("A") || a.equals("I") || a.equals("J")
						|| a.equals("Q") || a.equals("Y")) {
					number = number + 1;
					c=c+" + "+1;
					b=b+"  "+a;
				}
				if (a.equals("B") || a.equals("K") || a.equals("R")) {
					number = number + 2;
					c=c+" + "+2;
					b=b+"  "+a;
				}
				if (a.equals("C") || a.equals("G") || a.equals("L")
						|| a.equals("S")) {
					number = number + 3;
					c=c+" + "+3;
					b=b+"  "+a;
				}
				if (a.equals("D") || a.equals("M") || a.equals("T")) {
					number = number + 4;
					c=c+" + "+4;
					b=b+"  "+a;
				}
				if (a.equals("H") || a.equals("E") || a.equals("N")
						|| a.equals("X")) {
					number = number + 5;
					c=c+" + "+5;
					b=b+"  "+a;
				}
				if (a.equals("U") || a.equals("V") || a.equals("W")) {
					number = number + 6;
					c=c+" + "+6;
					b=b+"  "+a;
				}
				if (a.equals("O") || a.equals("Z")) {
					number = number + 7;
					c=c+" + "+7;
					b=b+"  "+a;
				}
				if (a.equals("P") || a.equals("F")) {
					number = number + 8;
					c=c+" + "+8;
					b=b+"  "+a;
				}	
				System.out.println(a + " is " + number);
			}
			c=c.trim();
			c=c.substring(1,c.length());
			System.out.println("c is "+c);
		
			System.out.println("number is " + number);
			
			req.setAttribute("TotalNumber", number);
			
			
			while (number !=0) 
			{
				while(number != 0)
                {
                     rem = number%10;
                     sum = sum+rem;
                     number=number/10;
                }
                if(sum > 9)
                {
                	number = sum;
                       sum = 0;
                }
			}
			System.out.println("  SUM  : "+sum);
			req.setAttribute("Digits", c);
			req.setAttribute("username", b);
			req.setAttribute("no", sum);
			
			
			req.setAttribute("LuckeyNumber", sum);
			rd = req.getRequestDispatcher("/Resources/JSP/result.jsp");
			rd.forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
