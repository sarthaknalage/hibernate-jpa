package sarthak.nalage.hibernate.inheritance.is_a.perSubClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cheque_sub")
@PrimaryKeyJoinColumn(name="fk_pId")
public class Cheque extends Payment {
	
	@Column(name="cheque_num")
	private Integer chequeNumber;
	
	@Column(name="cheque_type")
	private String chequeType;
	
	public Cheque() {
		
		
	}

	public Cheque(Integer chequeNumber, String chequeType,Integer paymentId, Double paymentAmt, String paymentDate) {
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