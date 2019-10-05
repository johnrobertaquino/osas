package org.pup.system.osas.ui.action;

public class DisplayManageSemesterAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3086280174120725382L;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Semester";
		
		String actionResult = FORWARD_SUCCESS;	
		
		return actionResult;
	}

	
	

}
