package sarthak.nalage.association_relationship.oneToOne;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import session.factory.GetSessionFactory;

public class Controller {
	public static void main(String[] args) {
		Session session=GetSessionFactory.getSessionFactory().openSession();
		Person person=new Person(111, "Sarthak", 20, new Passport("12A343zx",new Date().toString(),1));
		Transaction trx= session.beginTransaction();
		int status=(Integer)session.save(person);
		trx.commit();
		session.close();
		System.out.println(status);
	}

}
