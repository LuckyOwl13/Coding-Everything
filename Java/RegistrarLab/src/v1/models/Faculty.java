package v1.models;

import java.util.ArrayList;
/**
 * Class used to store a collection of instructors in an ArrayList; 
 * acts as a faculty listing for a term
 * @author Keenan McElwee,
 */
public class Faculty {
	private ArrayList<Instructor> instructors = new ArrayList<Instructor>(); // collection of instructors in faculty
	/**
	 * Constructor of the class
	 */
	public Faculty() {
		this.instructors = new ArrayList<Instructor>(); // instantiates the instructors field with a new ArrayList
	}
	/**
	 * Getter for the instructors collection
	 * @return
	 */
	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}
	/**
	 * Adds the passed instructor to the instructors collection
	 * @param instructor the instructor object to be added to the instructors collection 
	 */
	public void addInstructor(Instructor instructor){
		instructors.add(instructor);
	}
}
