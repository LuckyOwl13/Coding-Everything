package v1.models;

import java.util.ArrayList;
/**
 * Class used to store a collection of courses in an ArrayList; 
 * acts as a course catalog for a term
 * @author Keenan McElwee,
 */
public class Catalog {
	private ArrayList<Course> courses = new ArrayList<Course>(); // the catalog's collection of courses 
	// constructors of the class, with and without a passed ArrayList of courses
	public Catalog() {
		this.courses = new ArrayList<Course>();
	}
	public Catalog(ArrayList<Course> courses) {
		this.courses = courses;
	}
	/**
	 * Getter for the collection of courses
	 * @return
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}
	/**
	 * Adds a Course object to the ArrayList
	 * @param course
	 */
	public void addCourse(Course course){
		courses.add(course);
	}
}
