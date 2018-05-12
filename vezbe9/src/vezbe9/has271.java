package vezbe9;

/*Given an array of ints, return true if it contains a 2, 7, 1 pattern: 
 * a value, followed by the value plus 5, followed by the value minus 1. 
 * Additionally the 271 counts even if the "1" differs by 2 or less from the correct value.


has271([1, 2, 7, 1]) → true
has271([1, 2, 8, 1]) → false
has271([2, 7, 1]) → true*/

public class has271 {

	public boolean has271(int[] nums) {        // i, i + 5, i -1

		int endOfBounds = nums.length - 2;            //da ne bih bio OutOfBounds
		boolean istina = false;
		
		for (int i = 0; i < endOfBounds; i++) {
			int m = nums [i] ;
			int n = nums [i+1];
			int l = nums [i+2];
			if (n == m + 5 &&( l == m - 1 || l == m - 2 ||  // elegantnije rešenje Math.abs(nums[i+2] - (val-1)) <= 2)
					l == m - 3 || l == m || l == m + 1  ))  // ali ovo radi 
				istina = true;
			else
				istina = false;

		} 
		return istina;

	}
}