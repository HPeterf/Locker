package com.locker.service.exception;

public class LockerDoesNotExistsException extends NamesException {

	private static final long serialVersionUID = 4025550591170046271L;

	public LockerDoesNotExistsException() {
		super("Locker Does Not Exists");
	}

}
