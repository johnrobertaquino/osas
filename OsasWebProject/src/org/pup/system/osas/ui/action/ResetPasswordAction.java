package org.pup.system.osas.ui.action;

import java.text.SimpleDateFormat;

import org.pup.system.osas.core.domain.FirstTimeLoginReference;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class ResetPasswordAction extends AbstractAction {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 5434792641181279093L;

	private String userId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage User Account";

		String actionResult = FORWARD_SUCCESS;

		try {
			UserManager userManager = new UserManager();
			User user = userManager.getUser(Integer.parseInt(userId));
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddyyyy");
			String birthday = simpleDateFormat.format(user.getBirthday());
	
			user.setPassword(birthday);
			
			FirstTimeLoginReference firstTimeLoginReference = new FirstTimeLoginReference();
			firstTimeLoginReference.setFirstTimeLoginCode("PW");
			user.setFirstTimeLoginReference(firstTimeLoginReference);
			
			userManager.saveUser(user);
			
			notificationMessage = "Password Reset has been successfully done.";
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