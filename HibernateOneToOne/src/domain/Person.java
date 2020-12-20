package domain;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_id")
	private int personId;
	
	@Column(name="person_name")
	private String personName;
	
	@Column(name="person_age")
	private int personAge;
	
	//HAS-A relationship
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="passport_ref")
	private Passport passportRef;    //REF VARIABLE OF TYPE PASSPORT


	public int getPersonId() 
	{
		return personId;
	}


	public void setPersonId(int personId)
	{
		this.personId = personId;
	}


	public String getPersonName() 
	{
		return personName;
	}


	public void setPersonName(String personName) 
	{
		this.personName = personName;
	}


	public int getPersonAge() 
	{
		return personAge;
	}


	public void setPersonAge(int personAge) 
	{
		this.personAge = personAge;
	}


	public Passport getPassportRef() 
	{
		return passportRef;
	}


	public void setPassportRef(Passport passportRef) 
	{
		this.passportRef = passportRef;
	}
	
}


