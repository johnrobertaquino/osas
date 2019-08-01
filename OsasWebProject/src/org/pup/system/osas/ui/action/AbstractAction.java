package org.pup.system.osas.ui.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8558423099927873090L;
	
	protected static final String USER = "USER";
	
	protected static final String FORWARD_SUCCESS = "success";
	
	protected static final String FORWARD_ERROR = "error";
	
	private String currentDate;
	
	protected Map<String, Object> userSession;
	
	protected String errorMessage;
	
<<<<<<< HEAD
=======
	protected String notificationMessage;
	
	protected String pageName;
	
	public abstract String execute() throws Exception;
	
>>>>>>> branch 'master' of https://github.com/johnrobertaquino/osas
	public String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE | MMMM dd, yyyy");  
		LocalDateTime now = LocalDateTime.now(); 
		currentDate = dtf.format(now);
		return currentDate;
	}
	
	@Override
	public void setSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
<<<<<<< HEAD
=======

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
	
>>>>>>> branch 'master' of https://github.com/johnrobertaquino/osas
}
