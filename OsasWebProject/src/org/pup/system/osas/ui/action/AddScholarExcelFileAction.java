package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.transformer.ScholarExcelRowToDomainTransformer;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.pup.system.osas.ui.action.AbstractAction;

public class AddScholarExcelFileAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8910283248066116810L;

	private File file;
	
	private List<Scholar> scholarList;
	
	private String scholarshipProgramId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar";
		
		String actionResult = FORWARD_SUCCESS;
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;

		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			ScholarshipProgram scholarshipProgram = scholarshipProgramManager.getScholarshipProgram(Integer.parseInt(scholarshipProgramId));
			

			fis = new FileInputStream(file);

			workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheetAt(0);

			int index = 0;

			ScholarExcelRowToDomainTransformer transformer = null;

			scholarList = null;

			for (Row row : sheet) {
				if (index == 0) {
					
					transformer = new ScholarExcelRowToDomainTransformer(row);
				} else {
					Scholar scholar = transformer.transform(row);

					if (scholarList == null) {
						scholarList = new ArrayList<Scholar>();

					}
					scholarList.add(scholar);
					scholar.setScholarshipProgram(scholarshipProgram);
					ScholarManager scholarManager = new ScholarManager();
					scholarManager.insertScholar(scholar);
					
					notificationMessage = "Scholar has been saved successfully added.";
				}

				index++;
			}
		}
			
		catch (BusinessException be) {
			errorMessage = be.getMessage();
			actionResult = FORWARD_ERROR;
			be.printStackTrace();
		} catch (Exception e) {
			errorMessage = "System error occurred. Please contact administrator.";
			actionResult = FORWARD_ERROR;
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				workbook.close();
			}
			if (fis != null) {
				fis.close();
			}
		}

		return actionResult;

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List<Scholar> getScholarList() {
		return scholarList;
	}

	public void setScholarList(List<Scholar> scholarList) {
		this.scholarList = scholarList;
	}
	
	public String getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	public void setScholarshipProgramId(String scholarshipProgramId) 
	{
		this.scholarshipProgramId = scholarshipProgramId;
	}
	
	
}
