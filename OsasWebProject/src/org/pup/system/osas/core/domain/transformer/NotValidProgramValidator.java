package org.pup.system.osas.core.domain.transformer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.ProgramManager;
import org.pup.system.osas.core.manager.SemTermManager;

public class NotValidProgramValidator extends Validator<Cell> {

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
		
		ProgramManager programManager = new ProgramManager();
		SemTermManager semTermManager = new SemTermManager();
			
		try {
			Program program = programManager.getProgram(text.trim(), semTermManager.getCurrentActiveSemTerm().getSemTermId());
			if (program == null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public String getErrorMessage() {
		return "is not a valid program.";
	}

}
