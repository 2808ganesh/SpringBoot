package com.cjc.springmvccrudapp.app.servicei;

import java.util.List;

import com.cjc.springmvccrudapp.app.model.Employee;

public interface EmployeeServiceI {

	public void saveEmployee(Employee e);

	public List<Employee> loginEmployee(String username, String password);

	public List<Employee> deleteEmployee(int eid);

	public Employee editEmployee(int eid);

	public void updateEmployee(Employee e);

}
