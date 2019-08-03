package org.pup.system.osas.ui.action;

public class ChangePasswordAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7193689828446511089L;

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
