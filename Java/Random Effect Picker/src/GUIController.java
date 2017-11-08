import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIController {
	/**	The GUI used by the controller **/
	private MainIndivGUI main;
	/**	A panel for the GUI **/
	private PersonPanel pers;
	/**	A panel for the GUI **/
	private ScoresPanel scores;
	/**	A panel for the GUI **/
	private HighLowPanel highLow;
	
	/**
	 * Constructor for the class
	 * @param people
	 */
	public IndivGUIController(ArrayList<Person> people){
		main = new MainIndivGUI();	// instantiate the GUI and panels
		pers = new PersonPanel(people);
		scores = new ScoresPanel();
		highLow = new HighLowPanel();
		
		// add an action listener to pers
		pers.getPeople().addActionListener(new PeopleListener());
		
		main.add(pers,BorderLayout.NORTH);		// add panels to the GUI 
		main.add(scores,BorderLayout.CENTER);	
		main.add(highLow,BorderLayout.SOUTH);
		
		main.setVisible(true);	// make GUI visible
	}	// end Constructor
	
	/**
	 * Sublclass to handle pers's actionListener
	 * @author Caitlin McElwee
	 */
	class PeopleListener implements ActionListener{
		@Override
		/**
		 * Takes the selected person and updates the panels to display that
		 * person's scores in the selected order.
		 */
		public void actionPerformed(ActionEvent e) {
			Person per = pers.getSelectedPerson();	// The currently selected person
			
			scores.populate(per,pers.getAlphabet().isSelected());	// displays the person's scores alphabetically or 
																	// descendingly, whichever is selected
			highLow.setHighLow(per);	// displays that person's highest and lowest scores
		}	// end actionPerformed
	}	// end PeopleListener
}
