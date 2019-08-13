package org.pup.system.osas.report;

import java.util.List;

import com.itextpdf.layout.element.Table;

public abstract class ReportTableElement<T> extends Table {
	
	public ReportTableElement(List<String> headers, List<T> data) {
		super(headers.size());
	}
	

}
