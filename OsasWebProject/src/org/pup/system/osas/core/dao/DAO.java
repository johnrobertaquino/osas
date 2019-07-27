package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.pup.system.osas.core.settings.DBSettings;

public class DAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
	}
	
	public Connection getConnection() throws Exception {
		Connection connection = null;
		try { 
			String connectionString = "jdbc:mysql://" + DBSettings.HOST + ":" + DBSettings.PORT+ "/" + DBSettings.SCHEMA;
			connection=DriverManager.getConnection(connectionString, DBSettings.USER,DBSettings.PASSWORD);
		}catch (Exception e) {
			System.out.println("Error in db connection. Can't connect");
			e.printStackTrace();
			throw e;
		}
		
		return connection;
	}
	
	public void closeDbResources(ResultSet resultSet, Statement statement, Connection connection) {
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
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeDbResources(Statement statement, Connection connection) {
		closeDbResources(null, statement, connection);
	}
}
