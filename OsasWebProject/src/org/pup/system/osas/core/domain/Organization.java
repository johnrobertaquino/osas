package org.pup.system.osas.core.domain;

public class Organization {
	private int organizationId;
	
	private String organizationName;
	
	private String organizationTypeCode;
	
	private String program;
	
	private int organizationTermId;
	
	private int organizationRequirementId;
	
	private String adviser;
	
	private int semTermId;

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
	public String getOrganizationTypeCode() {
		return organizationTypeCode;
	}

	/**
	 * @param organizationTypeCode the organizationTypeCode to set
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
	 * @return the semTermId
	 */
	public int getSemTermId() {
		return semTermId;
	}

	/**
	 * @param semTermId the semTermId to set
	 */
	public void setSemTermId(int semTermId) {
		this.semTermId = semTermId;
	}
}
