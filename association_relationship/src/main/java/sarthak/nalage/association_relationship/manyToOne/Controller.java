package sarthak.nalage.association_relationship.manyToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;

import session.factory.GetSessionFactory;

public class Controller {
	public static void main(String[] args) {
		Session session=GetSessionFactory.getSessionFactory().openSession();
		Doctor doctor=new Doctor("Sarthak", 47, 20, "MS");
		Patient patient1=new Patient(1, "Mangal", 59, doctor);
		Patient patient2=new Patient(2, "Ramika", 29, doctor);
		Patient patient3=new Patient(3, "Rambha", 39, doctor);
		
		Doctor doctor1=new Doctor("SARO",12, 24, "MBBS");
		Patient patient4=new Patient(4, "Siya", 12, doctor1);
		Patient patient5=new Patient(5, "Mona", 32, doctor1);
		
		//begon Transaction
		Transaction trx=session.beginTransaction();
		session.save(patient1);
		session.save(patient2);
		session.save(patient3);
		session.save(patient4);
		session.save(patient5);
		trx.commit();
		session.close();
		
	}
}
