package org.pup.system.osas.core.domain;


public class ScholarshipQualification {

	private int scholarshipQualificationId;
	
	private String scholarshipQualificationName;
	
	private ScholarshipProgram scholarshipProgram;
	
	private boolean yearlyCheck;

	/**
	 * @return the scholarshipQualificationId
	 */
	public int getScholarshipQualificationId() {
		return scholarshipQualificationId;
	}

	/**
	 * @param scholarshipQualificationId the scholarshipQualificationId to set
	 */
	public void setScholarshipQualificationId(int scholarshipQualificationId) {
		this.scholarshipQualificationId = scholarshipQualificationId;
	}

	/**
	 * @return the scholarshipQualificationName
	 */
	public String getScholarshipQualificationName() {
		return scholarshipQualificationName;
	}

	/**
	 * @param scholarshipQualificationName the scholarshipQualificationName to set
	 */
	public void setScholarshipQualificationName(String scholarshipQualificationName) {
		this.scholarshipQualificationName = scholarshipQualificationName;
	}

	/**
	 * @return the scholarshipProgram
	 */
	public ScholarshipProgram getScholarshipProgram() {
		return scholarshipProgram;
	}

	/**
	 * @param scholarshipProgram the scholarshipProgram to set
	 */
	public void setScholarshipProgram(ScholarshipProgram scholarshipProgram) {
		this.scholarshipProgram = scholarshipProgram;
	}

	public boolean isYearlyCheck() {
		return yearlyCheck;
	}

	public void setYearlyCheck(boolean yearlyCheck) {
		this.yearlyCheck = yearlyCheck;
	}

}
