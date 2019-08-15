package org.pup.system.osas.ui.action;

public class ScholarshipManagementScholarship extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343186915653890118L;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship";
		
		return FORWARD_SUCCESS;
	}
}
