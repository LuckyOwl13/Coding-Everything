import java.io.*;

public class LRDriver {
	/** Reader used to receive input**/
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		LRPalindromer lrpa = new LRPalindromer();
		runInput(lrpa);
	}	// end main


	private static void runInput(LRPalindromer lrpa) throws IOException {
		Deq<Character> left = new Deq<Character>();
		char[] lett = new char[1];

		boolean hasStar = false;
		boolean sidesSame = false;
		int countSame = 0;
		boolean isPalindrome = false;

		do{
			System.out.print("Enter Character: ");
			lett = br.readLine().trim().toCharArray();
			System.out.println(lett[0]);

			if(lett[0] == '*'){	// end left side
				hasStar = true;
				left = lrpa.getLetters();
				Deq<Character> right = new Deq<Character>();

				do{		
					System.out.print("Enter Character: ");
					lett = br.readLine().trim().toCharArray();
					System.out.println(lett[0]);

					right.enqueue(lett[0]);	
				} while(lett[0] != '!');	// end do-while
				right.dequeueLast();	// removes the '!' at the end of right
				
				countSame = left.getNumItems() - right.getNumItems();
				sidesSame = checkSameLetters(lrpa.getLetters(),right);

			}	// end if
			else{
				lrpa.addLetter(lett[0]);
			}	// end else
		} while (lett[0] != '!');	// user ends input

		isPalindrome = checkPalindrome(left);

		printAnswer(hasStar, sidesSame, countSame, isPalindrome);
	}	// end printMenu

	private static boolean checkSameLetters(Deq<Character> left, Deq<Character> right) throws IOException{	
		boolean isSameLetters = true;
		char leftL;
		Deq<Character> temp = new Deq<Character>();

		while (!left.isEmpty() && !right.isEmpty()){
			leftL = left.dequeue();
			temp.enqueue(leftL);
			
			if(leftL != right.dequeue()){
				isSameLetters = false;
			}	// end if
		}
		
		while (!temp.isEmpty()){
			left.enqueue(temp.dequeue());
		}
		
		return isSameLetters;
	}	// end 

	private static boolean checkPalindrome(Deq<Character> left) {
		boolean answer = true;
		int charCount = left.getNumItems();

		if (charCount == 0) answer = false;

		while (charCount > 1){	// while there are still items
			if (left.dequeue() != left.dequeueLast()){	// if the ends are the same
				answer = false;
			}
			charCount -= 2;
		}

		return answer;
	}


	private static void printAnswer(boolean hasStar, boolean sidesSame, 
			int countSame, boolean isPalindrome)
	{
		String printString = "";
		if (!hasStar){				// if no star submitted by user
			printString = "No Star";
		}	// end if
		else if (countSame > 0){	// if left side longer
			printString = "Left Longer";
		}	// end else-if
		else if (countSame < 0){	// if right side longer
			printString = "Right Longer";
		}	// end else-if
		else {	// both sides same length
			printString = "Same Length";

			if (!sidesSame){		// if sides have different content
				printString += ", Different Content";
			}	// end if
			else{					// both sides have same content
				printString += " and Same Content";

				if (!isPalindrome){	// if not a palindrome
					printString += ", No Palindrome";
				}	// end if
				else{				// is a palindrome
					printString += ", Palindrome";
				}	// end else
			}	// end else
		}	// end else

		System.out.printf("\t\t>> %s",printString);
	}




























}
