package com.admin.process;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.admin.service.CL_DAO;

public class Socket_Config 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	public static String GetUsherCtrl()
	{
		String ipaddress="";
		int port=0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select admin_ipaddress,admin_port from m_admin  ");
			while(resultSet.next())
			{
				ipaddress=resultSet.getString(1);
				port=resultSet.getInt(2);
			}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
		return ipaddress+"~"+port;
	}
	
	public static void GetServerDet(Map<String, String> map,String ip_address,int port)
	{
		String ipaddress="";
		int updateFlag=0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			updateFlag=statement.executeUpdate("update m_serverdetails set vendor='"+map.get("vendor")+"',processor='"+map.get("processor")+"',mhz='"+map.get("mhz")+"',number_of_cpu='"+map.get("number_of_cpu")+"',cpu_usage='"+map.get("cpu_usage")+"',system_memory='"+map.get("system_memory")+"',used_memory='"+map.get("used_memory")+"',free_memory='"+map.get("free_memory")+"',status='"+map.get("status")+"',usage_percent='"+map.get("usage_percent")+"' where ip_address='"+ip_address+"' and port_number='"+port+"' ");
			
		
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
	}
	
	public static ResultSet RetriveServerDet()
	{
		String ipaddress="";
		int updateFlag=0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_serverdetails  ");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		return resultSet;
		
	}
	
	public static int RetrivePort(String ipaddress)
	{
		
		int port=0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select port_number from m_serverdetails where ip_address='"+ipaddress+"' ");
			while(resultSet.next())
			{
				port=resultSet.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		return port;
		
	}
	
	//Reterive memmory and cpu usage
	public static Map RetriveUsage()
	{
		Map map=new HashMap();
		ArrayList<Integer>s_no=new ArrayList<Integer>();
		ArrayList<String>s_name=new ArrayList<String>();
		ArrayList<String>ipaddress=new ArrayList<String>();
		
		ArrayList<Integer>no_access=new ArrayList<Integer>();
		ArrayList<Float>usage_percent=new ArrayList<Float>();
		ArrayList<String>status=new ArrayList<String>();
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select a.s_no,b.s_name,a.ip_address,a.no_access,a.usage_percent,a.status from m_serverdetails a join m_server_configuration b on a.s_no=b.s_no ");
			while(resultSet.next())
			{
				s_no.add(resultSet.getInt(1));
				s_name.add(resultSet.getString(2));
				ipaddress.add(resultSet.getString(3));
			
				no_access.add(resultSet.getInt(4));
				usage_percent.add(resultSet.getFloat(5));
				status.add(resultSet.getString(6));
			}
			
			map.put("s_no", s_no);
			map.put("s_name", s_name);
			map.put("ipaddress", ipaddress);
		
			map.put("no_access", no_access);
			map.put("usage_percent", usage_percent);
			map.put("status", status);
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		return map;
		
	}
	
	public static String CheckSysStatus(String ipaddress)
	{
		
		String status="";
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select status from m_serverdetails where ip_address='"+ipaddress+"' ");
			while(resultSet.next())
			{
				status=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		return status;
		
	}
	
	public static String Coldspot()
	{
		int s_no=0;
		String ip_address=""; 
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select s_no,ip_address,status,max(usage_percent) from m_serverdetails where status='cold_spot' group by status");
			while(resultSet.next())
			{
				s_no=resultSet.getInt(1);
				ip_address=resultSet.getString(2);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		if(s_no!=0 )
		{
			return s_no+"~"+ip_address;
		}
		else
			return null;
		
	}
	
	public static String checkStatus(String appid)
	{
		int s_no=0;
		String ipaddress=""; 
		String status=""; 
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select b.s_no,b.ip_address,b.status from m_application a join m_serverdetails b on a.s_no=b.s_no where a.a_no='"+appid+"'");
			while(resultSet.next())
			{
				s_no=resultSet.getInt(1);
				ipaddress=resultSet.getString(2);
				status=resultSet.getString(3);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}

			return s_no+"~"+ipaddress+"~"+status;
	}
	
	
	public static String Warmspot()
	{
		int s_no=0;
		String ip_address=""; 
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select s_no,ip_address,status,min(usage_percent) from m_serverdetails where status='warm_spot' group by status");
			while(resultSet.next())
			{
				s_no=resultSet.getInt(1);
				ip_address=resultSet.getString(2);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		if(s_no!=0 )
		{
			return s_no+"~"+ip_address;
		}
		else
			return null;
	}
	
	public static String Hotspot()
	{
		int s_no=0;
		String ip_address=""; 
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select s_no,ip_address,status,min(usage_percent) from m_serverdetails where status='hot_spot' group by status");
			while(resultSet.next())
			{
				s_no=resultSet.getInt(1);
				ip_address=resultSet.getString(2);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		return s_no+"~"+ip_address;
	}
	
	public static String GreenCompute()
	{
		int port_number=0;
		String ip_address=""; 
		int count=0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select a.ip_address,a.port_number,count(b.s_no) from m_serverdetails a left join m_connections b on a.s_no=b.s_no where a.status='cold_spot' and a.no_access >2 group by a.status");
			while(resultSet.next())
			{
				ip_address=resultSet.getString(1);
				port_number=resultSet.getInt(2);
				count=resultSet.getInt(3);
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		if(port_number!=0 )
		{
			return ip_address+"~"+port_number+"~"+count;
		}
		else
			return "0";
		
	}
	
	public static void ServerOff(String ipaddress)
	{
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			System.out.println("update m_serverdetails set server_status='OFF' where ip_address='"+ipaddress+"'  ");
			int updateFlag=statement.executeUpdate("update m_serverdetails set server_status='OFF' where ip_address='"+ipaddress+"'  ");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
	}
	
	
	
	public static void ResetValues()
	{
		int port_number=0;
		String ip_address=""; 
		int count=0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			
			int updateFlag=statement.executeUpdate("update m_serverdetails set server_status='ON',no_access='0'  ");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
	}
	
	public static String GreenComput_Msg()
	{
		String s_name=null;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet=statement.executeQuery("select a.s_name from m_server_configuration a join m_serverdetails b on a.s_no=b.s_no where b.server_status='OFF'");
			while(resultSet.next())
			{
				s_name=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		return s_name;
	}
	
	
}
