
public class Fourth {
	private int n;

	public Fourth(int n) {
		this.n = n;
	}
	
	public int sumToN(){
		int sum = 0;
		
		for(int i = 1; i <= n; i++){
			sum += i;
		}		
		
		return sum;
	}
	
}
