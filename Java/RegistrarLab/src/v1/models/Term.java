package v1.models;

import java.util.ArrayList;
/**
 * Class used to store a collection of sections in an ArrayList and the term the student is looking at
 * @author Keenan McElwee, 
 */
public class Term {
	private ArrayList<Section> sections = new ArrayList<Section>(); // the collection of sections
	private String semester; // the semester this term is of
	/**
	 * Constructor of the class
	 * @param semester the semester this term is of
	 */
	public Term(String semester){
		this.sections = new ArrayList<Section>(); // instantiate the sections ArrayList
		this.semester = semester;
	}
	/**
	 * Getter for the term's section collection
	 * @return the term's section collection
	 */
	public ArrayList<Section> getSections() {
		return sections;
	}
	/**
	 * Setter for the term's section collection
	 * @param sections the term's section collection
	 */
	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}
	/**
	 * Getter for the term's semester name
	 * @return the term's semester name
	 */
	public String getSemester() {
		return semester;
	}
	/**
	 * Setter for the term's semester name
	 * @param semester the term's semester name
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}
	/**
	 * Adds a section to the term's section collection
	 * @param section the section to be added to the term's section collection
	 */
	public void addSection(Section section){
		sections.add(section);
	}
}
