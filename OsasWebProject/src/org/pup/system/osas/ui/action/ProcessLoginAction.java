package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.dao.UserDAO;
import org.pup.system.osas.core.domain.User;

import com.opensymphony.xwork2.ActionSupport;

public class ProcessLoginAction  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7060200404061218541L;
	
	private String userName;
	
	private String password;
	
	private User user;
	
	private String errorMessage;

	public String execute() {
		User user = null;
		String actionResult = "success";

		try {
			UserDAO userDao = new UserDAO();
			user = userDao.validate(userName, password);
			
			if(user != null) {
				this.user = user;
			} else {
				errorMessage = "Invalid user.";
				actionResult = "error";
			}
		} catch (Exception e) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
