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
			
			firstTimeLoginReference = userDAO.getFirstTimeLoginByFirstTimeLoginCode(user.getFirstTimeLoginReference().getFirstTimeLoginCode());
			user.setFirstTimeLoginReference(firstTimeLoginReference);
			
			userRoleList = userDAO.getUserRoleListByUserId(user.getUserId());
			
			for (UserRole userRole : userRoleList) {
				UserRoleReference userRoleReference = userDAO.getUserRoleReferenceByUserRoleReferenceCode(userRole.getUserRoleReference().getUserRoleReferenceCode());
				userRole.setUserRoleReference(userRoleReference);
			}
			
			user.setUserRoleList(userRoleList);
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return user;
	}
}
