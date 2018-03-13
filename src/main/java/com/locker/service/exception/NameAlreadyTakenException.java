package com.locker.service.exception;

public class NameAlreadyTakenException extends NamesException {

	private static final long serialVersionUID = -8579088114434525964L;

	public NameAlreadyTakenException() {
		super("Name already taken!");
	}

}
