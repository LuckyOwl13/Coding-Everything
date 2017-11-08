import java.util.ArrayList;

// ********************************************************
// Array-based implementation of the ADT list.
// *********************************************************
public class ListArrayListBased implements ListInterface
{

    protected ArrayList<Object> items;  // an array of list items

    public ListArrayListBased()
    {
        items = new ArrayList<Object>(3);
    }  // end default constructor

    public boolean isEmpty()
    {
        return items.isEmpty();
    } // end isEmpty

    public int size()
    {
        return items.size();
    }  // end size

    public void removeAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = new ArrayList<Object>();
    } // end removeAll

    public void add(int index, Object item)
    {
            items.add(index,item);
    } //end add

    public Object get(int index)
    throws ListIndexOutOfBoundsException
    {
            return items.get(index);
    } // end get

    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
            items.remove(index);
    } //end remove
}
