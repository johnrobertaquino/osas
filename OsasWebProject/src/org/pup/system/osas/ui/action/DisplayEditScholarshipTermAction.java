package org.pup.system.osas.ui.action;


import org.pup.system.osas.core.domain.ScholarshipTerm;
import org.pup.system.osas.core.manager.ScholarshipTermManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditScholarshipTermAction extends AbstractAction  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9206475346895272087L;
	
	private String scholarshipTermId;
	
	private ScholarshipTerm scholarshipTerm;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarhip Term";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipTermManager scholarshipTermManager = new ScholarshipTermManager();
			setScholarshipTerm(scholarshipTermManager.getScholarshipTerm(Integer.parseInt(scholarshipTermId)));
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
	 * @return the startDate
	 */
	public String getScholarshipTermId() {
		return scholarshipTermId;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setScholarshipTermId(String scholarshipTermId) {
		this.scholarshipTermId = scholarshipTermId;
	}
	/**
	 * @return the scholarshipTerm
	 */
	public ScholarshipTerm getScholarshipTerm() {
		return scholarshipTerm;
	}
	/**
	 * @param scholarshipTerm the scholarshipTerm to set
	 */
	public void setScholarshipTerm(ScholarshipTerm scholarshipTerm) {
		this.scholarshipTerm = scholarshipTerm;
	}
	
}
