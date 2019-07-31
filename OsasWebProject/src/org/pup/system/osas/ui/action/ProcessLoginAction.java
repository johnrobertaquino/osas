package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class ProcessLoginAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7060200404061218541L;
	
	private String userName;
	
	private String password;
	
	public String execute() {
		User user = null;
		String actionResult = FORWARD_SUCCESS;

		try {
			UserManager userManager = new UserManager();
			user = userManager.validate(userName, password);
			
			if(user != null) {
				if(user.getUserRoleList() == null) {
					throw new BusinessException("There is no user role configured for this user. Please contact administrator.");
				}
				
				userSession.put(USER, user);
			} else {
				throw new BusinessException("Either Username or Password is incorrect.");
			}
		} catch (BusinessException be) {
			errorMessage = be.getMessage();
			actionResult = FORWARD_ERROR;
			be.printStackTrace();
		} catch (Exception e) {
			errorMessage = "System error occurred. Please contact administrator.";
			actionResult = FORWARD_ERROR;
			e.printStackTrace();
		}
		
		return actionResult;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
