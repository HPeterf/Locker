package com.locker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.locker.model.Employee;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findAll();

	public Employee findByName(String name);

	@Modifying
	@Query("delete from Employees e where e.name = :name")
	public void delete(@Param("name") String name);

}
