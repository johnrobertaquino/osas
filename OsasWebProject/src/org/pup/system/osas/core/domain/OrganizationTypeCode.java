package org.pup.system.osas.core.domain;

public class OrganizationTypeCode {

	private int organizationTypeCode;
	
	private String organizationTypeName;

	/**
	 * @return the organizationTypeCode
	 */
	public int getOrganizationTypeCode() {
		return organizationTypeCode;
	}

	/**
	 * @param organizationTypeCode the organizationTypeCode to set
	 */
	public void setOrganizationTypeCode(int organizationTypeCode) {
		this.organizationTypeCode = organizationTypeCode;
	}

	/**
	 * @return the organizationTypeName
	 */
	public String getOrganizationTypeName() {
		return organizationTypeName;
	}

	/**
	 * @param organizationTypeName the organizationTypeName to set
	 */
	public void setOrganizationTypeName(String organizationTypeName) {
		this.organizationTypeName = organizationTypeName;
	}
}
