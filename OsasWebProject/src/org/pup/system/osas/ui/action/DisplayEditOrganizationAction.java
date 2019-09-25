package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.core.manager.ProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditOrganizationAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private String organizationId;
	
	private Organization organization;
	
	private List<Program> programList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationManager scholarshipManager = new OrganizationManager();
			setOrganization(scholarshipManager.getOrganization(Integer.parseInt(organizationId)));
			
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
	 * @return the organizationId
	 */
	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	/**
	 * @return the organization
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<Program> getProgramList() {
		return programList;
	}

	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}
	
}
