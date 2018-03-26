package com.locker.service.exception;

public class CantAssignLockerToEmployeeException extends NamesException {

	private static final long serialVersionUID = 5761638641135895727L;

	public CantAssignLockerToEmployeeException() {
		super("Could not assign Employee to new Locker number please check your data again!");
	}

}
