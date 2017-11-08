
public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface{
	// ********************************************************
	// Array-based implementation of the ADT list.
	// *********************************************************


	private static final int MAX_LIST = 3;
	protected String[] items;  // an array of list items
	protected int numItems;  // number of items in list

	public AscendinglyOrderedStringList()
	{
		items = new String[MAX_LIST];
		numItems = 0;
	}  // end default constructor

	public boolean isEmpty()
	{
		return (numItems == 0);
	} // end isEmpty

	public int size()
	{
		return numItems;
	}  // end size

	public void add(String item) throws  ListIndexOutOfBoundsException	{
		if (numItems == items.length) {	// resizes if needed
			resize();
		}	// end if

		int index = numItems;	// initialize index as highest just in case
		
		boolean placed = false;

		for (int i = 0; i < numItems && !placed; i++){		// find where new item will fit
			if (item.compareTo(items[i]) <= 0){
				index = i;
				placed = true;
			}	// end if
		}	// end for
		
		// make room for new element by shifting all items at positions >= index 
		// toward the end of the list (no shift if index == numItems+1)
		for (int pos = numItems-1; pos >= index; pos--)
		{
			items[pos+1] = items[pos];
		} // end for
		
		// insert new item
		items[index] = item;
		numItems++;
	} //end add

	public String get(int index)
			throws ListIndexOutOfBoundsException
	{
		if (index >= 0 && index < numItems)
		{
			return items[index];
		}
		else
		{
			// index out of range
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on get");
		}  // end if
	} // end get

	public void remove(int index)
			throws ListIndexOutOfBoundsException
	{
		if (index >= 0 && index < numItems)
		{
			// delete item by shifting all items at
			// positions > index toward the beginning of the list
			// (no shift if index == size)
			for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException

			{
				items[pos-1] = items[pos];
			}  // end for
			items[--numItems] = null;		// fixes memory leak
		}
		else
		{
			// index out of range
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on remove");
		}  // end if
	} //end remove

	/**
	 * Resizes the array.
	 */
	private void resize() {
		String[] temp = new String[items.length * 2];

		for (int i = 0; i < numItems; i++) {
			temp[i] = items[i];
		}	// end for

		items = temp;
	}	// end resize

	public void clear()
	{
		// Creates a new array; marks old array for garbage collection.
		items = new String[MAX_LIST];
		numItems = 0;
	} // end clear

	/**
	 * I chose to use Binary Search II 
	 */
	@Override
	public int search(String item) {
		int index = -1;
		
		int low = 0;
		int high = numItems - 1;
		int mid;	
		
		boolean success = false;	// has found what you're looking for

	// begin searching algorithm
		do{
			mid = (low + high) / 2;
			
			if (item.compareTo(items[mid]) <= 0){ high = mid; } // reduce range down
			else { low = mid + 1; } // reduce range up
			
		} while (low != high);
		
		if (item.compareTo(items[low]) == 0) { // if retrieved matches saught
			success = true;
			index = low;			
		}	// end if
		else if (item.compareTo(items[low]) < 0) { // if retrieved is larger than saught
			index = low;
		}	// end else-if
		else{	// if retrieved is smaller than saught
			index = low + 1;
		}	// end else		
	// end searching algorithm
		
		if (success) System.out.printf("Item %s was found at index %s\n",item,index);
		else System.out.printf("Item %s was not found, could be inserted at index %s\n",item,index);
		
		
		return index;
	}	// end search

	
    /**
     * Returns a string representation of what is stored in the array.
     */
    public String toString() {
        String returnString = "";

        for (int i = 0; i < numItems; i++) {
            returnString += " " + items[i].toString();
        }	// end for

        return returnString;
    } // end toString

















}
