package org.pup.system.osas.ui.action;

public class DisplayAddAgencyAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;

	@Override
	public String execute() throws Exception {
		pageName = "Scholarship Management - Agency";
		
		return FORWARD_SUCCESS;
	}
}