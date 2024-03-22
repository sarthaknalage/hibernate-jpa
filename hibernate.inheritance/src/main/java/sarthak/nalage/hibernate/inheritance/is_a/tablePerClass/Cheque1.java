package sarthak.nalage.hibernate.inheritance.is_a.tablePerClass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "byCheque")
public class Cheque1 extends Payment1 {
	
	@Column(name="cheque_num")
	private Integer chequeNumber;
	
	@Column(name="cheque_type")
	private String chequeType;
	
	public Cheque1() {
		
		
	}

	public Cheque1(Integer chequeNumber, String chequeType,Integer paymentId, Double paymentAmt, String paymentDate) {
		super( paymentId, paymentAmt,paymentDate);
		this.chequeNumber = chequeNumber;
		this.chequeType = chequeType;
	}

	public Integer getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(Integer chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	
	
}