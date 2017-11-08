import java.awt.List;

/*
 * Purpose: Data Structure and Algorithms Lab 2
 * Status: Complete and thoroughly tested
 * Last update: 09/19/16
 * Submitted:  09/20/16
 * Comment: test suite and sample run attached
 * @author: Tom Harker
 * @version: 2016.09.19
 */
public class ListArrayBasedPlus extends ListArrayBased {
	/**
	 * Adds an item to the given index of the array.
	 * Shifts and resizes the array if necessary.
	 */
	public void add(int index, Object item) {
		if (numItems == items.length) {
			resize();
		}
		super.add(index, item);
	}
	
	/**
	 * Creates a new, larger array and copies over previous entries.
	 */
	private void resize() {
		Object[] items2 = new Object[items.length * 2]; // resize depends on
														// current size?
		for (int i = 0; i < items.length; i++) {
			items2[i] = items[i];
		}
		items = items2;
	}
	
	/**
	 * Returns a description of the contents of the array.
	 */
	public String toString() {
		StringBuilder retString = new StringBuilder();
		for (int i = 0; i < numItems; i++) {
			retString.append(items[i].toString() + " \n");
		}
		return retString.toString();
	}
	
}
