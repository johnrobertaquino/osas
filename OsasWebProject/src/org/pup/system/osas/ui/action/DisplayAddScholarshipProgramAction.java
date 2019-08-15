package org.pup.system.osas.ui.action;

public class DisplayAddScholarshipProgramAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8623493011979471145L;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship";
		
		return FORWARD_SUCCESS;
	}
}
