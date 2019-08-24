package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchScholarshipProgramAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343186915653890118L;
	
	private String scholarshipProgramSearchText;
	
	private List<ScholarshipProgram> scholarshipProgramList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship Agency";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			setScholarshipProgramList(scholarshipProgramManager.getScholarshipProgramListByScholarshipProgramSearchText(scholarshipProgramSearchText));
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
	public String getScholarshipProgramSearchText() {
		return scholarshipProgramSearchText;
	}

	/**
	 * @param agencySearchText the agencySearchText to set
	 */
	public void setScholarshipProgramSearchText(String scholarshipProgramSearchText) {
		this.scholarshipProgramSearchText = scholarshipProgramSearchText;
	}
	/**
	 * @return the scholarshipProgramList
	 */
	public List<ScholarshipProgram> getScholarshipProgramList() {
		return scholarshipProgramList;
	}

	/**
	 * @param scholarshipProgramList the scholarshipProgramList to set
	 */
	public void setScholarshipProgramList(List<ScholarshipProgram> scholarshipProgramList) {
		this.scholarshipProgramList = scholarshipProgramList;
	}
}
