package v1;

public class Instructor extends Person {
	
	private String department;

	public Instructor(Integer id,String firstName, String middleName, String lastName, String email, String ssn, Integer age,
			String department) {
		super(id,firstName, middleName, lastName, email, ssn, age);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String getStudies()
	{
		return department + "\n";
	}
	
	
	
	
	
	
	
	
	
	
	
}
