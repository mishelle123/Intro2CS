
/**
 * 
 * This class implements the well-known Game Of Life, invented in 1968 by John Conway. 
 * The universe of the Game of Life is a two-dimensional orthogonal grid of square cells, 
 * each of which is in one of two possible states: alive or dead. 
 * Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically,
 * or diagonally adjacent. A generation of the game is a state of the world: which cells are alive, 
 * and which cells are dead. The game advances from the initial generation to the next generation and so on. 
 * In the process of calculating generation n+1 from generation n, the following transitions occur 
 * (all 4 rules are applied simultaneously to every cell in the current generation - births and deaths occur 
 * simultaneously):
 *
 *
 * @author mishelle
 */


public class GameOfLife {
	/**
	 * creats the newWorld; 
	 */
	boolean [][] world;
	/**
	 * The hight of the world.
	 */
	private int worldHeight;
	/**
	 * The width of the world.
	 */
	private int worldWidth; 
	/**
	 * checks whether the world is cyclic.
	 */
	private boolean isCyclicClass = true; 

	/**
	 * Constructs a cyclic empty world with the given size.
	 *
	 * @param height - the height (number of rows) of the world. Assumed to be positive.
	 * @param width - the width (number of columns) of the world. Assumed to be positive.
	 **/
	public GameOfLife(int height, int width){
		worldHeight = height;
		worldWidth = width;
		world = new boolean[worldHeight][worldWidth]; 

	}

	/**    Advances this scanner past the curr
	 * Constructs an empty world with the given size.
	 * 
	 * @param height - the height (number of rows) of the world. Assumed to be positive.
	 * @param width - the width (number of columns) of the world. Assumed to be positive.
	 * @param isCyclic - whether the world is cyclic.
	 */
	public GameOfLife(int height, int width, boolean isCyclic){
		worldHeight = height;
		worldWidth = width;
		isCyclicClass = isCyclic;
		world = new boolean[worldHeight][worldWidth];
	}



	/**
	 * Constructs a world populated according to a String description.
	 * 
	 * @param height - the height (number of rows) of the world. Assumed to be positive.
	 * @param width - the width (number of columns) of the world. Assumed to be positive.
	 * @param content - a String description of the world.
	 * @param isCyclic - whether the world is cyclic.
	 */

	public GameOfLife(int height, int width, java.lang.String content, boolean isCyclic){
		worldHeight = height;
		worldWidth = width;
		isCyclicClass = isCyclic;
		this.world = new boolean[worldHeight][worldWidth];
		for(int y=0;y<=(worldHeight-1);y++){
			for(int x=0;x<=(worldWidth-1);x++){
				int index = (worldWidth+1)*y+x;
				if(content.charAt(index)=='+'){
					world[y][x] = true;
				}
			}

		}

	}

	/**
	 *
	 * Populates a creature in row y, column x (i.e. makes this cell alive). 
	 * If the parameters coordinates are outside of the world borders, no action is performed.
	 * 
	 * @param y - the row number. 
	 * @param x - the column number.
	 */
	public void addCreature(int y, int x){
		world[y][x] = true;

	}


	/**
	 * Removes a creature from the cell in row y, column x (i.e. makes this cell dead). 
	 * If the parameters coordinates are outside of the world borders, no action is performed.
	 * 
	 * @param y - the row number.
	 * @param x - the column number.
	 */
	public void removeCreature(int y, int x){
		world[y][x] = false;
	}

	/**
	 * Returns a two-dimensional boolean array representing the current state of the world.
	 * Any future changes to the world are not reflected on this array, and any future changes to this array 
	 * are not reflected in the world. 
	 * 
	 * @return a two-dimensional array in which cell [i][j] specifies 
	 * whether the cell in the i'th row and the j'th column is alive.
	 */
	public boolean[][] getWorld(){
		boolean [][] newWorld = new boolean[worldHeight][worldWidth];
		for(int y=0 ; y<=(worldHeight -1) ; y++){
			for(int x=0 ; x<=(worldWidth -1) ; x++){
				newWorld[y][x] = world[y][x];
			}
		}
		return newWorld.clone();
	}

