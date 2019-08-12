package org.pup.system.osas.ui.action;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class TestPrintAction extends AbstractAction implements ServletResponseAware {

	private HttpServletResponse response;

	@Override
	public String execute() throws Exception {
		try {
			response.setContentType("application/pdf");
			//response.addHeader("Content-Disposition", "attachment; filename=test.pdf");
			OutputStream responseOutputStream = response.getOutputStream();

			PdfWriter writer = new PdfWriter(responseOutputStream);

			PdfDocument pdfDoc = new PdfDocument(writer);

			Document document = new Document(pdfDoc);
			
			Paragraph para = new Paragraph("This is a paragraph");
			
			String imageFile = "http://localhost:8080/images/PUPLogo.png"; 
			ImageData data = ImageDataFactory.create(imageFile);
			Image img = new Image(data);
			
	
			Table table = new Table(3);
			table.addCell(img);
			table.addCell("POLYTECHNIC UNIVERSITY OF THE PHILIPPINES");
			
			document.add(table);
			document.close();

		} catch (Exception e) {

		}

		return null;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

}
