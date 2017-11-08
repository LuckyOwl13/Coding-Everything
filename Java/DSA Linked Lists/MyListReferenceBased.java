
public class MyListReferenceBased implements ListInterface {
	private Node head;


	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	@Override
	public boolean isEmpty() {
		if (head == null) return true;
		else return false;
	}	// end isEmpty


	@Override
	public int size() {
		int count = 0;
		Node current = head;

		while (current != null){
			count++;
			current = current.getNext();
		}

		return count;
	}	// end size


	private Node find(int index){
		Node current = head;

		while (index-- > 0){
			current = current.getNext();
		}

		return current;
	}	// end find


	@Override
	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		if (index <= size()){
			if (index != 0){
				Node prev = find(index - 1);		
				prev.setNext(new Node(item,prev.getNext()));
			}	// end if
			else{
				head = new Node(item,head);
			}	// end else
		}	// end if
		else{
			System.out.println("MLRB Class says Position specified is out range!");
		}
	}	// end add


	@Override
	public Object get(int index) throws ListIndexOutOfBoundsException {
		if (index <= size()){
			return find(index).getItem();
		}	// end if
		else{
			System.out.println("MLRB Class says Position specified is out range!");
		}	// end else
		return null;
	}	// end get


	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		if (index < size()){
			if (index != 0){
				Node prev = find(index - 1);		
				prev.setNext(prev.getNext().getNext());
			}	// end if
			else{
				head = head.getNext();
			}	// end else
		}	// end if
		else{
			System.out.println("MLRB Class says Position specified is out range!");
		}	// end else
	}	// end remove


	@Override
	public void removeAll() {
		head = null;
	}	// end removeAll


	public String toString(){
		String returnString = "";
		Node current = head;

		while (current != null){
			returnString += " " + current.getItem();
			current = current.getNext();
		}

		return returnString;
	}



















}
