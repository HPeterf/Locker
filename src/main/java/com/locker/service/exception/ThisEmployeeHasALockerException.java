package com.locker.service.exception;

public class ThisEmployeeHasALockerException extends NamesException {

	private static final long serialVersionUID = -2641327841005683756L;

	public ThisEmployeeHasALockerException() {
		super("This Employee Already Has a Locker! Free a Locker First!");
	}

}
