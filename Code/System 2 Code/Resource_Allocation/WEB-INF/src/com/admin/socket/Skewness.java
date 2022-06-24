package com.admin.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.admin.action.GetProperty;
import com.admin.process.Serv_Configuration;
import com.admin.process.Socket_Config;

public class Skewness 
{
	public static String System_status()
	{
		String url="";
		String address_det="";
		String url_det[]=null;
		
		String serv_det=Socket_Config.Warmspot();
		System.out.println("  serv_det :"+serv_det+"  For Warm_spot");
		if(serv_det==null)
		{
			System.out.println("------------------------------------------------------------------------------");
			serv_det=Socket_Config.Coldspot();
			System.out.println("  serv_det :"+serv_det+"  For Cold_spot");
			if(serv_det==null)
			{
				serv_det=Socket_Config.Hotspot();
				url_det=serv_det.split("~");
				url=Serv_Configuration.getURL(Integer.parseInt(url_det[0]), url_det[1]);
				String url_det1[]=url.split("~");
				address_det=url_det[0]+"~"+ url_det[1]+"~"+url_det1[1]+"~"+url_det1[0]+"~"+"hot_spot";
			}
			else
			{
				url_det=serv_det.split("~");
				url=Serv_Configuration.getURL(Integer.parseInt(url_det[0]), url_det[1]);
				String url_det1[]=url.split("~");
				address_det=url_det[0]+"~"+ url_det[1]+"~"+url_det1[1]+"~"+url_det1[0]+"~"+"cold_spot";
				System.out.println("  serv_det :"+address_det+"  For Cold_spot");
			}
		}
		else
		{
			url_det=serv_det.split("~");
			url=Serv_Configuration.getURL(Integer.parseInt(url_det[0]), url_det[1]);
			String url_det1[]=url.split("~");
			address_det=url_det[0]+"~"+ url_det[1]+"~"+url_det1[1]+"~"+url_det1[0]+"~"+"warm_spot";
		}
//		}
//		else
//		{
//			
//			 url=Serv_Configuration.getURL(Integer.parseInt(serv_no), ipaddress);
//			 String url_det1[]=url.split("~");
//			 address_det=serv_no+"~"+ ipaddress+"~"+url_det1[1]+"~"+url_det1[0]+"~"+spot;
//		}
		
		
		return address_det;
		
	}
	
	public static String skewness_algo()
	{
		
		
		String status=null;
	
		
		float r=0;
		float d1 = 0;
		
		ArrayList<Float> list=resourcesPercent();
		
		for(int i=0;i<list.size();i++)
		{
	
			float pro=list.get(i);
			r=r+pro;
			
		}
		r=r/list.size();
		for(int i=0;i<list.size();i++)
		{
	
			float pro=list.get(i);
			if(i==0)
			{
				 d1=(pro/r-1)*(pro/r-1);
			}
			float d2=(pro/r-1)*(pro/r-1);
			d1=d1+d2;
			
		}
		
		float y=(float) Math.sqrt(d1);
		
		
		
		System.out.println("  Skewness  : "+y);
		String cold=GetProperty.getProperty("cold");
		String warm=GetProperty.getProperty("warm");
		
		
		float cold_spot=Float.parseFloat(cold);
		float warm_spot=Float.parseFloat(warm);
		//cpuusage=cpuusage/10;
		
		if(y <=cold_spot)
		{
			status="cold_spot";
		}
		else if (warm_spot>y && y>cold_spot)
		{
			System.out.println("------------------------- warm_spot :"+y);
			status="warm_spot";
		}
		else if (y>=warm_spot)
		{
			System.out.println("******************************** hot spot :"+y);
			status="hot_spot";
		}
		return status+"~"+y;
		
	}
	
	
	public static  ArrayList<Float> resourcesPercent()
	{
		 ArrayList<String> list=new ArrayList<String>();
		 ArrayList<Float> list1=new ArrayList<Float>();
		 try {
   		 
   	        String line;
   	        Process p = Runtime.getRuntime().exec
   	                (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
   	        BufferedReader input =
   	                new BufferedReader(new InputStreamReader(p.getInputStream()));
   	        while ((line = input.readLine()) != null) 
   	        {
   	        	String h[]=line.trim().split("  ");
   	        	int g=h.length;
   	        	list.add(h[g-1].trim());
   	        }
   	      for(int i=0;i<3;i++)
   	      {
   	    	  list.remove(0);
   	      }

   	   for(int i=0;i<list.size();i++)
		{
			String p1=list.get(i);
			p1=p1.substring(0, p1.length()-2);
			String p2=p1.trim().replace(",","");
			float pro=Float.parseFloat(p2.trim());
			list1.add(pro);
			
			
		}
   	        input.close();
   	    } catch (Exception err) {
   	        err.printStackTrace();
   	    }
		return list1;
	}
	
	public static void main(String[] args) 
	{
		String ske=Skewness.skewness_algo();
		System.out.println("------------------------------------  ske : "+ske);
	}
}
