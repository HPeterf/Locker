package com.locker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locker.model.Employee;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findAll();

	Employee findByName(String name);

}
