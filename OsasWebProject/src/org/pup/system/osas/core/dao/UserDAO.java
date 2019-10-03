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

	public User getUserByFullName(String firstName, String middleName, String lastName) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		User user = null;
		
		try {
			connection = getConnection();
			
			statement = connection.prepareStatement("SELECT UserId, UserName, Password, FirstName, MiddleName, LastName, Birthday, ContactNumber, Position FROM user WHERE FirstName='" + firstName + "' AND MiddleName='"+ middleName +"' AND LastName='" + lastName + "'"); 
			
			resultSet = statement.executeQuery();  
			
			if (resultSet.next()) {
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
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getUserByUserName method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return user;
	}
	
	public User getUserByUserNameAndPassword(String userName, String password) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = getConnection();
			
			statement = connection.prepareStatement("SELECT UserId, UserName, Password, FirstName, MiddleName, LastName, Birthday, ContactNumber, Position, FirstTimeLoginCode FROM user WHERE UserName='" + userName + "' and Password='" + password + "'"); 
			
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
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
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getUserByUserNameAndPassword method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return user;
	}
	
	public User getUserByUserId(int userId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT UserId, UserName, Password, FirstName, MiddleName, LastName, Birthday, ContactNumber, Position, FirstTimeLoginCode FROM user WHERE UserId=" + userId);  
			
			if (resultSet.next()) {
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
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getUserByUserId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return user;
	}
	
	public List<User> getUserList() throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		List<User> userList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.prepareStatement("SELECT UserId, UserName, Password, FirstName, MiddleName, LastName, Birthday, ContactNumber, Position, FirstTimeLoginCode FROM user");   
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				if (userList == null) {
					userList = new ArrayList<User>();
				}
				
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
				
				userList.add(user);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getUserList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return userList;
	}
	
	public List<User> getUserListByUserSearchText(String userSearchText) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		User user = null;
		List<User> userList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT UserId, UserName, Password, FirstName, MiddleName, LastName, Birthday, ContactNumber, Position, FirstTimeLoginCode FROM user WHERE UserName LIKE '%"
					+ userSearchText + "%' OR FirstName LIKE '%" + userSearchText + "%' OR MiddleName LIKE '%" + userSearchText + "%' OR LastName LIKE '%" + userSearchText + "%'");  
			
			while (resultSet.next()) {
				if (userList == null) {
					userList = new ArrayList<User>();
				}
				
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
				
				userList.add(user);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getUserList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return userList;
	}
	
	public FirstTimeLoginReference getFirstTimeLoginByFirstTimeLoginCode(String firstTimeLoginCode) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		FirstTimeLoginReference firstTimeLoginReference = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT FirstTimeLoginCode, Description FROM firstTimeLoginReference WHERE FirstTimeLoginCode='" + firstTimeLoginCode + "'");  
			
			if (resultSet.next()) {
				firstTimeLoginReference = new FirstTimeLoginReference();
				
				firstTimeLoginReference.setFirstTimeLoginCode(resultSet.getString("FirstTimeLoginCode"));
				firstTimeLoginReference.setDescription(resultSet.getString("Description"));
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
			
			resultSet = statement.executeQuery("SELECT UserRoleId, UserId, UserRoleReferenceCode FROM userRole WHERE userId=" + userId);  
			
			while (resultSet.next()) {
				if (userRoleList == null) {
					userRoleList = new ArrayList<UserRole>();
				}
				
				userRole = new UserRole();
				
				userRole.setUserId(resultSet.getInt("UserId"));
				userRole.setUserRoleId(resultSet.getInt("UserRoleId"));
				
				UserRoleReference userRoleReference = new UserRoleReference();
				userRoleReference.setUserRoleReferenceCode(resultSet.getString("UserRoleReferenceCode"));
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
			
			resultSet = statement.executeQuery("SELECT UserRoleReferenceCode, UserRoleName, Verbiage FROM userRoleReference WHERE UserRoleReferenceCode='" + userRoleReferenceCode + "'");  
			
			if (resultSet.next()) {
				userRoleReference = new UserRoleReference();
				
				userRoleReference.setUserRoleName(resultSet.getString("UserRoleName"));
				userRoleReference.setUserRoleReferenceCode(resultSet.getString("UserRoleReferenceCode"));
				userRoleReference.setVerbiage(resultSet.getString("Verbiage"));
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

			statement = connection.prepareStatement("INSERT INTO user(UserName, Password, FirstName, MiddleName, LastName, Birthday, ContactNumber, Position) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
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
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}
	
	public void insertUserRole(UserRole userRole) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			
			statement = connection.prepareStatement("INSERT INTO userRole(UserId, UserRoleReferenceCode) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, userRole.getUserId());
			statement.setString(2, userRole.getUserRoleReference().getUserRoleReferenceCode());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				userRole.setUserRoleId(resultSet.getInt(1));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing insertUserRole method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}
	
	public void saveUser(User user) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE user SET UserName=?, Password=?, FirstName=?, MiddleName=?, LastName=?, Birthday=?, ContactNumber=?, Position=?, FirstTimeLoginCode=? WHERE UserId=?");
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getMiddleName());
			statement.setString(5, user.getLastName());
			statement.setDate(6, new Date(user.getBirthday().getTime()));
			statement.setString(7, user.getContactNumber());
			statement.setString(8, user.getPosition());
			statement.setString(9, user.getFirstTimeLoginReference().getFirstTimeLoginCode());
			statement.setInt(10, user.getUserId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveUser method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
	
	public void deleteUserRoleByUserId(int userId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM userRole WHERE UserId=?");
			statement.setInt(1, userId);
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteUserRoleByUserId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
	
	public void deleteUserByUserId(int userId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM user WHERE UserId=?");
			statement.setInt(1, userId);
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteUserByUserId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
}