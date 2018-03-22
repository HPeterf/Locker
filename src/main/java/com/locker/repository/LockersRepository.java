package com.locker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locker.model.Locker;

@Repository
public interface LockersRepository extends JpaRepository<Locker, Long> {

	public List<Locker> findAll();

	public List<Locker> findByNumber(Long number);

	public void delete(Long number);

}
