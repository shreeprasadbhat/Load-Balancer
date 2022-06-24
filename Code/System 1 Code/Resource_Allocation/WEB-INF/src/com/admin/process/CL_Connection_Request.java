/**
 * 
 */
package com.admin.process;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;

import com.admin.service.CL_DAO;

public class CL_Connection_Request 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	public static ResultSet connections()
	{
		try
		{
			connection=CL_DAO.connector();
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_connections");
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Connections_Request class-->connactions() : "+e);
		}
		return resultSet;		
	}
	public static int getHotConnections(String ip_add,int port)
	{
		int s_no=0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			String query="select count(s_no) from m_connections where s_no=(select s_no from m_serverdetails where ip_address='"+ip_add+"' and port_number='"+port+"')";
		System.out.println(query);
			resultSet = statement.executeQuery(query);
			while(resultSet.next())
			{
				s_no=resultSet.getInt(1);
			}
			System.out.println("************************** s_no :"+s_no);
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Connections_Request class-->connactions() : "+e);
		}
		finally
		{
			CL_DAO.closeConnection(connection, statement, resultSet);
		}
		return s_no;		
	}
	
	public static boolean addConnection(String date,String time,String ip,int s_no,int app_id,String status) throws ParseException
	{
		boolean flag=false;
		int updateFlag = 0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			System.out.println("insert into m_connections(con_date,con_time_begin,con_time_end,con_ip,s_no,a_no,da_status)values('"+date+"','"+time+"','"+time+"','"+ip+"','"+s_no+"','"+app_id+"','"+status+"')");
			updateFlag=statement.executeUpdate("insert into m_connections(con_date,con_time_begin,con_time_end,con_ip,s_no,a_no,da_status)values('"+date+"','"+time+"','"+time+"','"+ip+"','"+s_no+"','"+app_id+"','"+status+"')");
			if(updateFlag==1)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->addApplication() : "+e);
		}
		finally
		{
			CL_DAO.closeConnection(connection, statement, resultSet);
		}
		return flag;
	}
	public static ResultSet connections(String ip)
	{
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_connections where con_ip='"+ip+"'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Connections_Request class-->connactions() : "+e);
		}
		return resultSet;		
	}
	
	public static ResultSet server_spot()
	{
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select a.s_no,a.s_name,a.s_ipaddress,b.status,b.server_status from m_server_configuration a  join m_serverdetails b on a.s_no=b.s_no");
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Connections_Request class-->connactions() : "+e);
		}
		return resultSet;		
	}
	
	public static boolean checkExist(String ip)
	{
		boolean flag=true;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_connections where con_ip='"+ip+"'");
			while(resultSet.next())
			{
				flag=false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Connections_Request class-->checkExist() : "+e);
		}
		finally
		{
			CL_DAO.closeConnection(connection, statement, resultSet);
		}
		return flag;		
	}
	public static boolean deleteConnection(int c_no) throws ParseException
	{
		boolean flag=false;
		int updateFlag = 0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			updateFlag=statement.executeUpdate("delete from m_connections where Con_no='"+c_no+"' ");
			if(updateFlag==1)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->addApplication() : "+e);
		}
		finally
		{
			CL_DAO.closeConnection(connection, statement, resultSet);
		}
		return flag;
	}
}
