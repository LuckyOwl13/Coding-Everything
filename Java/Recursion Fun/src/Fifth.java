
public class Fifth {
	private int n;

	public Fifth(int n) {
		this.n = n;
	}
	
	public int productToN(){
		int product = 1;
		
		if(n == 0) return 1;
		
		for(int i = 1; i <= n; i++){
			product *= i;
		}		
		
		return product;
	}
}
