package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.OrganizationDAO;
import org.pup.system.osas.core.domain.Organization;

public class OrganizationManager {
	
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
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			organization = organizationDAO.getOrganizationByOrganizationId(organizationId);
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return organization;
	}
	
	public List<Organization> getOrganizationList() throws Exception {
		OrganizationDAO organizationDAO = null;
		List<Organization> organizationList = null;

		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
		organizationDAO = new OrganizationDAO(connection);
			
		organizationList = organizationDAO.getOrganizationList();
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return organizationList;
	}
	
	public List<Organization> getOrganizationListByOrganizationSearchText(String organizationSearchText) throws Exception {
		OrganizationDAO organizationDAO = null;
		List<Organization> organizationList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationDAO = new OrganizationDAO(connection);
			
			organizationList = organizationDAO.getOrganizationListByOrganizationSearchText(organizationSearchText);
			
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
