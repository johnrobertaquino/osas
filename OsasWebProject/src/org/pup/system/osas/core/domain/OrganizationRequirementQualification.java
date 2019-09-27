package org.pup.system.osas.core.domain;

public class OrganizationRequirementQualification {
	
	private OrganizationRequirement organizationRequirement;
	
	private OrganizationQualification organizationQualification;

	
	
	public String getStatusText() {
		String status = "NOT SUBMITTED";
		String statusCode = getStatus();
		
		if ("A".equals(statusCode)) {
			status = "APPROVED";
		} else if ("P".equals(statusCode)) {
			status = "PENDING APPROVAL";
		}
		
		return status;
	}
	
	public String getStatus() {
		String status = "N";
		
		if (organizationQualification != null) {
			if (organizationQualification.isQualified()) {
				status = "A";
			} else {
				status = "P";
			}
		}
		
		return status;
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
	 * @return the organizationQualification
	 */
	public OrganizationQualification getOrganizationQualification() {
		return organizationQualification;
	}

	/**
	 * @param organizationQualification the organizationQualification to set
	 */
	public void setOrganizationQualification(OrganizationQualification organizationQualification) {
		this.organizationQualification = organizationQualification;
	}

}
