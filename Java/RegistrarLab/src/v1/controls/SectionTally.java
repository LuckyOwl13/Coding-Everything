package v1.controls;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import v1.models.Catalog;
import v1.models.Department;
import v1.models.Faculty;
import v1.models.Section;
import v1.models.Student;
import v1.models.Term;
import v1.views.BottomPanel;
import v1.views.MiddlePanel;
import v1.views.RegistrarGUI;
import v1.views.TopPanel;
/**
 * Acts the the controller for everything going on in this application. Declares and instantiates
 * a window for an application used by students to look up, add, and drop courses.
 * @author Keenan
 *
 */
public class SectionTally {
	
	private RegistrarGUI registrar; // The GUI to be used
	private TopPanel top;			// The panel that goes at the top of the RegistrarGUI
	private MiddlePanel middle;		// The panel that goes at the middle of the RegistrarGUI
	private BottomPanel bottom;		// The panel that goes at the bottom of the RegistrarGUI
	
	private Student studen;			// Student who is interacting with Banner services
	
	private String sectionsFound;	// String to go in bottom to state how many sections are found for the selected department 
	
	/**
	 * Constructor for the class
	 * @param ter	the term the student is looking at
	 * @param studen	the student using Banner services
	 */
	public SectionTally(Term ter,Student studen){
		//initialize studen as the passed Student
		this.studen = studen;
		
		// initialize the Top-, Middle-, and BottomPanels
		top = new TopPanel();
		middle = new MiddlePanel();
		bottom = new BottomPanel();
		// initialize the RegistrarGUI using the passed variables and the newly instantiated panels
		registrar = new RegistrarGUI(studen,ter,top,middle,bottom);
		
		/**
		 * Instantiate and add a new, anonymous ActionListener to top's JComboBox
		 */
		top.getDepartments().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// clear middle so as to start fresh
				middle.removeAll();
				
				// checks if the blank option is selected - if so, resets the window to like-new and skips to the end
				if (((TopPanel.ComboItem) top.getDepartments().getSelectedItem()).getValue() == Department.NONE){
					registrar.setSize(RegistrarGUI.getMindowWidth(), RegistrarGUI.getMindowHeight());; // Make RegistrarGUI Normal-Sized Again
					bottom.getBottomText().setText("Matching Sections"); // sets the text displayed at the window's bottom back to origional
				}
				else{  // if any other option is selected
					
					// if middle is empty (e.g "____" was selected last, add in the
					// column labels
					if (middle.getComponentCount() == 0){
						// instantiate the column labels and the JPanel they'll be in
						JPanel firstSection = new JPanel();
						JLabel crn = new JLabel("Click CRN to add or drop course");
						JLabel num = new JLabel("Course Number");
						JLabel tit = new JLabel("Title");
						JLabel ins = new JLabel("Instructor");
						JLabel sch = new JLabel(("Schedule"));
						// Make the headers blue (for funsies)
						crn.setForeground(Color.BLUE);
						num.setForeground(Color.BLUE);
						tit.setForeground(Color.BLUE);
						ins.setForeground(Color.BLUE);
						sch.setForeground(Color.BLUE);
						// add the labels to the panel
						firstSection.setLayout(new GridLayout(1,5));
						firstSection.add(crn);
						firstSection.add(num);
						firstSection.add(tit);
						firstSection.add(ins);
						firstSection.add(sch);
						// give panel a border to separate it from the listed sections
						firstSection.setBorder(new LineBorder(Color.GRAY));
						firstSection.setBackground(Color.WHITE);
						// add the header panel to middle
						middle.add(firstSection);
					}
					// set up local variables: what department was selected, prepare for sections changing colors,
					// prepare for counting # of panels in a department.
					Department dept = ((TopPanel.ComboItem) top.getDepartments().getSelectedItem()).getValue(); 
					boolean isYellow = false;
					int sectionCount = 0;
					// iterate through all sections
					for(Iterator<Section> it = ter.getSections().iterator(); it.hasNext(); ){
						Section nextSect = it.next();
						// those which are in the selected department are added to the display
						if (nextSect.getCourse().getDepartment() == dept){
							CRNButton crnBut = new CRNButton(nextSect); // Instantiate new CRNButton for the section
							// set up the panel that will hold the CRNButton
							JPanel crnButPanel = new JPanel();
							crnButPanel.setLayout(new FlowLayout());
							crnButPanel.add(crnBut);
							// set up the section's panel
							JPanel nextSection = new JPanel();
							nextSection.setLayout(new GridLayout(1,5));
							nextSection.setBorder(new LineBorder(Color.GRAY));
							nextSection.add(crnButPanel);		//crn
							nextSection.add(new JLabel(nextSect.getCourse().getCourseNumber()));	//number
							nextSection.add(new JLabel(nextSect.getCourse().getTitle()));	//title
							nextSection.add(new JLabel(nextSect.getInstructor().getLastName()));	//instructor
							nextSection.add(new JLabel(nextSect.getSchedule()));	//schedule
							// makes sections alternate between yellow and white, then adds to middle
							middle.add(nextSection);
							if (!isYellow){
								crnButPanel.setBackground(Color.WHITE);
								nextSection.setBackground(Color.WHITE);
							}
							else{
								crnButPanel.setBackground(Color.YELLOW);
								nextSection.setBackground(Color.YELLOW);
								
							}
							isYellow = !isYellow; // set so that next panel alternates color
							sectionCount++;  // update the counter for sections
						}
					}
					// not registered in any sections means bottomText states how many sections are 
					// displayed with the department selected; the bottom text is updated to display this
					if (studen.getCurrentSections().keySet().size() <= 0){
						sectionsFound = sectionCount + " sections of " + getDeptString(dept) + " found.";
						bottom.getBottomText().setText(sectionsFound);
					}
					// set the registrar's size to fit the contents
					registrar.pack();
					registrar.setSize(RegistrarGUI.getMindowWidth(), registrar.getHeight());
				}
				registrar.setVisible(true);
			}
		});
	}
	//end constructor -------------------------------------------------------------------------------
	
	
	/**
	 * Custom button for sections put on display
	 * @author Keenan McElwee, 
	 */
	class CRNButton extends JButton{
		Section sect; // the section the button is for
		// constructor of the class
		public CRNButton(Section sect){
			super(sect.getCrn() + ""); // the button's label is the section's CRN
			this.sect = sect; // initialize the button's section storage
			this.addActionListener(new CRNListener(this)); // give this button a CRNListener
		}
		/**
		 * Returns the button's stored section's CRN
		 * @return String the stored section's CRN
		 **/
		public String getCRN(){
			return sect.getCrn().toString();
		}
		/**
		 * Returns the stored section
		 * @return Section the stored section
		 */
		public Section getSection(){
			return sect;
		}
		
		/**
		 * Listener for CRN Button to add-drop sections
		 * @author Keenan McElwee, 
		 */
		class CRNListener implements ActionListener{
			CRNButton crnBut; 	// the button an instance listens to
			Section sectio; 	// section this button is for
			/**
			 * Constructor for the class
			 * @param crnBut the button an instance listens to
			 */
			public CRNListener(CRNButton crnBut) {
				this.crnBut = crnBut;
				this.sectio = crnBut.getSection();
			}
			/**
			 * What to do when the button is pressed. If the section has an online component,
			 * the user is prompted if that is okay. If yes or the section does not have such
			 * a component, the section is added to the bottom text and the student's collection
			 * of added sections. If the button was for a section already in the collection,
			 * then the section is instead removed and bottom text is updated accordingly.
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// String to be added to bottomText when section is added by student
				String sectString = sectio.getCrn()+ " " + sectio.getCourse().getTitle();
				
				JLabel bottomText = bottom.getBottomText(); // JLabel to be updated during add/drop
				String bottomString = bottomText.getText(); // bottomText's current String displayed
				
				// Check to see if the section is already enrolled 
				boolean enrolled = false;
				if(studen.getCurrentSections().containsValue(sectio)) enrolled = true;
				
				// if the section is not enrolled, it is then added
				if(!enrolled && sectio.validateChoice()){
					studen.add(sectio);	// adds section to student's currentSections collection
					// clears bottomText if it does not list any sections, then apppends the newly added section 
					if  (bottomText.getText().contains("sections of")) bottomText.setText(sectString);
					else bottomText.setText(bottomText.getText() + "," + sectString);
				}
				else{ // section is dropped
					
					studen.drop(sectio);// drops section to student's currentSections collection
					
					// potential sections in bottomText are separated by "," and put into an array,
					// which is used to instantiate an ArrayList to iterate through
					String[] sectArray = bottomString.split(",");  
					ArrayList<String> sectList = new ArrayList<String>(Arrays.asList(sectArray)); 
					for(Iterator<String> it = sectList.iterator(); it.hasNext();){
						// if a 
						if(it.next().equals(sectString)){
							it.remove();
						}
					}
					bottomText.setText(""); // clear bottomText
					if(studen.getCurrentSections().size() <= 0){ // no sections registered
						bottomText.setText(sectionsFound);
					}
					else{ // there are still sections left for the student
						bottomText.setText(sectList.get(0)); // appends the first section to bottomText
						
						int i = 1; // initialize a counter (starts at 1 because the 0th already performed) 
						while(i < sectList.size()){ // if more than one section left
							bottomText.setText(bottomText.getText() + "," + sectList.get(i)); // add rest of the sections
							i++; // move to next section
						}
					}
				}
			}
		}
	}
	
	
	
	/**
	 * Returns a String to be put in the bottom text depending on which department is passed
	 * @param dept the selected department
	 * @return formatted String form of passed department
	 */
	private String getDeptString(Department dept) {
		String deptString = "";
		// determiner of department
		switch(dept){
		case ART: deptString = "Art";
			break;
		case BIOLOGY: deptString = "Biology";
			break;
		case CHEMISTRY: deptString = "Chemistry";
			break;
		case COMPUTER_SCIENCE: deptString = "Computer Science";
			break;
		case ECONOMICS: deptString = "Economics";
			break;
		case ENGLISH: deptString = "English";
			break;
		case HISTORY: deptString = "History";
			break;
		case MUSIC: deptString = "Music";
			break;
		case MATHEMATICS: deptString = "Mathematics"; 
			break;
		case PHILOSOPHY: deptString = "Philosophy";
			break;
		case PHYSICS: deptString = "Physics";
			break;
		case PSYCHOLOGY: deptString = "Psychology"; 
			break;
		default: System.err.println("I've made a mistake");
			break;
		}			
		return deptString;
	}
}
