package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditUserAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private String userId;
	
	private User user;

	@Override
	public String execute() throws Exception {
		pageName = "Manage User Account";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			UserManager userManager = new UserManager();
			user = userManager.getUser(Integer.parseInt(userId));
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
