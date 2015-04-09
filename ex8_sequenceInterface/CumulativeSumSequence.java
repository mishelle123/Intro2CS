/**
 *  Given another sequence S=(s0,s1,...,sn), this sequence has for its i'th element a 
 * of (s0+s1+...+si).  For example, given a sequence S=(1,2,3), the elements of the 
 * cumulative sum sequence will be (1,3,6). 
 *  
 *  @author mishelle
 *
 */

import il.ac.huji.cs.intro.ex8.Sequence;
public class CumulativeSumSequence implements Sequence {

	private double n;
	private Sequence source;

	/**
	 * Constructs a new cumulative sum sequence over the given source.
	 * 
	 * @param sourceSequence
	 */
	CumulativeSumSequence(Sequence sourceSequence){
		this.source = sourceSequence;
		this.n = 0;
	}


	/**
	 * Checks whether or not there are more numbers in the sequence to return.
	 * The next() method may be called if and only if hasNext() returns true.
	 * 
	 * @specified hasNext in interface Sequence
	 * @return true if more numbers remain in the sequence, false otherwise.
	 */
	public boolean hasNext() {
		if(this.source!=null){
			return source.hasNext();

		}

		return false;
	}

	/**
	 * Returns the next number in the sequence. 
	 * This function may only be called if hasNext() returns true.
	 * 
	 * @specified next in interface Sequence
	 * @return the next number in the sequence.
	 */
	public double next() {

		n+= this.source.next();

		return n;
	}

	/**
	 * Returns a string representation of this sequence. Let S be the result of invoking 
	 * the source sequence's toString method, or "null" if the source sequence is null. 
	 * This method returns the string "cumulativeSum(S)".
	 */
	public java.lang.String toString(){
		if(this.source==null){
			return "null";
		}
		return ("cumulativeSum(" + source.toString() + ")");


	}

}