package sarthak.nalage.hibernate_features.sessionFactory;

import java.io.FileReader;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import sarthak.nalage.hibernate_features.modelClass.Employee;
import sarthak.nalage.hibernate_features.modelClass.Student;

public class GetEmployeeSessionFactory {
	
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory=null;
		FileReader reader=null;
		Properties properties=null;
		try {
			 reader=new FileReader("C:\\sarthak_nalage_Hibernat\\hibernate_features\\config.properties");
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
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Student.class);
		
		// creation of session factory class
//		ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySetting(configuration.class);
		org.hibernate.service.ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory= configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
		
	}

}
