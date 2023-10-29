package com.cjc.springmvccrudapp.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.springmvccrudapp.app.daoi.EmployeeDaoI;
import com.cjc.springmvccrudapp.app.model.Employee;
import com.cjc.springmvccrudapp.app.servicei.EmployeeServiceI;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	EmployeeDaoI edi;

	@Override
	public void saveEmployee(Employee e) {

		edi.saveEmployee(e);
	}

	@Override
	public List<Employee> loginEmployee(String username, String password) {

		List<Employee> list = edi.loginEmployee(username, password);

		System.out.println("data send form ser impl");

		return list;

	}

	@Override
	public List<Employee> deleteEmployee(int eid) {

		return edi.deleteEmployee(eid);

	}

	@Override
	public Employee editEmployee(int eid) {

		return edi.editEmployee(eid);

	}

	@Override
	public void updateEmployee(Employee e) {

		edi.updateEmployee(e);
		
	}

}
