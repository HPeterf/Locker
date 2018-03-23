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

	// @Override // mivel nem használjuk, ez törölhető
	// public List<Locker> listLockers() {
	// return lockersRepo.findAll();
	// }

	@Override
	public void deleteLocker(Locker locker) throws Exception {

		// egy új deleteByNumber() függvény a repo-ba, és itt egyszerűen azt hívjuk majd
		// fel
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

	@Override  // assignLockerToEmployee()
	public void assignLockerToEmployee(Employee employee, Locker locker) throws Exception {  // TODO: nem általános exception-t dobunk, csak lockerexception-t ill. az új exceptiont ami a legvégén dobódik

		// employe es locker kikeresese nev/number alapjan a repositoryból
		
		List<Locker> lockerList = lockersRepo.findAll();  // ezt mellőzzük, mert a kód összetett, hibákra hajlamosít + az összes rekor leszelektálása sok memóriát foglal, és az adatbázisszervert is terheli
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
					logger.error("assignment of locker {} to employee {} has failed", employee.getId(), locker.getNumber());
		// TODO: saját exception dobása
					thorw new fhdgkjshdjkshdfjkException();
				}
			}
		}
		//return "save successful";  // nem használjuk semmire se ezt az értéket, így elég, ha void a visszaadott érték
	}

	@Override
	public List<Locker> search(Locker locker) {
		return lockersRepo.findByNumber(locker.getNumber());
	}
}
