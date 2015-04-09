/**
 * The Fibonacci sequence S=(s0,s1,s2,...) is defined as follows: 
 * s0 = 0, s1 = 1, , and for all i>1, si = s(i-1)+s(i-2). 
 * For example, the first few elements of the series are: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 *
 * 
 * @author mishelle
 *
 */
import il.ac.huji.cs.intro.ex8.Sequence;
public class FibonacciSequence implements Sequence {
	private double first, second, follown;
	private double current;
	
	/**
	 * Constructs a new Fibonacci sequence.
	 */
	FibonacciSequence(){
		this.first = 0;
		this.second = 1;
		this.current = 0;
	}
	
	
	/**
	 * Checks whether or not there are more numbers in the sequence to 
	 * return. The next() method may be called if and only if hasNext() 
	 * returns true.
	 * 
	 * @specified hasNext in interface Sequence
	 * @return true if more numbers remain in the sequence, false otherwise.
	 */
	public boolean hasNext(){
		return true;
	}
	
	/**
	 * Returns the next number in the sequence. This function may 
	 * only be called if hasNext() returns true.
	 * 
	 * @specified next in interface Sequence
	 * @return the next number in the sequence.
	 */
	public double next(){
		 
		if(current<=1){
			current++;
			return current-1;
		}
		this.follown= first + second;
		this.first = second;
		this.second = follown;
		return follown;
		
	}
	
	/**
	 * Returns a string representation of this sequence. This method returns 
	 * the string "fib()".
	 * 
	 * @override toString in class java.lang.Object
	 * @return a string representation of the sequence as defined above.
	 */
	public java.lang.String toString(){
		String fib = "fib()";
		return fib;
    	
    }
}