import java.util.ArrayList;

public class ListArrayListBasedPlus extends ListArrayListBased {

    public ListArrayListBasedPlus() {
        super();
    }

    /**
     * If the array is full, makes array larger and then adds the new item
     * using super's add method.
     */
    public void reverse() {
        ArrayList<Object> temp = new ArrayList<Object>(items.size());
        int numItems = items.size();

        for (int i = numItems - 1; i >= 0; i--) {
            temp.add(numItems - 1 - i,items.get(i));
        }	// end for

        items = temp;
    }	// end resize





    /**
     * Returns a string representation of what is stored in the array.
     */
    public String toString() {
        String returnString = "";
        int numItems = items.size();

        for (int i = 0; i < numItems; i++) {
            returnString += " " + items.get(i).toString();
        }	// end for

        return returnString;
    } // end toString






}
