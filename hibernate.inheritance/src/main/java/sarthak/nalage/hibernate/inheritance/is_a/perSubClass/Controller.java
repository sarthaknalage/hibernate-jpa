package sarthak.nalage.hibernate.inheritance.is_a.perSubClass;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import session.factory.GetSessionFactory;

public class Controller {
	public static void main(String[] args) {
		Session session=GetSessionFactory.getSessionFactory().openSession();
		// Inserting the payment by card data
//		Card card=new Card(1425, "VISA", 101, 45066.32, "12-Aug-2023");
//		Transaction trx= session.beginTransaction();
//		int cardId=(Integer)session.save(card);
//		trx.commit();
		
		@SuppressWarnings("unchecked")
		SQLQuery<Card> query= session.createSQLQuery("select * from card_sub as c where c.fk_Pid IN(select payment_id from payment_sub where payment_sub.payment_amt=45066.32)");
		query.addEntity(Card.class);
		List<Card> list=query.list();
		System.out.println(list);
		session.close();
//		System.out.println(cardId);
		
	}
}
