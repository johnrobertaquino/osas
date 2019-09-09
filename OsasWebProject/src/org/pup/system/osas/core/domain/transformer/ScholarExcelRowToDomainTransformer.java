package org.pup.system.osas.core.domain.transformer;

import org.apache.poi.ss.usermodel.Row;
import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.Scholar;

public class ScholarExcelRowToDomainTransformer extends ExcelRowToDomainTransformer<Scholar> {

	public ScholarExcelRowToDomainTransformer(Row row) {
		super(row, Scholar.class);
	}

	@Override
	protected void process(String fieldName, String value, Scholar domain) {
		// TODO Auto-generated method stub
		switch (fieldName) {
		case "studentNumber":
			domain.setStudentNumber(value);
			break;
		case "firstName":
			domain.setFirstName(value);
			break;
		case "middleName":
			domain.setMiddleName(value);
			break;
		case "lastName":
			domain.setLastName(value);
			break;
		case "email":
			domain.setEmail(value);
			break;
		case "contactNumber":
			domain.setContactNumber(value);
			break;
		case "program":
			domain.setProgram(value);
			break;
		case "year":
			domain.setYear(value);
			break;
		case "section":
			domain.setSection(value);
			break;
		case "gwa":
			domain.setGwa(value);
			break;
		default:
			break;
	}
	}
}
