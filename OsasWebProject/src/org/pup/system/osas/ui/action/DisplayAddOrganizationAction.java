package org.pup.system.osas.ui.action;

public class DisplayAddOrganizationAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private String organizationName;
	
	private String organizationTypeCode;
	
	private String program;
	
	private String adviser;
	 
	private String logoFileName;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization";
		
		return FORWARD_SUCCESS;
	}
	
	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @return the organizationType
	 */
	public String getOrganizationTypeCode() {
		return organizationTypeCode;
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationTypeCode(String organizationTypeCode) {
		this.organizationTypeCode = organizationTypeCode;
	}


	/**
	 * @return the program
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @param program the program to set
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * @return the adviser
	 */
	public String getAdviser() {
		return adviser;
	}

	/**
	 * @param adviser the adviser to set
	 */
	public void setAdviser(String adviser) {
		this.adviser = adviser;
	}
	
	/**
	 * @return the adviser
	 */
	public String getLogoFileName() {
		return logoFileName;
	}

	/**
	 * @param adviser the adviser to set
	 */
	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}
}
