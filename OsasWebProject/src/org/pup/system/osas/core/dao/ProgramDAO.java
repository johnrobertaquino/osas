package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.domain.SemTerm;

public class ProgramDAO extends DAO {

	public ProgramDAO(Connection connection) {
		super(connection);
	}
		
	public Program getProgramByProgramCode(String programCode, int semTermId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Program program = null;
		
		try {
			connection = getConnection();
			
			statement = connection.prepareStatement("SELECT ProgramCode, ProgramName, HighestYearLevel, SemTermId FROM program WHERE ProgramCode=? and SemTermId=?");
			statement.setString(1, programCode);
			statement.setInt(2, semTermId);
			
			resultSet = statement.executeQuery();  
			
			if (resultSet.next()) {
				program = new Program();
				
				program.setProgramCode(resultSet.getString("ProgramCode"));
				program.setProgramName(resultSet.getString("ProgramName"));
				program.setHighestYearLevel(resultSet.getInt("HighestYearLevel"));
				
				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				program.setSemTerm(semTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getProgramByProgramCode method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return program;
	}
	
	public List<Program> getProgramList(int semTermId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Program> programList = null;
		Program program = null;
		
		try {
			connection = getConnection();
			
			statement = connection.prepareStatement("SELECT ProgramCode, ProgramName, HighestYearLevel, SemTermId FROM program WHERE SemTermId=?");
			statement.setInt(1, semTermId);
			
			resultSet = statement.executeQuery();  
			
			while (resultSet.next()) {
				if (programList == null) {
					programList = new ArrayList<Program>();
				}
				
				program = new Program();
				
				program.setProgramCode(resultSet.getString("ProgramCode"));
				program.setProgramName(resultSet.getString("ProgramName"));
				program.setHighestYearLevel(resultSet.getInt("HighestYearLevel"));
				
				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				program.setSemTerm(semTerm);
				
				programList.add(program);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getProgramList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return programList;
	}
		
	public void insertProgram(Program program) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("INSERT INTO program(ProgramCode, ProgramName, HighestYearLevel, SemTermId) VALUES (?, ?, ?, ?)");
			statement.setString(1, program.getProgramCode());
			statement.setString(2, program.getProgramName());
			statement.setInt(3, program.getHighestYearLevel());
			statement.setInt(4, program.getSemTerm().getSemTermId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertProgram method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
	
	public void saveProgram(Program program) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE program SET ProgramName=, HighestYearLevel=? WHERE ProgramCode=? AND SemTermId=?");
			statement.setString(1, program.getProgramName());
			statement.setInt(2, program.getHighestYearLevel());
			statement.setString(3, program.getProgramCode());
			statement.setInt(4, program.getSemTerm().getSemTermId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing saveProgram method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

}
