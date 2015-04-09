import java.util.ArrayList;
import javax.naming.InitialContext;

public class PuzzlePiece {

	private ArrayList<boolean[][]> conformations = new ArrayList<boolean[][]>();

	/**
	 * Constructor for a puzzle piece
	 * 
	 * @param initialConformation  - a two-dimensional boolean array that represents 
	 * the initial (default) conformation for this piece.
	 */
	public PuzzlePiece(boolean[][] initialConformation){
		// adds the initial conformation and rotates it
		do{
			conformations.add(initialConformation);
			initialConformation = rotatePiece(initialConformation);

		}
		// while all the pieces are different
		while(!checkEquals(initialConformation, conformations.get(0)));
		
		//flip
		initialConformation = flipPiece(initialConformation);
		boolean insideConformations = false;
		//checks if the flipConformatiom equals to all the other conformaations
		for(int i=0; i<conformations.size(); i++){
			if(checkEquals(conformations.get(i), initialConformation)){
				insideConformations = true;
			}
		}
		
		// if its not equals add it to the array
		if(!insideConformations){
			int firstFlipIndex = conformations.size();
			do{
				conformations.add(initialConformation);
				initialConformation = rotatePiece(initialConformation);

			}
			// as long as the pieces are not equals
			while(!checkEquals(initialConformation, conformations.get(firstFlipIndex)));
		}
	}
	
	/**
	 * Returns a representation of the piece in one of its conformations. 
	 * The legal values for the parameter are from 0 to numberOfConformations-1.
	 * 
	 * @param conformation - the number of conformation.
	 * @return a two-dimensional boolean array that represents the requested conformation, 
	 * null if the number of conformation isn't legal.
	 */
	public boolean[][] getConformation(int conformation){
		return conformations.get(conformation);
	}
	
	/**
	 * the number of different conformations the piece has (>= 1).
	 * 
	 * @return the number of different conformations the piece has (>= 1).
	 */
	public int getNumberOfConformations(){
		return conformations.size();
	}
	
	// rotates the given piece
	private static boolean[][] rotatePiece(boolean[][] piece){
		int width = piece.length;
		int height = piece[0].length;
		boolean[][] rotatePiece = new boolean[height][width];
		for(int i=0; i<width; i++){
			for(int j=0; j<height ; j++){
				rotatePiece[j][width-1-i] = piece[i][j];
			}
		}
		return rotatePiece;
	}

	// flips the given piece
	private static boolean[][] flipPiece(boolean[][] piece){
		int width = piece.length;
		int height = piece[0].length;
		boolean[][] flipPiece = new boolean[width][height];
		for(int i=0; i<width; i++){
			for(int j=0; j<height ; j++){
				flipPiece[i][j] = piece[width-1-i][j];
			}
		}
		return flipPiece;
	}


	//check equals arrays
	private boolean checkEquals(boolean[][] piece1, boolean[][] piece2){
		if(piece1.length!=piece2.length){
			return false;

		}
		if(piece1[0].length!=piece2[0].length){
			return false;	
		}

		for(int i=0 ; i<piece1.length; i++){
			for(int j = 0 ; j<piece1[i].length; j++){
				if(piece1[i][j]!=piece2[i][j]){
					return false;
				}
			}
		}
		return true;
	}

	/* print Matrix for self check
	public static void printMatrix(boolean[][] puzzle){
		for(int i=0; i<puzzle.length ; i++){
			for(int j =0; j<puzzle[i].length;j++){
				if(puzzle[i][j]){
					System.out.print(" * ");
				}
				else{
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}
	*/

}