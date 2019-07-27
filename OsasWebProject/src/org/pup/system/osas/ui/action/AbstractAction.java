package org.pup.system.osas.ui.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8558423099927873090L;
	private String currentDate;
	
	public String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE | MMMM dd, yyyy");  
		LocalDateTime now = LocalDateTime.now(); 
		currentDate = dtf.format(now);
		return currentDate;
	}
}
