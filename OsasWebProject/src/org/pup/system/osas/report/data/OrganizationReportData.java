package org.pup.system.osas.report.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationRequirementQualification;

public class OrganizationReportData extends Organization {
	
	public OrganizationReportData(Organization organization) {
		setOrganizationId(organization.getOrganizationId());
		setOrganizationName(organization.getOrganizationName());
		setOrganizationType(organization.getOrganizationType());
		setProgram(organization.getProgram());
		setOrganizationTermId(organization.getOrganizationTermId());
		setOrganizationRequirementId(organization.getOrganizationRequirementId());
		setAdviser(organization.getAdviser());
		setSemTerm(organization.getSemTerm());
		setLogoFileName(organization.getLogoFileName());
		setDescription(organization.getDescription());
		setOrganizationRequirementQualificationList(organization.getOrganizationRequirementQualificationList());
	}
	
	private Map<Integer, OrganizationRequirementQualification> organizationRequirementQualificationMap;

	@Override
	public void setOrganizationRequirementQualificationList(
			List<OrganizationRequirementQualification> organizationRequirementQualificationList) {
		// TODO Auto-generated method stub
		super.setOrganizationRequirementQualificationList(organizationRequirementQualificationList);
		
		if (organizationRequirementQualificationList == null) {
			organizationRequirementQualificationMap = null;
		} else {
			for (OrganizationRequirementQualification organizationRequirementQualification : organizationRequirementQualificationList) {
				if (organizationRequirementQualificationMap == null) {
					organizationRequirementQualificationMap = new HashMap<Integer, OrganizationRequirementQualification>();
				}
				
				organizationRequirementQualificationMap.put(organizationRequirementQualification.getOrganizationRequirement().getOrganizationRequirementId(), organizationRequirementQualification);
			}
		}
	}
	
	public String getDateStatusByOrganizationRequirementId(int organizationRequirementId) {
		String dateStatus = "";
		
		if (organizationRequirementQualificationMap != null) {
			OrganizationRequirementQualification organizationRequirementQualification = organizationRequirementQualificationMap.get(organizationRequirementId);
			
			if (organizationRequirementQualification != null && organizationRequirementQualification.getOrganizationQualification() != null) {
				Date dateSubmitted = organizationRequirementQualification.getOrganizationQualification().getDateSubmitted();
				
				if (dateSubmitted != null) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					String status = "";
					
					if("A".equals(organizationRequirementQualification.getStatus())) {
						status =  " - Approved";
					} else if("P".equals(organizationRequirementQualification.getStatus())) {
						status =  " - Pending Approval";
					}

					dateStatus = format.format(dateSubmitted) + status;
				}
			}
		}
		
		return dateStatus;
	}
}
