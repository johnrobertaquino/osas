package org.pup.system.osas.report.data;

import java.util.List;

import org.pup.system.osas.core.domain.Scholar;

public class ScholarsByAgencyAndProgramReportData {
	
	private String year;
	
	private List<Scholar> scholarList;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Scholar> getScholarList() {
		return scholarList;
	}

	public void setScholarList(List<Scholar> scholarList) {
		this.scholarList = scholarList;
	}
	
	
	
	
}
