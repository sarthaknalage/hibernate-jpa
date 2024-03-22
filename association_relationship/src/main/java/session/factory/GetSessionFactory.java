package session.factory ;

import java.io.FileReader;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import sarthak.nalage.association_relationship.mayToMany.Author;
import sarthak.nalage.association_relationship.mayToMany.Book;
import sarthak.nalage.association_relationship.oneToMany.Doctor;
import sarthak.nalage.association_relationship.oneToMany.Patient;
import sarthak.nalage.association_relationship.oneToOne.Passport;
import sarthak.nalage.association_relationship.oneToOne.Person;

public class GetSessionFactory{
	public static SessionFactory getSessionFactory() {

		SessionFactory sessionFactory=null;
		FileReader reader=null;
		Properties properties=null;
		try {
			 reader=new FileReader("C:\\sarthak_nalage_Hibernat\\association_relationship\\config.properties");
			  properties=new Properties();
			properties.load(reader);
		} catch (Exception e) {
			System.out.println("Exception-1");
			e.printStackTrace();
		} 
		
		// configuration object
		Configuration configuration= new Configuration();
		// Setting Connection property
		configuration.setProperty(Environment.DRIVER,properties.getProperty("sql_driver"));
		configuration.setProperty(Environment.URL,properties.getProperty("url") );
		configuration.setProperty(Environment.USER,properties.getProperty("user_name") );
		configuration.setProperty(Environment.PASS,properties.getProperty("password") );
				
		// setting up Hibernate property
		configuration.setProperty(Environment.DIALECT, properties.getProperty("dialect_class"));
		configuration.setProperty(Environment.SHOW_SQL, properties.getProperty("sql_status"));
		configuration.setProperty(Environment.HBM2DDL_AUTO,properties.getProperty("hbm_status"));
		
		//Mapping Property
		
		configuration.addAnnotatedClass(Patient.class);
		configuration.addAnnotatedClass(Doctor.class);
		configuration.addAnnotatedClass(Book.class);
		configuration.addAnnotatedClass(Author.class);
		configuration.addAnnotatedClass(Passport.class);
		configuration.addAnnotatedClass(Person.class);
		configuration.addAnnotatedClass(sarthak.nalage.association_relationship.manyToOne.Doctor.class);
		configuration.addAnnotatedClass(sarthak.nalage.association_relationship.manyToOne.Patient.class);
		configuration.addAnnotatedClass(sarthak.nalage.association_relationship.oneToMany_manyToOne_bidirectional.Patient.class);
		configuration.addAnnotatedClass(sarthak.nalage.association_relationship.oneToMany_manyToOne_bidirectional.Doctor.class);
		
		
		// creation of session factory class
//		ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySetting(configuration.class);
		org.hibernate.service.ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory= configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
		
	
	}
}
