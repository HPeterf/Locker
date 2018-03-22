package com.locker.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locker.model.Employee;
import com.locker.model.Locker;
import com.locker.repository.LockersRepository;
import com.locker.service.exception.EmployeeDoesNotExistsException;
import com.locker.service.exception.LockerException;

@Service
public class LockersServiceImpl implements LockersService {

	private static final Logger logger = LoggerFactory.getLogger(LockersServiceImpl.class);

	private LockersRepository lockersRepo;

	@Autowired
	public void setLockersRepo(LockersRepository lockersRepo) {
		this.lockersRepo = lockersRepo;
	}

	@Override
	public List<Locker> listLockers() {
		return lockersRepo.findAll();
	}

	@Override
	public void deleteLocker(Locker locker) throws Exception {

		List<Locker> lockerList = lockersRepo.findAll();

		for (Locker l : lockerList) {
			if (l.getNumber().equals(locker.getNumber())) {
				try {
					lockersRepo.delete(l);
					logger.info("locker save successful");
				} catch (IllegalArgumentException e) {
					logger.error("Delete failed: " + e.toString());
				}
			}
		}
	}

	@Override
	public String addNewLocker(Employee employee, Locker locker) throws Exception {

		List<Locker> lockerList = lockersRepo.findAll();
		for (Locker l : lockerList) {
			logger.info("The locker: {}", l.getNumber());
			logger.info("New locker: " + locker.getNumber());
			if (((l.getNumber()).equals(locker.getNumber()))) {
				throw new LockerException();

			} else {
				try {
					if ((l.getEmployee().getName()).equals(employee.getName())) {
						l.setNumber(locker.getNumber());
						logger.info("New locker: " + locker.getNumber());
						logger.info("l is: " + l.getNumber());
						lockersRepo.save(l);
					} else {
						throw new EmployeeDoesNotExistsException();
					}
				} catch (Exception e) {
					e.toString();
				}
			}
		}
		return "save successful";
	}

	@Override
	public List<Locker> search(Locker locker) {
		return lockersRepo.findByNumber(locker.getNumber());
	}
}
