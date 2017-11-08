import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2Driver {
	/** Collection of Objects **/
	private static ListArrayBasedPlus labp;
	/** Reader used to receive input**/
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws NumberFormatException, IOException {
		labp = new ListArrayBasedPlus();

		printMenu(labp);
	}


	public static void printMenu(ListArrayBasedPlus labp) throws NumberFormatException, IOException{

		System.out.print("\nSelect from the following menu:"
				+ "\n\t1. Insert item into ordered list."
				+ "\n\t2. Remove item from list."
				+ "\n\t3. Get item from list."
				+ "\n\t4. Search for a specified item in the list."
				+ "\n\t5. Clear list. "
				+ "\n\t6. Print size and content of list."
				+ "\n\t7. Exit program."
				+ "\nMake you menu selection now: ");

		int select = Integer.parseInt(br.readLine());
		System.out.print(select + "\n");

		switch(select){
		case 1: insertItem(labp);
			break;
		case 2: removeItem(labp);
			break;
		case 3: getItem(labp);
			break;
		case 4: System.out.printf("Found item at index %s\n",searchListModB(labp));
			break;
		case 5: clearList(labp);
			break;
		case 6: printCollection(labp);
			break;
		case 7: System.out.println("Exiting program...Good Bye");
				System.exit(0);
			break;
		default: System.out.println("Error, please use valid input");
			break;
		}
		printMenu(labp);
	}

	// #4
	/**
	 * I chose to use Modified Sequential Search 2 
	 */
	private static int searchListModB(ListArrayBasedPlus labp) throws IOException {
		System.out.print("You are now searching for an item in the list."
				+ "\n\t Enter Item: ");
		String item = br.readLine();
		System.out.println(item);
		
		int size = labp.size();
		int index = -1;
		boolean searching = true;	// looking for something
		boolean success = false;	// has found what you're looking for
		
	// begin searching algorithm
		for (int i = 0; i < size && searching; i++){
			if (item.compareTo((String) labp.get(i)) > 0){	// if saught for is larger than retrieved
				// do nothing and advance
			} 	// end if
			else if (item.compareTo((String) labp.get(i)) == 0){	// if saught for is retrieved
				index = i;	// index to return set
				searching = false;	// no longer searching
				success = true;	// found the thing
			}	//end else-if 
			else {
				searching = false;	// no longer searching
			} 	// end else
		}	// end for
	// end searching algorithm
		
		return index;
	}
	



	// #1
	private static void insertItem(ListArrayBasedPlus labp) throws NumberFormatException, IOException {
		System.out.print("You are now inserting an item into the list."
				+ "\n\t Enter Item: ");
		String item = br.readLine();
		System.out.println(item);

		int size = labp.size();
		int index = size;
		boolean placed = false;
		
		for (int i = 0; i < size && !placed; i++){
			if (item.compareTo((String)labp.get(i)) < 0){
				index = i;
				placed = true;
			}
		}
		
		labp.add(index,item);
		
		System.out.println("\nItem " + item + " inserted in the list.");

	}	// end insertItem


	// #2
	private static void removeItem(ListArrayBasedPlus labp) throws NumberFormatException, IOException {
		System.out.print("\n\tEnter position to remove item from : ");
		int index = Integer.parseInt(br.readLine());
		System.out.println(index);

		if(index >= 0 && index < labp.size()){
			System.out.printf("Item %s removed from position %d in the list\n",labp.get(index),index);
			labp.remove(index);
		}	// end if
		else {
			System.out.println("Position specified is out of range!");
		}	// end else

	}	// end removeItem


	// #3
	private static void getItem(ListArrayBasedPlus labp) throws NumberFormatException, IOException {
		System.out.print("\n\tEnter position to retrieve item from : ");
		int index = Integer.parseInt(br.readLine());
		System.out.println(index);

		if(index >= 0 && index < labp.size()){
			System.out.printf("Item %s retrieved from position %d in the list\n",labp.get(index),index);
		}	// end if
		else {
			System.out.println("Position specified is out of range!");
		}	// end else

	}	// end getItem


	// #5
	private static void clearList(ListArrayBasedPlus labp) {
		labp.removeAll();
	}	// end clearList


	// #6
	private static void printCollection(ListArrayBasedPlus labp) {
		if (labp.size() > 0){
			System.out.printf("\n\tList of size %d has the following items : %s",labp.size(),labp.toString());
		}	// end if
		else{
			System.out.println("List is empty");
		}	// end else
	}	// end printCollection

















}
