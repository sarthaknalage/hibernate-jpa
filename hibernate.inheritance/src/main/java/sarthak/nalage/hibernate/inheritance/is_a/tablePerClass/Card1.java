package sarthak.nalage.hibernate.inheritance.is_a.tablePerClass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "byCard")
public class Card1 extends Payment1 {
	
	@Column(name="card_num")
	private Integer cardNumber;
	
	@Column(name="card_type")
	private String cardType;
	
	public Card1() {
		
	}

	public Card1(Integer cardNumber, String cardType,Integer paymentId, Double paymentAmt, String paymentDate) {
		super( paymentId, paymentAmt,paymentDate);
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	
	
}
