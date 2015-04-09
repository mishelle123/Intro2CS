
/**
 * non-recursive approach to sum all the divisors of a given number.
 * 
 * @author Mishelle Fried
 */

public class NonRecursiveMystery {
	
	/**
	 * non-recursive method that sums all the divisors of a given number
	 * 
	 * @param n - the number to check
	 * @return countDivisors - the sum of the divisors of n
	 */
	public static int mysteryComputation(int n){
		int countDivisors = 0;
		for(int i=(n-1) ; i>0 ; i--){
			if(n%i==0){
				countDivisors+=i;
			}

		}
		return countDivisors;
	}

	
}