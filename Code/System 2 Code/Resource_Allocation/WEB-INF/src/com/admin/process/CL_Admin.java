/**
 * 
 */
package com.admin.process;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.admin.service.CL_DAO;

public class CL_Admin 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	public static boolean checkAdmin(String name, String pass) throws SQLException
	{
		boolean flag=false;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where admin_id='"+name+"' and admin_pwd='"+pass+"'");
			if(resultSet.next())
			{
				flag = true;				
			} 
			System.out.println("Admin User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Admin class-->checkAdmin() : "+e);
		}
		finally
		{
			CL_DAO.closeConnection(connection, statement, resultSet);
		}
		return flag;
	}
	public static boolean changePass(String pass) 
	{
		boolean flag=false;
		try
		{
			connection=CL_DAO.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update m_admin set admin_pwd='"+pass+"'");
			if(i!=0)
			{
				flag = true;				
			} 
			System.out.println("Admin Change Password Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in CL_Admin class-->changePass() : "+e);
		}
		finally
		{
			CL_DAO.closeConnection(connection, statement, resultSet);
		}
		return flag;
	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
