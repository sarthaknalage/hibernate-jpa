package sarthak.nalage.association_relationship.oneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passport")
public class Passport {
	
	@Column(name="pass_number")
	private String passNumber;
	
	@Column(name="pass_validity")
	private String validity;
	
	@Id
	@Column(name="pass_id")
	private Integer passId;
	
	
	public Passport() {
		
	}

	public Passport(String passNumber, String validity, Integer passId) {
		super();
		this.passNumber = passNumber;
		this.validity = validity;
		this.passId = passId;
	}

	public String getPassNumber() {
		return passNumber;
	}

	public void setPassNumber(String passNumber) {
		this.passNumber = passNumber;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public Integer getPassId() {
		return passId;
	}

	public void setPassId(Integer passId) {
		this.passId = passId;
	}

	@Override
	public String toString() {
		return "Passport [passNumber=" + passNumber + ", validity=" + validity + ", passId=" + passId + "]";
	}

	
}
