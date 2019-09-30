package org.pup.system.osas.core.domain;

import java.util.Date;

public class OrganizationQualification {

	private int organizationQualificationId;
	
	private int organizationRequirementId;
	
	private boolean qualified;

	private String notes;
	
	private Date dateSubmitted;
	
	private String fileName;

	private int organizationId;

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

	/**
	 * @return the dateSubmitted
	 */
	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	/**
	 * @param dateSubmitted the dateSubmitted to set
	 */
	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
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
	
	
}
