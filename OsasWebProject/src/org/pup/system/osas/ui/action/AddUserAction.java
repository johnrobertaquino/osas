package org.pup.system.osas.ui.action;

public class AddUserAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2407562318288998481L;
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
