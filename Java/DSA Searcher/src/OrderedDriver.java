import java.io.*;

public class OrderedDriver {
	/** Reader used to receive input**/
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws NumberFormatException, IOException {
		AscendinglyOrderedStringList list = new AscendinglyOrderedStringList();

		printMenu(list);
	}


	public static void printMenu(AscendinglyOrderedStringList list){
		boolean exitNow = false;
		do{
			System.out.print("\nSelect from the following menu:"
					+ "\n\t1. Insert specified item into list."
					+ "\n\t2. Remove item in specified position from the list."
					+ "\n\t3. Search for a specified item."
					+ "\n\t4. Clear list. "
					+ "\n\t5. Print size and content of list."
					+ "\n\t6. Exit Program"
					+ "\nMake you menu selection now: ");
			try{
				int select = Integer.parseInt(br.readLine());
				System.out.print(select + "\n");

				switch(select){
				case 1: insertItem(list);
					break;
				case 2: removeItem(list);
					break;
				case 3: searchList(list);
					break;
				case 4: clearList(list);
					break;
				case 5: printCollection(list);
					break;
				case 6: exitNow = true;
					break;
				default: System.err.println("oops! you shouldn't see this lol");
					break;
				}	// end switch
			}	// end try
			catch(NumberFormatException e){
				System.err.println("number format issue");
				e.printStackTrace();
			}	// end catch
			catch(IOException e){
				System.err.println("IO issue");
				e.printStackTrace();
			}	// end catch
		}while (!exitNow);	// end do-while
		System.exit(0);
	}	// end printMenu()

	// #1
	private static void insertItem(AscendinglyOrderedStringList list) throws NumberFormatException, IOException {
		System.out.print("You are now inserting an item into the list."
				+ "\n\t Enter Item: ");
		String item = br.readLine();
		System.out.println(item);

		list.add(item);

		System.out.println("\nItem " + item + " added to the list.");

	}	// end insertItem


	// #2
	private static void removeItem(AscendinglyOrderedStringList list) throws NumberFormatException, IOException {
		System.out.print("\n\tEnter position to remove item from : ");
		int index = Integer.parseInt(br.readLine());
		System.out.println(index);

		if(index >= 0 && index < list.size()){
			System.out.printf("Item %s removed from position %s in the list\n",list.get(index),index);
			list.remove(index);
		}	// end if
		else {	// index out of range
			System.out.println("Position specified is out of range!");
		}	// end else

	}	// end removeItem


	// #3
	private static void searchList(AscendinglyOrderedStringList list) throws IOException {
		System.out.print("You are now searching for an item in the list."
				+ "\n\t Enter Item: ");
		String item = br.readLine();
		System.out.println(item);

		list.search(item);
	}


	// #4
	private static void clearList(AscendinglyOrderedStringList list) {
		list.clear();
	}	// end clearList


	// #5
	private static void printCollection(AscendinglyOrderedStringList list) {
		if (list.size() > 0){
			System.out.printf("\n\tList of size %d has the following items : %s",list.size(),list.toString());
		}	// end if
		else{
			System.out.println("List is empty");
		}	// end else
	}	// end printCollection

















}
