package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.OrganizationType;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayScholarshipQualificationListAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426112992716352970L;
	
	private List<ScholarshipQualification> scholarshipQualificationList;
	
	private ScholarshipProgram scholarshipProgram;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipProgram scholasrhipProgram = new ScholarshipProgram();
			//scholasrhipProgram.setScholarshipQualification(new ScholarshipQualification);
			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();
			setScholarshipQualificationList(scholarshipQualificationManager.getScholarshipQualificationList(scholarshipProgram.getScholarshipProgramId(), getCurrentActiveTerm().getSemTermId()));
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
	
	/**
	 * @return the scholarshipQualificationList
	 */
	public ScholarshipProgram getScholarshipProgram() {
		return scholarshipProgram;
	}

	/**
	 * @param scholarshipQualificationList the scholarshipQualificationList to set
	 */
	public void setScholarshipQualificationList(ScholarshipProgram scholarshipProgram) {
		this.scholarshipProgram = scholarshipProgram;
	}
}
