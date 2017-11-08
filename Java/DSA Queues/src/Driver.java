import java.io.*;

public class Driver {
    /** Reader used to receive input**/
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws NumberFormatException, IOException {
        QueueRAB<String> quab = new QueueRAB<String>();

        printMenu(quab);
    }


    public static void printMenu(QueueRAB<String> quab) throws NumberFormatException, IOException {

        System.out.print("\nSelect from the following menu:"
                         + "\n\t1. Insert item at back of queue."
                         + "\n\t2. Remove item from front of queue."
                         + "\n\t3. Display front item of queue."
                         + "\n\t4. Clear queue."
                         + "\n\t5. Display content of queue."
                         + "\n\t6. Exit program."
                         + "\nMake you menu selection now: ");

        int select = Integer.parseInt(br.readLine());
        System.out.println(select);

        switch(select) {
        case 1:
            insertItem(quab);
            break;
        case 2:
            removeItem(quab);
            break;
        case 3:
            peekItem(quab);
            break;
        case 4:
            quab = clearQueue(quab);
            break;
        case 5:
            displayQueue(quab);
            break;
        case 6:
            System.out.println("Exiting program...Good Bye");
            System.exit(0);
            break;
        default:
            System.out.println("Error, please use valid input");
            break;
        }
        printMenu(quab);
    }

    // #1
    private static void insertItem(QueueRAB<String> quab) throws IOException {
        System.out.print("You are now inserting an item at back of queue."
                         + "\n\tEnter Item: ");
        String item = br.readLine();
        System.out.print(item);

        quab.enqueue(item);
        System.out.println("\nItem " + item + " inserted to the queue.");
    }	// end pushItem

    // #2
    private static void removeItem(QueueRAB<String> quab) {
        if (quab.isEmpty()) {
            System.out.println("No items in the queue to dequeue!");
        }	// end if
        else {
            System.out.printf("Item %s dequeued.\n",quab.dequeue());
        }	// end else
    }	// end popItem

    // #3
    private static void peekItem(QueueRAB<String> quab) {
        if (quab.isEmpty()) {
            System.out.println("No items on the queue to peek!");
        }	// end if
        else {
            System.out.printf("Item %s peeked from the queue\n",quab.peek());
        }	/// end else
    }	// end peekItem

    // #4
    private static QueueRAB<String> clearQueue(QueueRAB<String> quab) {
        return new QueueRAB<String>();
    }	// end clearList

    //	#5
    private static void displayQueue(QueueRAB<String> quab) {
        System.out.println(quab.toString());
    }
















}
