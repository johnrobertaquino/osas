package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchUserAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4107930465504336565L;
	
	private String userSearchText;
	
	private List<User> userList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage User Account";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			UserManager userManager = new UserManager();
			userList = userManager.getUserListByUserSearchText(userSearchText);
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

	public String getUserSearchText() {
		return userSearchText;
	}

	public void setUserSearchText(String userSearchText) {
		this.userSearchText = userSearchText;
	}

}
