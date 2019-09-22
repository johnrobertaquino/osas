package org.pup.system.osas.ui.action;

public class DisplayAddProgramAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Account > Program Management";
		
		return FORWARD_SUCCESS;
	}

}
