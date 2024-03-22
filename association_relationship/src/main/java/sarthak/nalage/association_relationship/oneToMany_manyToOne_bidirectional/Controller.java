package sarthak.nalage.association_relationship.oneToMany_manyToOne_bidirectional;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import session.factory.GetSessionFactory;

public class Controller {
	public static void main(String[] args) {
		Session session=GetSessionFactory.getSessionFactory().openSession();
		//manyToOne
		 Doctor doctor=new Doctor("Sarthak", 47, 20, "MS");
		Patient patient1=new Patient(1, "Mangal", 59, doctor);
		Patient patient2=new Patient(2, "Ramika", 29, doctor);
		Patient patient3=new Patient(3, "Rambha", 39, doctor);
		
		//oneToMany
		Set<Patient> set=new HashSet<Patient>();
		set.add(patient1);
		set.add(patient2);
		set.add(patient3);
		doctor.setPatientSet(set);
		Transaction trx= session.beginTransaction();
		session.save(patient1);
		trx.commit();
		session.close();
		
	}

}
