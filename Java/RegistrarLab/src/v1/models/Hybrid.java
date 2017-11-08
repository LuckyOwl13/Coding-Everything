package v1.models;

import javax.swing.*;
/**
 * A type of section that has one in-person timeslot and an online component
 * @author Keenan McElwee, 
 */
public class Hybrid extends Section{
	private Timeslot classTime; // the section's in-person timeslot

	/**
	 * Constructor of the class
	 * @param instructor the section's professor
	 * @param course the section's course
	 * @param classTime the section's in-person timeslot
	 */
	public Hybrid(Instructor instructor, Course course, Timeslot classTime) {
		super(instructor, course); // call to superconstructor
		this.classTime = classTime;
	}
	/**
	 * Getter for the section's timeslot
	 * @return Timeslot the section's timeslot
	 */
	public Timeslot getClassTime() {
		return classTime;
	}
	/**
	 * Setter for the section's timeslot
	 * @param classTime the section's timeslot
	 */
	public void setClassTime(Timeslot classTime) {
		this.classTime = classTime;
	}
	/**
	 * Returns the string form of the section's in-person timeslot.
	 * @return the section's in-person timeslot's string form.
	 */
	@Override
	public String getSchedule() {
		return classTime.toString();
	}
	/**
	 * Checks with the user if they are okay with taking a class with an online component.
	 * @return the user's decision in boolean (yes == true, no == false)
	 */
	@Override
	public boolean validateChoice() {
		int dialongButton = JOptionPane.YES_NO_OPTION;
		JFrame alert = new JFrame();
		int dialogResult = JOptionPane.showConfirmDialog(alert,"Remote classes require online"
				+ " connectivity. \n Are you sure you want to register for this class?",
				"Hybrid registration verification",dialongButton);
		
		if (dialogResult == 0){
			return true;
		}
		else{
			return false;
		}
	}
}
