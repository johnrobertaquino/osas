package org.pup.system.osas.ui.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.pup.system.osas.core.domain.SemTerm;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8558423099927873090L;
	
	protected static final String USER = "USER";
	
	private static final String SEMTERM = "SEMTERM";
	
	protected static final String FORWARD_SUCCESS = "success";
	
	protected static final String FORWARD_ERROR = "error";
	
	private String currentDate;
	
	protected Map<String, Object> userSession;
	
	protected String errorMessage;
	
	protected String notificationMessage;
	
	protected String pageName;
	
	public abstract String execute() throws Exception;
	
	public String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE | MMMM dd, yyyy");  
		LocalDateTime now = LocalDateTime.now(); 
		currentDate = dtf.format(now);
		return currentDate;
	}
	
	public String getDateTimeStamp() {
		return Calendar.getInstance().getTimeInMillis() + "";
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
	
	protected SemTerm getCurrentActiveTerm() {
		Object semTermObject = userSession.get(SEMTERM);
		
		if (semTermObject != null) {
			return (SemTerm) semTermObject;
		} else {
			return null;
		}	
	}
	
	
}