	/**
	 * Returns the world's width (number of columns). 
	 * 
	 * @return the width (number of columns) of the world.
	 */
	public int getWidth(){
		return worldWidth;
	}

	/**
	 * Returns the world's height (number of rows). 
	 * 
	 * @return the height (number of rows) of the world.
	 */
	public int getHeight(){
		return worldHeight;
	}

	/**
	 * Advances the world to the next generation. The next generation is computed according to the following rules:
	 * Any cell that is alive and has fewer than two live neighbours in generation n will die of under-population, and will thus be dead in generation n+1.
	 * Any cell that is alive and has two or three live neighbours in generation n will stay alive in generation n+1.
	 * Any cell that is alive and has more than three live neighbours in generation n will die of overcrowding, and will thus be dead in generation n+1.
	 * Any cell that is dead and has exactly three live neighbours in generation n will be revived by reproduction, and will thus be alive in generation n+1. 
	 * 
	 */
	public void nextGeneration(){
		boolean nextGen[][] = new boolean [worldHeight][worldWidth];
		for(int y=0 ; y<=(worldHeight -1) ; y++){
			for(int x=0 ; x<=(worldWidth -1) ; x++){
				if(isCyclicClass){
					int neighboursNum = countNeighboursCyclic(y, x) ;
					boolean isAlive = false;
					isAlive = checkAlive(neighboursNum, world[y][x]);
					nextGen[y][x] = isAlive;
				}
				else{
					int neighboursNum = countNeighboursFinit(y, x) ;
					boolean isAlive = false;
					isAlive = checkAlive(neighboursNum, world[y][x]);
					nextGen[y][x] = isAlive;	
				}
			}

		}
		world = nextGen;




	}


