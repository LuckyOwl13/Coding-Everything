package v1.models;

import java.util.HashMap;

/***
 * This program adds a little more substance to the Person Class.
 * It registers them as an Student.
 * 
 * @author Keenan McElwee, 
 *
 */
public class Student extends Person {
	
	// What field of study the student is working on.
	private String major;
	// the student's collection of sections they are enrolled in
	private HashMap<Integer,Section> currentSections = new HashMap<Integer,Section>();

	/**
	 * Constructor for the class that only needs id and lastName
	 * @param id student's id
	 * @param lastName student's last name
	 */
	public Student(Integer id, String lastName) {
		super(id, lastName);
	}
	/**
	 * Adds the passed section to the student's section collection
	 * @param section section to be added
	 */
	public void add(Section section){
		currentSections.put(section.getCrn(),section);
	}
	/**
	 * Adds the passed section to the student's section collection
	 * @param section section to be removed
	 */
	public void drop(Section section){
		currentSections.remove(section.getCrn(),section);
	}
	/**
	 * Getter for currentSections
	 * @return currentSections field
	 */
	public HashMap<Integer,Section> getCurrentSections(){
		return currentSections;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
