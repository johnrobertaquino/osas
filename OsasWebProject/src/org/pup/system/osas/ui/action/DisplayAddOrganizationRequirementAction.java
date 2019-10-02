package org.pup.system.osas.ui.action;

public class DisplayAddOrganizationRequirementAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private String organizationRequirementName;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization Requirement";
		
		return FORWARD_SUCCESS;
	}

	/**
	 * @return the organizationRequirementName
	 */
	public String getOrganizationRequirementName() {
		return organizationRequirementName;
	}

	/**
	 * @param organizationRequirementName the organizationRequirementName to set
	 */
	public void setOrganizationRequirementName(String organizationRequirementName) {
		this.organizationRequirementName = organizationRequirementName;
	}

}
