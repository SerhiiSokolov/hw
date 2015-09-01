package person;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Person", uniqueConstraints={
		@UniqueConstraint(columnNames="ID")})

public class Person implements Serializable 
{
	private static final long serialVersionUID = -589231406593570500L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false,length = 100)
	int id;
	
	@Column(name="FirstName", unique=false, nullable=true, length = 100)
	private String fName;
	
	@Column(name="LastName", unique=false, nullable=true, length = 100)
	String lName;
	
	@Column(name="age", unique=false, nullable=true, length = 100)
	int age;
	
	public void setId(int id) {
		this.id = id;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setAge(int age) {
		this.age = age;
	}	
	
	public int getId() {
		return id;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public int getAge() {
		return age;
	}
	
	public Person() 
	{
		//
	}	
	
	public Person(int id, String fName, String lName, int age) 
	{
		this.id    = id;
		this.fName = fName;
		this.lName = lName;
		this.age   = age;
	}

	public Person(String fName, String lName, int age) 
	{
		this.fName = fName;
		this.lName = lName;
		this.age   = age;
	}
	
	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + "]";
	}
}
