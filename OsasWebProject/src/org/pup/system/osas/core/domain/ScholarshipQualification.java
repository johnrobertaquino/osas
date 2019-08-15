package org.pup.system.osas.core.domain;


public class ScholarshipQualification {

	private int scholarshipQualificationId;
	
	private String scholarshipQualificationName;

	private int scholarshipProgramId;

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
	 * @return the scholarshipProgramId
	 */
	public int getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	/**
	 * @param scholarshipProgramId the scholarshipProgramId to set
	 */
	public void setScholarshipProgramId(int scholarshipProgramId) {
		this.scholarshipProgramId = scholarshipProgramId;
	}
}
