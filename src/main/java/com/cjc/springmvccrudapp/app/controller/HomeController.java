package com.cjc.springmvccrudapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.springmvccrudapp.app.model.Employee;
import com.cjc.springmvccrudapp.app.servicei.EmployeeServiceI;

@Controller
public class HomeController {
	@Autowired
	EmployeeServiceI esi;

	@RequestMapping("/")
	public String preLogin() {

		System.out.println(" open login page");

		return "login";
	}

	@RequestMapping("openregpage")
	public String preRegister() {

		System.out.println("open register page");

		return "register";
	}

	@RequestMapping("/save")
	public String saveEmployee(@ModelAttribute Employee e) {

		esi.saveEmployee(e);

		return "login";
	}

	@RequestMapping("/login")
	public String loginEmployee(@RequestParam String username, @RequestParam String password, Model m) {

		List<Employee> list = esi.loginEmployee(username, password);
		System.out.println("Data Send");

		if (!list.isEmpty()) {
			m.addAttribute("list", list);

			return "success";

		} else

		{
			String n = "Enter valid username and password";
			m.addAttribute("msg", n);

			return "login";

		}

	}

	@RequestMapping
	public String deleteEmployee(@RequestParam int eid, Model m) {

		List<Employee> list = esi.deleteEmployee(eid);

		m.addAttribute("list", list);

		return "success";

	}

	@RequestMapping("/edit")
	public String editEmployee(@RequestParam int eid, Model m) {

		Employee e = esi.editEmployee(eid);

		m.addAttribute("emp", e);

		return "edit";

	}

	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Employee e) {

		esi.updateEmployee(e);

		return "login";
	}

}
