package com.locker.service;

import java.util.List;

import com.locker.model.Employee;
import com.locker.model.Lockers;

public interface LockersService {

	public String addNewLocker(Employee employees, Lockers locker) throws Exception;

	public void deleteLocker(Employee employee) throws Exception;

	public List<Lockers> listLockers();

	public Lockers findLocker(Long number);

}
