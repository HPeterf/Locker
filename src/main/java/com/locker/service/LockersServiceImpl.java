package com.locker.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locker.model.Employee;
import com.locker.model.Lockers;
import com.locker.repository.EmployeesRepository;
import com.locker.repository.LockersRepository;
import com.locker.service.exception.EmployeeDoesNotExistsException;
import com.locker.service.exception.LockerDoesNotExistsException;

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
	public List<Lockers> listLockers() {
		return lockersRepo.findAll();
	}

	@Override
	public void deleteLocker(Employee employee) throws Exception {
		if (employee.getLocker() == null) {
			throw new LockerDoesNotExistsException();
		}
		employee.setLocker(null);
		employeeRepo.save(employee);
	}

	@Override
	public Lockers findLocker(Long number) {
		return lockersRepo.getLockerByNumber(number);
	}

	@Override
	public String addNewLocker(Employee employee, Lockers locker) throws Exception {
		List<Employee> emplist = employeeRepo.findAll();

		for (Employee e : emplist) {
			if (((e.getName()).equals(employee))) {
				throw new EmployeeDoesNotExistsException();
			}
		}
		List<Lockers> lockerList = lockersRepo.findAll();
		for (Lockers l : lockerList) {
			logger.info("The locker: {}", l.getNumber());
			if (((l.getNumber()).equals(locker))) {
				throw new LockerDoesNotExistsException();
			} else {
				lockersRepo.save(locker);
				locker.setEmployee(employee);
				employee.setLocker(locker);

			}
		}

		return "save successful";
	}
}
