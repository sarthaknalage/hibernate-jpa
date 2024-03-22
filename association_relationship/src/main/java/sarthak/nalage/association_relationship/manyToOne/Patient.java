package sarthak.nalage.association_relationship.manyToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.print.Doc;

@Entity
@Table(name="patient_manyToOne")
public class Patient {
	
	@Id
	@Column(name="p_id")
	private Integer pId;
	
	@Column(name="p_name")
	private String pName;

	@Column(name="p_age")
	private Integer pAge;
	
	@ManyToOne(targetEntity = Doctor.class,
		    fetch = FetchType.EAGER,
		    cascade = CascadeType.ALL
			)
	@JoinColumn(name="fk_drId",referencedColumnName = "dr_id")
	private Doctor doctor;

	public Patient() {
		
	}
	



	public Patient(Integer pId, String pName, Integer pAge, Doctor doctor) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pAge = pAge;
		this.doctor = doctor;
	}


	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getpAge() {
		return pAge;
	}

	public void setpAge(Integer pAge) {
		this.pAge = pAge;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "Patient [pId=" + pId + ", pName=" + pName + ", pAge=" + pAge + ", doctor=" + doctor + "]";
	}
	

}
