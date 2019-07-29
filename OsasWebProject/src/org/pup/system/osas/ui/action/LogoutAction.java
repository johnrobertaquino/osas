package org.pup.system.osas.ui.action;

public class LogoutAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8930888062674819556L;
	
	public String execute() {
		this.userSession.clear();
		return "success";
	}

}
