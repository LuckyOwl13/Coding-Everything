import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	/** Reader used to receive input**/
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean canEndProgram = true;
		
		MyBinarySearchTreePlus<Data,String> tree = new MyBinarySearchTreePlus<Data,String>();

		printMenu(tree,canEndProgram);
	}	// end main

	private static void printMenu(MyBinarySearchTreePlus<Data, String> tree, boolean canEndProgram) throws NumberFormatException, IOException{
		boolean endNow = false;
		do{			
			System.out.print("\nSelect from the following menu:"
					+ "\n\t1. Insert key in BST."
					+ "\n\t2. Delete key from BST."
					+ "\n\t3. Search for key in BST."					
					+ "\n\t4. Display height of BST"
					+ "\n\t5. Display size of BST."
					+ "\n\t6. Display content of BST in inorder."
					+ "\n\t7. Display content of BST in preorder."
					+ "\n\t8. Display content of BST in postorder."
					+ "\n\t9. Build copy of the tree, and test it."
					+ "\n\t10. Exit program."
					+ "\nMake you menu selection now: ");

			String select = br.readLine().trim();
			System.out.println(select);

			switch (select){
			case "1": insertKey(tree);
				break;
			case "2": deleteKey(tree);
				break;
			case "3": searchKey(tree);
				break;
			case "4": displayHeight(tree);
				break;
			case "5": displaySize(tree);
				break;
			case "6": displayInOrder(tree);
				break;
			case "7": displayPreOrder(tree);
				break;
			case "8": displayPostOrder(tree);
				break;
			case "9": buildCopy(tree);
				break;
			case "10": if (!canEndProgram) System.out.println("Back to original tree"); 
					endNow = true;
				break;
			default: System.out.println("Error, please use valid input");
				break;
			}

		} while (!endNow);	// end do-while
		
		if (canEndProgram){
			System.out.println("Exitting now... Goodbye");
			System.exit(0);
		}	// end if (canEndProgram)
	}	// end printMenu

	// #1
	private static void insertKey(MyBinarySearchTreePlus<Data, String> tree) throws IOException {
		System.out.print("You are now inserting an item into the tree."
				+ "\n\tEnter Item: ");
		String item = br.readLine();
		System.out.println(item);

		tree.insert(new Data(item));
		System.out.println("\nItem " + item + " inserted into the tree.");
	}	// end insertKey

	// #2
	private static void deleteKey(MyBinarySearchTreePlus<Data, String> tree) throws IOException {
		if (!tree.isEmpty()){
			System.out.print("You are now removing an item from the tree."
					+ "\n\tEnter Item: ");
			String item = br.readLine();
			System.out.println(item);

			tree.delete(item);
			System.out.println("\nItem " + item + " removed from the tree.");
		}	// end if (!tree.isEmpty())
		else{
			System.out.println("Tree is empty, cannot delete!");
		}	// end else (!tree.isEmpty())
	}	// end deleteKey

	// #3
	private static void searchKey(MyBinarySearchTreePlus<Data, String> tree) throws IOException {
		if (!tree.isEmpty()){
			System.out.print("You are now removing an item from the tree."
					+ "\n\tEnter Item: ");
			String item = br.readLine();
			System.out.println(item);


			Data retrieved = tree.retrieve(item);

			if (retrieved != null) System.out.println("\nItem '" + retrieved.getKey() + "' retrieved from the tree.");
			else System.out.println("No such item found.");
		}	// end if (!tree.isEmpty())
		else{
			System.out.println("Tree is empty, cannot search!");
		}	// end else (!tree.isEmpty())
	}	// end searchKey

	// #4
	private static void displayHeight(MyBinarySearchTreePlus<Data, String> tree) {
		System.out.println("Tree is " + tree.getHeight() + " nodes tall at its tallest.");
	}	// end displayHeight

	// #5
	private static void displaySize(MyBinarySearchTreePlus<Data, String> tree) {
		System.out.println("Tree has " + tree.getSize() + " nodes in it.");
	}	// end displaySize

	// #6
	private static void displayInOrder(MyBinarySearchTreePlus<Data, String> tree) {
		System.out.println("The tree, inOrdered, goes as follows: " + tree.toStringInorder());
	}	// end displayInOrder

	// #7
	private static void displayPreOrder(MyBinarySearchTreePlus<Data, String> tree) {
		System.out.println("The tree, preOrdered, goes as follows: " + tree.toStringPreorder());
	}	// end displayPreOrder

	// #8
	private static void displayPostOrder(MyBinarySearchTreePlus<Data, String> tree) {
		System.out.println("The tree, postOrdered, goes as follows: " + tree.toStringPostorder());
	}	// end displayPostOrder

	// #9
	private static void buildCopy(MyBinarySearchTreePlus<Data, String> tree) throws NumberFormatException, IOException {
		if (!tree.isEmpty()){
			MyBinarySearchTreePlus<Data, String> copyTree = tree.getCopyOfTree();
			
			System.out.println("Tree copied, test copy now. 'End program' when you want to go back to the original.");
			
			printMenu(copyTree, false);
		}	// end if (!tree.isEmpty())
		else{
			System.out.println("Tree is empty, cannot copy!");
		}	// end else (!tree.isEmpty())
	}	// end buildCopy

















































	
	
	
	
	
	
}
