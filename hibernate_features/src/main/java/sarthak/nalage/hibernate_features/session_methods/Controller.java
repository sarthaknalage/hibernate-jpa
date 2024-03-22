package sarthak.nalage.hibernate_features.session_methods;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sarthak.nalage.hibernate_features.modelClass.Student;
import sarthak.nalage.hibernate_features.sessionFactory.GetEmployeeSessionFactory;

public class Controller {
	public static void main(String[] args) {
		Session session= GetEmployeeSessionFactory.getSessionFactory().openSession();
		Student std=new Student();
		std.setStdMarks(6.34);
		std.setStdName("Mahesh");
		// Saving the object
		Transaction trx= session.beginTransaction();
//		Integer status=(Integer)session.save(std);
//		session.persist(std);
		Student std1=session.load(Student.class, 2);
		System.out.println(std1);
		Student std2=session.get(Student.class, 2);
		System.out.println(std2);
		
		session.clear();
		// update and merge method demonstration
		Student stda=new Student(2, "Nalage", 23.3);
		session.update(stda);
		
		// delete method
		Student std3=session.get(Student.class, 3);
		session.delete(std3);
		trx.commit();
//		System.out.println(status);
		session.close();
	}

}
