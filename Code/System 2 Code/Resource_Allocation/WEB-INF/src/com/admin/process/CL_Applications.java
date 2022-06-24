/**
 * 
 */
package com.admin.process;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.admin.service.CL_DAO;

public class CL_Applications 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	public static ResultSet applications()
	{
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_application");
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->applications() : "+e);
		}
		return resultSet;		
	}
	
	public static boolean addApplication(String app_name,String desc,String app_image )
	{
		boolean flag=false;
		int updateFlag = 0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			if(flag=checkApplication(app_name))
			updateFlag=statement.executeUpdate("insert into m_application(a_name,s_no,a_image)values('"+app_name+"','"+desc+"','"+app_image+"')");
			if(updateFlag==1)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->addApplication() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
		return flag;
	}
	
	public static boolean checkApplication(String app_name)
	{
		boolean flag=true;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select a_name from m_application where a_name='"+app_name+"' ");
			if(resultSet.next())
			{
				flag=false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Application class-->checkApplication() : "+e);
		}
	//	CL_DAO.closeConnection(connection, statement, resultSet);
		return flag;
	}
	
	public static boolean editApplication(int a_no,String a_name,String desc,String app_image )
	{
		int updateFlag = 0;
		boolean flag=false;
		System.out.println("---in Class"+a_no+"-"+a_name+"-"+desc+"-");
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			updateFlag=statement.executeUpdate("update m_application set a_name='"+a_name+"',a_description='"+desc+"',a_image='"+app_image+"' where a_no='"+a_no+"'");
			if(updateFlag==1)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Configuration class-->deleteServer() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
		return flag;
	}
	
	public static boolean deleteApplication(int a_no)
	{
		boolean flag=false;
		int updateFlag = 0;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			updateFlag=statement.executeUpdate("delete from m_application where a_no='"+a_no+"' ");
			if(updateFlag==1)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->deleteApplication() : "+e);
		}
		return flag;
	}
	
	public static String getName(int a_no)
	{
		String name="";
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select a_name from m_application where a_no='"+a_no+"'");
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Applications class-->getName() : "+e);
		}
		CL_DAO.closeConnection(connection, statement, resultSet);
		return name;		
	}
	
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}
}
