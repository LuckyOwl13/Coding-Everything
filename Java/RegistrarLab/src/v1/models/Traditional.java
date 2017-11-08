package v1.models;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * A type of section that has two in-person timeslots and no online component
 * @author Keenan McElwee, 
 */
public class Traditional extends Section {

	private Timeslot[] classTimes; // the section's in-person timeslots
	/**
	 * Constructor of the class
	 * @param instructor the section's instructor
	 * @param course the section's course
	 * @param class1 the section's first in-person timeslot
	 * @param class2 the section's second in-person timeslot
	 */
	public Traditional(Instructor instructor, Course course, Timeslot class1, Timeslot class2) {
		super(instructor, course); // calls to the super's constructor
		this.setClassTimes(new Timeslot[]{class1,class2}); // sets the passed timeslots
	}
	/**
	 * Getter for the section's in-person timeslots
	 * @return
	 */
	public Timeslot[] getClassTimes() {
		return classTimes;
	}
	/**
	 * setter for the section's in-person timeslots
	 * @param classTimes
	 */
	public void setClassTimes(Timeslot[] classTimes) {
		this.classTimes = classTimes;
	}
	/**
	 * Returns a formatted string form of the section's two timeslots 
	 */
	@Override
	public String getSchedule() {
		return classTimes[0] + ", " + classTimes[1];
	}
	/**
	 * Checks with the user if they are okay with taking a class with an online component.
	 * This type of section does not have an online component, so returns true
	 * @return true
	 */
	@Override
	public boolean validateChoice() {
		return true;
	}
	
}
