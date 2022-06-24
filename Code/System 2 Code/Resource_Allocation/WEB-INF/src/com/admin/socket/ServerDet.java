package com.admin.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarProxy;
import org.hyperic.sigar.cmd.SigarCommandBase;






public class ServerDet 
{
	public static boolean displayTimes = true;
	
	
	 private static Sigar sigar = new Sigar();
	
	ServerDet()
	{
		System.out.println("Server Access Running");
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
   					InetAddress a=InetAddress.getLocalHost();
   					String ipaddress=a.getHostAddress();
   					System.out.println(ipaddress);
   				
   					ServerSocket server = new ServerSocket(7001);
   				    
   				    while (true)
   			        {
   				    	System.out.println("Server Start up *******");
   						Socket socket=server.accept();
   				    	System.out.println("Connection Accepted "+server);
						
   						InputStream is=socket.getInputStream();
   												
   						DataInputStream dis=new DataInputStream(is);
   						String Process=dis.readUTF();
   										
   						System.out.println("Process : "+Process);
   						Map map=getInformationsAboutCPU();
   						System.out.println("--------------------  Map Value  :"+map);
   						
   					
   						Socket adminsocket=new Socket("192.168.1.19",9000);
   						DataOutputStream dos=new DataOutputStream(adminsocket.getOutputStream());
   						
   						dos.writeUTF(ipaddress);
   						dos.writeInt(7001);
   						dos.writeInt(map.size());
   						
   						dos.writeUTF(map.toString());
   						System.out.println("--------------------"+map.toString());
   						
   						
   						System.out.println("\nPackets Sending Completed");
   						dos.flush();
   						dos.close();
   						adminsocket.close();
   						
   						
   			        }
   				    

   				}
   				
   				catch(Exception e)
   				{
   					
   				}

   			
		}
		
	}
	
	

	/* Method to get Informations about the CPU(s): */
    public static Map getInformationsAboutCPU() 
    {
    	 Map cpu_data=new HashMap();
     	 
         CpuInfo[] cpuinfo = null;
         CpuPerc[] cpus=null;
         try {
              cpuinfo = sigar.getCpuInfoList();
               cpus =sigar.getCpuPercList();
         } catch (SigarException se) {
              se.printStackTrace();
         }

       
         cpu_data.put("vendor", cpuinfo[0].getVendor());
         cpu_data.put("processor", cpuinfo[0].getModel());
         cpu_data.put("mhz", cpuinfo[0].getMhz());
         cpu_data.put("number_of_cpu", cpuinfo[0].getTotalCores());
         
         System.out.println("Vendor........." + cpuinfo[0].getVendor());
         System.out.println("processor.........." + cpuinfo[0].getModel());
         System.out.println("Mhz............" + cpuinfo[0].getMhz());
         System.out.println("Total CPUs....." + cpuinfo[0].getTotalCores());
      
     	
         for (int i = 0; i<cpuinfo.length; i++) 
         {
              Map map = cpuinfo[i].toMap();
              System.out.println("CPU " + i + ": " + map);
         }
         String usage="";
         for (int i=0; i<cpus.length; i++)
         {
             System.out.println("CPU " + i + ".........");
              usage= output(cpus[i]);
         }
         cpu_data.put("cpu_usage", usage);
         System.out.println("\n************************************\n");
         
         try 
         {
			Mem mem= sigar.getMem();
		
			  cpu_data.put("system_memory", mem.getTotal()/ 1024 + " KB");
			  cpu_data.put("used_memory", mem.getUsed()/ 1024 + " KB");
			  cpu_data.put("free_memory", mem.getFree()/ 1024 + " KB");
			  
			System.out.println("Total system memory............: " + mem.getTotal()
	                  / 1024 + " KB");
	        System.out.println("Total used system memory.......: " + mem.getUsed()
	                  / 1024 + " KB");
	        System.out.println("Total free system memory ......: " + mem.getFree()
	                / 1024 + " KB");
         }catch (SigarException e) {e.printStackTrace();}
		return cpu_data;
 		
    }
    private static String output(CpuPerc cpu)
    {
    	String usage= CpuPerc.format(cpu.getCombined());
        System.out.println("Usage......" + CpuPerc.format(cpu.getCombined()));
		return usage;
    }
    
//    public static void main(String[] args) 
//    {
//    	new ServerDet();
//	}
    public static void main(String[] args) 
    {
    	new ServerDet();
	}
}
