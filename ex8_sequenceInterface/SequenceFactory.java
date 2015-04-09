/**
 * Enables creation of sequences that correspond to the contents of strings.
 */

import static org.junit.Assert.assertEquals;

import java.beans.Expression;

import il.ac.huji.cs.intro.ex8.Sequence;

public class SequenceFactory {
	private String operators;

	public SequenceFactory(){

	}
	
	private final static char PLUS = '+';
	private final static char MINUS = '-';
	private final static char MULT = '*';
	private final static char DIVIDE  = '/';
	private final static char POWER = '^';
	private final static char CLOSEBRACKET = ')';
	private final static char OPENBRACKET= '(';
	private final static String RATIO = "ratio(";
	private final static String SUM = "sum(";
	private final static String FIB = "fib()";
	

	// returns if the expression is inside brackets.
	private static boolean isInsideBrackets(String expression, int charIndex)
	{
		int numberOfOpenBrackets = 0;
		for(int i = expression.length() -1; i> charIndex; i--)
		{
			if(expression.charAt(i) == CLOSEBRACKET)
			{
				numberOfOpenBrackets++;
			}
			else if (expression.charAt(i) == OPENBRACKET)
			{
				numberOfOpenBrackets--;
			}
		}		
		return numberOfOpenBrackets != 0;
	}

	private static boolean isOperator(char c)
	{
		return c == PLUS || 
				c == MINUS ||
				c == MULT ||
				c == DIVIDE ||
				c == POWER ;		
	}		

	// checks where to split the expression 
	private static int placeToSplit(String expression){
		// checks the '+' and '-' operators
		for(int i= expression.length()-1; i>=0; i-- ){

			if(expression.charAt(i)== PLUS && !isInsideBrackets(expression, i))
			{
				return i;				
			}

			// checks the '-' operator
			if(expression.charAt(i)==MINUS && !isInsideBrackets(expression, i)){
				// checks whether there is another operator before the minus	
				if(i!=0){
					if (!isOperator(expression.charAt(i-1)) ){
						return i;
					}

				}
			}
		}

		// checks the '*' and '/' operators
		for(int i= expression.length()-1; i>=0; i-- ){
			if((expression.charAt(i)== MULT || expression.charAt(i)== DIVIDE)
					&& !isInsideBrackets(expression, i))
			{
				return i;				
			}				
		}	

		// checks the '^' operator
		for(int i= expression.length()-1; i>=0; i-- ){
			if(expression.charAt(0)== MINUS){
				return 0;
			}
			if(expression.charAt(i)== POWER && !isInsideBrackets(expression, i))
			{
				return i;				
			}				
		}

		return -1;
	}

	/**
	 * Returns a sequence that corresponds to the given expression, as specified
	 * in the exercise description. Whitespace characters in the input string are ignored.
	 * 
	 * @param stringExpression - a string expression. Assumed to contain a legal expression string.
	 * @return a sequence equivalent to the string given. Returns null if the given string is null.
	 */
	public static Sequence sequenceFromString(java.lang.String stringExpression){
		String s= stringExpression;

		if(s==null || s.isEmpty())
			return null;

		s = s.replaceAll("\\s", "");


		int index = placeToSplit(s);
		if(index==0 && s.charAt(0)==MINUS){			
			return new MultiplicationSequence(new ConstantSequence(-1),sequenceFromString(s.substring(index+1)));			
		}

		//checks the operators
		if(index>0){
			switch(s.charAt(index)){
			case PLUS: 
				return new AdditionSequence(sequenceFromString(s.substring(0,index)) ,
						sequenceFromString(s.substring(index+1))); 

			case MINUS:
				return new AdditionSequence(sequenceFromString(s.substring(0,index)) ,
						sequenceFromString(s.substring(index)));

			case MULT:
				return new MultiplicationSequence(sequenceFromString(s.substring(0, index)) ,
						sequenceFromString(s.substring(index+1)));

			case DIVIDE:
				return new DivisionSequence(sequenceFromString(s.substring(0, index)) ,
						sequenceFromString(s.substring(index+1)));

			case POWER:
				return new PowerSequence(sequenceFromString(s.substring(0,index)) ,
						sequenceFromString(s.substring(index+1)));
			}

		}



		if(index==-1){
			if(s.startsWith("(") && s.endsWith(")")){
				return sequenceFromString(s.substring(1,s.length()-1));
			}
			if(s.startsWith(RATIO)){
				return new ConsecutiveRatioSequence((sequenceFromString(s.substring(6, s.length()-1)))); 
			}
			if(s.startsWith(SUM)){
				return new CumulativeSumSequence(sequenceFromString(s.substring(4, s.length()-1)));
			}
			if(s.equals(FIB)){
				return new FibonacciSequence(); 
			}
			if(s.equals("n")){
				return new IdentitySequence();
			}
			if(s.startsWith("(")){
				return sequenceFromString(s.substring(1, s.length()-1));
			}
			return new ConstantSequence(Double.parseDouble(s));

		}

		return null;
	}

	public static void main (String []args){

		String seqStr = "-n^-2";
		Sequence seq = SequenceFactory.sequenceFromString(seqStr);

		System.out.println(seq);

	}








}




