package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class AddUserAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2407562318288998481L;

	private String userId;
	
	public String execute() throws Exception {
		pageName = "Manage User Account";
		String actionResult = FORWARD_SUCCESS;

		try {
			UserManager userManager = new UserManager();
			User user = userManager.getUser(Integer.parseInt(userId));
			userManager.insertUser(user);
			notificationMessage = "User has been successfully registered.";
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


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
