package org.pup.system.osas.core.domain;

public class ScholarScholarshipQualification {
	
	private ScholarshipQualification scholarshipQualification;
	
	private ScholarQualification scholarQualification;

	public ScholarshipQualification getScholarshipQualification() {
		return scholarshipQualification;
	}

	public void setScholarshipQualification(ScholarshipQualification scholarshipQualification) {
		this.scholarshipQualification = scholarshipQualification;
	}

	public ScholarQualification getScholarQualification() {
		return scholarQualification;
	}

	public void setScholarQualification(ScholarQualification scholarQualification) {
		this.scholarQualification = scholarQualification;
	}
	
	public String getStatusText() {
		String status = "Not Submitted";
		String statusCode = getStatus();
		
		if ("A".equals(statusCode)) {
			status = "Approved";
		} else if ("P".equals(statusCode)) {
			status = "Pending Approval";
		}
		
		return status;
	}
	
	public String getStatus() {
		String status = "N";
		
		if (scholarQualification != null) {
			if (scholarQualification.isQualified()) {
				status = "A";
			} else {
				status = "P";
			}
		}
		
		return status;
	}

}
