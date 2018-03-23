package com.locker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.locker.model.Employee;
import com.locker.model.Locker;
import com.locker.service.EmployeesService;
import com.locker.service.LockersService;
import com.locker.service.exception.EmployeeDoesNotExistsException;

@Controller
public class EmployeeController {

	private static final String ROUTING_ADDLOCKER = "/employee"; // URL_ADDLOCKER
	private static final String ROUTING_EMPLIST = "/employeelist";
	private static final String ROUTING_DELETELOCKER = "/deletelockerwithemployee";
	private static final String ROUTING_FINDLOCKERBYEMPLOYEENAME = "/findlockerbyemployeename";

	private static final String JSP_ADDLOCKER = "employee";
	private static final String JSP_EMPLIST = "employeelist";
	private static final String JSP_DELETELOCKER = "deletelockerwithemployee";
	private static final String JSP_FINDLOCKERBYEMPLOYEENAME = "findlockerbyemployeename";

	private static final String POST_PARAM_ADDLOCKER_RESULT = "name";

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	private LockersService service;
	private EmployeesService empService;

	@Autowired
	public void setService(LockersService service) {
		this.service = service;
	}

	@Autowired
	public void setEmpService(EmployeesService empService) {
		this.empService = empService;
	}

	@RequestMapping(value = ROUTING_EMPLIST, method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		ModelAndView modelAndView;
		try {
			modelAndView = new ModelAndView(JSP_EMPLIST);
			modelAndView.addObject("employees", empService.listEmployees());
		} catch (Exception e) {
			modelAndView = new ModelAndView("/error"); // ez az oldal nem létezik, de nem is tudunk túl sok hasznosat
														// mondani a felhasználónak, hiszen valami súlyos DB zűr van,
														// amiből nem tudunk felépülni
			// irányítsuk a felhasználót egy általános magyarázkodó oldalra, pl a
			// controllerben elhelyezett @ExceptionHandler segítségével

		}

		return modelAndView;
	}

	@RequestMapping(value = ROUTING_ADDLOCKER, method = RequestMethod.GET)
	public ModelAndView addLocker() {
		ModelAndView modelAndView = new ModelAndView(JSP_ADDLOCKER);
		return modelAndView;
	}
	// mivel a fenti mapping egy síma view-ra irányít, így írhatjuk rövidebben is:
	// public String addLocker() {
	// return JSP_ADDLOCKER;
	// }

	@RequestMapping(value = ROUTING_DELETELOCKER, method = RequestMethod.GET)
	public ModelAndView deleteLockerWithEmployee(@RequestParam(value = POST_PARAM_ADDLOCKER_RESULT) final String name,
			final Long number) {

		ModelAndView modelAndView = new ModelAndView(JSP_DELETELOCKER);
		Employee employee = new Employee(name);
		Locker locker = new Locker(number);
		String result = "Delete successful!";

		try {
			service.deleteLocker(locker); // ezt a kettőt együtt service szintre kellene vinni.
			empService.deleteEmployee(employee);

		} catch (Exception e) {
			result = e.toString();

			modelAndView.addObject("error", "Error!"); // itt inkább i18n-es message key-t adjunk tovább, így
														// függetleníteni tudjuk a humán üzeneteket a java kódtól
		}

		modelAndView.addObject("result", result);
		return modelAndView;
	}

	@RequestMapping(value = ROUTING_FINDLOCKERBYEMPLOYEENAME, method = RequestMethod.GET)
	public ModelAndView findLockerByEmployeeName(String name) {

		ModelAndView modelAndView = new ModelAndView(JSP_FINDLOCKERBYEMPLOYEENAME);
		Employee employee = new Employee(name);

		try {
			modelAndView.addObject("employees", empService.search(employee));
		} catch (Exception e) {
			logger.error("exception during findLockerByEmployeeName()", e);
			modelAndView = new ModelAndView("/error");
		}
		return modelAndView;
	}

	@ExceptionHandler
	@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
	public String handleNotExistingEmployee(EmployeeDoesNotExistsException e) {
		return "/employee-does-not-exist";
	}
}
