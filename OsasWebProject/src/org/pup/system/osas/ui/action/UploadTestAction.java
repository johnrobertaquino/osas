package org.pup.system.osas.ui.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.transformer.AgencyExcelRowToDomainTransformer;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.ui.action.AbstractAction;

public class UploadTestAction extends AbstractAction {

	/**
	 ** 
	 */
	private static final long serialVersionUID = 2407562318288998481L;

	private File file;
	
	private List<Agency> agencyList;

	public String execute() throws Exception {
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;

		try {
			fis = new FileInputStream(file);

			workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheetAt(0);

			int index = 0;

			AgencyExcelRowToDomainTransformer transformer = null;

			agencyList = null;

			for (Row row : sheet) {
				if (index == 0) {
					
					transformer = new AgencyExcelRowToDomainTransformer(row);
				} else {
					Agency agency = transformer.transform(row);

					if (agencyList == null) {
						agencyList = new ArrayList<Agency>();
					}
					agencyList.add(agency);
				}

				index++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				workbook.close();
			}
			if (fis != null) {
				fis.close();
			}
		}

		return FORWARD_SUCCESS;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List<Agency> getAgencyList() {
		return agencyList;
	}

	public void setAgencyList(List<Agency> agencyList) {
		this.agencyList = agencyList;
	}
}
