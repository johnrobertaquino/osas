package org.pup.system.osas.core.domain;

import java.util.List;

public class Member {
	private int memberId;
	
	private String studentNumber;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Program program;
	
	private String position;

	private boolean officer;
	
	private String officerPhoto;
	
	private String gender;
	
	private String year;
	
	private String section;
	
	private String contactNumber;
	
	private List<Organization> organizationList;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isOfficer() {
		return officer;
	}

	public void setOfficer(boolean officer) {
		this.officer = officer;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the officerPhoto
	 */
	public String getOfficerPhoto() {
		return officerPhoto;
	}

	/**
	 * @param officerPhoto the officerPhoto to set
	 */
	public void setOfficerPhoto(String officerPhoto) {
		this.officerPhoto = officerPhoto;
	}

	/**
	 * @return the organizationList
	 */
	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	/**
	 * @param organizationList the organizationList to set
	 */
	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}	
	
	public String getOrganizationListDisplay() {
		String organizationListForDisplay = "";
		
		if (this.organizationList != null) {
			for (Organization organization : this.organizationList) {
				if(!organizationListForDisplay.isEmpty()) {
					organizationListForDisplay = organizationListForDisplay + ", ";
				}
				organizationListForDisplay = organizationListForDisplay + organization.getOrganizationName();
			}
		}
		
		return organizationListForDisplay;
	}
}