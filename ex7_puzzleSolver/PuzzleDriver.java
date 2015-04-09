
/**
 * This class contains a main method that runs your solver with a graphical user interface.
 * 
 * @author intro2cs team
 *
 */
public class PuzzleDriver {

	public static final int BOARD_WIDTH = 8;
	public static final int BOARD_HEIGHT = 8;
	public static final int PIECE_SIZE = 5;
	public static final int NUM_PIECES = 12;

	/**
	 * Main method.
	 * 
	 * Usage: java PuzzleDriver <i>&lt;board_num&gt;</i> <i>&lt;delay_in_milli_seconds&gt;</i>
	 * 
	 * @param args the command line parameters. The first parameter is a board number
	 * (to choose one of several pre-defined boards), the second is the delay in milliseconds
	 * (used for updating the graphical display).
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java PuzzleDriver <board_num> <delay>");
			return;
		}

		int boardNum = Integer.parseInt(args[0]);
		int delay = Integer.parseInt(args[1]);

		PuzzlePiece [] pieces = createPieces();
		PuzzleData data = new PuzzleData(BOARD_WIDTH,BOARD_HEIGHT, pieces);
		fillBlackSquares(data,boardNum);
		PuzzleGUI gui = new PuzzleGUI(data,delay);
		gui.run();
	}

	/**
	 * Fills the board with black squares from one of the pre-defined boards.
	 * 
	 * @param boardNum indicates which of a set of pre-defined boards to use.
	 * @return an array of the positions of the black squares.
	 * 
	 */
	public static int[][] fillBlackSquares(PuzzleData data, int boardNum) {
		int [][] black = null;
		switch (boardNum) {
		case 1: 	
			black = new int[4][2];
			black[0][0] = 3; black[0][1] = 3;
			black[1][0] = 3; black[1][1] = 4;
			black[2][0] = 4; black[2][1] = 3;
			black[3][0] = 4; black[3][1] = 4; 
			break;
		
		case 2: 
			black = new int[4][2];
			black[0][0] = 2; black[0][1] = 5;
			black[1][0] = 3; black[1][1] = 5;
			black[2][0] = 2; black[2][1] = 6;
			black[3][0] = 3; black[3][1] = 6; 
			break;
		case 3: 
			black = new int[4][2];
			black[0][0] = 2; black[0][1] = 5;
			black[1][0] = 5; black[1][1] = 2;
			black[2][0] = 2; black[2][1] = 2;
			black[3][0] = 5; black[3][1] = 5; 
			break;
		}
		
		if (black != null) {
			for (int i=0; i<black.length; i++) {
				data.setSquare(black[i][1],black[i][0],-1);
			}
		}
		return black;
	}
	
	/**
	 * Creates the twelve pre-defined puzzle pieces with five squares each.
	 * 
	 * @return an array of twelve puzzle pieces. 
	 */
	public static PuzzlePiece [] createPieces() {
		PuzzlePiece [] pieces = new PuzzlePiece[NUM_PIECES];
		int j=0;
		boolean [][] p = new boolean[1][5];
		for (int i=0; i<p[0].length;i++) {
			p[0][i] = true;
		}
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[3][3];
		p[0][0] = false; p[0][1] = true; p[0][2] = false; 
		p[1][0] = true; p[1][1] = true; p[1][2] = true; 
		p[2][0] = false; p[2][1] = true; p[2][2] = false; 
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[3][3];
		p[0][0] = false; p[0][1] = true; p[0][2] = true; 
		p[1][0] = false; p[1][1] = true; p[1][2] = false; 
		p[2][0] = true; p[2][1] = true; p[2][2] = false; 
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[3][3];
		p[0][0] = true; p[0][1] = false; p[0][2] = false; 
		p[1][0] = true; p[1][1] = false; p[1][2] = false; 
		p[2][0] = true; p[2][1] = true; p[2][2] = true; 
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[3][3];
		p[0][0] = true; p[0][1] = true; p[0][2] = true; 
		p[1][0] = false; p[1][1] = true; p[1][2] = false; 
		p[2][0] = false; p[2][1] = true; p[2][2] = false; 
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[3][3];
		p[0][0] = true; p[0][1] = false; p[0][2] = false; 
		p[1][0] = true; p[1][1] = true; p[1][2] = false; 
		p[2][0] = false; p[2][1] = true; p[2][2] = true; 
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[2][3];
		p[0][0] = true; p[0][1] = true; p[0][2] = true; 
		p[1][0] = true; p[1][1] = false; p[1][2] = true; 
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[2][4];
		p[0][0] = true; p[0][1] = false; p[0][2] = false; p[0][3] = false;
		p[1][0] = true; p[1][1] = true; p[1][2] = true; p[1][3] = true;
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[2][4];
		p[0][0] = false; p[0][1] = false; p[0][2] = true; p[0][3] = true;
		p[1][0] = true; p[1][1] = true; p[1][2] = true; p[1][3] = false;
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[2][4];
		p[0][0] = false; p[0][1] = false; p[0][2] = true; p[0][3] = false;
		p[1][0] = true; p[1][1] = true; p[1][2] = true; p[1][3] = true;
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[3][3];
		p[0][0] = false; p[0][1] = true; p[0][2] = false; 
		p[1][0] = true; p[1][1] = true; p[1][2] = true; 
		p[2][0] = false; p[2][1] = false; p[2][2] = true; 
		pieces[j++] = new PuzzlePiece(p);

		p = new boolean[3][2];
		p[0][0] = true; p[0][1] = true; 
		p[1][0] = true; p[1][1] = true; 
		p[2][0] = false; p[2][1] = true; 
		pieces[j++] = new PuzzlePiece(p);
		
		return pieces;
	}


}
