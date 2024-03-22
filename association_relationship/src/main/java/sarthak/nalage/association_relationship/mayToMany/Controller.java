package sarthak.nalage.association_relationship.mayToMany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import session.factory.GetSessionFactory;

public class Controller {
	
	public static void main(String[] args) {
		Session session= GetSessionFactory.getSessionFactory().openSession();
		Set<Author> list=new HashSet();
		
		// first book object Bidirectional Mechanism
		Transaction trx= session.beginTransaction();
		Author author1=new Author("sarthak", 47, "PHD-PHY");
		Author author2=new Author("sanjay", 12, "PHD-MA");
		Author author3=new Author("rupali", 23, "PHD-SCI");
		
		list.add(author1);
		list.add(author2);
		list.add(author3);
		Book book =new Book("sci-around-y", 1231, 232.32, list);
		
		// second Book Object
		Set<Author> list1=new HashSet<Author>();
		list1.add(author1);
		list1.add(author2);
		Book book1 =new Book("sciology", 111, 142.32, list1);
		
//		int status1=(Integer)session.save(book);
//		int status2=(Integer)session.save(book1);
//		System.out.println(status1+" : "+status2);
//		trx.commit();
//		
		//&&& Bi- directional mapping
		Set<Book> set1= new HashSet<Book>();
		set1.add(book);
		set1.add(book1);
		author1.setBookList(set1);
		
		author2.setBookList(set1);
		
		Set<Book> set2=new HashSet<Book>();
		set2.add(book);
		author3.setBookList(set2);

		// trying to do bi-directional mapping
		
//		Transaction trx=session.beginTransaction();
		int status1=(Integer)session.save(book);
		int status2=(Integer)session.save(book1);
//		int status3=(Integer)session.save(author3);
		trx.commit();
		System.out.println(status1+" : "+status2);
		
		session.close();
	}

}
