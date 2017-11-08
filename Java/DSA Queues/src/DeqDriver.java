import java.io.*;

public class DeqDriver {
	/** Reader used to receive input**/
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws NumberFormatException, IOException {
		Deq<String> dequ = new Deq<String>();

		printMenu(dequ);
	}


	public static void printMenu(Deq<String> dequ) throws NumberFormatException, IOException {

		System.out.print("\nSelect from the following menu:"
				+ "\n\t1. Insert item at back of Deq."
				+ "\n\t2. Insert item at front of Deq."
				+ "\n\t3. Remove item from front of Deq."
				+ "\n\t4. Remove item from back of Deq."
				+ "\n\t5. Display front item of Deq."
				+ "\n\t6. Display last item of Deq."
				+ "\n\t7. Clear Deq."
				+ "\n\t8. Display content of Deq."
				+ "\n\t9. Exit."
				+ "\nMake you menu selection now: ");

		int select = Integer.parseInt(br.readLine());
		System.out.println(select);

		switch(select) {
		case 1:
			insertBack(dequ);
			break;
		case 2:
			insertFront(dequ);
			break;
		case 3:
			removeFront(dequ);
			break;
		case 4:
			removeBack(dequ);
			break;
		case 5:
			peekFront(dequ);
			break;
		case 6:
			peekBack(dequ);
			break;
		case 7:
			dequ = clearDeq(dequ);
			break;
		case 8:
			displayDeq(dequ);
			break;
		case 9:
			System.out.println("Exiting program...Good Bye");
			System.exit(0);
			break;
		default:
			System.out.println("Error, please use valid input");
			break;
		}
		printMenu(dequ);
	}

	// #1
	private static void insertBack(Deq<String> dequ) throws IOException {
		System.out.print("You are now inserting an item at back of Deq."
				+ "\n\tEnter Item: ");
		String item = br.readLine();
		System.out.print(item);

		dequ.enqueue(item);
		System.out.println("\nItem " + item + " inserted to the back of Deq.");
	}	// end pushItem

	// #2
	private static void insertFront(Deq<String> dequ) throws IOException {
		System.out.print("You are now inserting an item at front of Deq."
				+ "\n\tEnter Item: ");
		String item = br.readLine();
		System.out.print(item);

		dequ.enqueueFirst(item);
		System.out.println("\nItem " + item + " inserted to the front of Deq.");
	}	// end pushItem

	// #3
	private static void removeFront(Deq<String> dequ) {
		if (dequ.isEmpty()) {
			System.out.println("No items in the Deq to deDeq!");
		}	// end if
		else {
			System.out.printf("Item %s deDeq'd from the front.\n",dequ.dequeue());
		}	// end else
	}	// end popItem

	// #4
	private static void removeBack(Deq<String> dequ) {
		if (dequ.isEmpty()) {
			System.out.println("No items in the Deq to deDeq!");
		}	// end if
		else {
			System.out.printf("Item %s deDeq'd from the back.\n",dequ.dequeueLast());
		}	// end else
	}	// end popItem

	// #5
	private static void peekFront(Deq<String> dequ) {
		if (dequ.isEmpty()) {
			System.out.println("No items on the Deq to peek!");
		}	// end if
		else {
			System.out.printf("Item %s peeked from the front of Deq\n",dequ.peek());
		}	/// end else
	}	// end peekItem

	// #6
	private static void peekBack(Deq<String> dequ) {
		if (dequ.isEmpty()) {
			System.out.println("No items on the Deq to peek!");
		}	// end if
		else {
			System.out.printf("Item %s peeked from the back of Deq\n",dequ.peekLast());
		}	/// end else
	}	// end peekItem

	// #7
	private static Deq<String> clearDeq(Deq<String> dequ) {
		return new Deq<String>();
	}	// end clearList

	//	#8
	private static void displayDeq(Deq<String> dequ) {
		System.out.println(dequ.toString());
	}
















}
