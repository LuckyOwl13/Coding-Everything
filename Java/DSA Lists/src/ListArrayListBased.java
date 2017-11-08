import java.util.ArrayList;

// ********************************************************
// Array-based implementation of the ADT list.
// *********************************************************
public class ListArrayListBased implements ListInterface
{

    private static final int MAX_LIST = 3;
    protected ArrayList<Object> items;  // an array of list items
    protected int numItems;  // number of items in list

    public ListArrayListBased()
    {
        items = new ArrayList<Object>(MAX_LIST);
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

    public void removeAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = new ArrayList<Object>(MAX_LIST);
        numItems = 0;
    } // end removeAll

    public void add(int index, Object item)
    {
//        if (numItems == items.length)		// fixes implementation errors, programming style
//        {
//            throw new ListException("ListException on add");
//        }  // end if
    	// The above block is broken because ArrayLists do not have a way to access the length of its array.
    	
        if (index >= 0 && index <= numItems)
        {
//            // make room for new element by shifting all items at
//            // positions >= index toward the end of the
//            // list (no shift if index == numItems+1)
//            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
//            {
//                items[pos+1] = items[pos];
//            } // end for
//            // insert new item
//            items[index] = item;
        		// The above code is depricated because the ArrayList will handle all of this.
        	items.add(index,item);
        	numItems++;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }  // end if

    	
    } //end add

    public Object get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items.get(index);
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
//            // delete item by shifting all items at
//            // positions > index toward the beginning of the list
//            // (no shift if index == size)
//            for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
//
//            {
//                items[pos-1] = items[pos];
//            }  // end for
//            items[--numItems] = null;		// fixes memory leak
        	// The above block is depricated because the ArrayList handles all of this.
        	items.remove(index);
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove
}
