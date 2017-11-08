package v1;
import java.util.ArrayList;

public class Notebook 
{
	ArrayList<String> notes;
	
	public Notebook()
	{
		notes = new ArrayList<String>();
	}
	public ArrayList<String> getNotes()
	{
		return notes;
	}
	
	public void addNote(String newNote)
	{
		boolean found = false;
		for (String oldNote : notes)
		{
			if (oldNote.equals(newNote))
			{
				found = true;
			}
		}
		if (!found)
		{
			notes.add(newNote);
		}
		
	}
	
	public int numberOfNotes()
	{ //when called this method returns the number of elements in the NoteBook Array
		return notes.size();
	}
	
	public void deleteNote(int index )
	{ //Removes an element of the array
		notes.remove(index);
	}
	
	public int getNoteNumber(String note)
	{ //gets the note number
		int index = -1;
		int counter = 0;
		for (String noteName : notes)
		{
			if (noteName.equals(note))
			{
				index = counter; 
			}
			counter++;
		}
		return index;
	}
	
	public String getNote(int index)
	{
		return notes.get(index);
	}
	
	public void setNote(int index,String newNote)
	{
		notes.set(index, newNote);
	}
	
	public void moveNoteUp(int index)
	{ ///when called moves an elemnt up one element
		String toUp = notes.get(index);
		String toDown = notes.get(index-1);
		
		this.setNote(index-1,toUp);
		this.setNote(index,toDown);
	}
	
	public void moveNoteDown(int index)
	{ ////when called moves an element down one element 
		String toDown = notes.get(index);
		String toUp = notes.get(index+1);
		
		this.setNote(index+1,toDown);
		this.setNote(index,toUp);
	}
	
	public void moveNoteMultiple(int index,int moveCount)
	{ ///moves an element to the nth place where nth is the moveCount
		int indexNew = index; 
		if (moveCount > 0)///if moveCount is positive then it moves the element up in the array, if negative it moves it down
		{		
			for (int moves = moveCount; moves > 0 ;moves--)
			{
				this.moveNoteUp(indexNew);
				indexNew--;
			}				
		}
		else if (moveCount < 0)
		{
			for (int moves = -moveCount; moves > 0 ;moves--)
			{
				
				this.moveNoteDown(indexNew);
				indexNew++;
			}
		}
	}
	
	public void moveNoteToBottom(int index) ///moves an element to the very last place in an array
	{
		this.moveNoteMultiple(index, index-notes.size()+1);		
	}
	
	public void moveNoteTop(int index)
	{ //moves an element to the first place in the array
		moveNoteMultiple (index,index);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

