package org.pup.system.osas.core.domain.transformer;

import org.apache.poi.ss.usermodel.Row;
import org.pup.system.osas.core.domain.Member;

public class MemberExcelRowToDomainTransformer extends ExcelRowToDomainTransformer<Member> {

	public MemberExcelRowToDomainTransformer(Row row) {
		super(row, Member.class);
	}

	@Override
	protected void process(String fieldName, String value, Member domain) {
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
		case "program":
			domain.setProgram(value);
			break;
		case "position":
			domain.setPosition(value);
			break;
		case "gender":
			domain.setGender(value);
			break;
		case "year":
			domain.setYear(value);
			break;
		case "section":
			domain.setSection(value);
			break;
		default:
			break;
	}
	}
}
