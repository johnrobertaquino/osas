package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.ScholarshipTerm;
import org.pup.system.osas.core.manager.ScholarshipTermManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayScholarshipTermListAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5840469153780205538L;
	
	private List<ScholarshipTerm> scholarshipTermList;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship Term";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipTermManager scholarshipTermManager = new ScholarshipTermManager();
			setScholarshipTermList(scholarshipTermManager.getScholarshipTermList());
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
}
