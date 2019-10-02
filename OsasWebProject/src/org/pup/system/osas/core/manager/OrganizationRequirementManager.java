package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.OrganizationRequirementDAO;
import org.pup.system.osas.core.domain.OrganizationRequirement;

public class OrganizationRequirementManager {

	public OrganizationRequirement validate(String organizationRequirementName, int semTermId) throws Exception {
		OrganizationRequirementDAO organizationRequirementDAO = null;
		OrganizationRequirement organizationRequirement = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			organizationRequirementDAO = new OrganizationRequirementDAO(connection);

			organizationRequirement = organizationRequirementDAO.getOrganizationRequirementByOrganizationRequirementName(organizationRequirementName, semTermId);

		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return organizationRequirement;
	}
	
	public void insertOrganizationRequirement(OrganizationRequirement organizationRequirement) throws Exception {
		OrganizationRequirementDAO organizationRequirementDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			organizationRequirementDAO = new OrganizationRequirementDAO(connection);

			organizationRequirementDAO.insertOrganizationRequirement(organizationRequirement);

			connection.commit();

		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	public OrganizationRequirement getOrganizationRequirement(int organizationRequirementId) throws Exception {
		OrganizationRequirementDAO organizationRequirementDAO = null;
		OrganizationRequirement organizationRequirement = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			organizationRequirementDAO = new OrganizationRequirementDAO(connection);

			organizationRequirement = organizationRequirementDAO.getOrganizationRequirementByOrganizationRequirementId(organizationRequirementId);

		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return organizationRequirement;
	}

	public List<OrganizationRequirement> getOrganizationRequirementList(int semTermId) throws Exception {
		OrganizationRequirementDAO organizationRequirementDAO = null;
		List<OrganizationRequirement> organizationRequirementList = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			organizationRequirementDAO = new OrganizationRequirementDAO(connection);

			organizationRequirementList = organizationRequirementDAO.getOrganizationRequirementList(semTermId);

		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return organizationRequirementList;
	}

	public List<OrganizationRequirement> getOrganizationRequirementListByOrganizationRequirementSearchText(
			String organizationRequirementSearchText, int semTermId) throws Exception {
		OrganizationRequirementDAO organizationRequirementDAO = null;
		List<OrganizationRequirement> organizationRequirementList = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			organizationRequirementDAO = new OrganizationRequirementDAO(connection);

			organizationRequirementList = organizationRequirementDAO.getOrganizationRequirementListByOrganizationRequirementSearchText(organizationRequirementSearchText, semTermId);

		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return organizationRequirementList;
	}

	public void saveOrganizationRequirement(OrganizationRequirement organizationRequirement) throws Exception {
		OrganizationRequirementDAO organizationRequirementDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			organizationRequirementDAO = new OrganizationRequirementDAO(connection);

			organizationRequirementDAO.saveOrganizationRequirement(organizationRequirement);

			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}

	public void deleteOrganizationRequirement(OrganizationRequirement organizationRequirement) throws Exception {
		OrganizationRequirementDAO organizationRequirementDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			organizationRequirementDAO = new OrganizationRequirementDAO(connection);

			organizationRequirementDAO.deleteOrganizationRequirementByOrganizationRequirementId(organizationRequirement.getOrganizationRequirementId());

			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
}
