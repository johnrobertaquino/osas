package org.pup.system.osas.ui.action;

import java.util.List;


import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayScholarshipProgramListAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426112992716352970L;
	
	private List<ScholarshipProgram> scholarshipProgramList;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			scholarshipProgramList = scholarshipProgramManager.getScholarshipProgramList(1);
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

	public List<ScholarshipProgram> getScholarshipProgramList() {
		return scholarshipProgramList;
	}

	public void setScholarshipProgramList(List<ScholarshipProgram> scholarshipProgramList) {
		this.scholarshipProgramList = scholarshipProgramList;
	}
}
