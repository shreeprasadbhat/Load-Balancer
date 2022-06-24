/**
 * 
 */
package com.admin.process;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.*;

import com.admin.action.GetProperty;
import com.admin.service.CL_DAO;
import com.admin.socket.GetServerDet;


public class Serv_Configuration 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	public static ResultSet config()
	{
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_server_configuration");
			System.out.println("select * from m_server_configuration");
		}
		catch(Exception e)
		{
			System.out.println("Exception in m_server_configuration class-->config() : "+e);
		}
		return resultSet;		
	}
	

	
	
	
	
	public static boolean addServer(String server_name,String url,String s_ipaddress,String port)
	{
		boolean flag=false;
		int updateFlag = 0;
		
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			if(flag=checkServer(server_name))
			{
				updateFlag=statement.executeUpdate("insert into m_server_configuration(s_name,s_url,s_current_connection,s_status,s_ipaddress,s_port)values('"+server_name+"','"+url+"','0','Active','"+s_ipaddress+"','"+port+"')");
			}
			if(updateFlag==1)
			{
				int s_no=0;
				String query="select * from m_server_configuration";
				resultSet=statement.executeQuery(query);
				while(resultSet.next())
				{
					s_no=resultSet.getInt(1);
				}
				updateFlag=statement.executeUpdate("insert into m_serverdetails(s_no,ip_address,port_number,server_status)values('"+s_no+"','"+s_ipaddress+"','"+port+"','ON')");
				flag=true;
			}
			GetServerDet.Sendserverreq();
		}
		catch(Exception e)
		{
			System.out.println("Exception in m_server_configuration class-->addServer() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
		return flag;
	}
	
	public static boolean deleteServer(int server_no)
	{
		boolean flag=false;
		int updateFlag = 0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			updateFlag=statement.executeUpdate("delete from m_serverdetails where s_no='"+server_no+"' ");
			updateFlag=statement.executeUpdate("delete from m_server_configuration where s_no='"+server_no+"' ");
			if(updateFlag==1)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in m_server_configuration class-->deleteServer() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
		return flag;
	}
	
	public static boolean editServer(int s_no,String server_name,String url,String ip_address,int port)
	{
		int updateFlag = 0;
	
		boolean flag=false;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			updateFlag=statement.executeUpdate("update m_server_configuration set s_name='"+server_name+"',s_url='"+url+"',s_ipaddress='"+ip_address+"',s_port='"+port+"' where s_no='"+s_no+"'");
			System.out.println();
			updateFlag=statement.executeUpdate("update m_serverdetails set ip_address='"+ip_address+"',port_number='"+port+"' where s_no='"+s_no+"'");
			if(updateFlag==1)
			{
				flag=true;
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in m_server_configuration class-->deleteServer() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
		return flag;
	}
	
	public static ResultSet Servers()
	{
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_server_configuration where s_no not in (select s_no from m_application)");
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Location class-->locations() : "+e);
		}
		return resultSet;		
	}
	
	public static boolean checkServer(String server_name)
	{
		boolean flag=true;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select s_name from m_server_configuration where s_name='"+server_name+"'");
			if(resultSet.next())
			{
				flag=false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in m_server_configuration class-->checkServer() : "+e);
		}
		//CL_DAO.closeConnection(connection, statement, resultSet);
		return flag;
	}
	
	public static String getName(int s_no)
	{
		String name="";
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select s_name from m_server_configuration where s_no='"+s_no+"'");
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in m_server_configuration class-->getName() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
		return name;		
	}
	
	public static String getURL(int s_no,String s_ipaddress)
	{
		String URL="";
		String s_name="";
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select s_name,s_url from m_server_configuration where s_no='"+s_no+"' and s_ipaddress ='"+s_ipaddress+"' ");
			while(resultSet.next())
			{
				s_name=resultSet.getString(1);
				URL=resultSet.getString(2);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in m_server_configuration class-->getURL() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
		return s_name+"~"+URL;		
	}
	
	
	

	public static Map GetserverDet()
	{
		Map map=new HashMap();
		ArrayList<String> ipaddress=new ArrayList<String>();
		ArrayList<Integer> port=new ArrayList<Integer>();
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select ip_address,port_number from m_serverdetails where server_status='ON' ");
			while(resultSet.next())
			{
				ipaddress.add(resultSet.getString(1));
				port.add(resultSet.getInt(2));
			}
			map.put(1, ipaddress);
			map.put(2, port);
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
		return map;
	}
	
	public static int Getserverport(String ipaddress)
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
		CL_DAO.closeConnection(connection, statement, resultSet);
		return port;
	}
	
	public static int addConnection(int s_no) throws ParseException
	{
		boolean flag=false;
		int updateFlag = 0;
		int con=0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			updateFlag=statement.executeUpdate("update m_server_configuration set s_current_connection=s_current_connection+1 where s_no='"+s_no+"'");
			updateFlag=statement.executeUpdate("update m_serverdetails set no_access=no_access+1 where s_no='"+s_no+"'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->addApplication() : "+e);
		}
		finally
		{
			CL_DAO.closeConnection(connection, statement, resultSet);
		}
		return con;
	}
	
	public static int removeConnection(int s_no) throws ParseException
	{
		int con=0;

		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			statement.executeUpdate("update m_server_configuration set s_current_connection=s_current_connection-1 where s_no='"+s_no+"'");
			resultSet=statement.executeQuery("select s_current_connection from  m_server_configuration where s_no='"+s_no+"'");
			
			
			while(resultSet.next())
			{
				con=resultSet.getInt(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->removeConnection() : "+e);
		}
		finally
		{
			CL_DAO.closeConnection(connection, statement, resultSet);
		}
		return con;
	}
	
}
