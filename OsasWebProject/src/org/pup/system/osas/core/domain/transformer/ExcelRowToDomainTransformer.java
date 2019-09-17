package org.pup.system.osas.core.domain.transformer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.pup.system.osas.exception.BusinessException;

public abstract class ExcelRowToDomainTransformer<T> {

	private Class<T> domainClass;

	private Map<Integer, String> indexFieldNameMapping = new HashMap<Integer, String>();
	
	private Map<String, List<Validator>> validatorMap = new HashMap<String, List<Validator>>();

	protected ExcelRowToDomainTransformer(Row row, Class<T> domainClass) {
		DataFormatter dataFormatter = new DataFormatter();
		
		for (int index = 0; index < row.getLastCellNum(); index++) {
			Cell cell = row.getCell(index);
			if (cell == null) {
				// ...
			} else {
				indexFieldNameMapping.put(index, dataFormatter.formatCellValue(cell));
			}
		}
		
		Map<String, List<Validator>> validatorMap = getValidatorMap();
		
		if (validatorMap != null) {
			this.validatorMap = validatorMap;
		}

		this.domainClass = domainClass;
	}

	private String getFieldNameByIndex(int index) {
		return indexFieldNameMapping.get(index);
	}

	public T transform(Row row, int rowNum) throws InstantiationException, IllegalAccessException {
		T domain = domainClass.newInstance();
		DataFormatter dataFormatter = new DataFormatter();

		for (int index = 0; index < row.getLastCellNum(); index++) {
			Cell cell = row.getCell(index);
			
			validate(getFieldNameByIndex(index), cell, rowNum);
			
			if (cell == null) {
				// ...
			} else {
				process(getFieldNameByIndex(index), dataFormatter.formatCellValue(cell), domain);
			}
		}

		return domain;
	}
	
	private void validate(String fieldName, Cell cell, int rowNum) {
		List<Validator> validatorList = validatorMap.get(fieldName);
		
		if (validatorList != null) {
			for (Validator validator : validatorList) {
				if (validator != null && validator.validate(cell)) {
					throw new BusinessException("Row " + (rowNum + 1) + " Column " + fieldName + " " + validator.getErrorMessage());
				}
			}
		}
	}

	protected abstract void process(String fieldName, String value, T domain);
	
	protected abstract Map<String, List<Validator>> getValidatorMap();
	

}
