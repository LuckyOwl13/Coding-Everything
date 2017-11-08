import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    /** Reader used to receive input**/
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws NumberFormatException, IOException {
        StackRAB<String> stab = new StackRAB<String>();
        printMenu(stab);
    }


    public static void printMenu(StackRAB<String> stab) throws NumberFormatException, IOException {

        System.out.print("\nSelect from the following menu:"
                         + "\n\t1. Push item onto stack."
                         + "\n\t2. Pop item from stack."
                         + "\n\t3. Display top item on stack."
                         + "\n\t4. Clear stack. "
                         + "\n\t5. Exit program."
                         + "\nMake you menu selection now: ");

        int select = Integer.parseInt(br.readLine());
        System.out.println(select);

        switch(select) {
        case 1:
            pushItem(stab);
            break;
        case 2:
            popItem(stab);
            break;
        case 3:
            peekItem(stab);
            break;
        case 4:
            clearStack(stab);
            break;
        case 5:
            System.out.println("Exiting program...Good Bye");
            System.exit(0);
            break;
        default:
            System.out.println("Error, please use valid input");
            break;
        }
        printMenu(stab);
    }

    // #1
    private static void pushItem(StackRAB<String> stab) throws IOException {
        System.out.print("You are now pushing an item onto the stack."
                         + "\n\tEnter Item: ");
        String item = br.readLine();
        System.out.print(item);

        stab.push(item);
        System.out.println("\nItem " + item + " pushed onto the stack.");
    }	// end pushItem

    // #2
    private static void popItem(StackRAB<String> stab) {
        if (stab.isEmpty()) System.out.println("No items on the stack to pop!");
        else System.out.printf("Item %s popped from the stack\n",stab.pop());
    }	// end popItem

    // #3
    private static void peekItem(StackRAB<String> stab) {
        if (stab.isEmpty()) System.out.println("No items on the stack to peek!");
        else System.out.printf("Item %s peeked from the stack\n",stab.peek());
    }	// end peekItem

    // #4
    private static void clearStack(StackRAB<String> stab) {
        stab.popAll();
    }	// end clearList


















}
