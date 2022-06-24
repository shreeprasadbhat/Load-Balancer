package com.admin.algorithm;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.admin.action.GetProperty;
import com.admin.process.CL_Connection_Request;
import com.admin.process.Socket_Config;

public class GreenComputing 
{
	public static void GreenComputing_check()
	{
		String host_address=Socket_Config.GreenCompute();
		String t_load=GetProperty.getProperty("total_load");
		double total_load=Double.parseDouble(t_load);
		
		System.out.println("--------------  host_address :"+host_address);
		if(host_address.contains("~"))
		{
			ResultSet rs1=CL_Connection_Request.connections();
			int observed_value=0;
			try 
			{
				while(rs1.next())
				{
					observed_value=observed_value+1;
				}
				double predict_value=Predtiction_algo(observed_value);
				System.out.println(" Predtiction value  : "+predict_value);
				predict_value=predict_value+observed_value;
				total_load=total_load/2;
				if(predict_value<total_load)
				{
					String host_det[]=host_address.split("~");
					if(host_det[2].equals("0"))
					{
						System.out.println(" host_det[0] : "+host_det[0]);
						Socket_Config.ServerOff(host_det[0]);
					//	JOptionPane.showMessageDialog(null, "By using Green computing algorithm, we are going to shutdown "+host_det[0]+" server.");
						serverShut(host_det[0], Integer.parseInt(host_det[1]));		
					}
					else
					{System.out.println("----------------- no need to server  -");}
				}				
				
			} 
			catch (SQLException e) 
			{e.printStackTrace();}	
		}
		else
		{
			System.out.println("----------------- no need to server  -");
		}		
	}
	
	public static void serverShut(String ipaddress,int port)
	{
		Socket De1;
		try 
		{
			De1 = new Socket(ipaddress,9876);
			DataOutputStream dis2=new DataOutputStream(De1.getOutputStream());
			dis2.writeUTF("Shutdown");
			System.out.println("Shutdown");
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static double Predtiction_algo(int observed_value)
	{	
		Random rand=new Random();
		int r1=rand.nextInt(1);
		int x=Integer.parseInt(GetProperty.getProperty("rand"));
		int r=rand.nextInt(x);
		String alp=GetProperty.getProperty("alpha");
		Float alpha=Float.parseFloat(alp);
		int estimated_value=0;
		if(r1==0)
		{
			estimated_value=observed_value+r;
		}
		else
		{
			estimated_value=observed_value-r;
		}
		double value=observed_value+alpha*(observed_value-estimated_value); 
		
		
		return value;
		
	}
}
