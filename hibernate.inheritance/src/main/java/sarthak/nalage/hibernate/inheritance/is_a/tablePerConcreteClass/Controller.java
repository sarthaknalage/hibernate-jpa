package sarthak.nalage.hibernate.inheritance.is_a.tablePerConcreteClass;

import org.hibernate.Session;
import org.hibernate.Transaction;

import session.factory.GetSessionFactory;

public class Controller {
	public static void main(String[] args) {
		Session session=GetSessionFactory.getSessionFactory().openSession();
		// Inserting the payment by card data
		Card card=new Card(1425, "VISA", 101, 45066.32, "12-Aug-2023");
		Transaction trx= session.beginTransaction();
		int cardId=(Integer)session.save(card);
		trx.commit();
		session.close();
		System.out.println(cardId);
		
	}
}
