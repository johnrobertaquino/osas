package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.exception.BusinessException;

public class DeleteAgencyAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2914771763486431991L;

	private int agencyId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship Agency";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			AgencyManager agencyManager = new AgencyManager();
			Agency agency = agencyManager.getAgency(agencyId);
			agencyManager.deleteAgency(agency);
			notificationMessage = "Agency has been successfully deleted.";
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
	 * @return the agencyId
	 */
	public int getAgencyId() {
		return agencyId;
	}

	/**
	 * @param agencyId the agencyId to set
	 */
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	
}
