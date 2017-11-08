import java.util.ArrayList;

public class Notebook {
	public ArrayList<String> notes;
	
	public Notebook(){
		notes = new ArrayList<String>();
	}
	public ArrayList<String> getNotes(){
		return notes;
	}
	
	public void addNote(String newNote){
		boolean found = false;
		for (String oldNote : notes){
			if (oldNote.equals(newNote)){
				found = true;
			}
		}
		if (!found){
			notes.add(newNote);
		}
		
	}
	
	public int numberOfNotes(){
		return notes.size();
	}
	
	public void deleteNote(int index ){
		notes.remove(index);
	}
	
	public int getNoteNumber(String note){
		int index = -1;
		int counter = 0;
		for (String noteName : notes){
			if (noteName.equals(note)){
				index = counter; 
			}
			counter++;
		}
		return index;
	}
	
	public String getNote(int index){
		return notes.get(index);
	}
	
	public void setNote(int index,String newNote){
		notes.set(index, newNote);
	}
	
	public void moveNoteUp(int index){
		String toUp = notes.get(index);
		String toDown = notes.get(index-1);
		
		this.setNote(index-1,toUp);
		this.setNote(index,toDown);
	}
	
	public void moveNoteDown(int index){
		String toDown = notes.get(index);
		String toUp = notes.get(index+1);
		
		this.setNote(index+1,toDown);
		this.setNote(index,toUp);
	}
	
	public void moveNoteMultiple(int index,int moveCount){
		int indexNew = index; 
		if (moveCount > 0)
		{		
			for (int moves = moveCount; moves > 0 ;moves--){
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
	
	public void moveNoteToBottom(int index)
	{
		this.moveNoteMultiple(index, index-notes.size()+1);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
