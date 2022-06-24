package com.cpu;

import java.io.*;
import java.net.*;

public class ServerAccess 
{
	public ServerAccess() 
	{
		System.out.println("Server Access Running");
		Thread t=new Thread(new ServerStart(5000));
		t.setName("Listener-ServerAccess" );
		t.start();
		
		Thread t1=new Thread(new ServerShut(9876));
		t1.setName("Listener-ServerAccess" );
		t1.start();
	}
	
	class ServerStart implements Runnable
	{
		int port;
		public ServerStart(int port)
		{
			this.port=port;
		}
		
		public void run()
		{
   				try 
   				{ 
   					
   					ServerSocket server = new ServerSocket(port);
   				    
   				    while (true)
   			        {
   				    	System.out.println("Server Start up *******");
   						
   						Socket socket=server.accept();
   						
   				    	System.out.println("Connection Accepted "+server);
						
   						InputStream is=socket.getInputStream();
   												
   						DataInputStream dis=new DataInputStream(is);
   						
   						
   						System.out.println("Data Input Stream "+dis);
   											
   						String Process=dis.readUTF(dis);
   										
   						System.out.println("Process : "+Process);
   						
   						String cmds[] = {"D:\\apache-tomcat-7.0.35\\bin\\startup.bat"};
	   		            Runtime runtime = Runtime.getRuntime();
	   		            Process process = runtime.exec(cmds);
	   		            process.getOutputStream().close();
	   		            InputStream inputStream = process.getInputStream();
	   		            InputStreamReader inputstreamreader = new InputStreamReader(inputStream);
	   		            BufferedReader bufferedrReader = new BufferedReader(inputstreamreader);
	   		            String strLine = "";
	   		            while ((strLine = bufferedrReader.readLine()) != null) 
	   		            {
	   		                System.out.println(strLine);
	   		            }
   						
   						
   						
   			        }
   				    

   				}
   				
   				catch(Exception e)
   				{
   					
   				}

   			
		}
		
	}
	class ServerShut implements Runnable
	{
		int port;
		public ServerShut(int port)
		{
			this.port=port;
		}
		
		public void run()
		{
   				try 
   				{ 
   					
   					ServerSocket server = new ServerSocket(port);
   				    
   				    while (true)
   			        {
   				    	System.out.println("Server Start up *******");
   						
   						Socket socket=server.accept();
   						
   				    	System.out.println("Connection Accepted "+server);
						
   						InputStream is=socket.getInputStream();
   												
   						DataInputStream dis=new DataInputStream(is);
   						
   						
   						System.out.println("Data Input Stream "+dis);
   											
   						String Process=dis.readUTF(dis);
   										
   						System.out.println("Process : "+Process);
   						
	   					String cmds[] = {"D:\\apache-tomcat-7.0.35\\bin\\shutdown.bat"};
	   			      
	   		            Runtime runtime = Runtime.getRuntime();
	   		            Process process = runtime.exec(cmds);
	   		            process.getOutputStream().close();
	   		            InputStream inputStream = process.getInputStream();
	   		            InputStreamReader inputstreamreader = new InputStreamReader(inputStream);
	   		            BufferedReader bufferedrReader = new BufferedReader(inputstreamreader);
	   		            String strLine = "";
	   		            while ((strLine = bufferedrReader.readLine()) != null) 
	   		            {
	   		                System.out.println(strLine);
	   		            }
   						
				   
   			        }
   				    

   				}
   				
   				catch(Exception e)
   				{
   					
   				}

		}
		
	}
	
	
	public static void main(String[] args) 
	{
		new ServerAccess();
	}

}
