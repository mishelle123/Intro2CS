/**
 * A sequence whose elements are a constant number. 
 * For example, if the constant is 4, then the sequence would be 4, 4, 4, ...
 * 
 * @author mishelle
 *
 */
import il.ac.huji.cs.intro.ex8.Sequence;
public class ConstantSequence implements Sequence {
	private double sequenceC;


	/**
	 * Constructs a new constant sequence whose elements are all the given
	 * number.
	 * 
	 * @param d - the number to return as the sequence elements.
	 */
	ConstantSequence(double d){
		this.sequenceC = d;
	}

	/**
	 * Checks whether or not there are more numbers in the sequence 
	 * to return. The next() method may be called if and only if hasNext() 
	 * returns true.
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
		return sequenceC;
	}

	/**
	 * Returns a string representation of this sequence. Let c be the constant 
	 * returned by this sequence. This method returns the string "c", as returned 
	 * by Double.toString()
	 * 
	 * @override toString in class java.lang.Object
	 * @return a string representation of the sequence as defined above.
	 */
	public java.lang.String toString(){
		return "" + sequenceC;
	}

}