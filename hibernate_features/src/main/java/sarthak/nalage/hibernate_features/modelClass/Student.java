package sarthak.nalage.hibernate_features.modelClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name="std_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer stdId;
	
	@Column(name="std_name")
	private String stdName;
	
	@Column(name="std_marks")
	private Double stdMarks;
	
	public Student() {
		
	}

	public Student(Integer stdId, String stdName, Double stdMarks) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdMarks = stdMarks;
	}

	public Integer getStdId() {
		return stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public Double getStdMarks() {
		return stdMarks;
	}

	public void setStdMarks(Double stdMarks) {
		this.stdMarks = stdMarks;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdMarks=" + stdMarks + "]";
	}
	
	

}
