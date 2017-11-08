
public class ListArrayBasedPlus extends ListArrayBased {

    public ListArrayBasedPlus() {
        super();
    }

    /**
     * If the array is full, makes array larger and then adds the new item
     * using super's add method.
     */
    @Override
    public void add(int index, Object item) {
        if (numItems == items.length) {
            resize();
        }
        super.add(index, item);
    }	// end add

    /**
     * Resizes the array.
     */
    private void resize() {
        Object[] temp = new Object[items.length * 2];

        for (int i = 0; i < numItems; i++) {
            temp[i] = items[i];
        }	// end for

        items = temp;
    }	// end resize

    public void reverse() {
        Object[] temp = new Object[items.length];

        for (int i = 0; i < numItems; i++) {
            temp[numItems - i - 1] = items[i];
        }	// end for

        items = temp;
    }	// end resize





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
