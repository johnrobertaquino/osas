package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayAddScholarQualificationAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private int scholarshipQualificationId;
	
	private int scholarId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar > Qualifications";

		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();
			ScholarshipQualification scholarshipQualification = scholarshipQualificationManager.getScholarshipQualification(scholarshipQualificationId);
			
			ScholarManager scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			if (scholar != null) {
				pageName = "Manage Scholar > " + scholar.getFirstName() + " " + scholar.getLastName() + " > " + scholarshipQualification.getScholarshipQualificationName() + " " ;
			}		
			
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
	 * @param scholarshipQualificationId the scholarshipQualificationId to set
	 */
	public void setScholarshipQualificationId(int scholarshipQualificationId) {
		this.scholarshipQualificationId = scholarshipQualificationId;
	}
	
	public int getScholarId() {
		return scholarId;
	}
	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
	}

}
