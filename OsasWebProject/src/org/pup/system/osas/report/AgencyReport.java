package org.pup.system.osas.report;

import java.util.List;

import org.pup.system.osas.core.domain.Agency;

import com.itextpdf.layout.element.Paragraph;

public class AgencyReport extends Report<List<Agency>> {

	public AgencyReport(String imagePath, String reportTitle) {
		super(imagePath, reportTitle);
	}

	@Override
	public Paragraph generateContent(List<Agency> data) throws Exception {
		
		return null;
	}


}
