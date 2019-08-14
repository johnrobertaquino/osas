package org.pup.system.osas.core.domain;

public class AgencyScholarshipTerm {
	
	private int agencyScholarTermId;
	
	private Agency agency;
	
	private ScholarshipTerm scholarshipTerm;

	public int getAgencyScholarTermId() {
		return agencyScholarTermId;
	}

	public void setAgencyScholarTermId(int agencyScholarTermId) {
		this.agencyScholarTermId = agencyScholarTermId;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public ScholarshipTerm getScholarshipTerm() {
		return scholarshipTerm;
	}

	public void setScholarshipTerm(ScholarshipTerm scholarshipTerm) {
		this.scholarshipTerm = scholarshipTerm;
	}

}
