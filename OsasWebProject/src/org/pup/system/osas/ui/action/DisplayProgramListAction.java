package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayProgramListAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5840469153780205538L;
	
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Accounts > Program Management";
		
		return FORWARD_SUCCESS;
		
	}
}
