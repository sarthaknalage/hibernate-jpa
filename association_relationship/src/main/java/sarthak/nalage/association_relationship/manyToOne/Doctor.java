package sarthak.nalage.association_relationship.manyToOne;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="doctor_manyToOne")
public class Doctor {
	


	private String drName;
	
	@Id
	@Column(name="dr_id")
	private Integer drId;
	
	@Column(name="dr_age")
	private Integer drAge;
	
	@Column(name="dr_design")
	private String drDesignation;	
	
	public Doctor(String drName, Integer drId, Integer drAge, String drDesignation) {
		super();
		this.drName = drName;
		this.drId = drId;
		this.drAge = drAge;
		this.drDesignation = drDesignation;
	}


	public String getDrName() {
		return drName;
	}


	public void setDrName(String drName) {
		this.drName = drName;
	}


	public Integer getDrId() {
		return drId;
	}


	public void setDrId(Integer drId) {
		this.drId = drId;
	}


	public Integer getDrAge() {
		return drAge;
	}


	public void setDrAge(Integer drAge) {
		this.drAge = drAge;
	}


	public String getDrDesignation() {
		return drDesignation;
	}


	public void setDrDesignation(String drDesignation) {
		this.drDesignation = drDesignation;
	}




	@Override
	public String toString() {
		return "Doctor [drName=" + drName + ", drId=" + drId + ", drAge=" + drAge + ", drDesignation=" + drDesignation
				+ ", patientSet=" + "]";
	}
	

	

}
