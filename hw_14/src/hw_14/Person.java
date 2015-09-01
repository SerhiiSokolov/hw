package hw_14;

public class Person
{
	int id;
	private String fName;
	String lName;
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
