
public class Second {
	private int[] nums;

	public Second(int[] nums) {
		this.nums = nums;
	}

	public void printArray(boolean forwards) {
		System.out.print("Array, printed ");
		if (forwards) {
			System.out.println("forwards:");
			for (int i = 0; i < nums.length; i++) {
				System.out.println(nums[i]);
			}
		}
		else{
			System.out.println("backwards:");
			for (int i = nums.length - 1; i >= 0; i--) {
				System.out.println(nums[i]);
			}
		}
	}

}
