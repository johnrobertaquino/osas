package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditScholarshipProgramAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private String scholarshipProgramId;
	
	private ScholarshipProgram scholarshipProgram;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipProgramManager scholarshipManager = new ScholarshipProgramManager();
			setScholarshipProgram(scholarshipManager.getScholarshipProgram(Integer.parseInt(scholarshipProgramId)));
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
	 * @return the scholarshipProgram
	 */
	public String getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	public void setScholarshipProgramId(String scholarshipProgramId) {
		this.scholarshipProgramId = scholarshipProgramId;
	}
	
	
	public ScholarshipProgram getScholarshipProgram() {
		return scholarshipProgram;
	}

	/**
	 * @param scholarshipProgram the scholarshipProgram to set
	 */
	public void setScholarshipProgram(ScholarshipProgram scholarshipProgram) {
		this.scholarshipProgram = scholarshipProgram;
	}
	
}
