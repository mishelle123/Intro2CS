/**
 * 
 *  A sequence whose elements are ascending numbers. For all n>=0, 
 *  the n'th element of the sequence is n.
 *  For example, the first few elements are 0, 1, 2, 3, 4, ... 
 *  The elements returned should be of a range as wide as possible, i.e. 
 *  have the range of the double data type.
 * 
 * @author mishelle
 *
 */
import il.ac.huji.cs.intro.ex8.Sequence;
public class IdentitySequence implements Sequence { 

	private double current; 

	/**
	 * Constructs a new identity sequence.
	 * 
	 */
	IdentitySequence(){
		this.current = 0;
	}

	/**
	 * Checks whether or not there are more numbers in the sequence to return. 
	 * The next() method may be called if and only if hasNext() returns true.
	 * 
	 * @specified hasNext in interface Sequence
	 * @return true if more numbers remain in the sequence, false otherwise.
	 */
	public boolean hasNext(){
		return true;
	}

	/**
	 * Returns the next number in the sequence. 
	 * This function may only be called if hasNext() returns true.
	 * 
	 * @specified next in interface Sequence
	 * @return the next number in the sequence.
	 */
	public double next(){
		current ++;
		return current-1;
	}

	/**
	 * Returns a string representation of this sequence. 
	 * This method returns the string "n".
	 * 
	 * @override toString in class java.lang.Object 
	 * @return a string representation of the sequence as defined above.
	 */
	public java.lang.String toString(){
		String result = "n";
		return result;
	}
}