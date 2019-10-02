package org.pup.system.osas.core.domain.transformer;

import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.ProgramManager;
import org.pup.system.osas.core.manager.SemTermManager;
	
public class MemberNotValidProgramYearValidator extends Validator<Member> {

	public boolean validate(Member value) {
		if (value == null) {
			return true;
		}
		
		ProgramManager programManager = new ProgramManager();
		SemTermManager semTermManager = new SemTermManager();
			
		try {
			Program program = programManager.getProgram(value.getProgram().getProgramCode(), semTermManager.getCurrentActiveSemTerm().getSemTermId());
			if (program == null) {
				return true;
			}
			
			if (program.getHighestYearLevel() < Integer.parseInt(value.getYear())) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;	
	}

	@Override
	public String getErrorMessage() {
		return "Column Year is not a valid year.";
	}
	
}
