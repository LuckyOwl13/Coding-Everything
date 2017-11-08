package v1;

/**
 * 
 * @author Ian Agostini, Keenan McElwee
 *
 */
public class Driver {
	public static void main (String[] args){
		Notebook notebook = new Notebook(); //Creates Notebook Arraylist
		notebook.addNote("1");// adds to the Arraylist
		notebook.addNote("2");
		notebook.addNote("3");
		notebook.addNote("4");
		notebook.addNote("5");
		notebook.addNote("6");
		notebook.getNotes(); 
		System.out.println(notebook.numberOfNotes()); //Prints the current number of elements in the array list or the Notes
		System.out.println(notebook.notes); 
		notebook.moveNoteMultiple(5,2); ///Moves the element in the 5th array slot to the 2rd array slot
		System.out.println(notebook.notes); ///Prints all the elements in order
		System.out.println(notebook.notes);
		notebook.moveNoteTop(2); ///Calls the moveNoteTop method to move the 2nd element in the array to the top
		System.out.println(notebook.notes);
		notebook.moveNoteToBottom(3); ///Calls the moveNoteToBottom method to move the 3nd element in the array to the bottom
		System.out.println(notebook.notes);
	}
}
