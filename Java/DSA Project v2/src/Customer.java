
// Tom Harker
public class Customer extends NamedObject{
	/** Time Customer entered the store.**/
	private int timeInStore;
	/** Number of items in Customer cart.**/
	private int numItems;
	
	/**
	 * Constructor which sets Customer name and time they entered the store.
	 * The Customer's item count is initialized to zero.
	 * 
	 * @param time when the Customer entered the store
	 * @param n Customer name
	 */
	public Customer(int time, String n) {
		super(n);
		timeInStore = time;
		numItems = 0;
	}
	
	/**
	 * Sets Customer's time in store.
	 * @param x time to set
	 */
	public void setTimeInStore(int x) {
		timeInStore = x;
	}
	
	/**
	 * Returns a Customer description.
	 */
	public String toString() {
		return "Customer " + name + " has " + numItems + " items in the shopping basket.";
	}
	
	/**
	 * @return time in store
	 */
	public int getTimeInStore() {
		return timeInStore;
	}
	
	/**
	 * @return integer count of items
	 */
	public int getNumItems() {
		return numItems;
	}
	
	/**
	 * @param numItems the numItems to set
	 */
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}	
}
