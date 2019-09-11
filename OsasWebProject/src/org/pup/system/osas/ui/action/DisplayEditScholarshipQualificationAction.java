package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditScholarshipQualificationAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private String scholarshipQualificationId;
	
	private ScholarshipQualification scholarshipQualification;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship > Qualfications";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipQualificationManager scholarshipManager = new ScholarshipQualificationManager();
			setScholarshipQualification(scholarshipManager.getScholarshipQualification(Integer.parseInt(scholarshipQualificationId)));
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
	 * @return the scholarshipQualification
	 */
	public String getScholarshipQualificationId() {
		return scholarshipQualificationId;
	}

	public void setScholarshipQualificationId(String scholarshipQualificationId) {
		this.scholarshipQualificationId = scholarshipQualificationId;
	}
	
	
	public ScholarshipQualification getScholarshipQualification() {
		return scholarshipQualification;
	}

	/**
	 * @param scholarshipQualification the scholarshipQualification to set
	 */
	public void setScholarshipQualification(ScholarshipQualification scholarshipQualification) {
		this.scholarshipQualification = scholarshipQualification;
	}
	
}
