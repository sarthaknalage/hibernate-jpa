package sarthak.nalage.hibernate.inheritance.is_a.perSubClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="card_sub")
@PrimaryKeyJoinColumn(name="fk_Pid")
public class Card extends Payment {
	
	@Column(name="card_num")
	private Integer cardNumber;
	
	@Column(name="card_type")
	private String cardType;
	
	public Card() {
		
	}

	public Card(Integer cardNumber, String cardType,Integer paymentId, Double paymentAmt, String paymentDate) {
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
