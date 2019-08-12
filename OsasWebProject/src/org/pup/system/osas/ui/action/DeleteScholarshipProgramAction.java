package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class DeleteScholarshipProgramAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4998330923614620844L;
	
	private int scholarshipProgramId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			ScholarshipProgram scholarshipProgram = scholarshipProgramManager.getScholarshipProgram(scholarshipProgramId);
			scholarshipProgramManager.deleteScholarshipProgram(scholarshipProgram);
			notificationMessage = "User has been successfully deleted.";
		} catch (BusinessException be) {
			errorMessage = be.getMessage();
			actionResult = FORWARD_ERROR;
			be.printStackTrace();
		} catch (Exception e) {
			errorMessage = "System error occurred. Please contact administrator.";
			actionResult = FORWARD_ERROR;
			e.printStackTrace();
		}
		
		return actionResult;
	}

	/**
	 * @return the scholarshipProgramId
	 */
	public int getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	/**
	 * @param agencyId the agencyId to set
	 */
	public void setScholarshipProgramId(int scholarshipProgramId) {
		this.scholarshipProgramId = scholarshipProgramId;
	}
	
}

