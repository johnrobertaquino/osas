package org.pup.system.osas.core.domain;

import java.util.List;

public class ScholarshipProgramTerm {

	private int scholarshipProgramTermId;

	private ScholarshipTerm scholarshipTerm;

	private ScholarshipProgram scholarshipProgram;

	private Agency agency;

	private List<ScholarshipQualification> scholarshipQualificationList;

	public List<ScholarshipQualification> getScholarshipQualificationList() {
		return scholarshipQualificationList;
	}

	public void setScholarshipQualificationList(List<ScholarshipQualification> scholarshipQualificationList) {
		this.scholarshipQualificationList = scholarshipQualificationList;
	}

	public int getScholarshipProgramTermId() {
		return scholarshipProgramTermId;
	}

	public void setScholarshipProgramTermId(int scholarshipProgramTermId) {
		this.scholarshipProgramTermId = scholarshipProgramTermId;
	}

	public ScholarshipTerm getScholarshipTerm() {
		return scholarshipTerm;
	}

	public void setScholarshipTerm(ScholarshipTerm scholarshipTerm) {
		this.scholarshipTerm = scholarshipTerm;
	}

	public ScholarshipProgram getScholarshipProgram() {
		return scholarshipProgram;
	}

	public void setScholarshipProgram(ScholarshipProgram scholarshipProgram) {
		this.scholarshipProgram = scholarshipProgram;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

}
