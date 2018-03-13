package com.locker.service.exception;

public class EmployeeDoesNotExistsException extends NamesException {

	private static final long serialVersionUID = -3379753625257945064L;

	public EmployeeDoesNotExistsException() {
		super("Employee does not exists!");
	}

}
