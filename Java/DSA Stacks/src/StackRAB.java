
public class StackRAB<T> implements StackInterface<T> {
    private T[] items;  // an array of list items
    private int top;  // number of items in list



    @SuppressWarnings("unchecked")
    public StackRAB() {
        items = (T[]) new Object[3];
        top = -1;
    }

    /**
     * Adds an item to the stack
     * @param item the item to add to the stack
     */
    public void push(T item) throws StackException  {
        if (top + 1 == items.length) {
            resize();
        }
        items[++top] = item;
    }	// end push

    /**
     * Resizes the array.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        T [] temp = (T[]) new Object[(int) (items.length * 1.5)];

        for (int i = 0; i <= top; i++) {
            temp[i] = items[i];
        }	// end for

        items = temp;
    }	// end resize

    /**
     * Returns the top item.
     * @return the top item
     */
    public T peek() {
        if (top != -1) return items[top];
        else throw new StackException("nothing to peek");
    } // end peek

    /**
     * Removes and returns the top item.
     * @return the top item
     */
    public T pop() {
        if (top != -1) {
            T item = items[top];
            items[top--] = null;
            return item;
        }	// end if
        else {
            throw new StackException("nothing to peek");
        }	// end else
    }	// end pop

    @Override
    public boolean isEmpty() {
        return top == -1;
    }	// end isEmpty

    @SuppressWarnings("unchecked")
    @Override
    public void popAll() {
        items = (T[]) new Object[3];
        top = -1;
    }	// end popAll

    public String toString() {
        String returnString = "";
        for (T item : items) {
            returnString += " " + item.toString();
        }
        return returnString;
    }	// end toString




















}
