package com.locker.service;

import java.util.List;

import com.locker.model.Employee;
import com.locker.model.Lockers;
import com.locker.service.exception.NamesException;

public interface EmployeesService {

	public String addEmployee(Employee employee, Lockers locker) throws NamesException;

	public void deleteEmployee(Employee employee);

	public List<Employee> listEmployees() throws NamesException;

	public Employee findEmployee(String name);

}
