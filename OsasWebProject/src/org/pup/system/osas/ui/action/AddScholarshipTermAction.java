package org.pup.system.osas.ui.action;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.ScholarshipTerm;
import org.pup.system.osas.core.manager.ScholarshipTermManager;
import org.pup.system.osas.exception.BusinessException;

public class AddScholarshipTermAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8154094740694698940L;

	private String scholarshipTermId;
	
	private String scholarshipTermName;
	
	private String startDate;
	
	private String endDate;
	
	private Boolean active;
	
	@Override
	public String execute() throws Exception {
		
		pageName = "Manage Scholarship";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			ScholarshipTerm scholarshipTerm = new ScholarshipTerm();
			scholarshipTerm.setScholarshipTermName(scholarshipTermName);
			scholarshipTerm.setStartDate(startDate);
			scholarshipTerm.setEndDate(endDate);
			scholarshipTerm.setActive(active);
			
			ScholarshipTermManager scholarshipTermManager = new ScholarshipTermManager();
			scholarshipTermManager.insertScholarshipTerm(scholarshipTerm);
			
			notificationMessage = "Scholarship Program has been saved successfully added.";
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
	public String getScholarshipTermId() {
		return scholarshipTermId;
	}

	/**
	 * @param scholarshipTermId the scholarshipTermId to set
	 */
	public void setScholarshipTermId(String scholarshipTermId) {
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
	 * @return the scholarshipTermName
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param scholarshipTermName the scholarshipTermName to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return the scholarshipTermName
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param scholarshipTermName the scholarshipTermName to set
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
