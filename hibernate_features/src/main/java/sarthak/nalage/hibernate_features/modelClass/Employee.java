package sarthak.nalage.hibernate_features.modelClass;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="employee_basic")

@NamedQueries({
	@NamedQuery(name = "emp_list",
				query = " from Employee"
			)
})
public class Employee implements Serializable {
		@Id
	@Column(name="emp_id")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_designation")
	private String empDesignation;
	
	@Column(name="emp_salary")
	private Double empSalary;
	
	public Employee() {
		
	}

	public Employee(Integer empId, String empName, String empDesignation, Double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.empSalary = empSalary;
	}
	public Employee( String empName, String empDesignation, Double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.empSalary = empSalary;
	}


	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesignation=" + empDesignation
				+ ", empSalary=" + empSalary + "]";
	}
	
	

}
