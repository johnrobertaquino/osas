package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class AddScholarshipProgramAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 89102832466116810L;

	private String scholarshipProgramId;

	private String scholarshipProgramName;

	private String agencyId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship";

		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipProgram scholarshipProgram = new ScholarshipProgram();
			scholarshipProgram.setScholarshipProgramName(scholarshipProgramName);
			//scholarshipProgram.setAgencyId(agencyId);

			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			scholarshipProgramManager.insertScholarshipProgram(scholarshipProgram);

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

	public String getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	public void setScholarshipProgramId(String scholarshipProgramId) {
		this.scholarshipProgramId = scholarshipProgramId;
	}

	public String getScholarshipProgramName() {
		return scholarshipProgramName;
	}

	public void setScholarshipProgramName(String scholarshipProgramName) {
		this.scholarshipProgramName = scholarshipProgramName;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

}
