package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.AgencyDAO;
import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.SemTermDAO;
import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.SemTerm;

public class AgencyManager {
	
	public Agency validate(String agencyName) throws Exception {
		AgencyDAO agencyDAO = null;
		Agency agency;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			agencyDAO = new AgencyDAO(connection);
			
			agency = agencyDAO.getAgencyByAgencyName(agencyName);
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return agency;
	}
	
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
	
	public List<Agency> getAgencyList(int semTermId) throws Exception {
		AgencyDAO agencyDAO = null;
		List<Agency> agencyList = null;

		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			agencyDAO = new AgencyDAO(connection);
			
			agencyList = agencyDAO.getAgencyList(semTermId);

			if (agencyList != null) {
				SemTermDAO semTermDAO = new SemTermDAO(connection);

				for (Agency agency : agencyList) {
					SemTerm semTerm = semTermDAO.getSemTermBySemTermId(agency.getSemTerm().getSemTermId());
					agency.setSemTerm(semTerm);
				}
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return agencyList;
	}
	
	public List<Agency> getAgencyListByAgencySearchText(String agencySearchText, int semTermId) throws Exception {
		AgencyDAO agencyDAO = null;
		List<Agency> agencyList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			agencyDAO = new AgencyDAO(connection);
			
			agencyList = agencyDAO.getAgencyListByAgencySearchText(agencySearchText, semTermId);
			
			if (agencyList != null) {
				SemTermDAO semTermDAO = new SemTermDAO(connection);

				for (Agency agency : agencyList) {
					SemTerm semTerm = semTermDAO.getSemTermBySemTermId(agency.getSemTerm().getSemTermId());
					agency.setSemTerm(semTerm);
				}
			}
			
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
