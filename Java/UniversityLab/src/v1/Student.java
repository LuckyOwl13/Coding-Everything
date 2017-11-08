package v1;

public class Student extends Person {
	
	private String major;

	public Student(Integer id,String firstName, String middleName, String lastName, String email, String ssn, Integer age,
			String major) {
		super(id,firstName, middleName, lastName, email, ssn, age);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String getStudies()
	{
		return major + "\n";
	}
	
	
	
}
