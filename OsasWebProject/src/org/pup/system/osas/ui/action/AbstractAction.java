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
	
	private String currentDate;
	
	protected Map<String, Object> userSession;
	
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
}
