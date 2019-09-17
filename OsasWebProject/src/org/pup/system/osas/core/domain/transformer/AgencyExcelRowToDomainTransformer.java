package org.pup.system.osas.core.domain.transformer;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.pup.system.osas.core.domain.Agency;

public class AgencyExcelRowToDomainTransformer extends ExcelRowToDomainTransformer<Agency> {

	public AgencyExcelRowToDomainTransformer(Row row) {
		super(row, Agency.class);
	}

	@Override
	protected void process(String fieldName, String value, Agency domain) {
		switch (fieldName) {
			case "agencyName":
				domain.setAgencyName(value);
				break;
			case "address":
				domain.setAddress(value);
				break;
			case "contactPerson":
				domain.setContactPerson(value);
				break;
			case "contactNumber":
				domain.setContactNumber(value);
				break;
			default:
				break;
		}
	}

	@Override
	protected Map<String, List<Validator>> getValidatorMap() {
		// TODO Auto-generated method stub
		return null;
	}
}
