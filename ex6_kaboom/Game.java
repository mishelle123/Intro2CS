import java.util.ArrayList;
import java.util.Random;

/**
 * A complete, yet abstract, representation of a Kaboom! game state, including the position of the bucket, 
 * the position/direction of the bomber, the position(s) of the bombs, etc.
 * 
 * @author mishelle
 *
 */

public class Game {

	private GameParams params;
	private Rectangle bomber;
	private Rectangle bucket;
	private int scores=0;
	private ArrayList<Circle> bombs;
	private boolean isOver;
	private int countSteps = 0;
	private int countTicks = 0;
	private Random rnd = new Random();
	private boolean moveRight = true;
	private double gameHeight=0, gameWidth=0;
	
	/**
	 * Constructs a new Game governed by the given parameters. 
	 * The entire settings of the game (e.g. sizes of objects) are specified by the given GameParams object.
	 * The score is reset to 0, the positions of the bomber and of the bucket are initialized according to the
	 * game parameters, and the starting direction of the bomber is set to the left. A bomb is dropped by the
	 * bomber at the instance the game begins.
	 *  
	 * @param params
	 */

	public Game(GameParams params){ // to add scores
		isOver = false;
		gameHeight= params.getGameHeight();
		gameWidth = params.getGameWidth();
		this.params = params;
		Point bomberTopLeft = new Point(params.getBomberInitialTopLeftX(),
										params.getBomberTopLeftY());
		bomber = new Rectangle(bomberTopLeft, params.getBomberWidth(), params.getBomberHeight());
		Point bucketTopLeft = new Point(params.getBucketInitialTopLeftX(),
										params.getBucketTopLeftY()) ;
		bucket = new Rectangle(bucketTopLeft, params.getBucketWidth(), params.getBucketHeight());
		bombs = new ArrayList<Circle>();
		double newBombCenterX = bomber.getTopLeft().getX() + bomber.getWidth()*0.5;
		double newBombCenterY = params.getBombsInitialY();
		Point newBombCenter = new Point(newBombCenterX, newBombCenterY);
		Circle newBomb = new Circle(newBombCenter, params.getBombsRadius());
		bombs.add(newBomb);

	}

	/**
	 * Returns the geometry of one of the bombs in this Game. 
	 * 
	 * @param i - the index of the requested bomb. Assumed to be ≥ 0 and < the value returned by numberOfBombs. 
	 * While the order of bombs is not guaranteed, it is guaranted that between calls to step, each bomb is consistently indexed by exactly one index. 
	 * (Thus, iterating over all indices will return all bombs, each one exactly once.)
	 * 
	 * @return the geometry of the bomb indexed as i in the current game step.
	 */
	public Circle getBomb(int i){
		Circle newBomb = new Circle(bombs.get(i));
		return newBomb;

	}

	/**
	 * Returns the current geometry of the bomber in this Game. 
	 * 
	 * @return the current geometry of the bomber in this Game.
	 */
	public Rectangle getBomber(){
		Rectangle bomberCopy = new Rectangle(bomber); // like this?
		return bomberCopy;

	}

	/**
	 * Returns the current geometry of the bucket in this Game. 
	 * 
	 * @return the current geometry of the bucket in this Game.
	 */
	public Rectangle getBucket(){
		Rectangle bucketCopy = new Rectangle(bucket);
		return bucketCopy;
	}

	/**
	 * Return the score of this Game. 
	 * 
	 * @return the score of this Game.
	 */
	public int getScore(){
		return scores;
	}

	/**
	 * Checks whether this Game is over. 
	 * 
	 * @return whether this Game is over.
	 */
	public boolean isOver(){
		return isOver;
	}
	/**
	 *  Moves the bucket left according to the speed specified by the game parameters. 
	 *  
	 */
	public void moveBucketLeft(){
		if(bucket.getTopLeft().getX()>0){
		Point newPointLeft = new Point((bucket.getTopLeft().getX()-params.getBucketSpeed()),bucket.getTopLeft().getY());
		bucket.setTopLeft(newPointLeft);
		}
	}
	/**
	 * Moves the bucket right according to the speed specified by the game parameters. 
	 */
	public void moveBucketRight(){
		if(bucket.getTopLeft().getX()+bucket.getWidth()<params.getGameWidth()){
		Point newPointLeft = new Point((bucket.getTopLeft().getX()+params.getBucketSpeed()),bucket.getTopLeft().getY());
		bucket.setTopLeft(newPointLeft);
		}
	}

