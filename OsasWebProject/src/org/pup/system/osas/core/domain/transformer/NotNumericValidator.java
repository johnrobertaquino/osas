package org.pup.system.osas.core.domain.transformer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class NotNumericValidator extends Validator<Cell> {

	@Override
	public boolean validate(Cell value) {
		if (value == null) {
			return true;
		}
		
		DataFormatter dataFormatter = new DataFormatter();
		String text = dataFormatter.formatCellValue(value);
		
		if (text == null || text.trim().length() == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
