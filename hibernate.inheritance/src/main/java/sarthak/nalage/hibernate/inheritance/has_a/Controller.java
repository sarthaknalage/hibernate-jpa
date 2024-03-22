package sarthak.nalage.hibernate.inheritance.has_a;

import org.hibernate.Session;
import org.hibernate.Transaction;

import session.factory.GetSessionFactory;

public class Controller {
	public static void main(String[] args) {
		Session session= GetSessionFactory.getSessionFactory().openSession();
		Student std=new Student("sarthak",47,9,new Address("Azzad Hind Tarun mandal","Gokhalnegar",411016));
		Transaction trx= session.beginTransaction();
		Integer status_save=(Integer)session.save(std);
		trx.commit();
		session.close();
		System.out.println(status_save);
		
	}

}
