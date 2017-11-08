import java.util.ArrayList;

public class ListArrayListBasedPlus extends ListArrayListBased {

    public ListArrayListBasedPlus() {
        super();
    }

    /**
     * If the array is full, makes array larger and then adds the new item
     * using super's add method.
     */
    @Override
    public void add(int index, Object item) {
//        if (numItems == items.length) {
//            resize();
//        }
			// This block is depricated because ArrayList already handles this.
        super.add(index, item);
    }	// end add
    
//    /**
//     * Resizes the array.
//     */
//    private void resize() {
//        Object[] temp = new Object[items.length + 3];
//
//        for (int i = 0; i < numItems; i++) {
//            temp[i] = items[i];
//        }	// end for
//
//        items = temp;
//    }	// end resize
	// This method is depricated because ArrayList already handles this.

    public void reverse() {
        ArrayList<Object> temp = new ArrayList<Object>(items.size());

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

        for (int i = 0; i < numItems; i++) {
            returnString += " " + items.get(i).toString();
        }	// end for

        return returnString;
    } // end toString






}
