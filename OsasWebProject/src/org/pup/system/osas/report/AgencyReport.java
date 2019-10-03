package org.pup.system.osas.report;

import java.util.List;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.User;

import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class AgencyReport extends Report<List<Agency>> {

	public AgencyReport(String imagePath, String reportTitle, List<Agency> data, User preparedBy, boolean landscape) {
		super(imagePath, reportTitle, data, preparedBy, landscape);
	}

	@Override
	public Paragraph generateContent(List<Agency> data) throws Exception {
		return null;	
	}

	@Override
	public Table generateContentTable(List<Agency> data) throws Exception {
		Table table = new Table(5).useAllAvailableWidth();
		
		
		table.addCell(generateTableCellHeader("#"));
		table.addCell(generateTableCellHeader("Agency Name"));
		table.addCell(generateTableCellHeader("Address"));
		table.addCell(generateTableCellHeader("Contact Person"));
		table.addCell(generateTableCellHeader("Contact Number"));
		
		int ctr = 0;
		if(data != null) {
			for (Agency agency : data) {
				ctr++;
				
				table.addCell(generateTableCell(ctr + ""));
				table.addCell(generateTableCell(agency.getAgencyName()));
				table.addCell(generateTableCell(agency.getAddress()));
				table.addCell(generateTableCell(agency.getContactPerson()));
				table.addCell(generateTableCell(agency.getContactNumber()));
			}
		}	
		
		return table;
	}

}
