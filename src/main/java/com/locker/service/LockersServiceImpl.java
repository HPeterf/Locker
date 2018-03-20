package com.locker.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locker.model.Employee;
import com.locker.model.Locker;
import com.locker.repository.EmployeesRepository;
import com.locker.repository.LockersRepository;

@Service
public class LockersServiceImpl implements LockersService {

	private static final Logger logger = LoggerFactory.getLogger(LockersServiceImpl.class);

	private LockersRepository lockersRepo;
	private EmployeesRepository employeeRepo;

	@Autowired
	public void setLockersRepo(LockersRepository lockersRepo) {
		this.lockersRepo = lockersRepo;
	}

	@Autowired
	public void setEmployeeRepo(EmployeesRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
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
	public Locker findLocker(Long number) {
		return lockersRepo.findByNumber(number);
	}

	@Override
	public String addNewLocker(Employee employee, Locker locker) throws Exception {
		// List<Employee> emplist = employeeRepo.findAll();

		// for (Employee e : emplist) {
		// if (e.getName().equals(employee.getName())) {
		// throw new EmployeeDoesNotExistsException();
		// }

		List<Locker> lockerList = lockersRepo.findAll();
		for (Locker l : lockerList) {
			logger.info("The locker: {}", l.getNumber());
			logger.info("New locker: " + locker.getNumber());
			if (((l.getNumber()).equals(locker.getNumber()))) {
				// throw new LockerException();

				try {

					l.setNumber(locker.getNumber());
					logger.info("New locker: " + locker.getNumber());
					lockersRepo.save(locker);
					locker.setEmployee(employee);
					employee.setLocker(locker);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
		return "save successful";
	}
}
