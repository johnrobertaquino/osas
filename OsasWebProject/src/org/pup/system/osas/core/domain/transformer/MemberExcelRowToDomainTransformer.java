package org.pup.system.osas.core.domain.transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		case "officer":
			if ("Y".equals(value)) {
				domain.setOfficer(true);
			}
			break;
		case "position":
			domain.setPosition(value);
			break;
		case "officerPhoto":
			domain.setOfficerPhoto(value);
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

	@Override
	protected Map<String, List<Validator>> getValidatorMap() {
		Map<String, List<Validator>> validatorMap = new HashMap<String, List<Validator>>();
		
		validatorMap.put("studentNumber", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("firstName", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("lastName", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("program", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("gender", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("year", new ArrayList<Validator>(Arrays.asList(new EmptyValidator(), new NotNumericValidator())));
		validatorMap.put("section", new ArrayList<Validator>(Arrays.asList(new EmptyValidator(), new NotNumericValidator())));
		
		return validatorMap;
	}
}
