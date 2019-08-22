package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayAddScholarshipProgramAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private List<Agency> agencyList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			AgencyManager agencyManager = new AgencyManager();
			agencyList = agencyManager.getAgencyList(getCurrentActiveTerm().getSemTermId());	
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

	public List<Agency> getAgencyList() {
		return agencyList;
	}

	public void setAgencyList(List<Agency> agencyList) {
		this.agencyList = agencyList;
	}
	
	
}
