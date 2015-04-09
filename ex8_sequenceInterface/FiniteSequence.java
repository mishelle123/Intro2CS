/**
 * A finite sequence of numbers.
 * 
 * @author mishelle
 *
 */
import il.ac.huji.cs.intro.ex8.Sequence;
public class FiniteSequence implements Sequence {
	private int current;
	private double[] sourceArray;

	/**
	 * Constructs a sequence whose elements are the contents of the
	 * given array.
	 * 
	 * @param sourceArray - an array whose elements will be stored as a new 
	 * sequence. In case the array is null, the sequence will be empty.
	 */
	FiniteSequence(double[] sourceArray){
		this.sourceArray = sourceArray;
		if(sourceArray!=null){
		this.sourceArray = sourceArray.clone();
		}
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
		if(sourceArray!=null){
		if(current<sourceArray.length){
			return true;
		}
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
			this.current++;
			return sourceArray[current-1];
			
	}

	/**
	 * Returns a string representation of this sequence. 
	 * This method returns the string "finiteSequence(s0,s1,...,sn)",
	 * where the elements of the finite sequence are s0,...,sn. If the sequence is empty, 
	 * no elements are displayed in the parentheses.  
	 * As an example, the output may be "finiteSequence(1.0,15.2,7.33)" for 
	 * a non-empty sequence, or "finiteSequence()" for an empty sequence.
	 * 
	 * @override toString in class java.lang.Object
	 * @return a string representation of the sequence as defined above.
	 */
	public java.lang.String toString(){
	String result = "finiteSequence(";
	if(sourceArray!=null){
	for(int i=0; i<sourceArray.length; i++){
		result += sourceArray[i];
		if(i!=sourceArray.length-1){
			result += ",";
		}
	}
	}
	return result + ")" ;
	}

}