package org.pup.system.osas.ui.action;


import org.pup.system.osas.core.domain.ScholarshipTerm;
import org.pup.system.osas.core.manager.ScholarshipTermManager;
import org.pup.system.osas.exception.BusinessException;

public class EditScholarshipTermAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2399121123000593161L;

	private int scholarshipTermId;
	
	private String scholarshipTermName;
	
	private String startDate;
	
	private String endDate;
	
	private Boolean active;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship Term";

		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipTermManager scholarshipTermManager = new ScholarshipTermManager();
			ScholarshipTerm scholarshipTerm = scholarshipTermManager.getScholarshipTerm(scholarshipTermId);
			
			scholarshipTerm.setScholarshipTermName(scholarshipTermName);
			scholarshipTerm.setStartDate(startDate);
			scholarshipTerm.setEndDate(endDate);
			scholarshipTerm.setActive(active);
			
			scholarshipTermManager.saveScholarshipTerm(scholarshipTerm);
			
			notificationMessage = "Changes to scholarship term has been saved successfully.";
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
	 * @return the scholarshipTermId
	 */
	public int getScholarshipTermId() {
		return scholarshipTermId;
	}

	/**
	 * @param scholarshipTermId the scholarshipTermId to set
	 */
	public void setScholarshipTermId(int scholarshipTermId) {
		this.scholarshipTermId = scholarshipTermId;
	}

	/**
	 * @return the scholarshipTermName
	 */
	public String getScholarshipTermName() {
		return scholarshipTermName;
	}

	/**
	 * @param scholarshipTermName the scholarshipTermName to set
	 */
	public void setScholarshipTermName(String scholarshipTermName) {
		this.scholarshipTermName = scholarshipTermName;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	

}
