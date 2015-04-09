
/**
 * This class checks if it possible to reach the end of an array 
 * by walking according to the given numbers of the array.
 * 
 * @author mishelle
 *
 */

public class GetToTheZero {
	/**
	 *  return if the given array is solvable
	 * 
	 * @param start - the start index
	 * @param board - the board to check
	 * @return - true if there is a solution and false if not.
	 */
	public static boolean isSolvable(int start, int[] board){
		// creates the boolean array
		boolean[] visitedBoard = new boolean[board.length];
		return isSolvableHelper(start, board, visitedBoard);
		

	}

	/**
	 * checks if the given array is solvable
	 * 
	 * @param start - the start index
	 * @param board - the board to check
	 * @param visitedBoard - boolean array represents if I have been to this point.
	 * @return
	 */
	public static boolean isSolvableHelper(int start, int[] board, boolean[] visitedBoard){
		// checks if I have been to this place.
		if (visitedBoard[start]){
			return false;
		}
		// checks if I have reaches the end of the array.
		if(board[start]==0){
			return true;
		}
		// mark in the array - I have been to this place.
		visitedBoard[start]= true;
		// I can go to the left and to the right
		if((start - board[start])>=0 && (start + board[start]<board.length)){
			return (isSolvableHelper(start + board[start], board, visitedBoard) || 
					isSolvableHelper(start - board[start], board, visitedBoard));

		}
		// I can only go to the right
		if((start - board[start])<0 && (start + board[start])<board.length){
			return isSolvableHelper (start + board[start], board, visitedBoard);
		}
		// I can only go to the left
		if((start - board[start])>=0 && (start + board[start]>board.length)){
			return isSolvableHelper (start - board[start], board, visitedBoard);
		}
		// I am stuck
		return false;
	}
		

}


