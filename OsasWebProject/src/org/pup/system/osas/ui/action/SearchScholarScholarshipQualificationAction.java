package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.ScholarQualification;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarScholarshipQualificationManager;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchScholarScholarshipQualificationAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343186915653890118L;
	
	private String scholarshipSearchText;
	
	private List<ScholarQualification> scholarQualificationList;
	
	private int scholarId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship > Qualifications";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarQualification scholarQualification = new ScholarQualification();
			scholarQualification.setScholarId(scholarId);
			ScholarScholarshipQualificationManager scholarScholarshipQualificationManager = new ScholarScholarshipQualificationManager();
			//setScholarQualificationList(scholarScholarshipQualificationManager.getScholarScholarshipQualificationListBySearchText(scholarshipSearchText, scholarId,  getCurrentActiveTerm().getSemTermId()));
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

	public String getScholarshipSearchText() {
		return scholarshipSearchText;
	}

	public void setScholarshipSearchText(String scholarshipSearchText) {
		this.scholarshipSearchText = scholarshipSearchText;
	}

	public List<ScholarQualification> getScholarQualificationList() {
		return scholarQualificationList;
	}

	public void setScholarQualificationList(List<ScholarQualification> scholarQualificationList) {
		this.scholarQualificationList = scholarQualificationList;
	}

	public int getScholarId() {
		return scholarId;
	}

	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
	}
	
	
}

