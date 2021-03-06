package com.locker.service;

import java.util.List;

import com.locker.model.Employee;
import com.locker.model.Locker;

public interface LockersService {

	public void assignLockerToEmployee(Employee employees, Locker locker) throws Exception;

	public void deleteLocker(Locker locker) throws Exception;

	public List<Locker> search(Locker locker);

}
