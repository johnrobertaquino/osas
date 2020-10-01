package org.pup.system.osas.core.domain;

public class ScholarshipProgram {

	private int scholarshipProgramId;
	
	private String scholarshipProgramName;
	
	private Agency agency;
	
	private ScholarshipQualification scholarshipQualification; 
	
	public int getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	public void setScholarshipProgramId(int scholarshipProgramId) {
		this.scholarshipProgramId = scholarshipProgramId;
	}

	public String getScholarshipProgramName() {
		return scholarshipProgramName;
	}

	public void setScholarshipProgramName(String scholarshipProgramName) {
		this.scholarshipProgramName = scholarshipProgramName;
	}

	/**
	 * @return the agency
	 */
	public Agency getAgency() {
		return agency;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	/**
	 * @return the scholarshipQualification
	 */
	public ScholarshipQualification getScholarshipQualification() {
		return scholarshipQualification;
	}

	/**
	 * @param scholarshipQualification the scholarshipQualification to set
	 */
	public void setScholarshipQualification(ScholarshipQualification scholarshipQualification) {
		this.scholarshipQualification = scholarshipQualification;
	}

}
