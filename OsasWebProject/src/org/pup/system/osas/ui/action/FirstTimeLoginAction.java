package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.FirstTimeLoginReference;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class FirstTimeLoginAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8239216729445991639L;

	private String userId;
	
	private String password;
	
	private String userName;

	public String execute() throws Exception {
		
		String actionResult = FORWARD_SUCCESS;

		try {
			UserManager userManager = new UserManager();

			User user = userManager.getUser(Integer.parseInt(userId));
			
			user.setPassword(password);
			user.setUserName(userName);
			
			FirstTimeLoginReference firstTimeLoginReference = new FirstTimeLoginReference();
			firstTimeLoginReference.setFirstTimeLoginCode("N");
			user.setFirstTimeLoginReference(firstTimeLoginReference);
				
			userManager.saveUser(user);
				
			user = userManager.getUser(Integer.parseInt(userId));
			userSession.put(USER, user);
			notificationMessage = "User and Password have been successfully updated.";
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
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
