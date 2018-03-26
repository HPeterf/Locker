package com.locker.service.exception;

public class LockerNumberOrEmployeeNameAlreadyTakenException extends NamesException {

	private static final long serialVersionUID = -7288632276839120414L;

	public LockerNumberOrEmployeeNameAlreadyTakenException() {
		super("The Locker Number Or The Employee Name is Already Taken!");
	}

}
