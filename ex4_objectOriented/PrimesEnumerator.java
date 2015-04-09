
/**
 * 
 * Tests primality and generates prime numbers in 
 *  a specified range. 
 *
 * @author mishelle
 */

public class PrimesEnumerator{
	/**
	 * The upperBound.
	 */
	private int upperBound;
	/**
	 * The lowerBound.
	 */
	private int lowerBound; // Encapsulated internal state
	/**
	 * The current LowerBound;
	 */
	private int currentLowerBound;
	
	/** Constructs a new PrimesEnumerator with a given upper bound, and a lower bound value of 2.
	 * 
	 * @param upperBound
	 */
	public PrimesEnumerator(int upperBound){
		lowerBound = 2;
		this.upperBound = upperBound;
		currentLowerBound = lowerBound - 1;

	}
	/**
	 * Creates a new PrimesEnumerator with a lower bound and an upper bound.
	 * 
	 * @param lowerBound
	 * @param upperBound
	 */
	public PrimesEnumerator(int lowerBound, int upperBound){
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		currentLowerBound = lowerBound - 1;

	}
	/**
	 * Checks if a given number is prime.
	 * 
	 *  @param count
	 * @param number
	 * @return isPrime
	 */
	public static boolean isPrime(int number){
		
		if(number<2){
			return false;
		}
        if (number==2){
            return true;
        }
        if (number%2==0){
            return false;
        }
        
		for(int i=3; i<=Math.sqrt(number);i+=2){
			if(number%i==0){
				return false;
			}
		}
			return true;
	}   

	/**
	 * Checks whether or not more primes in the range remain. 
	 * The next() method may be called if hasNext() returns true.
	 * 
	 * @param count
	 * @return true/false
	 */
	public boolean hasNext(){
		for(int k = currentLowerBound +1 ; k<=upperBound; k++){ 
			if(isPrime(k)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the next prime in the range. 
	 * This function may only be called if hasNext() returns true.
	 *
	 * @param count
	 * @return the next prime in the range. 
	 */
	public int next(){
		for(currentLowerBound= currentLowerBound +1 ; currentLowerBound<=upperBound; currentLowerBound++){
			if(isPrime(currentLowerBound)){
				return currentLowerBound;
			}

		}
		return -1;
	
	}
	 
}










