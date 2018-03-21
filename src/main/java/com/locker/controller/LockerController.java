package com.locker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.locker.model.Employee;
import com.locker.model.Locker;
import com.locker.service.EmployeesService;
import com.locker.service.LockersService;

@Controller
public class LockerController {

	private static final String ROUTING_FINDLOCKER = "/findlocker";
	private static final String ROUTING_LOCKERMOD = "/lockermod";
	private static final String ROUTING_LOCKERMOD_RESULT = "/lockermodresult";
	private static final String ROUTING_LOCKERRESULT = "/lockerresult";

	private static final String JSP_FINDLOCKER = "findlocker";
	private static final String JSP_LOCKERMOD = "lockermod";
	private static final String JSP_LOCKERMOD_RESULT = "lockermodresult";
	private static final String JSP_LOCKERRESULT = "lockerresult";

	private static final String POST_PARAM_ADDLOCKER_RESULT = "name";

	private static final Logger logger = LoggerFactory.getLogger(LockerController.class);

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

	@RequestMapping(value = ROUTING_FINDLOCKER, method = RequestMethod.GET)
	public ModelAndView findLocker(Long number) {

		Locker locker = new Locker(number);
		ModelAndView modelAndView;
		try {
			modelAndView = new ModelAndView(JSP_FINDLOCKER);
			modelAndView.addObject("lockers", service.findLocker(locker.getNumber()));
			logger.info("locker: " + service.findLocker(locker.getNumber()));
			// modelAndView.addObject("locker", locker.getEmployee().getName());
		} catch (Exception e) {
			logger.error("exception during findLocker()", e);
			modelAndView = new ModelAndView("/error");
		}
		return modelAndView;
	}

	@RequestMapping(value = ROUTING_LOCKERMOD, method = RequestMethod.GET)
	public ModelAndView modLocker() {
		ModelAndView modelAndView = new ModelAndView(JSP_LOCKERMOD);
		return modelAndView;
	}

	@RequestMapping(value = ROUTING_LOCKERMOD_RESULT, method = RequestMethod.POST)
	public ModelAndView lockerModResult(@RequestParam(value = POST_PARAM_ADDLOCKER_RESULT) final String name,
			final Long number) {
		ModelAndView modelAndView = new ModelAndView(JSP_LOCKERMOD_RESULT);
		Locker locker = new Locker(number);
		Employee employee = new Employee(name);
		String result;
		try {
			result = service.addNewLocker(employee, locker);
		} catch (Exception e) {
			result = e.toString();

			modelAndView.addObject("error", "Error");
		}
		modelAndView.addObject("result", result);
		return modelAndView;
	}

	@RequestMapping(value = ROUTING_LOCKERRESULT, method = RequestMethod.POST)
	public ModelAndView lockerResult(@RequestParam(value = POST_PARAM_ADDLOCKER_RESULT) final String name,
			final Long number) {

		ModelAndView modelAndView = new ModelAndView(JSP_LOCKERRESULT);
		Employee employee = new Employee(name);
		Locker locker = new Locker(number);
		String result;

		try {
			result = empService.addEmployee(employee, locker);

		} catch (Exception e) {
			result = e.toString();

			modelAndView.addObject("error", "Error!");
		}
		modelAndView.addObject("result", result);
		return modelAndView;
	}
}
