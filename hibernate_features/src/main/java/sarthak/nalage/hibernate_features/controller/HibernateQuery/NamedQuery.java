package sarthak.nalage.hibernate_features.controller.HibernateQuery;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import sarthak.nalage.hibernate_features.modelClass.Employee;
import sarthak.nalage.hibernate_features.sessionFactory.GetEmployeeSessionFactory;
public class NamedQuery {
	static void readObjectStream() throws Exception {
		FileInputStream input=new FileInputStream("test.txt");
		ObjectInputStream inputObj=new ObjectInputStream(input);
		List<Employee> employeeList=(List)inputObj.readObject();
		System.out.println("This is reading the Stream of Object");
		System.out.println(employeeList);
	}
	public static void main(String[] args) throws Exception{
		Session session=GetEmployeeSessionFactory.getSessionFactory().openSession();
		Query<Employee> query= session.createNamedQuery("emp_list", Employee.class);
		List<Employee> list=query.list();
		FileOutputStream output=new FileOutputStream("test.txt");
		ObjectOutputStream obj=new ObjectOutputStream(output);
		obj.writeObject(list);
		System.out.println(list);
		readObjectStream();
	}

}
