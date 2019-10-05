package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.OrganizationQualificationDAO;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationQualification;
import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.domain.OrganizationRequirementQualification;

public class OrganizationRequirementQualificationManager {
	
	public List<OrganizationRequirementQualification> getOrganizationRequirementQualificationList(int organizationId, int semTermId) throws Exception {
		OrganizationQualificationDAO organizationQualificationDAO = null;
		OrganizationRequirementManager organizationRequirementManager = null;
		List<OrganizationRequirement> organizationRequirementList = null;
		List<OrganizationRequirementQualification> organizationRequirementQualificationList = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();
			
			organizationRequirementManager = new OrganizationRequirementManager();
			organizationRequirementList = organizationRequirementManager.getOrganizationRequirementList(semTermId);

			if (organizationRequirementList != null) {
				organizationQualificationDAO = new OrganizationQualificationDAO(connection);

				for (OrganizationRequirement organizationRequirement : organizationRequirementList) {
					if (organizationRequirementQualificationList == null) {
						organizationRequirementQualificationList = new ArrayList<OrganizationRequirementQualification>();
					}
					
					OrganizationRequirementQualification organizationRequirementQualification = new OrganizationRequirementQualification();
					organizationRequirementQualification.setOrganizationRequirement(organizationRequirement);
					
					OrganizationQualification organizationQualification = organizationQualificationDAO.getOrganizationQualificationByOrganizationRequirementIdAndOrganizationId(organizationRequirement.getOrganizationRequirementId(), organizationId);
					if	(organizationQualification != null) {
						organizationRequirementQualification.setOrganizationQualification(organizationQualification);
					}
					
					organizationRequirementQualificationList.add(organizationRequirementQualification);
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return organizationRequirementQualificationList;
	}
	
	public List<OrganizationRequirementQualification> getOrganizationRequirementQualificationListByYearlyTerm(int organizationId, int yearlyTermId) throws Exception {
		OrganizationQualificationDAO organizationQualificationDAO = null;
		OrganizationRequirementManager organizationRequirementManager = null;
		List<OrganizationRequirement> organizationRequirementList = null;
		List<OrganizationRequirementQualification> organizationRequirementQualificationList = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();
			
			organizationRequirementManager = new OrganizationRequirementManager();
			organizationRequirementList = organizationRequirementManager.getOrganizationRequirementListByYearlyTerm(yearlyTermId);

			if (organizationRequirementList != null) {
				organizationQualificationDAO = new OrganizationQualificationDAO(connection);

				for (OrganizationRequirement organizationRequirement : organizationRequirementList) {
					if (organizationRequirementQualificationList == null) {
						organizationRequirementQualificationList = new ArrayList<OrganizationRequirementQualification>();
					}
					
					OrganizationRequirementQualification organizationRequirementQualification = new OrganizationRequirementQualification();
					organizationRequirementQualification.setOrganizationRequirement(organizationRequirement);
					
					OrganizationQualification organizationQualification = organizationQualificationDAO.getOrganizationQualificationByOrganizationRequirementIdAndOrganizationId(organizationRequirement.getOrganizationRequirementId(), organizationId);
					if	(organizationQualification != null) {
						organizationRequirementQualification.setOrganizationQualification(organizationQualification);
					}
					
					organizationRequirementQualificationList.add(organizationRequirementQualification);
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return organizationRequirementQualificationList;
	}
	
	
	public void insertOrganizationQualification(OrganizationQualification organizationQualification) throws Exception {
		OrganizationQualificationDAO organizationQualificationDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			organizationQualificationDAO = new OrganizationQualificationDAO(connection);

			organizationQualificationDAO.insertOrganizationQualification(organizationQualification);

			connection.commit();

		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	public OrganizationQualification getOrganizationQualification(int organizationQualificationId) throws Exception {
		OrganizationQualificationDAO organizationQualificationDAO = null;
		OrganizationQualification organizationQualification = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationQualificationDAO = new OrganizationQualificationDAO(connection);
			
			organizationQualification = organizationQualificationDAO.getOrganizationQualificationByOrganizationQualificationId(organizationQualificationId);
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return organizationQualification;
	}
	
	public void saveOrganizationQualification(OrganizationQualification organizationQualification) throws Exception {
		OrganizationQualificationDAO organizationQualificationDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			organizationQualificationDAO = new OrganizationQualificationDAO(connection);
			
			organizationQualificationDAO.saveOrganizationQualification(organizationQualification);
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	
}
