package org.pup.system.osas.core.domain.transformer;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public abstract class ExcelRowToDomainTransformer<T> {

	private Class<T> domainClass;

	private Map<Integer, String> indexFieldNameMapping = new HashMap<Integer, String>();

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

		this.domainClass = domainClass;
	}

	private String getFieldNameByIndex(int index) {
		return indexFieldNameMapping.get(index);
	}

	public T transform(Row row) throws InstantiationException, IllegalAccessException {
		T domain = domainClass.newInstance();
		DataFormatter dataFormatter = new DataFormatter();

		for (int index = 0; index < row.getLastCellNum(); index++) {
			Cell cell = row.getCell(index);
			if (cell == null) {
				// ...
			} else {
				process(getFieldNameByIndex(index), dataFormatter.formatCellValue(cell), domain);
			}
		}

		return domain;
	}

	protected abstract void process(String fieldName, String value, T domain);

}
