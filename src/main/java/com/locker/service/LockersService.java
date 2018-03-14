package com.locker.service;

import java.util.List;

import com.locker.model.Employee;
import com.locker.model.Locker;

public interface LockersService {

	public String addNewLocker(Employee employees, Locker locker) throws Exception;

	public void deleteLocker(Employee employee) throws Exception;

	public List<Locker> listLockers();

	public Locker findLocker(/* String name, */ Long number);

}
