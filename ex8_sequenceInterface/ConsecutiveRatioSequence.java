/**
 * Given another sequence S=(s0,s1,...,sn), this sequence has for its i'th 
 * element a value of (s(i+1)/s(i)).
 * The first element has a value of s1/s0, and thus this sequence has one less 
 * element than the source sequence.
 * In case the the source sequence has an element s(i) == 0, the i'th element 
 * in this sequence is defined as 0, to avoid illegal division. 
 * For example, given a source sequence S=(1,2,3,0,7,-14), the elements 
 * of the ratio sequence will be (2,1.5,0,0,-2). 
 * 
 * @author mishelle
 *
 */
import il.ac.huji.cs.intro.ex8.Sequence;
public class ConsecutiveRatioSequence implements Sequence {

	private Sequence source;
	private double n;

	/**
	 * Constructs a new consecutive ratio sequence over the given source.
	 * 
	 * @param sourceSequence - a source sequence whose elements will be used. 
	 * If the source sequence is null, the resulting sequence is empty. It is 
	 * assumed that the source sequence is not accessed by any other code; i.e. 
	 * the newly constructed sequence should hold a reference to this
	 * source Sequence instance.
	 */
	public ConsecutiveRatioSequence(Sequence sourceSequence){	
		this.source = sourceSequence;
		if(sourceSequence!=null){
			if(source.hasNext()){
				this.n = source.next();
			}
		}



	}


	/**
	 * Checks whether or not there are more numbers in the sequence to return. 
	 * The next() method may be called if and only if hasNext() returns true.
	 * 
	 * @Specified hasNext in interface Sequence
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
		double follown; 

		if(n==0){
			follown=source.next();
			n= follown;
			return 0 ; 
		}


		follown = source.next();
		double result = (follown/n);
		n= follown;
		return result;
	}





	/**
	 * Returns a string representation of this sequence. 
	 * Let S be the result of invoking the source sequence's toString
	 * method, or "null" if the source sequence is null. 
	 * This method returns the string "ratio(S)".
	 * 
	 *@Overrides toString in class java.lang.Object
	 *@return a string representation of the sequence as defined above.
	 */
	public java.lang.String toString(){
		if(this.source==null){
			return null;
		}
		return ("ratio(" + source.toString() + ")");

	}

}

