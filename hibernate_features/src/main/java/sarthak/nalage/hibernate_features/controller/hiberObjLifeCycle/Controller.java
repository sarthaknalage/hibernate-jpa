package sarthak.nalage.hibernate_features.controller.hiberObjLifeCycle;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sarthak.nalage.hibernate_features.modelClass.Employee;
import sarthak.nalage.hibernate_features.sessionFactory.GetEmployeeSessionFactory;

public class Controller {
	
	public static void main(String[] args) {
		Session session= GetEmployeeSessionFactory.getSessionFactory().openSession();
		Employee employee =new Employee(10,"Jaya","DBA",344534.34);
		// here the object is Transient state any changes are made to the object are not get's the reflected into the db/cache
		Transaction trx= session.beginTransaction();
		session.save(employee);
		trx.commit();
		Transaction trx1=session.beginTransaction();
		employee.setEmpDesignation("SE");
		session.flush();
		trx1.commit();
		System.out.println(session.get(Employee.class,10));
		
		session.close();
		
	}
	
	

}
