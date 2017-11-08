package v1.models;

/***
 * This program adds a little more substance to the Person Class.
 * It registers them as an Instructor.
 * 
 * @author Keenan McElwee, 
 *
 */
public class Instructor extends Person {

	/**
	 * Constructor of the class
	 * @param id the instructor's id
	 * @param lastName the instructor's last name
	 */
	public Instructor(Integer id,String lastName) {
		super(id, lastName);
	}
	/**
	 * Returns a string form of the instructor's information
	 * @return the instructor's info
	 */
	@Override
	public String getInfo() {
		String info = super.getInfo();
		return info;
	}
	
}
