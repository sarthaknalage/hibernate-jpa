package sarthak.nalage.testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.hibernate.Query;

import sarthak.nalage.testing.model.Employee;
import sarthak.nalage.testing.registration.GetSessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	
	static void doSerialization(List<Employee> list) throws Exception {
		FileOutputStream output=new FileOutputStream("empList.txt");
		ObjectOutputStream obj=new ObjectOutputStream(output);
		obj.writeObject(list);
		System.out.println("done");
		
	}
	static void readObject() throws Exception{
		FileInputStream input= new FileInputStream("empList.txt");
		ObjectInputStream objInput=new ObjectInputStream(input);
		List<Employee>itr=(List<Employee>) objInput.readObject();
		System.out.println(itr.get(0));
	}
    public static void main ( String[] args )throws Exception
    {
    	org.hibernate.Session session= GetSessionFactory.getSessionFactory().openSession();
    	Query<Employee> query= session.createQuery("from Employee");
    	List<Employee> list=query.list();
    	System.out.println(list);
    	doSerialization(list);
    	readObject();
    }
}
