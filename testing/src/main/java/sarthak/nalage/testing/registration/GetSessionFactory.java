package sarthak.nalage.testing.registration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import sarthak.nalage.testing.model.Employee;

public class GetSessionFactory {
	
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory=null;
		Configuration configuration=new Configuration();
		// setting up Connection properties
		configuration.setProperty(Environment.DRIVER,"com.mysql.cj.jdbc.Driver" );
		configuration.setProperty(Environment.URL,"jdbc:mysql://localhost:3306/student" );
		configuration.setProperty(Environment.USER,"root" );
		configuration.setProperty(Environment.PASS,"sarthak@2003" );
				
		// setting up Hibernate property
		configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		configuration.setProperty(Environment.SHOW_SQL, "true");
		configuration.setProperty(Environment.HBM2DDL_AUTO,"update");
		
		//Mapping Property
		configuration.addAnnotatedClass(Employee.class);
		
		// creation of session factory class
//		ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySetting(configuration.class);
		org.hibernate.service.ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory= configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
		
	}

}
