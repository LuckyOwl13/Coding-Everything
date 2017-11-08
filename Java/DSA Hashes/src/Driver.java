import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    /** Reader used to receive input**/
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        HashTable<String,String> table = new HashTable<String,String>();

        printMenu(table);
    }	// end main

    private static void printMenu(HashTable<String, String> table) throws NumberFormatException, IOException {
        boolean endNow = false;
        do {
            System.out.print("\nSelect from the following menu:"
                             + "\n\t1. Insert a symbol key with an associated value in the table."
                             + "\n\t2. Delete a symbol from the table."
                             + "\n\t3. Retrieve and display the value associated with a symbol key in the table."
                             + "\n\t4. Display the hash index of a symbol key."
                             + "\n\t5. Exit program."
                             + "\nMake you menu selection now: ");

            int select = Integer.parseInt(br.readLine().trim());
            System.out.println(select);

            switch (select) {
            case 1:
                insertItem(table);
                break;
            case 2:
                deleteItem(table);
                break;
            case 3:
                retrieveValue(table);
                break;
            case 4:
                displayHash(table);
                break;
            case 5:
                endNow = true;
                break;
            default:
                System.out.println("Error, please use valid input");
                break;
            }

        } while (!endNow);	// end do-while

        System.out.println("Exitting now... Goodbye");
        System.exit(0);
    }	// end printMenu

    // #1
    private static void insertItem(HashTable<String, String> table) throws IOException {
        System.out.print("You are now inserting a key/value pair into the table."
                         + "\n\tEnter symbol key: ");
        String key = br.readLine();
        System.out.println(key);

        System.out.print("\tEnter associated value: ");
        String value = br.readLine();
        System.out.println(value);

        table.tableInsert(key, value);
        System.out.println("\nKey " + key + " with value " + value + " inserted into the table.");

    }	// end insertItem

    // #2
    private static void deleteItem(HashTable<String, String> table) throws IOException {
        if (table.tableIsEmpty()) {
            System.out.println("Table empty, cannot delete!");
        }	// end if
        else {
            System.out.print("You are now deleting a key/value pair from the table."
                             + "\n\tEnter search key: ");
            String key = br.readLine();
            System.out.println(key);

            if (table.tableDelete(key)) {
                System.out.println("Value associated with key " + key + " deleted successfully.");
            }	// end if
            else {
                System.out.println("No key matching input found.");
            }	// end else
        }	// end else
    }	// end deleteItem

    // #3
    private static void retrieveValue(HashTable<String, String> table) throws IOException {
        if (table.tableIsEmpty()) {
            System.out.println("Table empty, cannot delete!");
        }	// end if
        else {
            System.out.print("You are now retrieving a value from the table."
                             + "\n\tEnter search key: ");
            String key = br.readLine();
            System.out.println(key);

            String value = table.tableRetrieve(key);

            if (value != null) {
                System.out.println("Value '" + value + "' retrieved.");
            }	// end if
            else {
                System.out.println("No key matching input found.");
            }	// end else
        }	// end else
    }	// end retrieveValue

    // #4
    private static void displayHash(HashTable<String, String> table) throws IOException {
        System.out.print("You are now seeing the value for a symbol key."
                         + "\n\tEnter symbol key: ");
        String key = br.readLine();
        System.out.println(key);

        System.out.printf("The hash index of '%s' is '%s'\n",key,table.hashIndex(key));
    }	// end displayHash
}	// end Class













































