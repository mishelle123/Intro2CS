/**
 * Given two sequences S=(s0,s1,...,sn) and T=(t0,t1,...,tm), this sequence
 * has for its i'th element a value of (si/ti). The number of elements this 
 * sequence has is exactly min{n,m} where n,m are the lengths of the two input sequences. 
 * To avoid division by zero, in case ti == 0, the i'th element is defined as 0. 
 * For example, given two sequences S=(1,2,3), T=(7,4), the elements of the division 
 * sequence will be (1/7,1/2). 
 * 
 * 
 * @author mishelle
 *
 */
import il.ac.huji.cs.intro.ex8.Sequence;
public class DivisionSequence implements Sequence {
	private Sequence seq1, seq2;
	
	/**
	 * Constructs a new division sequence. If any of the source sequences is null,
	 * the resulting sequence is empty. It is assumed that the given source sequence 
	 * parameters are not accessed by any other code; i.e. the newly constructed 
	 * sequence should hold a reference to these source Sequence instances.
	 * 
	 * @param seq1 - the sequence whose elements will the numerators. 
	 * @param seq2 - the sequence whose elements will be the denominators. 
	 */
	DivisionSequence(Sequence seq1, Sequence seq2){
		this.seq1 = seq1;
		this.seq2 = seq2;
	}
	
	/**
	 * Checks whether or not there are more numbers in the sequence to return.
	 * The next() method may be called if and only if hasNext() returns true.
	 * 
	 * @specified hasNext in interface Sequence
	 * @return true if more numbers remain in the sequence, false otherwise.
	 */
	public boolean hasNext(){
		if(seq1==null || seq2==null){
			return false;
		}
		if(seq1.hasNext() && seq2.hasNext()){
				return true;
			}
		return false;	
	}
	
	/**
	 * /**
	 * Checks whether or not there are more numbers in the sequence to return. 
	 * The next() method may be called if and only if hasNext() returns true.
	 * 
	 * @Specified hasNext in interface Sequence
	 * @return true if more numbers remain in the sequence, false otherwise.
	 */
	public double next(){
		double seq2n = seq2.next();
		if(seq2n==0){
			return 0;
		}
		else{
		return seq1.next()/seq2n;	
		}
	}
	
	/**
	 * Returns a string representation of this sequence. Let S1, S2 be the results of 
	 * invoking the two source sequences' toString methods, or "null" if the corresponding 
	 * source sequence is null. This method returns the string "division(S1,S2)".
	 */
	public java.lang.String toString(){
		if(seq1==null || seq2==null){
			return null;
		}
		else{
			return "division(" + seq1.toString() + "," + seq2.toString() + ")" ;
		}
	}
	
	
	
}
