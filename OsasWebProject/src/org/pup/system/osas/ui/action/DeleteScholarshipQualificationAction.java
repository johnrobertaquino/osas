package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class DeleteScholarshipQualificationAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4998330923614620844L;
	
	private int scholarshipQualificationId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship > Qualifications";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();
			ScholarshipQualification scholarshipQualification = scholarshipQualificationManager.getScholarshipQualification(scholarshipQualificationId);
			scholarshipQualificationManager.deleteScholarshipQualification(scholarshipQualification);
			notificationMessage = "Scholarship qualification has been successfully deleted.";
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
	 * @return the scholarshipQualificationId
	 */
	public int getScholarshipQualificationId() {
		return scholarshipQualificationId;
	}

	/**
	 * @param agencyId the agencyId to set
	 */
	public void setScholarshipQualificationId(int scholarshipQualificationId) {
		this.scholarshipQualificationId = scholarshipQualificationId;
	}
	
}

