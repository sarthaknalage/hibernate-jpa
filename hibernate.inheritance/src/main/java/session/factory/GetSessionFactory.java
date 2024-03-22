package session.factory;

import java.io.FileReader;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import sarthak.nalage.hibernate.inheritance.has_a.Student;
import sarthak.nalage.hibernate.inheritance.is_a.perSubClass.Card;
import sarthak.nalage.hibernate.inheritance.is_a.perSubClass.Cheque;
import sarthak.nalage.hibernate.inheritance.is_a.perSubClass.Payment;
import sarthak.nalage.hibernate.inheritance.is_a.tablePerClass.Card1;
import sarthak.nalage.hibernate.inheritance.is_a.tablePerClass.Cheque1;
import sarthak.nalage.hibernate.inheritance.is_a.tablePerClass.Payment1;

public class GetSessionFactory {
	
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory=null;
		FileReader reader=null;
		Properties properties=null;
		try {
			 reader=new FileReader("C:\\sarthak_nalage_Hibernat\\hibernate.inheritance\\config.properties");
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
		configuration.addAnnotatedClass(Payment.class);
		configuration.addAnnotatedClass(Card.class);
		configuration.addAnnotatedClass(Cheque.class);
		configuration.addAnnotatedClass(Cheque1.class);
		configuration.addAnnotatedClass(Payment1.class);
		configuration.addAnnotatedClass(Card1.class);
		
		configuration.addAnnotatedClass(sarthak.nalage.hibernate.inheritance.is_a.tablePerConcreteClass.Card.class);
		configuration.addAnnotatedClass(sarthak.nalage.hibernate.inheritance.is_a.tablePerConcreteClass.Payment.class);
		configuration.addAnnotatedClass(sarthak.nalage.hibernate.inheritance.is_a.tablePerConcreteClass.Cheque.class);
		
		configuration.addAnnotatedClass(Student.class);
		
		// creation of session factory class
//		ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySetting(configuration.class);
		org.hibernate.service.ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory= configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
		
	}

}
