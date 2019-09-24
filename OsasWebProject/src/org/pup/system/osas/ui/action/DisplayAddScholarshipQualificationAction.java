package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayAddScholarshipQualificationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;

	private int scholarshipProgramId;

	@Override
	public String execute() throws Exception {

		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			ScholarshipProgram scholarshipProgram = scholarshipProgramManager
					.getScholarshipProgram(scholarshipProgramId);
			if (scholarshipProgram != null) {
				pageName = "Manage Scholarship > " + scholarshipProgram.getScholarshipProgramName()
						+ " > Qualifications";
			}
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

	public int getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	public void setScholarshipProgramId(int scholarshipProgramId) {
		this.scholarshipProgramId = scholarshipProgramId;
	}

}
