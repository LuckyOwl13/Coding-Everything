
public class ListCDLSBased implements ListInterface {
	private DNode head;
	private int numItems;


	public DNode getHead() {
		return head;
	}	// end getHead

	public void setHead(DNode head) {
		this.head = head;
	}	// end setHead

	@Override
	public boolean isEmpty() {
		return (numItems == 0);
	}	// end isEmpty

	@Override
	public int size() {
		return numItems;
	}	// end size


	private DNode find(int index){
		DNode current = head;
		if (index < numItems/2){		
			while (index-- > 0){
				current = current.getNext();
			}
		}
		else{
			int count = numItems - index + 1;
			while (count-- > 0){
				current = current.getBack();
			}
		}
		return current;
	}	// end find

	@Override
	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		if (index <= numItems && index >= 0){
			if (index != 0){
				DNode prev = find(index - 1);
				DNode aft = prev.getNext();

				DNode newNode = new DNode(item,prev.getNext(),prev);

				prev.setNext(newNode);
				aft.setBack(newNode);

			}	// end if
			else{
				if (head != null){ 
					DNode prevHead = head;
					head = new DNode(item,head,head.getBack());
					prevHead.getBack().setNext(head);;
					prevHead.setBack(head);
				}	// end if
				else{
					head = new DNode(item,null,null);
					head.setBack(head);
					head.setNext(head);
				}	// end else
			}	// end else
			numItems++;
		}	// end if
		else{
			System.out.println("ListCDLSBased Class says Position specified is out range!");
		}
	}	// end add

	@Override
	public DNode get(int index) throws ListIndexOutOfBoundsException {
		if (index <= numItems && index >= 0){
			return find(index);
		}	// end if
		else{
			System.out.println("ListCDLSBased Class says Position specified is out range!");
			return null;
		}	// end else
	}	// end get

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		if (index <= numItems && index >= 0){
			if (index != 0){
				DNode prev = find(index - 1);
				DNode aft = prev.getNext().getNext();
				prev.setNext(aft);
				aft.setBack(prev);

			}	// end if
			else{
				DNode aft = head.getNext();
				aft.setBack(head.getBack());
				head = aft;
			}	// end else
			numItems--;
		}	// end if
		else{
			System.out.println("ListCDLSBased Class says Position specified is out range!");
		}	// end else
	}	// end remove

	@Override
	public void removeAll() {
		head = null;
	}	// end removeAll
	
	@Override
	public String toString(){
		String returnString = "";		
		DNode current = head;

		do{
			returnString += " " + current.getItem();
			current = current.getNext();
		}while (current != head);

		return returnString;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
