package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.ProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class DeleteProgramAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2914771763486431991L;

	private String programCode;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Program";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ProgramManager programManager = new ProgramManager();
			Program program = programManager.getProgramCode(programCode);
			programManager.deleteProgram(program);
			notificationMessage = "Program has been successfully deleted.";
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
	
	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	
}
