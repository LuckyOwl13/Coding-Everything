/**
 * 
 */
package v1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mcelweek3
 *
 */
public class Person 
{
	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String ssn;
	private Integer age;
	
	private static Integer oldestAge;
	

	public Person(Integer id,String firstName, String middleName, String lastName, String email, String ssn,
			Integer age) 
	{
		this.id = id;
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setEmail(email);
		setSsn(ssn);
		setAge(age);
	}
	
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getMiddleName() 
	{
		return middleName;
	}
	/**
	 * @param middleName
	 */
	public void setMiddleName(String middleName) 
	{
		this.middleName = middleName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		if (validateEmail(email)) 
		{
			this.email = email;
		}
	}
	public String getSsn() 
	{
		return ssn;
	}
	public void setSsn(String ssn) 
	{
		
		if (validateSsn(ssn))
		{
			this.ssn = ssn;
		}
	}
	public Integer getAge() 
	{
		return age;
	}
	public void setAge(Integer age) 
	{
		if (validateAge(age))
		{
			this.age = age;			
		}
	}
	public Integer getId() 
	{
		return id;
	}
	
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
	public static boolean validateAge(Integer age)
	{
		boolean valid = false;
		
		if (age > 16 && age < 100)
		{
			valid = true;
		}
		else
		{
			System.out.println("Is that realy your age? That's silly!");
		}
		return valid;		
	}
	
	@Override
	public String toString() 
	{
		return "" + firstName + " " + middleName + " " + lastName;
	}
	
	
	public String getEmailDomain()
	{
		String[] emailArray = email.split("@");
		String domain = emailArray[1];
		return domain;		
	}
	
	public String getLast4SSN()
	{
		String[] ssnArray = ssn.split("-");
		String ssn4 = ssnArray[2];
		return ssn4;
	}
	
	public String isOldest()
	{
		if (oldestAge == null || age >= oldestAge)
		{
			oldestAge = age;
			return "oldest";
		}
		else
		{
			return "not oldest";
		}
	}
	
	public String getType()
	{
		return this.getClass().getSimpleName();
	}
	
	public String getStudies()
	{
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
