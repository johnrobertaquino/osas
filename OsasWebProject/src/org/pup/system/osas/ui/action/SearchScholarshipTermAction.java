package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.ScholarshipTerm;
import org.pup.system.osas.core.manager.ScholarshipTermManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchScholarshipTermAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5777267392504750903L;

	private String scholarshipTermSearchText;
	
	private List<ScholarshipTerm> scholarshipTermList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship Term";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipTermManager scholarshipTermManager = new ScholarshipTermManager();
			setScholarshipTermList(scholarshipTermManager.getScholarshipTermListByScholarshipTermSearchText(scholarshipTermSearchText));
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
	 * @return the scholarshipTermList
	 */
	public List<ScholarshipTerm> getScholarshipTermList() {
		return scholarshipTermList;
	}

	/**
	 * @param scholarshipTermList the scholarshipTermList to set
	 */
	public void setScholarshipTermList(List<ScholarshipTerm> scholarshipTermList) {
		this.scholarshipTermList = scholarshipTermList;
	}
	
	/**
	 * @return the agencySearchText
	 */
	public String getScholarshipTermSearchText() {
		return scholarshipTermSearchText;
	}

	/**
	 * @param agencySearchText the agencySearchText to set
	 */
	public void setScholarshipTermSearchText(String scholarshipTermSearchText) {
		this.scholarshipTermSearchText = scholarshipTermSearchText;
	}
}
