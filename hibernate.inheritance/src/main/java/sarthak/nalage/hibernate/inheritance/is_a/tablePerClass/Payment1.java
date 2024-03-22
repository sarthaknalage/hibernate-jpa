package sarthak.nalage.hibernate.inheritance.is_a.tablePerClass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="payment_per_class")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="mode", discriminatorType = DiscriminatorType.STRING, length = 10)
public abstract class Payment1 {
	
	@Id
	@Column(name="payment_id")
	protected Integer paymentId;
	
	@Column(name="payment_amt")
	protected Double paymentAmt;
	
	@Column(name="payment_date")
	protected String paymentDate;

	public Payment1() {}
	
	public Payment1(Integer paymentId, Double paymentAmt, String paymentDate) {
		super();
		this.paymentId = paymentId;
		this.paymentAmt = paymentAmt;
		this.paymentDate = paymentDate;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Double getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(Double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	
	
	

}
