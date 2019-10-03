package org.pup.system.osas.report;

import java.util.List;

import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.report.data.OrganizationReportData;
import org.pup.system.osas.report.data.OrganizationsStatusReportData;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

public class OrganizationsStatusReport extends Report<OrganizationsStatusReportData> {

	public OrganizationsStatusReport(String imagePath, String reportTitle, OrganizationsStatusReportData data,
			User preparedBy) {
		super(imagePath, reportTitle, data, preparedBy);
	}

	@Override
	public Table generateContentTable(OrganizationsStatusReportData data) throws Exception {

		Table table = new Table(data.getOrganizationRequirementList().size() + 1).useAllAvailableWidth();

		Cell nameOfOrganizationTextCell = new Cell(2, 1);
		nameOfOrganizationTextCell.add(generateTableCellParagraphHeader("NAME OF ORGANIZATION"));
		nameOfOrganizationTextCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		table.addCell(nameOfOrganizationTextCell);

		Cell dateSubmittedTextCell = new Cell(1, data.getOrganizationRequirementList().size());
		dateSubmittedTextCell.add(generateTableCellParagraphHeader("DATE SUBMITTED"));
		dateSubmittedTextCell.setTextAlignment(TextAlignment.CENTER);
		table.addCell(dateSubmittedTextCell);

		List<OrganizationRequirement> organizationRequirementList = data.getOrganizationRequirementList();

		for (OrganizationRequirement organizationRequirement : organizationRequirementList) {
			Paragraph requirementListCell = generateTableCellParagraphHeader(organizationRequirement.getOrganizationRequirementName().toUpperCase());
			requirementListCell.setTextAlignment(TextAlignment.CENTER);
			table.addCell(requirementListCell);
		}

		Cell organizationTypeCell = new Cell(1, data.getOrganizationRequirementList().size() + 1);
		organizationTypeCell.add(generateTableCellParagraphHeader(data.getOrganizationType().getOrganizationTypeName().toUpperCase() + " ORGANIZATION"));
		table.addCell(organizationTypeCell);

		List<OrganizationReportData> organizationReportDataList = data.getOrganizationReportDataList();

		int ctr = 0;
		for (OrganizationReportData organizationReportData : organizationReportDataList) {
			table.addCell(generateTableCellParagraph((++ctr) + ". " + organizationReportData.getOrganizationName()));

			for (OrganizationRequirement organizationRequirement : organizationRequirementList) {
				String dateStatus = organizationReportData.getDateStatusByOrganizationRequirementId(
						organizationRequirement.getOrganizationRequirementId());
				Paragraph dateStatusParagraph = generateTableCellParagraph(dateStatus);
				dateStatusParagraph.setTextAlignment(TextAlignment.CENTER);
				table.addCell(dateStatusParagraph);
			}
		}

		return table;
	}

	@Override
	public Paragraph generateContent(OrganizationsStatusReportData data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
