
public class LRPalindromer {
	private Deq<Character> letters;
	private int letterCount;
	
	public LRPalindromer() {
		letters = new Deq<Character>();
		letterCount = 0;
	}	// end constructor
	
	public int getLetterCount() {
		return letterCount;
	}	// end getLetterCount


	public Deq<Character> getLetters() {
		return letters;
	}	// end getLetters
	
	public void addLetter(char let){
		letters.enqueue(let);
		letterCount++;
	}	// end addLetter
	
	public boolean isPalindrome(){
		boolean answer = true;
		
		while(!letters.isEmpty()){
			if (!letters.dequeue().equals(letters.dequeueLast())){
				answer = false;	// if first and last letter not same, not palindrome
			}	// end if
		}	// end while
		return answer;
	}	// end isPalindrome
	
	
	
	
	
	
	
	
}
