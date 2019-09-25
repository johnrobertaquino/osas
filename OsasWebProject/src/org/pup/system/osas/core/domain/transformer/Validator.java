package org.pup.system.osas.core.domain.transformer;

public abstract class Validator<T> {
	
	public abstract boolean validate(T value);
	
	public abstract String getErrorMessage();
	
}
	