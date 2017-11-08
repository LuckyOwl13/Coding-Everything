
public class Deq<T> extends QueueRAB<T> implements ExtendedQueueInterface<T> {

	public Deq() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void enqueueFirst(T newItem) throws ExtendedQueueException {
		if (numItems == items.length) {	// if colletion full
			resize();	// call the resize for this 
		}	// end if
		
		front = (front - 1 + items.length)%items.length;
		items[front] = newItem;

		numItems++;
	}	// end enqueueFirst

	@Override
	public T dequeueLast() throws ExtendedQueueException {
		T temp= null;
		if (numItems == 0) {
			throw new QueueException("QueueRAB says it's empty");
		}	// end if
		else {
			temp = items[back];
			items[back] = null;
			back = (back - 1)%items.length;
		}	// end else

		numItems--;
		return temp;
	}	// end dequeueLast

	@Override
	public T peekLast() throws ExtendedQueueException {
		if (numItems == 0) {
			throw new QueueException("Deq says it's empty");
		}	// end if
		else {
			return items[back];
		}	// end else
	}	// end peekLast

}	// end class
