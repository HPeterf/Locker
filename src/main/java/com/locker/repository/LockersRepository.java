package com.locker.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.locker.model.Locker;

@Repository
public interface LockersRepository extends JpaRepository<Locker, Long> {

	public List<Locker> findAll();

	@Query(value = "select l from Lockers l where l.number = :number")
	public Locker findByNumber(@Param("number") Long number);

	@Transactional
	@Modifying
	@Query("UPDATE Lockers l SET l.number = :number")
	public void updateLockerNumber(@Param("number") long number);

	@Modifying
	@Query("delete from Lockers l where l.number = :number")
	public void delete(@Param("number") Long number);

}
