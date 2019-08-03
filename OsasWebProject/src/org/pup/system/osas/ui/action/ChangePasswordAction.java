package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class ChangePasswordAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7193689828446511089L;

	private String userId;
	private String userName;
	private String password;

	public String execute() throws Exception {
		
		String actionResult = FORWARD_SUCCESS;

		try {
			UserManager userManager = new UserManager();

			User user = userManager.getUser(Integer.parseInt(userId));
			userManager.saveUser(user);
			notificationMessage = "Password has been successfully updated.";
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
