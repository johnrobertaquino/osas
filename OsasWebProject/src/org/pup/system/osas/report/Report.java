package org.pup.system.osas.report;

import java.io.OutputStream;

import org.pup.system.osas.core.domain.User;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

public abstract class Report<T> {

	private String imagePath;

	private String reportTitle;

	private T data;

	private User preparedBy;
	
	private boolean landscape;

	public Report(String imagePath, String reportTitle, T data, User preparedBy, boolean landscape) {
		this.imagePath = imagePath;
		this.reportTitle = reportTitle;
		this.data = data;
		this.preparedBy = preparedBy;
		this.landscape = landscape;
	}

	public abstract Table generateContentTable(T data) throws Exception;

	public abstract Paragraph generateContent(T data) throws Exception;

	public void generateReport(OutputStream outputStream) throws Exception {
		PdfWriter writer = new PdfWriter(outputStream);

		PdfDocument pdfDoc = new PdfDocument(writer);

		Document document = null;
				
		if (landscape) {
			document = new Document(pdfDoc, PageSize.A4.rotate());
		} else {
			document = new Document(pdfDoc);
		}

		document.add(generateHeader());
		SolidLine line = new SolidLine(1f);
		document.add(new LineSeparator(line));
		document.add(generateTitle());
		document.add(new Paragraph("\n"));

		Table table = generateContentTable(data);

		if (table != null) {
			document.add(table);
		} else {
			document.add(generateContent(data));
		}

		document.add(new Paragraph("\n"));
		if (preparedBy != null) {
			document.add(generatePreparedBy(preparedBy));
		}
		document.close();
	}

	protected Paragraph generatePreparedBy(User preparedBy) {
		Paragraph paragraph = new Paragraph();

		Text preparedByText = new Text("Prepared by:");
		preparedByText.setFontSize(10f);
		preparedByText.setItalic();

		Text nameText = new Text(preparedBy.getFirstName() + " " + preparedBy.getLastName());
		nameText.setFontSize(10f);
		nameText.setItalic();

		Text positionText = new Text(preparedBy.getPosition());
		positionText.setFontSize(9f);
		positionText.setItalic();

		paragraph.add(preparedByText);
		paragraph.add("\n");
		paragraph.add(nameText);
		paragraph.add("\n");
		paragraph.add(positionText);

		return paragraph;
	}

	protected Paragraph generateTitle() throws Exception {
		Paragraph paragraph = new Paragraph();

		Text title = new Text(reportTitle);
		title.setFontSize(11f);
		title.setBold();

		paragraph.setMarginTop(20f);
		paragraph.setTextAlignment(TextAlignment.CENTER);
		paragraph.add(title);

		return paragraph;
	}

	protected Paragraph generateHeader() throws Exception {
		Paragraph paragraph = new Paragraph();

		Table table = new Table(2);
		table.setBorder(Border.NO_BORDER);

		String imageFile = imagePath + "/PUPLogo.png";
		ImageData data = ImageDataFactory.create(imageFile);
		Image img = new Image(data);
		img.setWidth(65);
		img.setHeight(65);

		Cell logoCell = new Cell(1, 1);
		logoCell.setBorder(Border.NO_BORDER);
		logoCell.setPaddingRight(50);
		logoCell.setPaddingTop(5);
		logoCell.setPaddingLeft(10);
		logoCell.add(img);

		Text school = new Text("POLYTECHNIC UNIVERSITY OF THE PHILIPPINES\n");
		school.setFontSize(11f);

		Text schoolBranch = new Text("Sto. Tomas Branch\n");
		schoolBranch.setFontSize(9f);

		Text schoolAddress = new Text("Sto. Tomas, Batangas\n");
		schoolAddress.setFontSize(9f);

		Text osasTitle = new Text("\nOFFICE OF THE STUDENT AFFAIRS AND SERVICES");
		osasTitle.setFontSize(9f);

		Paragraph schoolDetail = new Paragraph();
		schoolDetail.add(school);
		schoolDetail.add(schoolBranch);
		schoolDetail.add(schoolAddress);
		schoolDetail.add(osasTitle);
		schoolDetail.setTextAlignment(TextAlignment.CENTER);

		Cell schoolDetailCell = new Cell(1, 1);
		schoolDetailCell.add(schoolDetail);
		schoolDetailCell.setBorder(Border.NO_BORDER);
		schoolDetailCell.setWidth(272);

		table.addCell(logoCell);
		table.addCell(schoolDetailCell);

		paragraph.add(table);

		return paragraph;
	}

	protected Cell generateTableCell(String text) {
		Text textObj = new Text(text);
		textObj.setFontSize(9f);

		Paragraph paragraph = new Paragraph();
		paragraph.add(textObj);

		Cell cell = new Cell(1, 1);
		cell.add(paragraph);

		return cell;
	}

	protected Cell generateTableCellHeader(String text) {
		Text textObj = new Text(text);
		textObj.setFontSize(9f);
		textObj.setBold();

		Paragraph paragraph = new Paragraph();
		paragraph.add(textObj);

		Cell cell = new Cell(1, 1);
		cell.add(paragraph);

		return cell;
	}
	
	protected Paragraph generateTableCellParagraph(String text) {
		Text textObj = new Text(text);
		textObj.setFontSize(9f);

		Paragraph paragraph = new Paragraph();
		paragraph.add(textObj);

		return paragraph;
	}
	
	protected Paragraph generateTableCellParagraphHeader(String text) {
		Text textObj = new Text(text);
		textObj.setFontSize(9f);
		textObj.setBold();

		Paragraph paragraph = new Paragraph();
		paragraph.add(textObj);

		return paragraph;
	}

}
