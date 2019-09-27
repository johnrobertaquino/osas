package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.core.manager.ProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class AddProgramAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8910283248066116810L;
	
	private static final String FORWARD_DISPLAYADDPROGRAM = "displayAddProgram";
	
	private String programCode;
	
	private String programName;
	
	private int highestYearLevel;
	
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Program";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			Program program = new Program();
			ProgramManager programManager = new ProgramManager();
			program = programManager.getProgram(programCode, getCurrentActiveTerm().getSemTermId());
			
			if(program != null) { 
				notificationMessage = "Program already exist.";
				actionResult = FORWARD_DISPLAYADDPROGRAM;
			}
			else
			{
				program = new Program();
				program.setProgramCode(programCode);
				program.setProgramName(programName);
				program.setHighestYearLevel(highestYearLevel);
				program.setSemTerm(getCurrentActiveTerm());
				programManager.insertProgram(program);
				notificationMessage = "Agency has been successfully added.";
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

	/**
	 * @return the highestYearLevel
	 */
	public int getHighestYearLevel() {
		return highestYearLevel;
	}

	/**
	 * @param highestYearLevel the highestYearLevel to set
	 */
	public void setHighestYearLevel(int highestYearLevel) {
		this.highestYearLevel = highestYearLevel;
	}
}
