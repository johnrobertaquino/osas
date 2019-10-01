package org.pup.system.osas.core.domain;

import java.util.List;

public class Organization {
	
	private int organizationId;
	
	private String organizationName;
	
	private OrganizationType organizationType;
	
	private Program program;
	
	private int organizationTermId;
	
	private int organizationRequirementId;
	
	private String adviser;
	
	private SemTerm semTerm;
	
	private String logoFileName;
	
	private List<OrganizationRequirementQualification> organizationRequirementQualificationList;
	
	public Organization() {
		
	}
	
	public Organization(int organizationId) {
		this.organizationId = organizationId;
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

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
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

	public List<OrganizationRequirementQualification> getOrganizationRequirementQualificationList() {
		return organizationRequirementQualificationList;
	}

	public void setOrganizationRequirementQualificationList(
			List<OrganizationRequirementQualification> organizationRequirementQualificationList) {
		this.organizationRequirementQualificationList = organizationRequirementQualificationList;
	}
	
	public String getStatusText() {
		String statusText = "Approved";
		boolean hasPendingReview = false;
		boolean hasNotSubmitted = false;
		
		if (organizationRequirementQualificationList != null) {
			for (OrganizationRequirementQualification organizationRequirementQualification : organizationRequirementQualificationList) {
				if ("N".equals(organizationRequirementQualification.getStatus())) {
					hasNotSubmitted = true;
				} else if ("P".equals(organizationRequirementQualification.getStatus())) {
					hasPendingReview = true;
				}
			}
		}
		
		if (hasPendingReview && hasNotSubmitted) {
			statusText = "Incomplete / Pending Approval";
		} else if (hasPendingReview) {
			statusText = "Pending Approval";
		} else if (hasNotSubmitted) {
			statusText = "Incomplete";
		}
		
		return statusText;
	}
	
	
}
