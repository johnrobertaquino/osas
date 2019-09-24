package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.manager.ProgramManager;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditScholarAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private String scholarId;
	
	private Scholar scholar;
	
	private List<Program> programList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarManager scholarshipManager = new ScholarManager();
			setScholar(scholarshipManager.getScholar(Integer.parseInt(scholarId)));
			
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
	 * @return the scholar
	 */
	public String getScholarId() {
		return scholarId;
	}

	public void setScholarId(String scholarId) {
		this.scholarId = scholarId;
	}
	
	
	public Scholar getScholar() {
		return scholar;
	}

	/**
	 * @param scholar the scholar to set
	 */
	public void setScholar(Scholar scholar) {
		this.scholar = scholar;
	}
	public List<Program> getProgramList() {
		return programList;
	}
	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}
	
}
