package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.OrganizationDAO;
import org.pup.system.osas.core.dao.ScholarDAO;
import org.pup.system.osas.core.dao.ScholarshipProgramDAO;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationType;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.SemTerm;
import org.pup.system.osas.report.data.OrganizationReportData;
import org.pup.system.osas.report.data.OrganizationsStatusReportData;
import org.pup.system.osas.report.data.ScholarsByAgencyAndProgramReportData;

public class ReportManager {

	public List<ScholarsByAgencyAndProgramReportData> getScholarsByAgencyAndProgramReportData(int semTermId, int scholarProgramId, String program) throws Exception {
		ScholarDAO scholarDAO = null;
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		List<Scholar> scholarList = null;
		
		List<ScholarsByAgencyAndProgramReportData> scholarsByAgencyAndProgramReportDataList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholarList = scholarDAO.getScholarListByProgramAndScholarshipProgramId(semTermId, program, scholarProgramId);
			
			if (scholarList != null) {
				scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

				for (Scholar scholar : scholarList) {
					ScholarshipProgram scholarshipProgram = scholarshipProgramDAO.getScholarshipProgramByScholarshipProgramId(scholar.getScholarshipProgram().getScholarshipProgramId());
					scholar.setScholarshipProgram(scholarshipProgram);
				}
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		if (scholarList != null && !scholarList.isEmpty()) {
			scholarsByAgencyAndProgramReportDataList = generateScholarsByAgencyAndProgramReportData(scholarList);
		}
		
		return scholarsByAgencyAndProgramReportDataList;
	}
	
	private List<ScholarsByAgencyAndProgramReportData> generateScholarsByAgencyAndProgramReportData(List<Scholar> scholarList) {
		Map<String, ScholarsByAgencyAndProgramReportData> scholarsByAgencyAndProgramReportDataMap = null;
		
		for (Scholar scholar : scholarList) {
			if(scholarsByAgencyAndProgramReportDataMap == null) {
				scholarsByAgencyAndProgramReportDataMap = new HashMap<String, ScholarsByAgencyAndProgramReportData>();
			}
			
			ScholarsByAgencyAndProgramReportData scholarsByAgencyAndProgramReportData = null;
			
			if (!scholarsByAgencyAndProgramReportDataMap.containsKey(scholar.getYear())) {
				scholarsByAgencyAndProgramReportData = new ScholarsByAgencyAndProgramReportData();
				scholarsByAgencyAndProgramReportData.setScholarList(new ArrayList<Scholar>());
				scholarsByAgencyAndProgramReportData.setYear(scholar.getYear());
				
				scholarsByAgencyAndProgramReportDataMap.put(scholar.getYear(), scholarsByAgencyAndProgramReportData);
			}
			else {
				scholarsByAgencyAndProgramReportData = scholarsByAgencyAndProgramReportDataMap.get(scholar.getYear());
			}
			
			scholarsByAgencyAndProgramReportData.getScholarList().add(scholar);
		}
		
		return new ArrayList<ScholarsByAgencyAndProgramReportData>(scholarsByAgencyAndProgramReportDataMap.values());
	}
	
	private List<OrganizationReportData> getOrganizationReportDataList(int yearlyTermId, String organizationTypeCode) throws Exception {
		OrganizationDAO organizationDAO = null;
		List<Organization> organizationList = null;
		List<OrganizationReportData> organizationReportDataList = null;
		OrganizationType organizationType = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
				
			organizationList = organizationDAO.getOrganizationListByYearlyTermId(yearlyTermId);
			
			if (organizationList != null) {
				OrganizationRequirementQualificationManager organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
				
				organizationReportDataList =  new ArrayList<OrganizationReportData>();
				
				for(Organization organization : organizationList) {
					
					OrganizationReportData organizationReportData = new OrganizationReportData(organization);
					
					organizationType = organizationDAO.getOrganizationTypeNameByOrganizationTypeCode(organization.getOrganizationType().getOrganizationTypeCode());
					organizationReportData.setOrganizationType(organizationType);
					
					organizationReportData.setOrganizationRequirementQualificationList(organizationRequirementQualificationManager.getOrganizationRequirementQualificationListByYearlyTerm(organization.getOrganizationId(), yearlyTermId));
					
					organizationReportDataList.add(organizationReportData);
				}
			}	
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return organizationReportDataList;
	}
	
	public OrganizationsStatusReportData getOrganizationsStatusReportData(int yearlyTermId, String organizationTypeCode) throws Exception {
		OrganizationsStatusReportData organizationsStatusReportData = null;
		Connection connection = null;
		OrganizationDAO organizationDAO = null;
		OrganizationType organizationType = null;
		
		try {
			organizationsStatusReportData = new OrganizationsStatusReportData();
			
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			OrganizationRequirementManager organizationRequirementnManager = new OrganizationRequirementManager();
					
			organizationType = organizationDAO.getOrganizationTypeNameByOrganizationTypeCode(organizationTypeCode);

			organizationsStatusReportData.setOrganizationType(organizationType);	
			
			organizationsStatusReportData.setOrganizationRequirementList(organizationRequirementnManager.getOrganizationRequirementListByYearlyTerm(yearlyTermId));
			
			organizationsStatusReportData.setOrganizationReportDataList(getOrganizationReportDataList(yearlyTermId, organizationTypeCode));
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		return organizationsStatusReportData;
	}
}
