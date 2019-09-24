package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarQualification;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class ApproveScholarQualificationAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8495140342055540043L;
	
	private int scholarQualificationId;
	
	private int scholarId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar > Qualifications";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarManager scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			if (scholar != null) {
				pageName = "Manage Scholar > " + scholar.getFirstName() + " " + scholar.getLastName() + " > Qualifications";
			}
			ScholarScholarshipQualificationManager scholarScholarshipQualificationManager = new ScholarScholarshipQualificationManager();
			ScholarQualification scholarQualification = scholarScholarshipQualificationManager.getScholarQualification(scholarQualificationId);
			
			scholarQualification.setQualified(true);
			
			scholarScholarshipQualificationManager.saveScholarQualification(scholarQualification);
			notificationMessage = "Scholar Requirement has been approved.";
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

	public int getScholarQualificationId() {
		return scholarQualificationId;
	}

	public void setScholarQualificationId(int scholarQualificationId) {
		this.scholarQualificationId = scholarQualificationId;
	}
	
	public int getScholarId() {
		return scholarId;
	}

	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
	}
	
}
