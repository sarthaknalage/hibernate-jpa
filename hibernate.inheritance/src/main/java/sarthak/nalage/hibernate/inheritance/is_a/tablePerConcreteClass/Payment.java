package sarthak.nalage.hibernate.inheritance.is_a.tablePerConcreteClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {
	
	@Id
	@Column(name="payment_id")
	protected Integer paymentId;
	
	@Column(name="payment_amt")
	protected Double paymentAmt;
	
	@Column(name="payment_date")
	protected String paymentDate;

	public Payment() {}
	
	public Payment(Integer paymentId, Double paymentAmt, String paymentDate) {
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
