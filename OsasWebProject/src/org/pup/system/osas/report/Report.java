package org.pup.system.osas.report;

import java.io.OutputStream;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
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

	public Report(String imagePath, String reportTitle) {
		this.imagePath = imagePath;
		this.reportTitle = reportTitle;
	}

	public abstract Paragraph generateContent(T data) throws Exception;

	public void generateReport(OutputStream outputStream) throws Exception {
		PdfWriter writer = new PdfWriter(outputStream);

		PdfDocument pdfDoc = new PdfDocument(writer);

		Document document = new Document(pdfDoc);

		document.add(generateHeader());
		SolidLine line = new SolidLine(1f);
		document.add(new LineSeparator(line));
		document.add(generateTitle());
		document.close();
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
}
