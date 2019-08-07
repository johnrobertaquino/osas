package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.AgencyDAO;
import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.domain.Agency;

public class AgencyManager {
	
	public void insertAgency(Agency agency) throws Exception {
		AgencyDAO agencyDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			agencyDAO = new AgencyDAO(connection);
			
			agencyDAO.insertAgency(agency);
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public Agency getAgency(int agencyId) throws Exception {
		AgencyDAO agencyDAO = null;
		Agency agency = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			agencyDAO = new AgencyDAO(connection);
			
			agency = agencyDAO.getAgencyByAgencyId(agencyId);
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return agency;
	}
	
	public List<Agency> getAgencyList() throws Exception {
		AgencyDAO agencyDAO = null;
		List<Agency> agencyList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			agencyDAO = new AgencyDAO(connection);
			
			agencyList = agencyDAO.getAgencyList();
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return agencyList;
	}
	
	public List<Agency> getAgencyListByAgencySearchText(String agencySearchText) throws Exception {
		AgencyDAO agencyDAO = null;
		List<Agency> agencyList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			agencyDAO = new AgencyDAO(connection);
			
			agencyList = agencyDAO.getAgencyListByAgencySearchText(agencySearchText);
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return agencyList;
	}

	public void saveAgency(Agency agency) throws Exception {
		AgencyDAO agencyDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			agencyDAO = new AgencyDAO(connection);
			
			agencyDAO.saveAgency(agency);
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}

	public void deleteAgency(Agency agency) throws Exception {
		AgencyDAO agencyDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			agencyDAO = new AgencyDAO(connection);
			
			agencyDAO.deleteAgencyByAgencyId(agency.getAgencyId());
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
}
