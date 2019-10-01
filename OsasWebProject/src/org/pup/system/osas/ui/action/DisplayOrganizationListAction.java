package org.pup.system.osas.ui.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayOrganizationListAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5840469153780205538L;
	
	private List<Organization> organizationList;
	
	private String filter;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationManager organizationManager = new OrganizationManager();
			organizationList = organizationManager.getOrganizationList(getCurrentActiveTerm().getSemTermId());
			if(StringUtils.isEmpty(filter)) {
				organizationList = organizationManager.getOrganizationList(getCurrentActiveTerm().getSemTermId());
			} else {
				organizationList = organizationManager.getOrganizationList(getCurrentActiveTerm().getSemTermId(), filter);
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

	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
}
