
public class First {
	private Integer numbe;

	public First(int numbe) {
		this.numbe = numbe;
	}
	
	public int sumOfDigits(){
		Integer sum = 0;
		
		char[] digits = numbe.toString().toCharArray();
		
		for(char c : digits){
			switch(c){
			case '-':
			case '0': sum += 0;
				break;
			case '1': sum += 1;
				break;
			case '2': sum += 2;
				break;
			case '3': sum += 3;
				break;
			case '4': sum += 4;
				break;
			case '5': sum += 5;
				break;
			case '6': sum += 6;
				break;
			case '7': sum += 7;
				break;
			case '8': sum += 8;
				break;
			case '9': sum += 9;
				break;
			default: sum = Integer.MIN_VALUE;
			}
		}
		
		return sum;		
	}
	
}
