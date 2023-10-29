package com.cjc.springmvccrudapp.app.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.springmvccrudapp.app.daoi.EmployeeDaoI;
import com.cjc.springmvccrudapp.app.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoI {

	@Autowired
	SessionFactory sf;

	@Override
	public void saveEmployee(Employee e) {

		Session openSession = sf.openSession();

		openSession.save(e);
		openSession.beginTransaction().commit();
	}

	public List<Employee> getEmployees() {

		Session session = sf.openSession();

		List<Employee> list = session.createQuery("from Employee").getResultList();

		return list;

	}

	@Override
	public List<Employee> loginEmployee(String username, String password) {
		if (username.equals("ADMIN") && password.equals("ADMIN")) {

			return getEmployees();

		} else {
			Session session = sf.openSession();

			Query<Employee> q = session.createQuery("from Employee where username=? and password=? ");

			q.setParameter(0, username);
			q.setParameter(1, password);

			System.out.println("UserName PassWord Send to db");

			List<Employee> list = q.getResultList();
			System.out.println("Get Data from db");

			return list;

		}

	}

	@Override
	public List<Employee> deleteEmployee(int eid) {

		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();

		Query<Employee> createQuery = openSession.createQuery("delete from Employee where eid=?");

		createQuery.setParameter(0, eid);

		createQuery.executeUpdate();

		beginTransaction.commit();

		return getEmployees();
	}

	@Override
	public Employee editEmployee(int eid) {

		Session openSession = sf.openSession();

		Employee e = openSession.get(Employee.class, eid);

		return e;
		
	}

	@Override
	public void updateEmployee(Employee e) {

		Session openSession = sf.openSession();

		Transaction beginTransaction = openSession.beginTransaction();

		openSession.update(e);

		beginTransaction.commit();
	}

}
