/***
 * Purpose: Data Structure and Algorithms Lab 1 Problem 9
 * Status: Barely started
 * Last update: 09/07/16
 * Submitted:  09/07/16
 * Comment: test suite and sample run attached
 * @author: Caitlin McElwee
 * @version: 2016.09.07
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class CharTracker{

	private ArrayList<Character> data = new ArrayList<Character>();

	/**
	 * Adds chars to the ArrayList.
	 * @param Character to be added to data
	 */
	public void add(Character c){
		data.add(c);
	}

	// Forward Methods (5 found) ------------------------------------------------------------------------------

	/**
	 * Displays forward every element of data using a foreach loop.
	 */
	public void displayForEach(){
		System.out.println("\n Display Forward Using For-Each");

		for(char c : data){
			System.out.println(c);
		}
	}

	/**
	 * Displays forward every element of data using a three-part for loop with counter.
	 */
	public void displayForCounter(){
		System.out.println("\nDisplay Forward Using Three-Part For Loop with Counter");

		for(int i = 0; i < data.size(); i++){
			System.out.println(data.get(i));
		}
	}

	/**
	 * Displays forward every element of data using a three-part for loop with iterator.
	 */
	public void displayForIterator(){
		System.out.println("\nDisplay Forward Using Three-Part For Loop with Iterator");

		for(Iterator<Character> it = data.iterator(); it.hasNext(); ){
			System.out.println(it.next());
		}
	}

	/**
	 * Displays forward every element of data using a stream with a consumer.
	 */
	public void displayStreamConsumer(){
		System.out.println("\nDisplay Forward Using A Stream and Consumer");

		Consumer<Character> print = c -> System.out.println(c);

		data.stream().forEach(print);
	}

	/**
	 * Displays forward every element of data using a forEach() method which calls a class method.
	 */
	public void displayForEachMethodMethod(){
		System.out.println("\nDisplay Reverse Using forEach() Method Calling a Class Method");
		data.forEach(CharTracker::printCharacter);
	}
	public static void printCharacter(Character c){ // method to be called by .displayForEachMethodMethod()
		System.out.println(c);
	}

	// Reverse Methods (2 found, 2 methods from forward could be reused) --------------------------------------

	/**
	 * Displays reverse every element of data using a three-part for loop with counter.
	 */
	public void displayReverseForCounter(){
		System.out.println("\nDisplay Reverse Using Three-Part For Loop with Counter");

		for(int i = data.size() - 1; i >= 0; i--){
			System.out.println(data.get(i));
		}
	}

	/**
	 * Displays reverse every element of data using a while loop and ListIterator.
	 */
	public void displayReverseForIterator(){
		System.out.println("\nDisplay Reverse Using A While Loop and ListIterator");

		ListIterator<Character> li = data.listIterator(data.size());

		// Iterate in reverse.
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
	}


	// Palindrome Tester ( found) -----------------------------------------------------------------------------

	/**
	 * Checks if ArrayList is a palindrome using a While loop with two iterators
	 */
	public boolean testIfPalindromeWhileTwoIterators(){
		System.out.println("\nTesting if data is palindrome using a while loop and two iterators");
		boolean palindrome = true;

		ListIterator<Character> forward = data.listIterator();
		ListIterator<Character> backward = data.listIterator(data.size());

		while(palindrome && forward.hasNext() && backward.hasPrevious()){
			if ( !(forward.next().equals( backward.previous() )) ){
				palindrome = false;
			}
		}

		return palindrome;
	}

	/**
	 * Checks if ArrayList is a palindrome using a While loop, a BiPredicate with two iterators
	 */
	public boolean testIfPalindromeIteratorBiPredicate(){
		System.out.println("\nTesting if data is palindrome using a while loop, a bipredicate and two iterators");
		boolean palindrome = true;
		
		ListIterator<Character> forward = data.listIterator();
		ListIterator<Character> backward = data.listIterator(data.size());
		
		BiPredicate<Character,Character> compare = (c1,c2) -> c1.equals(c2);
		
		while(palindrome && forward.hasNext() && backward.hasPrevious()){
			palindrome = compare.test(forward.next(), backward.previous());
		}
		
		return palindrome;
	}












}