	/**
	 * Returns the current number of bombs in this Game.
	 * 
	 * @return the current number of bombs in this Game.
	 */
	public int numberOfBombs(){
		return bombs.size();
	}
	
	/*
	 * moves the bomberLeft
	 */
	private void moveBomberLeft(){
		if(bomber.getTopLeft().getX()>=params.getBomberSpeed()){
			Point newPointLeft = new Point((bomber.getTopLeft().getX()-params.getBomberSpeed()),bomber.getTopLeft().getY());
			bomber.setTopLeft(newPointLeft);
		}
		else{
			moveRight =! moveRight;
		}
	}
	
	/*
	 * moves the bomber right
	 */
	private void moveBomberRight(){
		if(bomber.getTopLeft().getX()<=(params.getGameWidth()-bomber.getWidth())){
			Point newPointLeft = new Point((bomber.getTopLeft().getX() + params.getBomberSpeed()),bomber.getTopLeft().getY());
			bomber.setTopLeft(newPointLeft);
		}
		else {
			moveRight =! moveRight;
		}
	}
	public void step(){
	
		countSteps++;
		/*step 1 - Moves the bomber right or left (in a "random" manner). 
		The bomber should be in constant motion, but does not move in a predictable pattern. 
		Once the bomber commences in a particular direction (left or right), it continues to move in that direction for a randomly-chosen number of game steps within the bounds specified by the game parameters.
		If it reaches the edge of the gameplay field, it always changes direction.*/
		if(countTicks==0){
			int possibleTicksNum = rnd.nextInt(params.getMaxStepsTillDirectionChange()-
					params.getMinStepsTillDirectionChange()+1);
			countTicks = params.getMinStepsTillDirectionChange()+ possibleTicksNum;
			moveRight =! moveRight;
		}
		if(moveRight){
			moveBomberRight();
		}
		else{
			moveBomberLeft();
		}
		countTicks--;

		

		//step 2 - Moves all bombs down toward the bottom of the game play field.
		for(int i=0;i<=(bombs.size()-1);i++){
		//	Point initialBombPoint = new Point(bomber.getTopLeft())
			double newBombX = bombs.get(i).getCenter().getX();
			double newBombY = bombs.get(i).getCenter().getY() + params.getBombsSpeed();
			Point newCenter = new Point(newBombX, newBombY);
			bombs.get(i).setCenter(newCenter); 
		}

		/*step 3 - Checks whether the bucket has caught one or more bombs; a bomb is caught if its center is
	inside the bucket. The score increases by the amount specified by the game parameters for every bomb caught. */
		for(int k=0;k<=(bombs.size()-1);k++){
			if(bucket.isPointInside(bombs.get(k).getCenter())){
				scores += params.getPointsPerBomb();
				bombs.remove(k);
			}

		}

		/*step 4 - Checks whether any bomb has reached the bottom of the gameplay field 
		 * (i.e. whether the bottom of any bomb has reached the bottom of the gameplay field),
		 *  in which case the game is over. 
		 */
		for(int j=0;j<=(bombs.size()-1);j++){
			double bombYReachBottom = bombs.get(j).getCenter().getY() + bombs.get(j).getRadius(); 
			if(bombYReachBottom==params.getGameHeight()){
				isOver = true;
			}
		}
		/*
		 * step 5 - Possibly dropping a bomb by the bomber, according to the game parameters. 
		 */
		if(countSteps%params.getBombsFrequency()==0){
			double newBombCenterX = bomber.getTopLeft().getX() + bomber.getWidth()*0.5;
			double newBombCenterY = params.getBombsInitialY();
			Point newBombCenter = new Point(newBombCenterX, newBombCenterY);
			Circle newBomb = new Circle(newBombCenter, params.getBombsRadius());
			bombs.add(newBomb);
		}
		
	}
	
	
	
	

}


