package v1.models;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * A type of section that is entirely online
 * @author Keenan McElwee, 
 */
public class Online extends Section{
	/**
	 * Constructor for the class
	 * @param instructor the section's instructor
	 * @param course the section's course
	 */
	public Online(Instructor instructor, Course course) {
		super(instructor, course); // call to super's constructor
	}
	/**
	 * Getter for the section's timeslots; this type of section does not
	 * have any, so returns "online".
	 * @return "Online" 
	 */
	@Override
	public String getSchedule() {
		return "Online";
	}

	@Override
	public boolean validateChoice() {
		int dialongButton = JOptionPane.YES_NO_OPTION;
		JFrame alert = new JFrame();
		int dialogResult = JOptionPane.showConfirmDialog(alert,"Remote classes require online connectivity and"
				+ " good time management skills. \n Are you sure you want to register for"
				+ " this class?","Online registration verification",dialongButton);
		
		if (dialogResult == 0){
			return true;
		}
		else{
			return false;
		}
	}

}
