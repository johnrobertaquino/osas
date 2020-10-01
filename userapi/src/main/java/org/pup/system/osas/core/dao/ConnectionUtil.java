package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.pup.system.osas.core.settings.DBSettings;


public abstract class ConnectionUtil
{

	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection createConnection() throws Exception {
		Connection connection = null;
		try { 
			String connectionString = "jdbc:mysql://" + DBSettings.HOST + ":" + DBSettings.PORT+ "/" + DBSettings.SCHEMA;
			connection=DriverManager.getConnection(connectionString, DBSettings.USER,DBSettings.PASSWORD);
			connection.setAutoCommit(false);
		}catch (Exception e) {
			System.out.println("Error in db connection. Can't connect");
			e.printStackTrace();
			throw e;
		}
		
		return connection;
	}
	
	public static void closeDbResources(ResultSet resultSet, Statement statement) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeDbConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeDbResources(Statement statement) {
		closeDbResources(null, statement);
	}
	
	public static void rollbackConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
