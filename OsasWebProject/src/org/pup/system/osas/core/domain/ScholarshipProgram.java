package org.pup.system.osas.core.domain;

public class ScholarshipProgram {

	private int scholarshipProgramId;
	
	private String scholarshipProgramName;
	
	private int agencyId;
	
	private Agency agency;
	
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
	 * @return the agencyId
	 */
	public int getAgencyId() {
		return agencyId;
	}

	/**
	 * @param agencyId the agencyId to set
	 */
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

}
