package sarthak.nalage.hibernate.inheritance.has_a;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_has_a")
public class Student {
	
	private String stdName;
	@Id
	private Integer stdId;
	
	private Integer stdMarks;
	
	@Embedded
	private Address stdAddress;
	
	
	public Student() {
		
		
	}


	public Student(String stdName, Integer stdId, Integer stdMarks, Address stdAddress) {
		super();
		this.stdName = stdName;
		this.stdId = stdId;
		this.stdMarks = stdMarks;
		this.stdAddress = stdAddress;
	}


	public String getStdName() {
		return stdName;
	}


	public void setStdName(String stdName) {
		this.stdName = stdName;
	}


	public Integer getStdId() {
		return stdId;
	}


	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}


	public Integer getStdMarks() {
		return stdMarks;
	}


	public void setStdMarks(Integer stdMarks) {
		this.stdMarks = stdMarks;
	}


	public Address getStdAddress() {
		return stdAddress;
	}


	public void setStdAddress(Address stdAddress) {
		this.stdAddress = stdAddress;
	}


	@Override
	public String toString() {
		return "Student [stdName=" + stdName + ", stdId=" + stdId + ", stdMarks=" + stdMarks + ", stdAddress="
				+ stdAddress + "]";
	}
	


}
