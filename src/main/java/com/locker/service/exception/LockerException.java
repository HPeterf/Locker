package com.locker.service.exception;

public class LockerException extends NamesException {

	private static final long serialVersionUID = -4496665085186765495L;

	public LockerException() {
		super("Locker already taken!");

	}

}
