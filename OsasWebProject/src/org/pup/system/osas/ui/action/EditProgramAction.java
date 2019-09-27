package org.pup.system.osas.ui.action;


import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.core.manager.ProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class EditProgramAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;
	
	private static final String FORWARD_DISPLAYEDITPROGRAM = "displayEditProgram";
	
	private String programCode;
	
	private String programName;
	
	private int highestYearLevel; 

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship Agency";

		String actionResult = FORWARD_SUCCESS;

		try {
			ProgramManager programManager = new ProgramManager();
			Program program = programManager.getProgramCode(programCode);
		
			program = new Program();
			program.setProgramCode(programCode);
			program.setProgramName(programName);
			program.setHighestYearLevel(highestYearLevel);
				
			programManager.saveProgram(program);
				
			notificationMessage = "Changes to program has been saved successfully.";
			
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

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public int getHighestYearLevel() {
		return highestYearLevel;
	}

	public void setHighestYearLevel(int highestYearLevel) {
		this.highestYearLevel = highestYearLevel;
	}


}
