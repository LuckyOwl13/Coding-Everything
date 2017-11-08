/**
 * 
 */
package v1.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * People are complicated. This program allows us to quantify them.
 * 
 * @author Keenan Mcelwee, 
 *
 */
public class Person 
{
	// Arbitrary number used to identify a person. 
	private Integer id;
	// The person's first name.
	private String firstName;
	// The person's middle name.
	private String middleName;
	// The person's last name.
	private String lastName;
	// The person's email address.
	private String email;
	// The Social Security Number of the person.
	private String ssn;
	// The age of the person.
	private Integer age;
	// Whether the person is the oldest or not.
	private static Integer oldestAge;
	
	/**
	 * Constructor for the Person class.
	 * 
	 * @param id Arbitrary number used to identify a person.
	 * @param lastName The last name of the person.
	 */
	public Person(Integer id, String lastName) 
	{
		this.id = id;
		setLastName(lastName);
	}
	
	/**
	 * Access the person's first name.
	 * 
	 * @return The first name of the person.
	 */
	public String getFirstName() 
	{
		return firstName;
	}
	
	/**
	 * Set or change the person's first name.
	 * 
	 * @param firstName The first name of the person.
	 */
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	/**
	 * Access the person's middle name.
	 * 
	 * @return The middle name of the person.
	 */
	public String getMiddleName() 
	{
		return middleName;
	}
	
	/**
	 * Set or change the person's middle name
	 * 
	 * @param middleName The middle name of the person.
	 */
	public void setMiddleName(String middleName) 
	{
		this.middleName = middleName;
	}
	
	/**
	 * Access the person's last name.
	 * 
	 * @return The last name of the person.
	 */
	public String getLastName() 
	{
		return lastName;
	}
	
	/**
	 * Set or change the person's last name.
	 * 
	 * @param lastName The last name of the person.
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	/**
	 * Access the person's email address.
	 * 
	 * @return The email of the person.
	 */
	public String getEmail() 
	{
		return email;
	}
	
	/**
	 * Set or change the person's email address.
	 * 
	 * @param newEmail The email of the person.
	 */
	public void setEmail(String email) 
	{
		if (validateEmail(email)) 
		{
			this.email = email;
		}
	}
	
	/**
	 * Access the person's Social Security number.
	 * 
	 * @return The Social Security Number of the person.
	 */
	public String getSsn() 
	{
		return ssn;
	}
	
	/**
	 * Set or change the person's Social Security number.
	 * 
	 * @param newSsn The Social Security Number of the person.
	 */
	public void setSsn(String ssn) 
	{
		
		if (validateSsn(ssn))
		{
			this.ssn = ssn;
		}
	}
	
	/**
	 * Access the person's age
	 * 
	 * @return The age of the person.
	 */
	public Integer getAge() 
	{
		return age;
	}
	
	/**
	 * Set or change the person's age
	 * 
	 * @param newAge The age of the person.
	 */
	public void setAge(Integer age) 
	{
		if (validateAge(age))
		{
			this.age = age;			
		}
	}
	
	/**
	 * Access the person's Identification Number.
	 * 
	 * @return Arbitrary number used to identify a person.
	 */
	public Integer getId() 
	{
		return id;
	}
	
	/**
	 * Prevents invalid email addresses from being accepted.
	 * 
	 * @param email The email entered.
	 * @return Whether or not the email is valid
	 */
	public static boolean validateEmail(String email) 
	{
		boolean valid = false;
		String emailRE = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(emailRE);
		Matcher m = p.matcher(email);
		if (m.matches())
		{
			valid = true;		
		}
		else 
		{
			System.out.println("Error: Please enter a valid email addess.");
		}	
		return valid;
	}
	
	/**
	 * Prevents invalid Social Security Numbers from being accepted.
	 * 
	 * @param ssn The Social Security Number entered.
	 * @return Whether or not the ssn is valid.
	 */
	public static boolean validateSsn(String ssn) 
	{
		boolean valid = false;
		String ssnRE = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-"
				+ "(?!0000)[0-9]{4}$";
		Pattern p = Pattern.compile(ssnRE);
		Matcher m = p.matcher(ssn);
		if (m.matches())
		{
			valid = true;		
		}
		else 
		{
			System.out.println("Error: Please enter a valid SSN.");
		}	
		return valid;		
	}
	
	/**
	 * Confirms if the age entered is 16 or older.
	 * 
	 * @param age The age entered.
	 * @return Whether they are 16 or older.
	 */
	public static boolean validateAge(Integer age)
	{
		boolean valid = false;
		
		if (age > 16)
		{
			valid = true;
		}
		else
		{
			System.out.println("Is that realy your age? That's silly!");
		}
		return valid;		
	}
	
	/**
	 * Returns a String representation of the Person object.
	 * In this case the method is overridden to include the 
	 * person's first, middle, and last names.
	 */
	@Override
	public String toString() 
	{
		return "" + firstName + " " + middleName + " " + lastName;
	}
	
	/**
	 * Receive the domain of a person's email address.
	 * 
	 * @return The domain of the email address.
	 */
	public String getEmailDomain()
	{
		String[] emailArray = email.split("@");
		String domain = emailArray[1];
		return domain;		
	}
	
	/**
	 * We can use a the partial Social Security Number to verify the person's
	 * identity while also preventing unnecessary access to the entire number
	 * by the staff.
	 * 
	 * @return The last 4 digits of the person's Social Security Number.
	 */
	public String getLast4SSN()
	{
		String[] ssnArray = ssn.split("-");
		String ssn4 = ssnArray[2];
		return ssn4;
	}
	
	/**
	 * When placed in a group this allows to know if 
	 * the person is the oldest in that group.
	 * 
	 * @return Whether or not they are the oldest.
	 */
	public boolean isOldest()
	{
		if (oldestAge == null || age >= oldestAge)
		{
			oldestAge = age;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Access the class of a person object.
	 * 
	 * @return The class of the person
	 */
	public String getType()
	{
		return this.getClass().getSimpleName();
	}
	
	/**
	 * Returns information about a Person suitable for display
	 * @return formatted person info
	 */
	public String getInfo() {
		String info = this.toString() + " (" + this.getClass().getSimpleName() + ")";
		info += "\n" + this.getEmailDomain();
		info += "\n" + this.getLast4SSN();
		info += "\n" + (this.isOldest() ? "oldest" : "not oldest");
		return info;
	}	
	
	
	
	
}
