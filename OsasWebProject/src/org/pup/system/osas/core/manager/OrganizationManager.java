package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.OrganizationDAO;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationRequirementQualification;
import org.pup.system.osas.core.domain.OrganizationType;
import org.pup.system.osas.core.domain.SemTerm;

public class OrganizationManager {
	
	public Organization validate(String organizationName, int semTermId) throws Exception {
		OrganizationDAO organizationDAO = null;
		Organization organization = null;
		OrganizationType organizationTypeCode = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			organization = organizationDAO.getOrganizationByOrganizationName(organizationName, semTermId);
			
			if (organization != null) {
				organizationTypeCode = organizationDAO.getOrganizationTypeNameByOrganizationTypeCode(organization.getOrganizationType().getOrganizationTypeName());
				organization.setOrganizationType(organizationTypeCode);
			}		
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return organization;
	}
	
	public void insertOrganization(Organization organization) throws Exception {
		OrganizationDAO organizationDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			organizationDAO.insertOrganization(organization);
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public Organization getOrganization(int organizationId) throws Exception {
		OrganizationDAO organizationDAO = null;
		Organization organization = null;
		OrganizationType organizationTypeCode = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			organization = organizationDAO.getOrganizationByOrganizationId(organizationId);
			
			if (organization != null) {
				organizationTypeCode = organizationDAO.getOrganizationTypeNameByOrganizationTypeCode(organization.getOrganizationType().getOrganizationTypeCode());
				organization.setOrganizationType(organizationTypeCode);
			}	
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return organization;
	}
	
	public List<Organization> getOrganizationList(int semTermId) throws Exception {
		OrganizationDAO organizationDAO = null;
		List<Organization> organizationList = null;
		OrganizationType organizationType = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
		organizationDAO = new OrganizationDAO(connection);
			
		organizationList = organizationDAO.getOrganizationList(semTermId);
		
		if (organizationList != null) {
			OrganizationRequirementQualificationManager organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
			
			for(Organization organization : organizationList) {
				organizationType = organizationDAO.getOrganizationTypeNameByOrganizationTypeCode(organization.getOrganizationType().getOrganizationTypeCode());
				organization.setOrganizationType(organizationType);
				
				organization.setOrganizationRequirementQualificationList(organizationRequirementQualificationManager.getOrganizationRequirementQualificationList(organization.getOrganizationId(), semTermId));
			}
		}	
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return organizationList;
	}
	
	public List<Organization> getOrganizationListByYearlyTermId(int yearlyTermId) throws Exception {
		OrganizationDAO organizationDAO = null;
		List<Organization> organizationList = null;
		OrganizationType organizationType = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
		organizationDAO = new OrganizationDAO(connection);
			
		organizationList = organizationDAO.getOrganizationListByYearlyTermId(yearlyTermId);
		
		if (organizationList != null) {
			OrganizationRequirementQualificationManager organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
			
			for(Organization organization : organizationList) {
				organizationType = organizationDAO.getOrganizationTypeNameByOrganizationTypeCode(organization.getOrganizationType().getOrganizationTypeCode());
				organization.setOrganizationType(organizationType);
				
				organization.setOrganizationRequirementQualificationList(organizationRequirementQualificationManager.getOrganizationRequirementQualificationListByYearlyTerm(organization.getOrganizationId(), yearlyTermId));
			}
		}	
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return organizationList;
	}
	
	
	
	public List<Organization> getOrganizationList(int semTermId, String filter) throws Exception {
		OrganizationDAO organizationDAO = null;
		OrganizationRequirementQualificationManager organizationRequirementQualificationManager = null;
		List<Organization> organizationList = null;
		List<Organization> filteredOrganizationList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			organizationList = organizationDAO.getOrganizationList(semTermId);
			
			if (organizationList != null) {
				organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
				
				for (Organization organization : organizationList) {
					
					List<OrganizationRequirementQualification> organizationRequirementQualificationList = organizationRequirementQualificationManager.getOrganizationRequirementQualificationList(organization.getOrganizationId(), semTermId);
					
					if (organizationRequirementQualificationList != null) {
						organization.setOrganizationRequirementQualificationList(organizationRequirementQualificationList);
					}
					
					String statusText = organization.getStatusText();
					
					
					if("pending".equalsIgnoreCase(filter) && ("Pending Approval".equalsIgnoreCase(statusText) || "Incomplete / Pending Approval".equalsIgnoreCase(statusText))) {
						if(filteredOrganizationList == null) {
							filteredOrganizationList = new ArrayList<Organization>();
						}
						
						filteredOrganizationList.add(organization);
					} else if("incomplete".equalsIgnoreCase(filter) && ("Incomplete".equalsIgnoreCase(statusText) || "Incomplete / Pending Approval".equalsIgnoreCase(statusText))) {
						if(filteredOrganizationList == null) {
							filteredOrganizationList = new ArrayList<Organization>();
						}
						
						filteredOrganizationList.add(organization);
					} else if("approved".equalsIgnoreCase(filter) && "Approved".equalsIgnoreCase(statusText)) {
						if(filteredOrganizationList == null) {
							filteredOrganizationList = new ArrayList<Organization>();
						}
						
						filteredOrganizationList.add(organization);
					} else if("all".equalsIgnoreCase(filter)) {
						if(filteredOrganizationList == null) {
							filteredOrganizationList = new ArrayList<Organization>();
						}
						
						
						filteredOrganizationList.add(organization);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return filteredOrganizationList	;
	}
	
	public List<Organization> getOrganizationListByOrganizationSearchText(String organizationSearchText, int semTermId) throws Exception {
		OrganizationDAO organizationDAO = null;
		List<Organization> organizationList = null;
		OrganizationType organizationType = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			organizationList = organizationDAO.getOrganizationListByOrganizationSearchText(organizationSearchText, semTermId);
			
			if (organizationList != null) {
				for(Organization organization : organizationList) {
					organizationType = organizationDAO.getOrganizationTypeNameByOrganizationTypeCode(organization.getOrganizationType().getOrganizationTypeCode());
					organization.setOrganizationType(organizationType);
				}
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return organizationList;
	}

	public void saveOrganization(Organization organization) throws Exception {
		OrganizationDAO organizationDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			organizationDAO.saveOrganization(organization);
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}

	public void deleteOrganization(Organization organization) throws Exception {
		OrganizationDAO organizationDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			organizationDAO.deleteOrganizationByOrganizationId(organization.getOrganizationId());
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public List<Organization> getOrganizationListByMemberId(int memberId) throws Exception {
		OrganizationDAO organizationDAO = null;
		List<Organization> organizationList = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			organizationList = organizationDAO.getOrganizationListByMemberId(memberId);
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return organizationList;
	}
}
