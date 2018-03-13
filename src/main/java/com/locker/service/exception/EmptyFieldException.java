package com.locker.service.exception;

public class EmptyFieldException extends NamesException {

	private static final long serialVersionUID = -8568556285019244277L;

	public EmptyFieldException() {
		super("Empty field!");
	}

}
