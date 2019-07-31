package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;

public class ProcessLoginAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7060200404061218541L;
	
	private static final String USER = "USER";
	
	private String userName;
	
	private String password;
	
	private String errorMessage;
	
	public String execute() {
		User user = null;
		String actionResult = "success";

		try {
			UserManager userManager = new UserManager();
			user = userManager.validate(userName, password);
			
			if(user != null) {
				this.userSession.put(USER, user);
			} else {
				errorMessage = "Invalid user.";
				actionResult = "error";
			}
		} catch (Exception e) {
			errorMessage = "System error occurred. Contact administrator.";
			actionResult = "error";
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

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
