package com.locker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locker.model.Employee;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findAll();

	public List<Employee> findByName(String name);

	// @Modifying // helyettesíthető deleteByName()-mel
	// @Query("delete from Employees e where e.name = :name")
	// public void delete(@Param("name") String name);

	public void deleteByName(String name);

}
