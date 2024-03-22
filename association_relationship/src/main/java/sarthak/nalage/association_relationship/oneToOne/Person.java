package sarthak.nalage.association_relationship.oneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@Column(name="person_id")
	private Integer personId;
	
	@Column(name="person_name")
	private String personName;
	
	@Column(name="person_age")
	private Integer personAge;
	
	@OneToOne(targetEntity = Passport.class,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="fk_person")
	private Passport passport;
	
	public Person() {
		
	}

	public Person(Integer personId, String personName, Integer personAge, Passport passport) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAge = personAge;
		this.passport = passport;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Integer getPersonAge() {
		return personAge;
	}

	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge
				+ ", passport=" + passport + "]";
	}
	
	
	

}
