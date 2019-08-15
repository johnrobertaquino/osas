package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.exception.BusinessException;


public class DisplayScholarListAction extends AbstractAction
{

	private static final long serialVersionUID = 4251608337401003937L;
	private List<Scholar> scholarList;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholars";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarManager scholarManager = new ScholarManager();
			scholarList = scholarManager.getScholarList();
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
	
	public List<Scholar> getScholarList() {
		return scholarList;
	}

	public void setScholarList(List<Scholar> scholarList) {
		this.scholarList = scholarList;
	}

}
