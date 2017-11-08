package v1.models;
/**
 * Abstract concept of a section, a discreet group of students learning a course 
 * taught by an instructor at certain times and/or online
 * @author Keenan McElwee, 
 */
public abstract class  Section {
	private Integer crn; 			// the section's crn
	private Course course;			// the section's course
	private Instructor instructor;	// the section's instructor
	
	private static int nextCRN = 40001; // starts off the CRN count for all sections at 40001. Each section
										// has its own unique CRN, the lowest being 40001 and increasing.
	/**
	 * Constructor for the course
	 * @param instructor
	 * @param course
	 */
	public Section(Instructor instructor, Course course) {
		// sets the CRN as the current value of nextCRN, which is then incremented so no section has the same CRN
		this.crn = nextCRN++;
		// set the instance's corresponding fields with the passed values
		this.course = course;
		this.instructor = instructor;
	}
	/**
	 * Getter for the section's CRN
	 * @return crn
	 */
	public Integer getCrn() {
		return crn;
	}
	/**
	 * Setter for the section's CRN
	 * @param crn the CRN for the section
	 */
	public void setCrn(Integer crn) {
		this.crn = crn;
	}
	/**
	 * Getter for the section's course
	 * @return the section's course
	 */
	public Course getCourse() {
		return course;
	}
	/**
	 * Setter for the section's course
	 * @param course the course for the section
	 */
	public void setCourse(Course course) {
		this.course = course;
	}
	/**
	 * Getter for the section's instructor
	 * @return the section's instructer
	 */
	public Instructor getInstructor() {
		return instructor;
	}
	/**
	 * Setter for the section's instructor
	 * @param instructor the instructor for the section
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	/**
	 * Abstract method where the section returns the string form of its schedule
	 * @return the string form of the section's schedule
	 */
	public abstract String getSchedule();
	/**
	 * Abstract method where the section returns if the user is okay with the section's online components
	 * @return true if yes, false if no
	 */
	public abstract boolean validateChoice();
	
}
