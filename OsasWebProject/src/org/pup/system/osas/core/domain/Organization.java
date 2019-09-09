package org.pup.system.osas.core.domain;

public class Organization {
	
	private int organizationId;
	
	private String organizationName;
	
	private OrganizationType organizationType;
	
	private String program;
	
	private int organizationTermId;
	
	private int organizationRequirementId;
	
	private String adviser;
	
	private SemTerm semTerm;
	
	private String logoFileName;

	/**
	 * @return the organizationId
	 */
	public int getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
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
	 * @return the organizationTypeCode
	 */
	public OrganizationType getOrganizationType() {
		return organizationType;
	}

	/**
	 * @param organizationTypeCode the organizationTypeCode to set
	 */
	public void setOrganizationType(OrganizationType organizationTypeCode) {
		this.organizationType = organizationTypeCode;
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
	 * @return the organizationTermId
	 */
	public int getOrganizationTermId() {
		return organizationTermId;
	}

	/**
	 * @param organizationTermId the organizationTermId to set
	 */
	public void setOrganizationTermId(int organizationTermId) {
		this.organizationTermId = organizationTermId;
	}

	/**
	 * @return the organizationRequirementId
	 */
	public int getOrganizationRequirementId() {
		return organizationRequirementId;
	}

	/**
	 * @param organizationRequirementId the organizationRequirementId to set
	 */
	public void setOrganizationRequirementId(int organizationRequirementId) {
		this.organizationRequirementId = organizationRequirementId;
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
	 * @return the logoFileName
	 */
	public String getLogoFileName() {
		return logoFileName;
	}

	/**
	 * @param logoFileName the logoFileName to set
	 */
	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	/**
	 * @return the semTerm
	 */
	public SemTerm getSemTerm() {
		return semTerm;
	}

	/**
	 * @param semTerm the semTerm to set
	 */
	public void setSemTerm(SemTerm semTerm) {
		this.semTerm = semTerm;
	}
}
