package org.pup.system.osas.core.domain.transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.domain.Scholar;

public class ScholarExcelRowToDomainTransformer extends ExcelRowToDomainTransformer<Scholar> {

	public ScholarExcelRowToDomainTransformer(Row row) {
		super(row, Scholar.class);
	}

	@Override
	protected void process(String fieldName, String value, Scholar domain) {

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
		case "gender":
			domain.setGender(value);
			break;
		case "email":
			domain.setEmail(value);
			break;
		case "contactNumber":
			domain.setContactNumber(value);
			break;
		case "program":
			domain.setProgram(new Program(value));
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

	@Override
	protected Map<String, List<Validator>> getValidatorMap() {
		Map<String, List<Validator>> validatorMap = new HashMap<String, List<Validator>>();
		
		validatorMap.put("studentNumber", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("firstName", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("lastName", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("gender", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("email", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("contactNumber", new ArrayList<Validator>(Arrays.asList(new EmptyValidator())));
		validatorMap.put("program", new ArrayList<Validator>(Arrays.asList(new EmptyValidator(), new NotValidProgramValidator())));
		validatorMap.put("year", new ArrayList<Validator>(Arrays.asList(new EmptyValidator(), new NotNumericValidator())));
		validatorMap.put("section", new ArrayList<Validator>(Arrays.asList(new EmptyValidator(), new NotNumericValidator())));
		validatorMap.put("gwa", new ArrayList<Validator>(Arrays.asList(new EmptyValidator(), new NotNumericValidator())));
		
		return validatorMap;
	}

	@Override
	protected List<Validator> getPostValidatorList() {
		return new ArrayList<Validator>(Arrays.asList(new NotValidProgramYearValidator()));
	}
}
