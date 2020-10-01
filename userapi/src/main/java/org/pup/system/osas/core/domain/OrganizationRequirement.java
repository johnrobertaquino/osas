package org.pup.system.osas.core.domain;


public class OrganizationRequirement {

	private int organizationRequirementId;
	
	private String organizationRequirementName;

	private boolean yearlyCheck;
	
	private Organization organization;
	
	private SemTerm semTerm;
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

	/**
	 * @return the semTermId
	 */
	public SemTerm getSemTerm() {
		return semTerm;
	}

	/**
	 * @param semTermId the semTermId to set
	 */
	public void setSemTerm(SemTerm semTerm) {
		this.semTerm = semTerm;
	}

	/**
	 * @return the yearlyCheck
	 */
	public boolean isYearlyCheck() {
		return yearlyCheck;
	}

	/**
	 * @param yearlyCheck the yearlyCheck to set
	 */
	public void setYearlyCheck(boolean yearlyCheck) {
		this.yearlyCheck = yearlyCheck;
	}
	
}
