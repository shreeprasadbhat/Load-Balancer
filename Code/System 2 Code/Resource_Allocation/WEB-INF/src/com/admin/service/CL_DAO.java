/**
 * 
 */
package com.admin.service;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.admin.comman.Global;


public class CL_DAO 
{
	public static Connection connector()
	{
		Connection con=null;
		try {

			Class.forName(Global.JDBC_DRIVER);
		//	System.out.println();
			con = DriverManager.getConnection(Global.JDBC_HOST_URL_WITH_DBNAME,Global.DATABASE_USERNAME, Global.DATABASE_PASSWORD);
			//System.out.println("Connected" + con);
			}
		catch (Exception e) {
			System.out.println("Exception in serverconnector-->connector(): "+ e);
		}
		return con;
	}
	
	public static void closeConnection(Connection con,Statement stmt,ResultSet rs)
	{
		if(rs!=null)
		{
			try 
			{
				rs.close();
				rs=null;
			} 
			catch (SQLException e) 
			{	
				e.printStackTrace();
			}
			
		}
		if(stmt!=null)
		{
			try 
			{
				stmt.close();
				stmt=null;
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
		}
		if(con!=null)
		{
			try 
			{
				con.close();
				con=null;
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
		}
		
	}
}
