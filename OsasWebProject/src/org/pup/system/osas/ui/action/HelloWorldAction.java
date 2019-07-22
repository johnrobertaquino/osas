package org.pup.system.osas.ui.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6710651484900451590L;
	
	private String name;

	public String execute() throws Exception {
		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
