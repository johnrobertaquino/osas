package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.OrganizationDAO;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationType;

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
}
