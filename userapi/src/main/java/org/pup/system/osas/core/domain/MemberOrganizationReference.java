package org.pup.system.osas.core.domain;

public class MemberOrganizationReference {
	private int memberId;
	
	private Organization organization;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	

}
