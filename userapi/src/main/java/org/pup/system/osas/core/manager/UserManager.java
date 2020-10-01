package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.UserDAO;
import org.pup.system.osas.core.domain.FirstTimeLoginReference;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.domain.UserRole;
import org.pup.system.osas.core.domain.UserRoleReference;
import org.springframework.stereotype.Component;

public class UserManager {

	public User checkFullName(String firstName, String middleName, String lastName) throws Exception {
		UserDAO userDAO = null;
		User user = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			userDAO = new UserDAO(connection);
			
			user = userDAO.getUserByFullName(firstName, middleName, lastName);
		
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return user;
	}
	
}
