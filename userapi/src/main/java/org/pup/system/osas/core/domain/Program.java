package org.pup.system.osas.core.domain;

public class Program {

	private String programCode;
	
	private String programName;
	
	private int highestYearLevel;
	
	private SemTerm semTerm;
	
	public Program() {
		
	}
	
	public Program(String programCode) {
		this.programCode = programCode;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public int getHighestYearLevel() {
		return highestYearLevel;
	}

	public void setHighestYearLevel(int highestYearLevel) {
		this.highestYearLevel = highestYearLevel;
	}

	public SemTerm getSemTerm() {
		return semTerm;
	}

	public void setSemTerm(SemTerm semTerm) {
		this.semTerm = semTerm;
	}
	
}
