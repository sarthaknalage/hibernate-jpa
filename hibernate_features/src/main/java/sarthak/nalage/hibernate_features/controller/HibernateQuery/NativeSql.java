package sarthak.nalage.hibernate_features.controller.HibernateQuery;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sarthak.nalage.hibernate_features.modelClass.Employee;
import sarthak.nalage.hibernate_features.sessionFactory.GetEmployeeSessionFactory;

public class NativeSql {
	public static void main(String[] args) {
		Session session= GetEmployeeSessionFactory.getSessionFactory().openSession();
		SQLQuery<Object[]> sqlQuery= session.createSQLQuery("select * from employee_basic");
//		sqlQuery.addEntity(Employee.class);
		List<Object[]> list= sqlQuery.list();
		System.out.println(list);
		Iterator<Object[]> itr= list.iterator();
		while(itr.hasNext()) {
			Object[] arr= itr.next();
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
	}
		
		// Non-read queries i.e update and delete
		SQLQuery<Integer> sqlQuery1= session.createSQLQuery("update employee_basic set emp_name='SARO' where emp_id=5");
		Transaction trx=session.beginTransaction();
		int status_update=sqlQuery1.executeUpdate();
		trx.commit();
		System.out.println(status_update);

		session.close();
	}
}

