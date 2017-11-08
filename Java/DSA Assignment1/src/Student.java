/**
 * 
 */

/**
 * @author Keenan
 *
 */
public class Student {

	private String firstName;
	private String lastName;
	private String ssn;
	private String birthday;
	private int credits;
	private String major;
	private String minor;
	
	public Student(String firstName, String lasName, String ssn, 
			String birthday, int credits, String major,	String minor) {
		this.firstName = firstName;
		this.lastName = lasName;
		this.ssn = ssn;
		this.birthday = birthday;
		this.credits = credits;
		this.major = major;
		this.minor = minor;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lasName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @return the minor
	 */
	public String getMinor() {
		return minor;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	
	
	
	
	
	
	
}
