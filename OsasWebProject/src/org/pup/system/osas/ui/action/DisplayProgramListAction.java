package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.ProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayProgramListAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5840469153780205538L;
	
	private List<Program> programList;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Accounts > Program Management";
		
		String actionResult = FORWARD_SUCCESS;

		try {
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
	 * @return the programList
	 */
	public List<Program> getProgramList() {
		return programList;
	}

	/**
	 * @param programList the programList to set
	 */
	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}
}
