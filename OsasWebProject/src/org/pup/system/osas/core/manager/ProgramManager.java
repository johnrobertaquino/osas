package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.ProgramDAO;
import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.SemTermDAO;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.domain.SemTerm;

public class ProgramManager {

	public Program getProgram(String programCode, int semTermId) throws Exception {
		ProgramDAO programDAO = null;
		Connection connection = null;
		Program program = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			programDAO = new ProgramDAO(connection);
			program = programDAO.getProgramByProgramCode(programCode, semTermId);
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
			
		return program;
	}
	
	public Program getProgramCode(String programCode) throws Exception {
		ProgramDAO programDAO = null;
		Connection connection = null;
		Program program = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			programDAO = new ProgramDAO(connection);
			program = programDAO.getProgramByProgramCode(programCode);
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
			
		return program;
	}
	
	public List<Program> getProgramList(int semTermId) throws Exception {
		ProgramDAO programDAO = null;
		Connection connection = null;
		List<Program> programList = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			programDAO = new ProgramDAO(connection);
			programList = programDAO.getProgramList(semTermId);
			
			if (programList != null) {
				SemTermDAO semTermDAO = new SemTermDAO(connection);
				
				for (Program program : programList) {
					SemTerm semTerm = semTermDAO.getSemTermBySemTermId(program.getSemTerm().getSemTermId());
					program.setSemTerm(semTerm);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
			
		return programList;
	}
	
	public List<Program> getProgramListByProgramSearchText(String programSearchText, int semTermId) throws Exception {
		ProgramDAO programDAO = null;
		List<Program> programList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			programDAO = new ProgramDAO(connection);
			
			programList = programDAO.getProgramListSearchText(programSearchText, semTermId);
			
			if (programList != null) {
				SemTermDAO semTermDAO = new SemTermDAO(connection);

				for (Program program : programList) {
					SemTerm semTerm = semTermDAO.getSemTermBySemTermId(program.getSemTerm().getSemTermId());
					program.setSemTerm(semTerm);
				}
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return programList;
	}
	
	public void insertProgram(Program program) throws Exception {
		ProgramDAO programDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			programDAO = new ProgramDAO(connection);
			
			programDAO.insertProgram(program);
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public void saveProgram(Program program) throws Exception {
		ProgramDAO programDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			programDAO = new ProgramDAO(connection);
			
			programDAO.saveProgram(program);
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}

	public void deleteProgram(Program program) throws Exception {
		ProgramDAO programDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			programDAO = new ProgramDAO(connection);
			
			programDAO.deleteProgramByProgramCode(program.getProgramCode());
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
}
