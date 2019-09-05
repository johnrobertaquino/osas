package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.UserDAO;
import org.pup.system.osas.core.domain.FirstTimeLoginReference;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.domain.UserRole;
import org.pup.system.osas.core.domain.UserRoleReference;

public class UserManager {

	public User checkFullName(String firstName, String lastName) throws Exception {
		UserDAO userDAO = null;
		User user = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			userDAO = new UserDAO(connection);
			
			user = userDAO.getUserByFullName(firstName, lastName);
		
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return user;
	}
	
	public User validate(String userName, String password) throws Exception {
		UserDAO userDAO = null;
		User user = null;
		FirstTimeLoginReference firstTimeLoginReference = null;
		List<UserRole> userRoleList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			userDAO = new UserDAO(connection);
			
			user = userDAO.getUserByUserNameAndPassword(userName, password);
			
			if (user != null) {
				firstTimeLoginReference = userDAO.getFirstTimeLoginByFirstTimeLoginCode(user.getFirstTimeLoginReference().getFirstTimeLoginCode());
				user.setFirstTimeLoginReference(firstTimeLoginReference);
				
				userRoleList = userDAO.getUserRoleListByUserId(user.getUserId());
				
				if (userRoleList != null) {
					for (UserRole userRole : userRoleList) {
						UserRoleReference userRoleReference = userDAO.getUserRoleReferenceByUserRoleReferenceCode(userRole.getUserRoleReference().getUserRoleReferenceCode());
						userRole.setUserRoleReference(userRoleReference);
					}
					
					user.setUserRoleList(userRoleList);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return user;
	}
	
	public User getUser(int userId) throws Exception {
		UserDAO userDAO = null;
		User user = null;
		FirstTimeLoginReference firstTimeLoginReference = null;
		List<UserRole> userRoleList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			userDAO = new UserDAO(connection);
			
			user = userDAO.getUserByUserId(userId);
			
			if (user != null) {
				firstTimeLoginReference = userDAO.getFirstTimeLoginByFirstTimeLoginCode(user.getFirstTimeLoginReference().getFirstTimeLoginCode());
				user.setFirstTimeLoginReference(firstTimeLoginReference);
				
				userRoleList = userDAO.getUserRoleListByUserId(user.getUserId());
				
				if (userRoleList != null) {
					for (UserRole userRole : userRoleList) {
						UserRoleReference userRoleReference = userDAO.getUserRoleReferenceByUserRoleReferenceCode(userRole.getUserRoleReference().getUserRoleReferenceCode());
						userRole.setUserRoleReference(userRoleReference);
					}
					
					user.setUserRoleList(userRoleList);
				}
			}
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return user;
	}
	
	public List<User> getUserList() throws Exception {
		UserDAO userDAO = null;
		List<User> userList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			userDAO = new UserDAO(connection);
			
			userList = userDAO.getUserList();
			
			if (userList != null) {
				for (User user : userList) {
					FirstTimeLoginReference firstTimeLoginReference = userDAO.getFirstTimeLoginByFirstTimeLoginCode(user.getFirstTimeLoginReference().getFirstTimeLoginCode());
					user.setFirstTimeLoginReference(firstTimeLoginReference);
					
					List<UserRole> userRoleList = userDAO.getUserRoleListByUserId(user.getUserId());
					
					if (userRoleList != null) {
						for (UserRole userRole : userRoleList) {
							UserRoleReference userRoleReference = userDAO.getUserRoleReferenceByUserRoleReferenceCode(userRole.getUserRoleReference().getUserRoleReferenceCode());
							userRole.setUserRoleReference(userRoleReference);
						}
						user.setUserRoleList(userRoleList);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return userList;
	}
	
	public List<User> getUserListByUserSearchText(String userSearchText) throws Exception {
		UserDAO userDAO = null;
		List<User> userList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			userDAO = new UserDAO(connection);
			
			userList = userDAO.getUserListByUserSearchText(userSearchText);
			
			if (userList != null) {
				for (User user : userList) {
					FirstTimeLoginReference firstTimeLoginReference = userDAO.getFirstTimeLoginByFirstTimeLoginCode(user.getFirstTimeLoginReference().getFirstTimeLoginCode());
					user.setFirstTimeLoginReference(firstTimeLoginReference);
					
					List<UserRole> userRoleList = userDAO.getUserRoleListByUserId(user.getUserId());
					
					if (userRoleList != null) {
						for (UserRole userRole : userRoleList) {
							UserRoleReference userRoleReference = userDAO.getUserRoleReferenceByUserRoleReferenceCode(userRole.getUserRoleReference().getUserRoleReferenceCode());
							userRole.setUserRoleReference(userRoleReference);
						}
						
						user.setUserRoleList(userRoleList);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return userList;
	}
	
	public void insertUser(User user) throws Exception {
		UserDAO userDAO = null;
		Connection connection = null;
		List<UserRole> userRoleList = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			userDAO = new UserDAO(connection);
			
			userDAO.insertUser(user);
			
			userRoleList = user.getUserRoleList();
			
			if (userRoleList != null) {
				for (UserRole userRole : userRoleList) {
					userRole.setUserId(user.getUserId());
					userDAO.insertUserRole(userRole);
				}
			}

			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public void saveUser(User user) throws Exception {
		UserDAO userDAO = null;
		Connection connection = null;
		List<UserRole> userRoleList = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			userDAO = new UserDAO(connection);
			
			userDAO.saveUser(user);
			
			//Delete the old user role entries then insert the new ones. That's how we update the user role for a user.
			userDAO.deleteUserRoleByUserId(user.getUserId());
			userRoleList = user.getUserRoleList();
			
			if (userRoleList != null) {
				for (UserRole userRole : userRoleList) {
					userRole.setUserId(user.getUserId());
					userDAO.insertUserRole(userRole);
				}
			}
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public void deleteUser(User user) throws Exception {
		UserDAO userDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			userDAO = new UserDAO(connection);
			
			userDAO.deleteUserRoleByUserId(user.getUserId());
			userDAO.deleteUserByUserId(user.getUserId());
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
}
