package sarthak.nalage.hibernate_features.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sarthak.nalage.hibernate_features.modelClass.Employee;
import sarthak.nalage.hibernate_features.sessionFactory.GetEmployeeSessionFactory;

/**
 * Here is demonstration of get() , load(), clear(),, evict() ,persist(),save(),delete(),update(),merge()
 * saveOrUpdate()*
 */
public class EmployeeController 
{
    public static void main( String[] args )
    {
       Session session= GetEmployeeSessionFactory.getSessionFactory().openSession();
       // lazy Loading and Caching
       Employee emp1=session.get(Employee.class,2);
       session.evict(emp1);
       Employee emp2=session.load(Employee.class,2);
       System.out.println(emp2);
       System.out.println(emp1==emp2);
       System.out.println(emp1.hashCode());
       System.out.println(emp2.hashCode());
       
       // save/persist/saveOrUpdate
       Employee employee1=new Employee(5,"Saro","SDE-2",120000.90);
       Employee employee2=new Employee(6,"Maxyy","Architect",220000.90);
       Employee employee3=new Employee(7,"Kane","SDE-3",100000.90);
       Transaction trx= session.beginTransaction();
//       session.save(employee1);
//       session.persist(employee2);
//       session.saveOrUpdate("sarthak.nalage.hibernate_features.modelClass.Employeesarthak.nalage.hibernate_features.modelClass.Employee",employee3);
       trx.commit(); 
       
       // update & Delete
       // with loading the object from dbs
       Employee emp=session.get(Employee.class,1);
       if(emp!=null) {
    	   emp.setEmpDesignation("SE-Tier-3");
    	   emp.setEmpSalary(320000.80);
    	   Transaction trx1=session.beginTransaction();
    	   session.update(emp);
    	   trx1.commit();
       }
       Transaction trx2=session.beginTransaction();
       Employee employee4=new Employee(8,"Kane","SDE-3",100000.90);
       try {
//    	   session.saveOrUpdate(employee4);
       }catch(Exception e) {
    	   e.printStackTrace();;
       }
       trx2.commit();
       
       // delete Object
       Employee emp4=(Employee)session.get("sarthak.nalage.hibernate_features.modelClass.Employee",8);
       if(emp4!=null) {
    	   Transaction trx3=session.beginTransaction();
    	   session.delete(emp4);
    	   trx3.commit();
       }
       
       // update vs merge
       Employee employee5=new Employee(2,"Ruturaj","Engineer",232322.323);
       Transaction trx4=session.beginTransaction();
       try {
//    	   session.update(employee5); org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session : [sarthak.nalage.hibernate_features.modelClass.Employee#2]
    	   session.merge(employee5);
    	   trx4.commit();
       }catch(Exception e) {
    	   e.printStackTrace();
       }
       
       
       session.close();
       
    	
    	
    	
    }
}
