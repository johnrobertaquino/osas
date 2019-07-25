package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.pup.system.osas.core.domain.User;

public class UserDAO extends DAO {

	public User validate(String userName, String password) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			//Select userId, userName, password, userTypeId from users where usernName='value' and password='value'
			resultSet = statement.executeQuery("Select userId, userName, password, userTypeId from users where userName='" + userName + "' and password='" + password + "'");  
			
			while (resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("userId"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setUserTypeId(resultSet.getInt("userTypeId"));
				
				break;
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing validate method", e);
		} finally {
			closeDbResources(resultSet, statement, connection);
		}
		
		return user;
	}
}
