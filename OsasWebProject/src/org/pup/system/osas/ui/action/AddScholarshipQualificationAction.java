package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class AddScholarshipQualificationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 89102832466116810L;

	private String scholarshipQualificationName;

	private String scholarshipProgramId;


	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship > Qualifications";

		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			ScholarshipProgram scholarshipProgram = scholarshipProgramManager.getScholarshipProgram(Integer.parseInt(scholarshipProgramId));
			
			ScholarshipQualification scholarshipQualification = new ScholarshipQualification();
			scholarshipQualification.setScholarshipQualificationName(scholarshipQualificationName);
			scholarshipQualification.setScholarshipProgram(scholarshipProgram);

			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();
			scholarshipQualificationManager.insertScholarshipQualification(scholarshipQualification);

			notificationMessage = "Scholarship Qualification has been successfully added.";
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
	 * @return the scholarshipQualificationId
	 */
	public String getScholarshipQualificationName() {
		return scholarshipQualificationName;
	}

	/**
	 * @param scholarshipQualificationId the scholarshipQualificationId to set
	 */
	public void setScholarshipQualificationName(String scholarshipQualificationName) {
		this.scholarshipQualificationName = scholarshipQualificationName;
	}
	
	/**
	 * @return the scholarshipProgramId
	 */
	public String getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	/**
	 * @param scholarshipQualificationId the scholarshipQualificationId to set
	 */
	public void setScholarshipProgramId(String scholarshipProgramId) {
		this.scholarshipProgramId = scholarshipProgramId;
	}


}
