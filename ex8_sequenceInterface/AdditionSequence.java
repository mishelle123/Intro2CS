/**
 *  Given two sequences S=(s0,s1,...,sn) and T=(t0,t1,...,tm), this sequence
 *  has for its i'th element a value of (si+ti). The number of elements this 
 *  sequence has is exactly min{n,m} where n,m are the lengths of the two input sequences.
 *	For example, given two sequences S=(1,2,3), T=(7,4), the elements of the addition sequence 
 *  will be (8,6). 
 *  
 * @author mishelle
 *
 */
import il.ac.huji.cs.intro.ex8.Sequence;
public class AdditionSequence implements Sequence {
	private Sequence source1, source2;


	/**
	 * Constructs a new addition sequence over the given sources.
	 * 
	 * @param seq1
	 * @param seq2
	 */
	AdditionSequence(Sequence seq1, Sequence seq2){
		this.source1 = seq1;
		this.source2 = seq2;
		

	}
	
	/**
	 * Checks whether or not there are more numbers in the sequence to return. 
	 * The next() method may be called if and only if hasNext() returns true.
	 * 
	 * @Specified hasNext in interface Sequence
	 * @return true if more numbers remain in the sequence, false otherwise.
	 */
	public boolean hasNext(){
		if(source1==null || source2==null){
			return false;
		}
		if(source1.hasNext() && source2.hasNext()){
				return true;
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
	public double next(){
		return source1.next() + source2.next();
		}
		
	
	/**
	 * Returns a string representation of this sequence. Let S1, S2 be the results of 
	 * invoking the two source sequences' toString methods, or "null" if the corresponding 
	 * source sequence is null. This method returns the string "addition(S1,S2)".
	 * 
	 */
	public java.lang.String toString(){
		if(source1==null || source2==null){
			return null;
		}
		else{
			return "addition(" + source1.toString() + "," + source2.toString() + ")" ;
		}
	}
	
	

}