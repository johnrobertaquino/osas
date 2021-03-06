package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ProgramManager;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayAddScholarAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;

	private List<ScholarshipProgram> scholarshipProgramList;
	
	private List<Program> programList;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			scholarshipProgramList = scholarshipProgramManager.getScholarshipProgramList(getCurrentActiveTerm().getSemTermId());
			
			ProgramManager programManager = new ProgramManager();
			programList = programManager.getProgramList(getCurrentActiveTerm().getSemTermId());
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
	 * @return the scholarshipProgramList
	 */
	public List<ScholarshipProgram> getScholarshipProgramList() {
		return scholarshipProgramList;
	}

	/**
	 * @param scholarshipProgramList the scholarshipProgramList to set
	 */
	public void setScholarshipProgramList(List<ScholarshipProgram> scholarshipProgramList) {
		this.scholarshipProgramList = scholarshipProgramList;
	}

	public List<Program> getProgramList() {
		return programList;
	}

	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}
	
}
