package com.locker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.locker.model.Lockers;

@Repository
public interface LockersRepository extends JpaRepository<Lockers, Long> {

	public List<Lockers> findAll();

	@Query(value = "select l from Lockers l where l.number = :number")
	Lockers getLockerByNumber(@Param("number") Long number);

}
