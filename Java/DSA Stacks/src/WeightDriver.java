import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeightDriver {
    /** Reader used to receive input**/
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws NumberFormatException, IOException {
        Bag ba = new Bag();
        Bag sample = new Bag();
        printMenu(ba,sample);
    }


    public static void printMenu(Bag ba,Bag sample) throws NumberFormatException, IOException {

        System.out.print("\nSelect from the following menu:"
                         + "\n\t1. Place a layer of item(s) in the bag."
                         + "\n\t2. Remove a layer of item(s) from the bag."
                         + "\n\t3. Display the weight of the bag."
                         + "\n\t4. Display the number of layers in the bag."
                         + "\n\t5. Display the number of items and the weight of the sample bag."
                         + "\n\t6. Remove an item from the sample bag."
                         + "\n\t7. Empty the sample bag."
                         + "\n\t8. Exit program."
                         + "\nMake your menu selection now: ");

        try {
            int select = Integer.parseInt(br.readLine().trim());

            System.out.println(select);

            switch(select) {
            case 1:
                placeItem(ba);
                break;
            case 2:
                removeItem(ba,sample);
                break;
            case 3:
                displayWeight(ba);
                break;
            case 4:
                displayLayers(ba);
                break;
            case 5:
                displaySample(sample);
                break;
            case 6:
                removeSample(sample);
                break;
            case 7:
                System.out.println("The sample bag has been emptied.");
                sample = new Bag();
                break;
            case 8:
                System.out.println("Exiting program...Good Bye");
                System.exit(0);
                break;
            default:
                System.out.println("Error, please use valid input");
                break;
            }	// end switch
            printMenu(ba,sample);

        } catch (NumberFormatException e) {
            System.out.println("Error: please input a number 1-8.");
            printMenu(ba,sample);
        }	//end try-catch
    }	// end printMenu

    //	#1
    private static void placeItem(Bag ba) {
        System.out.print("Enter number of items to place in bag : ");
        try {
            Integer itemCount = Integer.parseInt(br.readLine().trim());
            System.out.print(itemCount+ "\nEnter weight of item (lb): ");
            Double weight = Double.parseDouble(br.readLine().trim());
            System.out.print(weight);

            BagLayer bagLay = new BagLayer(itemCount,weight);

            ba.placeLayer(bagLay);
            System.out.printf("\n%s items weighting %s have been placed in the bag.\n",itemCount.toString(),weight.toString());

        } catch (NumberFormatException e) {
            System.out.println("Error, please use a valid input.");
        } catch (IOException e) {
            System.out.println("IO Exception, please try again");
            e.printStackTrace();
        }	// end try/catch
    }	// end placeItem


    //	#2
    private static void removeItem(Bag ba,Bag samp) throws IOException {
        if (ba.getNumLayers() == 0) System.out.println("Error: Empty bag.");	// end if
        else {
            BagLayer remov = ba.removeLayer();
            System.out.printf("%s items have been removed from the bag."
                              + "\nWould you like to store a sample from this layer(Y/N)?",remov.getNumItems());
            String answer = br.readLine().trim();
            System.out.println(answer);
            if (answer.startsWith("Y")) {
                samp.placeLayer(new BagLayer(1,remov.getWeight()));
                System.out.println("Sample stored.");
            }	// end if
        }	// end else
    }	// end removeItem


    //	#3
    private static void displayWeight(Bag ba) {
        if (ba.getLayers().isEmpty()) System.out.println("The bag is empty : Weight is 0 lbs.");
        else System.out.printf("The weight of the bag is %s lbs.\n","" + ba.getTotWeight());
    }	// end displayWeight


    //	#4
    private static void displayLayers(Bag ba) {
        System.out.printf("The number of layers in the bag is %s.\n",ba.getNumLayers());
    }	//end displayLayers


    //	#5
    private static void displaySample(Bag sample) {
        System.out.printf("The number of items in the sample bag is %s.\n",sample.getNumLayers());
        System.out.printf("The weight of the bag is %s lbs.\n",sample.getTotWeight());
    }	// end displaySample


    //	#6
    private static void removeSample(Bag sample) {
        if (sample.getLayers().isEmpty()) {
            System.out.println("Error: Empty sample bag.");
        }	// end if
        else {
            System.out.printf("An item weighing %s lbs has been removed from "
                              + "the sample bag.\n",sample.removeLayer().getWeight());
        }	// end else

    }	// end removeSample

//
//	// #1
//	private static void pushItem(StackRAB stab) throws IOException {
//		System.out.print("You are now pushing an item onto the list."
//				+ "\n\tEnter Item: ");
//		Object item = br.readLine();
//		System.out.print(item);
//
//		stab.push(item);
//		System.out.println("\nItem " + item + " pushed onto the stack.");
//	}	// end pushItem
//
//	// #2
//	private static void popItem(StackRAB stab) {
//		if (stab.isEmpty()) System.out.println("No items on the stack to pop!");
//		else System.out.printf("Item %s popped from the stack\n",stab.pop());
//	}	// end popItem
//
//	// #3
//	private static void peekItem(StackRAB stab) {
//		if (stab.isEmpty()) System.out.println("No items on the stack to peek!");
//		else System.out.printf("Item %s peeked from the list\n",stab.peek());
//	}	// end peekItem
//
//	// #4
//	private static void clearStack(StackRAB stab) {
//		stab.popAll();
//	}	// end clearList


















}
