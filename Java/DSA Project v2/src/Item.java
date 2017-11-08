
// Caitlin McElwee
public class Item extends NamedObject {
	/**	The count of this particular product in stock **/
	private int count;
	
	/**
	 * Constructor which sets Item name and count
	 * 
	 * @param name item name
	 * @param count item count
	 */
	public Item(String name,int count) {
		super(name);
		this.count = count;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}	// end getCount;
	
	/**
	 * Decrements the item count by 1.
	 */
	public void decrementStock() {
		count--;
	}
	
	/**
	 * Adds an amount to the item count.
	 * @param added amount of stock to add
	 * @return new item count;
	 */
	public int addStock(int added){
		return count += added;
	}	// end addStock

}	// end class
