package sarthak.nalage.hibernate.inheritance.has_a;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String lane1;
	
	private String lane2;
	
	private Integer pinCode;

	
	public Address() {
		
	}
	public Address(String lane1, String lane2, Integer pinCode) {
		super();
		this.lane1 = lane1;
		this.lane2 = lane2;
		this.pinCode = pinCode;
	}

	public String getLane1() {
		return lane1;
	}

	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}

	public String getLane2() {
		return lane2;
	}

	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	
	
}
