package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import data.EmployeDao;
import data.Employee;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeDao employeeDao;
	
	@RequestMapping("GetEmployeeById.do")
	public ModelAndView getEmployeeById(int id){
		Employee emp = employeeDao.getEmpById(id);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("employee", emp);
		
		return mv;
	}
}
