package sarthak.nalage.hibernate_features.controller.HibernateQuery;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import sarthak.nalage.hibernate_features.modelClass.Employee;
import sarthak.nalage.hibernate_features.sessionFactory.GetEmployeeSessionFactory;

//purpose is to work on the bulk of object
public class HQLquery {
	
	public static void main(String[] args) {
		Session session = GetEmployeeSessionFactory.getSessionFactory().openSession();
		// complete Object retrieval
		Query<Employee> query= session.createQuery("from Employee where empSalary>=200000");
		List<Employee> list= query.list();
		Iterator<Employee> itr= list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		//partial object retrieval
		Query<Object[]> query1= session.createQuery("select empName, empId from Employee where empSalary>=200000");
		List<Object[]> list1= query1.list();
		
		Iterator<Object[]> itr1=list1.iterator();
		while(itr1.hasNext()) {
			Object[] arr= itr1.next();
			System.out.println("Employee Name: "+arr[0]);
			System.out.println("Employee Id: "+arr[1]);
		}
		
		//selecting only Single property
		Query<String> query2= session.createQuery(" select empName from Employee where empSalary>=200000");
		List<String> list2= query2.list();
		Iterator<String> itr2=list2.iterator();
		while(itr2.hasNext()) {
			System.out.println("Employee Name:"+itr2.next());
		}
		// perform the Non-read queries
		// update and delete
		Query<String> query3= session.createQuery("update  Employee set empName='Ruturaj' where empId=2");
		Query<String> query4= session.createQuery("delete from Employee where empId=8");
		Transaction trx= session.beginTransaction();
		Integer status=query3.executeUpdate();
		Integer status1=query4.executeUpdate();
		trx.commit();
		System.out.println(status);
		System.out.println(status1);

		session.close();
	}

}
