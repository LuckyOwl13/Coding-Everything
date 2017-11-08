
public class CharTrackDriver {

	public static void main(String[] args) {
		System.out.println("Loading data with a,b,c,d,e,d,c,b,a");
		
		CharTracker ct = new CharTracker();
		ct.add('a');
		ct.add('b');
		ct.add('c');
		ct.add('d');
		ct.add('e');
		ct.add('d');
		ct.add('c');
		ct.add('b');
		ct.add('a');
		
		ct.displayForEach();
        ct.displayForCounter();
        ct.displayForIterator();
        ct.displayStreamConsumer();
        ct.displayForEachMethodMethod();

        ct.displayReverseForCounter();
        ct.displayReverseForIterator();
        

		System.out.println("Loading data with a,b,c,d,e,f,g,h");
		
		ct = new CharTracker();
		ct.add('a');
		ct.add('b');
		ct.add('c');
		ct.add('d');
		ct.add('e');
		ct.add('f');
		ct.add('g');
		ct.add('h');

        System.out.println(ct.testIfPalindromeWhileTwoIterators());
        System.out.println(ct.testIfPalindromeIteratorBiPredicate());

	}

}
