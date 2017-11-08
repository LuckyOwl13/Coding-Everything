
public class Driver {
	public static void main (String[] args){
		Notebook notebook = new Notebook();
		for (int index = 1;index <=10;index++)
		{
			notebook.addNote("" + index);
		}
		notebook.getNotes();
		System.out.println(notebook.notes);
		//notebook.moveNoteToBottom(0);
		//System.out.println(notebook.getNote(2));
		//notebook.moveNoteMultiple(3,2);
		System.out.println(notebook.notes);
		for (int index = 1;index < 10;index++)
		{
			notebook.moveNoteToBottom(0);
			System.out.println(notebook.notes);
		}
	}
}
