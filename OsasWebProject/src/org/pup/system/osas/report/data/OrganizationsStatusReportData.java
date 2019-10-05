package org.pup.system.osas.report.data;

import java.util.List;

import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.domain.OrganizationType;

public class OrganizationsStatusReportData {
	
	private List<OrganizationReportData> organizationReportDataList;
	
	private List<OrganizationRequirement> organizationRequirementList;
	
	private OrganizationType organizationType;

	public List<OrganizationReportData> getOrganizationReportDataList() {
		return organizationReportDataList;
	}

	public void setOrganizationReportDataList(List<OrganizationReportData> organizationReportDataList) {
		this.organizationReportDataList = organizationReportDataList;
	}

	public List<OrganizationRequirement> getOrganizationRequirementList() {
		return organizationRequirementList;
	}

	public void setOrganizationRequirementList(List<OrganizationRequirement> organizationRequirementList) {
		this.organizationRequirementList = organizationRequirementList;
	}

	public OrganizationType getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}

}
