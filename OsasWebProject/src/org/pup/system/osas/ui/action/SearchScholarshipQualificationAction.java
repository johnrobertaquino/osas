package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchScholarshipQualificationAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343186915653890118L;
	
	private String scholarshipQualificationSearchText;
	
	private List<ScholarshipQualification> scholarshipQualificationList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship Agency";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();
			setScholarshipQualificationList(scholarshipQualificationManager.getScholarshipQualificationListByScholarshipQualificationSearchText(scholarshipQualificationSearchText));
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
	 * @return the agencySearchText
	 */
	public String getScholarshipQualificationSearchText() {
		return scholarshipQualificationSearchText;
	}

	/**
	 * @param agencySearchText the agencySearchText to set
	 */
	public void setScholarshipQualificationSearchText(String scholarshipQualificationSearchText) {
		this.scholarshipQualificationSearchText = scholarshipQualificationSearchText;
	}
	/**
	 * @return the scholarshipQualificationList
	 */
	public List<ScholarshipQualification> getScholarshipQualificationList() {
		return scholarshipQualificationList;
	}

	/**
	 * @param scholarshipQualificationList the scholarshipQualificationList to set
	 */
	public void setScholarshipQualificationList(List<ScholarshipQualification> scholarshipQualificationList) {
		this.scholarshipQualificationList = scholarshipQualificationList;
	}
}
