import java.io.*;

public class Driver {
    /** Collection of Objects **/
    private static ListArrayBasedPlus labp;
    /** Reader used to receive input**/
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws NumberFormatException, IOException {
        labp = new ListArrayBasedPlus();
        printMenu();
    }


    public static void printMenu() throws NumberFormatException, IOException {

        System.out.print("\nSelect from the following menu:"
                         + "\n\t1. Insert item to list."
                         + "\n\t2. Remove item from list."
                         + "\n\t3. Get item from list."
                         + "\n\t4. Clear list. "
                         + "\n\t5. Print size and content of list."
                         + "\n\t6. Reverse list."
                         + "\n\t7. Exit program."
                         + "\nMake you menu selection now: ");

        int select = Integer.parseInt(br.readLine());
        System.out.println(select);

        switch(select) {
        case 1:
            insertItem();
            break;
        case 2:
            removeItem();
            break;
        case 3:
            getItem();
            break;
        case 4:
            clearList();
            break;
        case 5:
            printCollection();
            break;
        case 6:
            reverseList();
            break;
        case 7:
            System.out.println("Exiting program...Good Bye");
            System.exit(0);
            break;
        default:
            System.out.println("Error, please use valid input");
            break;
        }
        printMenu();
    }


    private static void insertItem() throws NumberFormatException, IOException {
        System.out.print("You are now inserting an item into the list."
                         + "\n\tEnter Item: ");
        Object item = br.readLine();
        System.out.print(item);

        System.out.print("\n\tEnter position to insert item in : ");
        int index = Integer.parseInt(br.readLine());
        System.out.println(index);

        if (index <= labp.size()) {
            labp.add(index,item);
            System.out.println("\nItem " + item + " inserted in position " + index + " in the list.");
        }	// end if
        else {
            System.out.println("Position specified is out of range!");
        }	// end else

    }	// end insertItem


    private static void removeItem() throws NumberFormatException, IOException {
        System.out.print("\n\tEnter position to remove item from : ");
        int index = Integer.parseInt(br.readLine());
        System.out.println(index);

        if(index >= 0 && index < labp.size()) {
            System.out.printf("Item %s removed from position %d in the list\n",labp.get(index),index);
            labp.remove(index);
        }	// end if
        else {
            System.out.println("Position specified is out of range!");
        }	// end else

    }	// end removeItem


    private static void getItem() throws NumberFormatException, IOException {
        System.out.print("\n\tEnter position to retrieve item from : ");
        int index = Integer.parseInt(br.readLine());
        System.out.println(index);

        if(index >= 0 && index < labp.size()) {
            System.out.printf("Item %s retrieved from position %d in the list\n",labp.get(index),index);
        }	// end if
        else {
            System.out.println("Position specified is out of range!");
        }	// end else

    }	// end getItem


    private static void clearList() {
        labp.removeAll();
    }	// end clearList


    private static void printCollection() {
        if (labp.size() > 0) {
            System.out.printf("\n\tList of size %d has the following items : %s",labp.size(),labp.toString());
        }	// end if
        else {
            System.out.println("List is empty");
        }	// end else
    }	// end printCollection


    private static void reverseList() {
        labp.reverse();
        System.out.println("\tList reversed");
    }	// end reverseList


















}
