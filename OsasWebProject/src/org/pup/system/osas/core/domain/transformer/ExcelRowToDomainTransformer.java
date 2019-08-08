package org.pup.system.osas.core.domain.transformer;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public abstract class ExcelRowToDomainTransformer<T> {

	private Class<T> domainClass;

	private Map<Integer, String> indexFieldNameMapping = new HashMap<Integer, String>();

	protected ExcelRowToDomainTransformer(Row row, Class<T> domainClass) {
		int index = 0;

		for (Cell cell : row) {
			indexFieldNameMapping.put(index, cell.getRichStringCellValue().getString().trim());
			index++;
		}

		this.domainClass = domainClass;
	}

	private String getFieldNameByIndex(int index) {
		return indexFieldNameMapping.get(index);
	}

	public T transform(Row row) throws InstantiationException, IllegalAccessException {
		T domain = domainClass.newInstance();
		int index = 0;

		for (Cell cell : row) {
			process(getFieldNameByIndex(index), cell.getRichStringCellValue().getString(), domain);
			index++;
		}

		return domain;
	}

	protected abstract void process(String fieldName, String value, T domain);

}
