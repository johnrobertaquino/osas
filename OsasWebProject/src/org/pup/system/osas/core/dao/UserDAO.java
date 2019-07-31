package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.FirstTimeLoginReference;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.domain.UserRole;
import org.pup.system.osas.core.domain.UserRoleReference;

public class UserDAO extends DAO {

	public UserDAO(Connection connection) {
		super(connection);
	}

	public User getUserByUserNameAndPassword(String userName, String password) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			//Select userId, userName, password, userTypeId from users where usernName='value' and password='value'
			resultSet = statement.executeQuery("Select userId, userName, password, firstName, middleName, lastName, birthday, contactNumber, position, firstTimeLoginCode from user where userName='" + userName + "' and password='" + password + "'");  
			
			while (resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("UserId"));
				user.setUserName(resultSet.getString("Username"));
				user.setPassword(resultSet.getString("Password"));
				user.setFirstName(resultSet.getString("Firstname"));
				user.setMiddleName(resultSet.getString("Middlename"));
				user.setLastName(resultSet.getString("LastName"));
				user.setBirthday(resultSet.getDate("Birthday"));
				user.setContactNumber(resultSet.getString("ContactNumber"));
				user.setPosition(resultSet.getString("Position"));
				
				FirstTimeLoginReference firstTimeLoginReference = new FirstTimeLoginReference();
				firstTimeLoginReference.setFirstTimeLoginCode(resultSet.getString("FirstTimeLoginCode"));
				user.setFirstTimeLoginReference(firstTimeLoginReference);
				
				break;
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getUserByUserNameAndPassword method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return user;
	}
	
	public FirstTimeLoginReference getFirstTimeLoginByFirstTimeLoginCode(String firstTimeLoginCode) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		FirstTimeLoginReference firstTimeLoginReference = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("Select firstTimeLoginCode, description from firstTimeLoginReference where firstTimeLoginCode='" + firstTimeLoginCode + "'");  
			
			while (resultSet.next()) {
				firstTimeLoginReference = new FirstTimeLoginReference();
				
				firstTimeLoginReference.setFirstTimeLoginCode(resultSet.getString("firstTimeLoginCode"));
				firstTimeLoginReference.setDescription(resultSet.getString("description"));
				
				break;
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getFirstTimeLoginByFirstTimeLoginCode method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return firstTimeLoginReference;
	}
	
	public List<UserRole> getUserRoleListByUserId(int userId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		UserRole userRole = null;
		List<UserRole> userRoleList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("Select userRoleId, userId, userRoleReferenceCode from userRole where userId=" + userId);  
			
			while (resultSet.next()) {
				if (userRoleList == null) {
					userRoleList = new ArrayList<UserRole>();
				}
				
				userRole = new UserRole();
				
				userRole.setUserId(resultSet.getInt("userId"));
				userRole.setUserRoleId(resultSet.getInt("userRoleId"));
				
				UserRoleReference userRoleReference = new UserRoleReference();
				userRoleReference.setUserRoleReferenceCode(resultSet.getString("userRoleReferenceCode"));
				userRole.setUserRoleReference(userRoleReference);

				userRoleList.add(userRole);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getUserRoleListByUserId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return userRoleList;
	}
	
	public UserRoleReference getUserRoleReferenceByUserRoleReferenceCode(String userRoleReferenceCode) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		UserRoleReference userRoleReference = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("Select userRoleReferenceCode, userRoleName, verbiage from userRoleReference where userRoleReferenceCode='" + userRoleReferenceCode + "'");  
			
			while (resultSet.next()) {
				userRoleReference = new UserRoleReference();
				
				userRoleReference.setUserRoleName(resultSet.getString("userRoleName"));
				userRoleReference.setUserRoleReferenceCode(resultSet.getString("userRoleReferenceCode"));
				userRoleReference.setVerbiage(resultSet.getString("verbiage"));
				
				break;
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getFirstTimeLoginByFirstTimeLoginCode method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return userRoleReference;
	}
	
	public void insertUser(User user) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("INSERT INTO user(userName, password, firstName, middleName, lastName, birthday, contactNumber, position) values (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getMiddleName());
			statement.setString(5, user.getLastName());
			statement.setDate(6, new Date(user.getBirthday().getTime()));
			statement.setString(7, user.getContactNumber());
			statement.setString(8, user.getPosition());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				user.setUserId(resultSet.getInt(1));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getFirstTimeLoginByFirstTimeLoginCode method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
}
