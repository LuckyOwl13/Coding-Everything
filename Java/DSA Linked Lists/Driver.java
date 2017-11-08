import java.io.*;

public class Driver {
	/** Reader used to receive input**/
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws NumberFormatException, IOException {
		MyListReferenceBased mlrb = new MyListReferenceBased();
		mlrb.add(0, "hi");
		mlrb.add(1, "hello");
		mlrb.add(2, "how ya doin");
		printMenu(mlrb);
	}	// end main

	public static void printMenu(MyListReferenceBased mlrb) throws NumberFormatException, IOException{

		System.out.print("\nSelect from the following menu:"
				+ "\n\t1. Insert item to list."
				+ "\n\t2. Remove item from list."
				+ "\n\t3. Get item from list."
				+ "\n\t4. Clear list. "
				+ "\n\t5. Print size and content of list."
				+ "\n\t6. Delete largest item in the list."
				+ "\n\t7. Reverse list."
				+ "\n\t8. Exit program."
				+ "\nMake you menu selection now: ");

		int select = Integer.parseInt(br.readLine());
		System.out.println(select);

		switch(select){
		case 1: insertItem(mlrb);
		break;
		case 2: removeItem(mlrb);
		break;
		case 3: getItem(mlrb);
		break;
		case 4: clearList(mlrb);
		break;
		case 5: printCollection(mlrb);
		break;
		case 6: deleteLargest(mlrb);
		break;
		case 7: mlrb = reverseList(mlrb);
		break;
		case 8: System.out.println("Exiting program...Good Bye");
		System.exit(0);
		break;
		default: System.out.println("Error, please use valid input");
		break;
		}
		printMenu(mlrb);
	}	// end printMenu


	// #1
	private static void insertItem(MyListReferenceBased mlrb) throws NumberFormatException, IOException {
		System.out.print("You are now inserting an item into the list."
				+ "\n\tEnter Item: ");
		Object item = br.readLine();
		System.out.println(item);

		System.out.print("\tEnter position to insert item in : ");
		int index = Integer.parseInt(br.readLine());
		System.out.println(index);
		if (index <= mlrb.size()){
			mlrb.add(index,item);		
			System.out.println("\nItem " + item + " inserted in position " + index + " in the list.");
		}	// end if
		else{
			System.out.println("\nPosition specified is out of range!");
		}	// end else
	}	// end insertItem


	// #2
	private static void removeItem(MyListReferenceBased mlrb) throws NumberFormatException, IOException {
		System.out.print("\tEnter position to remove item from : ");
		int index = Integer.parseInt(br.readLine());
		System.out.println(index);

		if(index >= 0 && index < mlrb.size()){
			System.out.printf("Item %s removed from position %d in the list\n",mlrb.get(index),index);
			mlrb.remove(index);
		}	// end if
		else {
			System.out.println("\nPosition specified is out of range!");
		}	// end else
	}	// end removeItem


	// #3
	private static void getItem(MyListReferenceBased mlrb) throws NumberFormatException, IOException {
		System.out.print("\n\tEnter position to retrieve item from : ");
		int index = Integer.parseInt(br.readLine());
		System.out.println(index);

		if(index >= 0 && index < mlrb.size()){
			System.out.printf("Item %s retrieved from position %d in the list\n",mlrb.get(index),index);
		}	// end if
		else {
			System.out.print("\nPosition specified is out of range!");
		}	// end else
	}	// end getItem


	// #4
	private static void clearList(MyListReferenceBased mlrb) {
		mlrb.removeAll();
	}	// end clearList


	// #5
	private static void printCollection(MyListReferenceBased mlrb) {
		if (mlrb.size() > 0){
			System.out.printf("\n\tList of size %d has the following items : %s",mlrb.size(),mlrb.toString());
		}	// end if
		else{
			System.out.println("List is empty");
		}	// end else
	}	// end printCollection


	// #6
	private static void deleteLargest(MyListReferenceBased mlrb) {
		if (!mlrb.isEmpty()){
//			int count = 0;
			int size = mlrb.size();
			int indexBiggest = 0;
			Object current = mlrb.get(0);
			Object biggest = current;
//			while (count < size - 1){
//				int result = ((String) biggest).compareTo((String) current);
//				if (result < 0){	// new node is bigger
//					biggest = current;
//					indexBiggest = count;
//				}
//				current = mlrb.get(++count);
//			}	// end while
			
			for (int count = 0; count < size; count++){
				current = mlrb.get(count);
				int result = ((String) biggest).compareTo((String) current);
				if (result < 0){	// new node is bigger
					biggest = current;
					indexBiggest = count;
				}
			}
			
			
			System.out.println("Largest item " + mlrb.get(indexBiggest) + " deleted.");
			mlrb.remove(indexBiggest);
		}
		else{
			System.out.println("List empty, nothing to delete!");
		}

	}	// end deleteLargest


	// #7
	private static MyListReferenceBased reverseList(MyListReferenceBased mlrb) {
		if (!mlrb.isEmpty()){
			Object[] items = new Object[mlrb.size()];
			for (int i = 0; i < items.length; i++){
				items[i] = mlrb.get(i);
			}
			
			mlrb = new MyListReferenceBased(); 
			for (int i = 0; i < items.length; i++){
				mlrb.add(0, items[i]);
			}
//			nodes[0].setNext(null);
//			
//			mlrb.setHead(nodes[nodes.length - 1]);

			System.out.println("List has been reversed."
					+ "\n Here is the content: " + mlrb.toString());

		}	// end if
		else{
			System.out.println("List is empty.. nothing to reverse!");
		}	// end else
		return mlrb;
	}	// end reverseList






















}
