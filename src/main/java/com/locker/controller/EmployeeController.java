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
public class EmployeeController {

	private static final String ROUTING_ADDLOCKER = "/employee";
	private static final String ROUTING_EMPLIST = "/employeelist";
	private static final String ROUTING_DELETELOCKER = "/deletelockerwithemployee";

	private static final String JSP_ADDLOCKER = "employee";
	private static final String JSP_EMPLIST = "employeelist";
	private static final String JSP_DELETELOCKER = "deletelockerwithemployee";

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
			modelAndView = new ModelAndView("/error");
		}

		return modelAndView;
	}

	@RequestMapping(value = ROUTING_ADDLOCKER, method = RequestMethod.GET)
	public ModelAndView addLocker() {
		ModelAndView modelAndView = new ModelAndView(JSP_ADDLOCKER);
		return modelAndView;
	}

	@RequestMapping(value = ROUTING_DELETELOCKER, method = RequestMethod.GET)
	public ModelAndView deleteLockerWithEmployee(@RequestParam(value = POST_PARAM_ADDLOCKER_RESULT) final String name,
			final Long number) {

		ModelAndView modelAndView = new ModelAndView(JSP_DELETELOCKER);
		Employee employee = new Employee(name);
		Locker locker = new Locker(number);
		String result = "Delete successful!";

		try {
			service.deleteLocker(locker);
			empService.deleteEmployee(employee);

		} catch (Exception e) {
			result = e.toString();

			modelAndView.addObject("error", "Error!");
		}

		modelAndView.addObject("result", result);
		return modelAndView;
	}
}