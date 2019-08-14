package org.pup.system.osas.core.domain;

import java.util.List;

public class ScholarScholarshipProgramTerm {

	private int scholarScholarshipProgramTermId;

	private ScholarTerm scholarTerm;

	private List<ScholarScholarshipQualification> scholarScholarshipQualificationList;

	public int getScholarScholarshipProgramTermId() {
		return scholarScholarshipProgramTermId;
	}

	public void setScholarScholarshipProgramTermId(int scholarScholarshipProgramTermId) {
		this.scholarScholarshipProgramTermId = scholarScholarshipProgramTermId;
	}

	public ScholarTerm getScholarTerm() {
		return scholarTerm;
	}

	public void setScholarTerm(ScholarTerm scholarTerm) {
		this.scholarTerm = scholarTerm;
	}

	public List<ScholarScholarshipQualification> getScholarScholarshipQualificationList() {
		return scholarScholarshipQualificationList;
	}

	public void setScholarScholarshipQualificationList(
			List<ScholarScholarshipQualification> scholarScholarshipQualificationList) {
		this.scholarScholarshipQualificationList = scholarScholarshipQualificationList;
	}

}
