package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class AddScholarshipProgramAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 89102832466116810L;

	private String scholarshipProgramName;

	private String agencyId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship";

		String actionResult = FORWARD_SUCCESS;

		try {
			AgencyManager agencyManager = new AgencyManager();
			Agency agency = agencyManager.getAgency(Integer.parseInt(agencyId));
			
			ScholarshipProgram scholarshipProgram = null;
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			scholarshipProgram = scholarshipProgramManager.validate(scholarshipProgramName);

			if(scholarshipProgram != null) { 
				notificationMessage = "Scholarship program already exist.";
			}
			else
			{			
				scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramName(scholarshipProgramName);
				scholarshipProgram.setAgency(agency);
				scholarshipProgramManager.insertScholarshipProgram(scholarshipProgram);
				notificationMessage = "Scholarship Program has been successfully added.";
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
