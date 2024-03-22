package sarthak.nalage.hibernate_features.controller.HibernateQuery;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import sarthak.nalage.hibernate_features.modelClass.Employee;
import sarthak.nalage.hibernate_features.sessionFactory.GetEmployeeSessionFactory;

public class CriterialImpl {
	public static void main(String[] args) {
		Session session= GetEmployeeSessionFactory.getSessionFactory().openSession();
		Criteria ctr=session.createCriteria(Employee.class);
		Projection prj1= Projections.property("empId");
		Projection prj2= Projections.property("empName");
		ProjectionList pList= Projections.projectionList();
		Criterion ctrn= Restrictions.eq("empId",4);
		pList.add(prj1);
		pList.add(prj2);
		ctr.setProjection(pList);
		ctr.add(ctrn);
		List<Object[]> list= ctr.list();
		Iterator<Object[]> itr= list.iterator();
		while(itr.hasNext()) {
			Object[] arr= itr.next();
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
	}
		
	}

}
