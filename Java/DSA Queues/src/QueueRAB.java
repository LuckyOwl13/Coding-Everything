
public class QueueRAB<T> implements QueueInterface<T> {
	protected int front;
	protected int back;
	protected int numItems;
	protected T[] items;

	@SuppressWarnings("unchecked")
	public QueueRAB() {
		items = (T[]) new Object[3];
		front = 0;
		back = items.length -1;
		numItems = 0;
	}	// end constructor

	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}	/// end isEmpty

	public int getNumItems() {
		return numItems;
	}

	@Override
	public void enqueue(T newItem) throws QueueException {
		if (numItems == items.length) {	// if colletion full
			resize();
		}	// end if

		back = (back + 1)%items.length;
		items[back] = newItem;

		numItems++;
	}	// end enqueue

	@Override
	public T dequeue() throws QueueException {
		T temp= null;
		if (numItems == 0) {
			throw new QueueException("QueueRAB says it's empty");
		}	// end if
		else {
			temp = items[front];
			items[front] = null;
			front = (front + 1)%items.length;
		}	// end else

		numItems--;
		return temp;
	}	// end dequeue

	@SuppressWarnings("unchecked")
	@Override
	public void dequeueAll() {
		items = (T[]) new Object[3];
		front = 0;
		back = items.length -1;
		numItems = 0;
	}	// end dequeueAll

	@Override
	public T peek() throws QueueException {
		if (numItems == 0) {
			throw new QueueException("QueueRAB says it's empty");
		}	// end if
		else {
			return items[front];
		}	// end else
	}	// end peek

	@SuppressWarnings("unchecked")
	protected void resize() {
		T [] temp = (T[]) new Object[(int) (items.length * 1.5)];

		for (int i = 0; i <= numItems; i++) {
			temp[i] = items[(front + i)%items.length];
		}	// end for

		back = items.length - 1;
		front = 0;

		items = temp;
	}	// end resize

	public String toString() {
		String returnString = "";
		for (int i = 0; i <= numItems; i++) {
			returnString += " " + items[(front + i)%items.length];
		}	// end for
		return returnString;
	}	// end toString




}
