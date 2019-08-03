package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.FirstTimeLoginReference;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class PasswordResetAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2389975718779242600L;

	private String userId;
	
	private String password;

	public String execute() throws Exception {
		
		String actionResult = FORWARD_SUCCESS;

		try {
			UserManager userManager = new UserManager();

			User user = userManager.getUser(Integer.parseInt(userId));
			
			user.setPassword(password);
			
			FirstTimeLoginReference firstTimeLoginReference = new FirstTimeLoginReference();
			firstTimeLoginReference.setFirstTimeLoginCode("N");
			user.setFirstTimeLoginReference(firstTimeLoginReference);
				
			userManager.saveUser(user);
				
			user = userManager.getUser(Integer.parseInt(userId));
			userSession.put(USER, user);
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


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
