package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.ProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchProgramAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5777267392504750903L;

	private String programSearchText;
	
	private List<Program> programList;
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship Agency";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ProgramManager programManager = new ProgramManager();
			setProgramList(programManager.getProgramListByProgramSearchText(programSearchText, getCurrentActiveTerm().getSemTermId()));
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
	
	public String getProgramSearchText() {
		return programSearchText;
	}
	public void setProgramSearchText(String programSearchText) {
		this.programSearchText = programSearchText;
	}
	public List<Program> getProgramList() {
		return programList;
	}
	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}


}