	// cyclic world- count the number of neighbours next to specific cell
	private int countNeighboursCyclic(int y, int x){
		int countLiveCells = 0;
		if(world[(y-1+worldHeight)%worldHeight][x]){
			countLiveCells++;
		}
		if(world[(y+1+worldHeight)%worldHeight][x]){
			countLiveCells++;
		}
		if(world[(y-1+worldHeight)%worldHeight][(x+1+worldWidth)%worldWidth]){
			countLiveCells++;
		}
		if(world[y][(x+1+worldWidth)%worldWidth]){
			countLiveCells++;
		}
		if(world[(y+1+worldHeight)%worldHeight][(x+1+worldWidth)%worldWidth]){
			countLiveCells++;
		}
		if(world[(y-1+worldHeight)%worldHeight][(x-1+worldWidth)%worldWidth]){
			countLiveCells++;
		}
		if(world[y][(x-1+worldWidth)%worldWidth]){
			countLiveCells++;
		}
		if(world[(y+1+worldHeight)%worldHeight][(x-1+worldWidth)%worldWidth]){
			countLiveCells++;
		}
		return countLiveCells;

	}
	// finit world- count the number of neighbours next to specific cell
	private int countNeighboursFinit(int y, int x){
		int countLiveCells = 0;
		if(y!=0 && x!=0 && x!=(worldWidth-1) && y!=(worldHeight-1)){
			if(world[y-1][x]){
				countLiveCells++;
			}
			if(world[y-1][x-1]){
				countLiveCells++;
			}
			if(world[y][x-1]){
				countLiveCells++;
			}
			if(world[y+1][x-1]){
				countLiveCells++;
			}
			if(world[y+1][x]){
				countLiveCells++;
			}	
			if(world[y+1][x+1]){
				countLiveCells++;
			}
			if(world[y][x+1]){
				countLiveCells++;
			}
			if(world[y-1][x+1]){
				countLiveCells++;
			}	
		}
		else {
			if(y==0 && x==0){ // the left corner
				if(world[y][x+1]){
					countLiveCells++;
				}
				if(world[y+1][x+1]){
					countLiveCells++;
				}
				if(world[y+1][x]){
					countLiveCells++;
				}
			}
			if(y==(worldHeight-1) && x==0){ // down and left corner
				if(world[y-1][x]){
					countLiveCells++;
				}
				if(world[y-1][x+1]){
					countLiveCells++;
				}
				if(world[y][x+1]){
					countLiveCells++;
				}
			}
			if(y==(worldHeight-1) && x==(worldWidth-1)){ // down and right corner
				if(world[y-1][x]){
					countLiveCells++;
				}
				if(world[y-1][x-1]){
					countLiveCells++;
				}
				if(world[y][x-1]){
					countLiveCells++;
				}
			}
			if(y==0 && x==(worldWidth-1)){ // top and right corner
				if(world[y][x-1]){
					countLiveCells++;
				}
				if(world[y+1][x-1]){
					countLiveCells++;
				}
				if(world[y+1][x]){
					countLiveCells++;
				}
			}
			if(y==0 && x>0 && x<(worldWidth-1)){ // the top mid cells
				if(world[y][x-1]){
					countLiveCells++;
				}
				if(world[y+1][x-1]){
					countLiveCells++;
				}
				if(world[y+1][x]){
					countLiveCells++;
				}
				if(world[y+1][x+1]){
					countLiveCells++;
				}
				if(world[y][x+1]){
					countLiveCells++;
				}
			}
			if(y==(worldHeight-1) && x>0 && x<(worldWidth-1)){ // the boton mid cells
				if(world[y][x-1]){
					countLiveCells++;
				}
				if(world[y-1][x-1]){
					countLiveCells++;
				}
				if(world[y-1][x]){
					countLiveCells++;
				}
				if(world[y-1][x+1]){
					countLiveCells++;
				}
				if(world[y][x+1]){
					countLiveCells++;
				}
			}
			if(y>0 && y<(worldHeight-1) && x==0){ // the left mid cells
				if(world[y-1][x]){
					countLiveCells++;
				}
				if(world[y-1][x+1]){
					countLiveCells++;
				}
				if(world[y][x+1]){
					countLiveCells++;
				}
				if(world[y+1][x+1]){
					countLiveCells++;
				}
				if(world[y+1][x]){
					countLiveCells++;
				}
			}
			if(y>0 && y<(worldHeight-1) && x==(worldWidth-1)){ // the right mid cells
				if(world[y-1][x]){
					countLiveCells++;
				}
				if(world[y-1][x-1]){
					countLiveCells++;
				}
				if(world[y][x-1]){
					countLiveCells++;
				}
				if(world[y+1][x-1]){
					countLiveCells++;
				}
				if(world[y+1][x]){
					countLiveCells++;
				}
			}

		}
		return countLiveCells;
	}

	//cyclic world- check if the cell would live in the next generation;
	private boolean checkAlive(int neighbours ,boolean cellNow){
		boolean isAlive = false;
		if(cellNow){
			if(neighbours<2 || neighbours>3){
				isAlive= false;
			}
			else{
				isAlive= true;
			}
		}
		else{
			if(neighbours==3){
				isAlive=true;
			}
			else{
				isAlive=false;
			}
		}

		return isAlive;
	}

	/**
	 * Returns a String representation of the world. 
	 * 
	 * @return  String description of the world. In this String, a minus sign ('-') represents a dead cell, 
	 * and a plus sign ('+') represents a live cell.
	 */
	public java.lang.String toString(){
		String stringWorld = "";
		for(int y=0;y<=(worldHeight-1);y++){
			for(int x=0;x<=(worldWidth-1);x++){
				if(world[y][x]){
					stringWorld+="+";
				}
				else { 
					stringWorld+="-";
				}
			}
			stringWorld+='\n';
		}
		return stringWorld;


	}
}
