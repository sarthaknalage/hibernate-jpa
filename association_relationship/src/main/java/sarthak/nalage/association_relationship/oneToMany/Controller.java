package sarthak.nalage.association_relationship.oneToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import session.factory.GetSessionFactory;

public class Controller {
	public static void main(String[] args) {
		Session session= GetSessionFactory.getSessionFactory().openSession();
		Set<Patient> set= new HashSet<Patient>();
		set.add(new Patient(1, "amar", 34));
		set.add(new Patient(2, "karan", 24));
		set.add(new Patient(3, "samar", 44));
		Doctor dr1=new Doctor("Sarthak", 47, 23, "MS-surgery", set);
		Set<Patient> set1= new HashSet<Patient>();
		set1.add(new Patient(11, "Raj", 11));
		set1.add(new Patient(12, "Mahi", 31));
		Doctor dr2=new Doctor("Saro", 102, 34, "MS-dental", set1);
		
		Transaction trx= session.beginTransaction();
		int status1=(Integer)session.save(dr1);	
		int status2=(Integer) session.save(dr2);
		trx.commit();
		System.out.println("status 1= "+status1+" Status-2: "+status2);
		session.close();
		
	
	}
	
}
