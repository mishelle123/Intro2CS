

/**
 * This class solves a Fill-the-Board puzzle, given a board and a list of pieces, 
 * using the recursive backtracking approach. 
 * 
 * @author mishelle
 *
 */

public class PuzzleSolver {
	PuzzleGUI gui;
	PuzzleData data;
	boolean[] countPieces;
	int countRecursiveCalls;
	String recsNum = "Number of recursion calls:" ;



	/**
	 * Constructor for a solver of the Fill-the-Board puzzle.
	 * 
	 * @param data - an object containing the board and the list of puzzle pieces to use.
	 */

	public PuzzleSolver(PuzzleData data){
		this.data = data;
		countPieces = new boolean[data.getPieces().length];
		countRecursiveCalls = 0;
	}

	/**
	 * Solves the puzzle.
	 * The solution uses recursive backtracking, as described in more detail in the
	 *  definition of the exercise, while displaying the board using the provided GUI, as
	 * the solution progresses. More specifically, as each puzzle piece is placed on the 
	 * board, the corresponding cells on the board are painted. This is done by first calling
	 * PuzzleGUI.startPiece(int) followed by a number of calls to PuzzleGUI.colorSquare(int,int) 
	 * and finishing with a call to PuzzleGUI.endPiece(). Every time a new recursive call is made,
	 * the number of calls made so far should be displayed in the GUI 
	 * (using PuzzleGUI.setStatusMessage(String)). 
	 * 
	 * @param gui - the GUI object, needed for graphically displaying the board.
	 * @return if the board is solvable.
	 */
	public boolean solve(PuzzleGUI gui){
		this.gui = gui;
		return recursiveCall();

	}


	// gets the next left free index on the board
	private int[] getNextFreeIndex(){
		int[] point=new int[2];
		for(int y=0; y<data.getBoard().length; y++){
			for(int x=0; x<data.getBoard()[0].length; x++){
				if(data.getBoard()[y][x]==0){
					point[0]= x;
					point[1]= y;
					return point;
				}
			}
		}
		point[0]= -1;
		point[1]= -1;
		return point;

	}

	// gets the piece initial X index
	private int pieceInitialX(int pieceNum, int confNum){
		boolean[][] piece = data.getPiece(pieceNum).getConformation(confNum);
		int pieceBeginX =0; 
		for(int y=0; y<piece.length; y++){
			for(int x=0; x<piece[0].length; x++){
				if(piece[y][x]){
					pieceBeginX = x;
					return pieceBeginX;

				}
			}
		}
		return pieceBeginX;
	}

	// checks if the piece fits
	private boolean pieceFits(int pieceNum, int confNum){
		boolean[][] piece = data.getPiece(pieceNum).getConformation(confNum);
		int[] freeIndex = getNextFreeIndex();
		int beginX = pieceInitialX(pieceNum, confNum);
		for(int i=0; i<piece.length; i++){
			for(int j =0; j<piece[0].length;j++){
				if(piece[i][j]){
					if(freeIndex[0] + (j-beginX)>=data.getBoardWidth()){
						return false;
					}
					if(freeIndex[0] + (j-beginX)<0){
						return false;
					}
					if(freeIndex[1] + (i)>=data.getBoardHeight()){
						return false;
					}
					if(freeIndex[1] + (i)<0){
						return false;
					}

					if(data.getBoard()[freeIndex[1] + (i)][freeIndex[0] + (j-beginX)]!=0){
						return false;
					}

				}

			}
		}
		return true;
	}



	// insert the piece
	public void insertPiece(int pieceNum, int confNum){
		boolean[][] piece = data.getPiece(pieceNum).getConformation(confNum);
		int[] freeIndex = getNextFreeIndex();
		int beginX = pieceInitialX(pieceNum, confNum);
		gui.startPiece(pieceNum + 1);
		for(int y=0; y<piece.length; y++){
			for(int x = 0; x<piece[0].length;x++){
				if(piece[y][x]){
					data.setSquare(freeIndex[0] + (x-beginX),freeIndex[1] + y, pieceNum + 1);
					gui.colorSquare(freeIndex[0] + (x-beginX),freeIndex[1] + y, pieceNum + 1);	
				}
			}
		}
		gui.endPiece();

	}

	//remove piece 
	public void removePiece(int pieceNum, int confNum){
		gui.startPiece(0);
		for(int y=0; y<data.getBoardHeight(); y++){
			for(int x = 0; x<data.getBoardWidth();x++){
				if(data.getBoard()[y][x]==pieceNum +1){
					data.setSquare(x, y, 0);
					gui.colorSquare(x, y); 

				}
			}
		}
		gui.endPiece();
	}

	// checks if the pieces are over
	private boolean finishPieces(){
		int usedAllPieces = 0;
		for(int i=0; i< countPieces.length; i++){
			if(countPieces[i]){
				usedAllPieces++;
			}
		}
		if(usedAllPieces==countPieces.length){
			return true;
		}
		return false;
	}



	// recursive method fills the board with the pieces
	private boolean recursiveCall() { 
		countRecursiveCalls++;
		gui.setStatusMessage(recsNum + countRecursiveCalls);
		int piecesNumber = data.getPieces().length;
		if(finishPieces()){
			return true;
		}
		// implements the recursive call on the pieces and the configurations.
		for(int i=0; i<=piecesNumber-1; i++){
			if (!countPieces[i]){
				for(int j=0; j<=data.getPiece(i).getNumberOfConformations()-1; j++){
					if(pieceFits(i,j)){
						insertPiece(i,j);
						countPieces[i]= true;		
						if(recursiveCall()){
							return true;
						}
						else{
							removePiece(i,j);
							countPieces[i]= false;
						}

					}
				}
			}

		}


		return false;
	}


}


