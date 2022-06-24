package com.admin.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import sun.misc.Perf.GetPerfAction;

import com.admin.action.GetProperty;
import com.admin.algorithm.GreenComputing;
import com.admin.algorithm.Skewness;
import com.admin.process.CL_Connection_Request;
import com.admin.process.Serv_Configuration;
import com.admin.process.Socket_Config;
import com.admin.socket.ServerDet.ServerDetails;

public class GetServerDet 
{
	GetServerDet()
	{
	//	System.out.println("Server Access Running");
		Thread t=new Thread(new ServerDetails());
		t.setName("Listener-ServerDetalis" );
		t.start();
	}
	

	class ServerDetails implements Runnable
	{
		int port;
		
		
		public void run()
		{
   				try 
   				{ 
   					String address=Socket_Config.GetUsherCtrl();
					String data[]=address.split("~");
					port=Integer.parseInt(data[1]);
   					ServerSocket server = new ServerSocket(port);
   				    
   				    while (true)
   			        {
   				    	
   						Socket socket=server.accept();
   			//	    	System.out.println("  Connection :"+socket);
						
   						InputStream is=socket.getInputStream();
   												
   						DataInputStream dis=new DataInputStream(is);
   						String ipaddress=dis.readUTF();
   						int port1=dis.readInt();
   						int len=dis.readInt();
   						String cpu_det=dis.readUTF();
   						cpu_det=cpu_det.trim().substring(1, cpu_det.length()-1);				
   
   						
   						String sys_data[]=cpu_det.trim().split(",");
   						HashMap<String, String> map=new HashMap<String, String>();
   						
   						for(int i=0;i<len;i++)
   						{
   							String value[]=sys_data[i].trim().split("=");
   							map.put(value[0].trim(), value[1].trim());
   						}
   						String sys_usage_det=System_Usage(map.get("cpu_usage"), map.get("system_memory"), map.get("used_memory"));
   						String sys_usage[]=sys_usage_det.split("~");
   						String usage_percent=""+sys_usage[1];
   						String stat=Skewness.skewness_algo(map.get("cpu_usage"),sys_usage[0]);
   						System.out.println("==================================  stat  : "+stat);
   						String status[]=stat.split("~");
   						int count=CL_Connection_Request.getHotConnections(ipaddress, port1);
   						System.out.println("  Count value :"+count);
   						if(count>5)
   						{
   							status[0]="hot_spot";
   							System.out.println("------------------------ "+status[0]);
   						}
   						if(count>2 && count<5)
   						{
   							status[0]="warm_spot";
   							System.out.println("------------------------ "+status[0]);
   						}
   						
   						map.put("status", ""+status[0]);
   						map.put("usage_percent",usage_percent);
   						Socket_Config.GetServerDet(map, ipaddress,port1);  							
   						GreenComputing.GreenComputing_check();
   			        }
   				}
   				catch(Exception e)
   				{
   					
   				}
		}
		
	}
	public static boolean Sendserverreq()
	{
		Map map= Serv_Configuration.GetserverDet();
		ArrayList<String> ipaddress=(ArrayList<String>) map.get(1);
		ArrayList<Integer> port= (ArrayList<Integer>) map.get(2);
		//System.out.println("  ipaddress :"+ipaddress+"  port :"+port);
		Socket so1;
		
		try 
		{
			for(int i=0;i<ipaddress.size();i++)
			{
				String host=ipaddress.get(i);
				int portno=port.get(i);
			//	System.out.println("  hosat :"+host+"  port :"+portno);
				so1 = new Socket(host,portno);
				DataOutputStream dos=new DataOutputStream(so1.getOutputStream());
				dos.writeUTF("Server Details");
			
				//System.out.println("\nPackets Sending Completed");
				dos.flush();
				dos.close();
				so1.close();
			}
		}catch (IOException e) {e.printStackTrace();}
		
		
		return false;
		
	}
	public static String System_Usage(String cpu_usage,String sys_mem,String used_mem)
	{
		
			String cpu=cpu_usage;
			cpu=cpu.substring(0, cpu.length()-1);
			float cpuusage=Float.parseFloat(cpu);
			
			String sysmem=sys_mem;
			sysmem=sysmem.substring(0, sysmem.length()-3);
			float sysmemory=Integer.parseInt(sysmem);
			
			String usemem=used_mem;
			usemem=usemem.substring(0, usemem.length()-3);
			float usedmemory=Integer.parseInt(usemem);
			//System.out.println("------------- usedmemory :"+usedmemory+" ----------------- sysmemory :"+sysmemory+"------------------ usedmemory/sysmemory :"+usedmemory/sysmemory);
			float mem_usage=(float)(usedmemory/sysmemory)*100;
			float total_mem_usage=(float)((cpuusage+mem_usage)/20);
		//	System.out.println( "---------------------- cpu_usage :"+cpu_usage+"--------- mem_usage :"+mem_usage+"----------- total_mem_usage :"+total_mem_usage);
			
		
		return mem_usage+"~"+total_mem_usage;
		
	}
	
	public static void main(String[] args) {
		new GetServerDet();
	}
}
