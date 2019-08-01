package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayUserListAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8475748192334605108L;
	
	private List<User> userList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage User Account";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			UserManager userManager = new UserManager();
			userList = userManager.getUserList();
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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	

}
