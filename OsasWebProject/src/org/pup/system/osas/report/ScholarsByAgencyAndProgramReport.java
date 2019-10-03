package org.pup.system.osas.report;

import java.util.List;

import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.report.data.ScholarsByAgencyAndProgramReportData;

import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class ScholarsByAgencyAndProgramReport extends Report<List<ScholarsByAgencyAndProgramReportData>>{

	public ScholarsByAgencyAndProgramReport(String imagePath, String reportTitle,
			List<ScholarsByAgencyAndProgramReportData> data, User preparedBy, boolean landscape) {
		super(imagePath, reportTitle, data, preparedBy, landscape);
	}

	@Override
	public Table generateContentTable(List<ScholarsByAgencyAndProgramReportData> data) throws Exception {

		Table table = new Table(1).useAllAvailableWidth();
		
		for (ScholarsByAgencyAndProgramReportData scholarsByAgencyAndProgramReportData : data) {
			table.addCell(generateTableCellHeader(generateYearText(scholarsByAgencyAndProgramReportData.getYear())));
			
			List<Scholar> scholarList = scholarsByAgencyAndProgramReportData.getScholarList();
			
			for (Scholar scholar : scholarList) {
				table.addCell(generateTableCell(scholar.getLastName() + ", " + scholar.getFirstName()));
			}	
		}
		
		return table;
	}
	
	private String generateYearText(String year) {
		String yearText = null;
		
		if("5".equalsIgnoreCase(year)) {
			yearText = "FIFTH YEAR";
		} else if("4".equalsIgnoreCase(year)) {
			yearText = "FOURTH YEAR";
		} else if("3".equalsIgnoreCase(year)) {
			yearText = "THIRD YEAR";
		} else if("2".equalsIgnoreCase(year)) {
			yearText = "SECOND YEAR";
		} else if("1".equalsIgnoreCase(year)) {
			yearText = "FIRST YEAR";
		} else {
			yearText = year;
		}
		
		return yearText;
	}

	@Override
	public Paragraph generateContent(List<ScholarsByAgencyAndProgramReportData> data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
