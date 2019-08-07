package org.pup.system.osas.core.domain;

public class Agency {

	private int agencyId;
	
	private String agencyName;
	
	private String address;
	
	private String contactPerson;
	
	private String contactNumber;
	
	private ScholarshipProgram scholarshipProgram;

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public ScholarshipProgram getScholarshipProgram() {
		return scholarshipProgram;
	}

	public void setScholarshipProgram(ScholarshipProgram scholarshipProgram) {
		this.scholarshipProgram = scholarshipProgram;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
}
