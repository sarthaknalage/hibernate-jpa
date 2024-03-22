package sarthak.nalage.testing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{
	
	@Id
	@Column(name="id")
	private Integer empId;
	
	@Column(name="name")
	private String empName;
	
	@Column(name="salary")
	private Integer empSalary;

	public Employee() {
		super();
	}
	
	public Employee(Integer empId, String empName, Integer empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	
	@Override
	public String toString() {
		return "Student [roll_number=" + empId + ", name=" + empName + ", marks=" + empSalary + "]";
	}

	public Integer getRoll_number() {
		return empId;
	}

	public void setRoll_number(Integer roll_number) {
		this.empId = roll_number;
	}

	public String getName() {
		return empName;
	}

	public void setName(String name) {
		this.empName = name;
	}

	public Integer getMarks() {
		return empSalary;
	}

	public void setMarks(Integer marks) {
		this.empSalary = marks;
	}

	
	
	
	

}
