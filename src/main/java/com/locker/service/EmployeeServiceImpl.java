package com.locker.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.util.Assert;

import com.locker.model.Employee;
import com.locker.model.Locker;
import com.locker.repository.EmployeesRepository;
import com.locker.repository.LockersRepository;
import com.locker.service.exception.EmptyFieldException;
import com.locker.service.exception.InsertFailedException;
import com.locker.service.exception.LockerDoesNotExistsException;
import com.locker.service.exception.LockerException;
import com.locker.service.exception.NamesException;

@Service
public class EmployeeServiceImpl implements EmployeesService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	private EmployeesRepository employeeRepo;
	private LockersRepository lockerRepo;

	@Autowired
	public void setLockerRepo(LockersRepository lockerRepo) {
		this.lockerRepo = lockerRepo;
	}

	@Autowired
	public void setEmployeeRepo(EmployeesRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> listEmployees() throws LockerDoesNotExistsException {
		List<Employee> emplist = employeeRepo.findAll();

		// ez a blokk itt nem szükséges, mert csak logolunk benne, ami nem feltétlenül
		// szükséges a funkcionalitás szempontjából
		for (int i = 0; i < emplist.size(); i++) {
			final Employee e = emplist.get(i);
			// emplist.get(i).getName();
			logger.info(e.getName());
			// emplist.get(i).getLocker().getNumber();
			logger.info("TODO: miért írjuk ezt itt ki? ezt ide leírni {}", e.getLocker().getNumber());
			if (e.getLocker().getNumber() == null) { // ez az ellenőrzés feleslegessé vált, mivel az adatbázisba nem
														// kerülhet null
				throw new LockerDoesNotExistsException();
			}
		}
		return emplist;
	}

	@Override // addNewEmployeeWithResevedLocker
	public String addEmployee(Employee employee, Locker locker) throws NamesException {

		Assert.notNull(employee, "the employee reference must not be null!");
		Assert.hasText(employee.getName(), "the employee reference must not be null!");
		Assert.notNull(locker, "the locker reference must not be null!");

		if (locker.getEmployee() != null) {
			// TODO: throw new ezaaszekrenymarfoglaltexception....
		}

		if (employee.getLocker() == null) {
			// TODO: throw new ennekadolgozonakmarvanszekrenyeelobbszabaditsdaztfelexception
		}

		if (employee.getName().isEmpty()) {
			throw new EmptyFieldException();
		} else {
			employee.setName(employee.getName());
			employeeRepo.save(employee);
			locker.setEmployee(employee);

			logger.info("Search in DB by name :" + employee.getName());
		}

		logger.info("No match, insert start");

		if (employee.getLocker() == null) {
			locker.setNumber(locker.getNumber());
			lockerRepo.save(locker);
			employee.setLocker(locker);

			logger.info("Search in DB by number: " + locker.getNumber());
		}
		logger.info("No match, insert start");

		try {

			employeeRepo.save(employee);
			lockerRepo.save(locker);
			locker.setEmployee(employee);
			employee.setLocker(locker);

			return "Save successful";

		} catch (TransactionSystemException e) { // TODO: ilyen tényleg jöhet itt? Én valami DataAccessException
													// leszármazottra számítanék
			logger.error("Empty field: " + e.toString());
			throw new EmptyFieldException();
		} catch (ConstraintViolationException e) {
			logger.error(e.toString());
			throw new LockerException(); // TODO: miért történhet ez? új exception típus bevezetése...
		} catch (Exception e) {
			logger.error("Insert failed: " + e.toString());
			throw new InsertFailedException();
		}

	}

	@Override
	public void deleteEmployee(Employee employee) throws Exception {

		List<Employee> emplist = employeeRepo.findAll();

		for (Employee e : emplist) {
			if (e.getName().equals(employee.getName())) {
				try {
					employeeRepo.delete(e);
					logger.info("employee save successful");

				} catch (IllegalArgumentException ex) {
					logger.error("Delete failed: " + ex.toString());
				}
			}
		}
	}

	@Override
	public List<Employee> search(Employee employee) {
		return employeeRepo.findByName(employee.getName());
	}
}
