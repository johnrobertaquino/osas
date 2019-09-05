package org.pup.system.osas.core.domain;

public class OrganizationQualification {

	private int organizationQualificationId;
	
	private boolean qualified;

	private String notes;
	
	private String fileName;

	private Organization organization;
	
	private OrganizationRequirement organizationRequirement;
	
	private YearlyTerm yearlyTerm;

	/**
	 * @return the organizationQualificationId
	 */
	public int getOrganizationQualificationId() {
		return organizationQualificationId;
	}

	/**
	 * @param organizationQualificationId the organizationQualificationId to set
	 */
	public void setOrganizationQualificationId(int organizationQualificationId) {
		this.organizationQualificationId = organizationQualificationId;
	}

	/**
	 * @return the qualified
	 */
	public boolean isQualified() {
		return qualified;
	}

	/**
	 * @param qualified the qualified to set
	 */
	public void setQualified(boolean qualified) {
		this.qualified = qualified;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	 * @return the organizationRequirement
	 */
	public OrganizationRequirement getOrganizationRequirement() {
		return organizationRequirement;
	}

	/**
	 * @param organizationRequirement the organizationRequirement to set
	 */
	public void setOrganizationRequirement(OrganizationRequirement organizationRequirement) {
		this.organizationRequirement = organizationRequirement;
	}

	/**
	 * @return the yearlyTerm
	 */
	public YearlyTerm getYearlyTerm() {
		return yearlyTerm;
	}

	/**
	 * @param yearlyTerm the yearlyTerm to set
	 */
	public void setYearlyTerm(YearlyTerm yearlyTerm) {
		this.yearlyTerm = yearlyTerm;
	}
}
