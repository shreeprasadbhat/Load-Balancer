package com.admin.algorithm;


import com.admin.action.GetProperty;
import com.admin.process.Serv_Configuration;
import com.admin.process.Socket_Config;

public class Skewness 
{
	public static String System_status(String appid)
	{
		String url="";
		String address_det="";
		String url_det[]=null;
		
		String serv_det=Socket_Config.checkStatus(appid);
		url_det=serv_det.split("~");
		System.out.println("  serv_det :"+serv_det+"  For Warm_spot");
		if(url_det[2].trim().equals("hot_spot"))
		{
			System.out.println("------------------------------------------------------------------------------");	
			serv_det=Socket_Config.Warmspot();
			if(serv_det==null)
			{
				serv_det=Socket_Config.Coldspot();
				System.out.println("  serv_det :"+serv_det+"  For Cold_spot");
				
				url_det=serv_det.split("~");
				url=Serv_Configuration.getURL(Integer.parseInt(url_det[0]), url_det[1]);
				String url_det1[]=url.split("~");
				address_det=url_det[0]+"~"+ url_det[1]+"~"+url_det1[1]+"~"+url_det1[0]+"~"+"cold_spot";
				System.out.println("  serv_det :"+address_det+"  For Cold_spot");				
			}
			else
			{
				url=Serv_Configuration.getURL(Integer.parseInt(url_det[0]), url_det[1]);
				String url_det1[]=url.split("~");
				address_det=url_det[0]+"~"+ url_det[1]+"~"+url_det1[1]+"~"+url_det1[0]+"~"+"warm_spot";
			}
		}
		else
		{
			url=Serv_Configuration.getURL(Integer.parseInt(url_det[0]), url_det[1]);
			String url_det1[]=url.split("~");
			address_det=url_det[0]+"~"+ url_det[1]+"~"+url_det1[1]+"~"+url_det1[0]+"~"+url_det[2].trim();
		}
		return address_det;
	}
	
	public static String skewness_algo(String cpu_usage,String memory_usuage)
	{
		System.out.println("  cpu_usage  : "+cpu_usage+" memory_usuage  : "+memory_usuage);
		String cpu=cpu_usage;
		cpu=cpu.substring(0, cpu.length()-1);
		float cpuusage=Float.parseFloat(cpu);
		String status=null;
		float memoryusuage=Float.parseFloat(memory_usuage);
		
		float r=(float)(cpuusage+memoryusuage)/2;
		float d1=(cpuusage/r-1)*(cpuusage/r-1);
		float d2=(memoryusuage/r-1)*(memoryusuage/r-1);
		float y=(float) Math.sqrt(d1+d2);
		
		System.out.println("  d1  : "+d1+"  d2  : "+d2+"  r  : "+r);		
		System.out.println("  Skewness  : "+y);
		String cold=GetProperty.getProperty("cold");
		String warm=GetProperty.getProperty("warm");
		float cold_spot=Float.parseFloat(cold);
		float warm_spot=Float.parseFloat(warm);
		
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
}
