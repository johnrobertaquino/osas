package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditAgencyAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private String agencyId;
	
	private Agency agency;

	@Override
	public String execute() throws Exception {
		pageName = "Manage User Account";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			AgencyManager scholarshipManager = new AgencyManager();
			setAgency(scholarshipManager.getAgency(Integer.parseInt(agencyId)));
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
	 * @return the agency
	 */
	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}
	
	
	public Agency getAgency() {
		return agency;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
}
