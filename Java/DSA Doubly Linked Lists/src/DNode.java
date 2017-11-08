//please note that this code is different from the textbook code, because the data is encapsulated!

public class DNode 
{
	private Object item;
	private DNode next;
	private DNode back;

	public DNode(Object newItem) 
	{
		item = newItem;
		next = null;
		back = null;
	} // end constructor

	public DNode(Object newItem, DNode nextNode) 
	{
		item = newItem;
		next = nextNode;
		back = null;
	} // end constructor

	public DNode(Object newItem, DNode nextNode, DNode backNode) {
		item = newItem;
		next = nextNode;
		back = backNode;
	}

	public void setItem(Object newItem) 
	{
		item = newItem;
	} // end setItem

	public Object getItem() 
	{
		return item;
	} // end getItem

	public void setNext(DNode nextNode) 
	{
		next = nextNode;
	} // end setNext

	public DNode getNext() 
	{
		return next;
	} // end getNext
	
	public void setBack(DNode back) {
		this.back = back;
	} // end setBack
	
	public DNode getBack() {
		return back;
	} // end getBack
} // end class Node