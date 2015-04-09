import java.awt.Graphics;
import java.awt.Font;
import  java.awt.Color;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;



/**
 * A mediator between a Game logic and a KaboomView) GUI, responsible for translating timer
 * ticks and mouse movements to Game messages, and for graphically drawing the Game. The API 
 * does not guarantee the exact details of how the game is drawn. (E.g. it does not guarantee the colors.) 
 * 
 * @author mishelle
 */

public class Mediator {
	private Game kaboom;
	private String gameOver = "Game Over";
	private double mouseX;
	private Point newLocation;
	private Point test = new Point(0,0);
	private String GameOver = "Game Over";
	

	/**
	 * Constructor a Mediator object encapsulating a given Game object. 
	 * 
	 * @param game
	 */
	public Mediator(Game game){
		this.kaboom = game;

	}
	/**
	 * Paints the entire content of the encapsulated Game, including the bucket, 
	 * bomber, bombs, the current score and the game over message if relevant. Called by the KaboomView 
	 * whenever the game graphics are to be refreshed. 
	 * 
	 * @param g
	 */
	public void drawGame(Graphics g){
		g.setColor(Color.pink);
		//creates the bomber
		int bomberTopLeftX = (int)(kaboom.getBomber().getTopLeft().getX());
		int bomberTopLeftY = (int)(kaboom.getBomber().getTopLeft().getY());
		int bomberWidth = (int)(kaboom.getBomber().getWidth());
		int bomberHeight = (int)(kaboom.getBomber().getHeight());
		g.fillRect(bomberTopLeftX, bomberTopLeftY, bomberWidth,bomberHeight);
		g.setColor(Color.darkGray);
		//creates the bucket
		int bucketTopLeftX = (int)(kaboom.getBucket().getTopLeft().getX());
		int bucketTopLeftY = (int)(kaboom.getBucket().getTopLeft().getY());
		int bucketWidth = (int)(kaboom.getBucket().getWidth());
		int bucketHeight = (int)(kaboom.getBucket().getHeight());
		g.fillRect(bucketTopLeftX, bucketTopLeftY, bucketWidth,bucketHeight);
		g.setColor(Color.white);
		//creates the bombs
		for(int i=0;i<kaboom.numberOfBombs();i++){
			int bombCenterPointX = (int)(kaboom.getBomb(i).getCenter().getX());
			int bombCenterPointY = (int)(kaboom.getBomb(i).getCenter().getY());
			int bombRadius = (int)(kaboom.getBomb(i).getRadius());
			g.fillOval(bombCenterPointX, bombCenterPointY, bombRadius, bombRadius);
		}
		//creates the scores
		int scores = kaboom.getScore();
		g.setColor(Color.black);
		g.setFont(new Font(null,Font.PLAIN,40));
		g.drawString(String.valueOf(scores), 550, 50);
		//create game over
		if(kaboom.isOver()){
			g.setColor(Color.red);
			g.setFont(new Font(null,Font.PLAIN,50));
			g.drawString(gameOver, 200, 200);
		}
	}

	/**
	 * Registers a mouse movement. Called by the KaboomView whenever the mouse is moved. 
	 * 
	 * @param newLocatio - the new location of the cursor.
	 */
	public void setMouseLocation(Point newLocation){
		this.newLocation = newLocation;
	}

	/**
	 * Updates the bucket location (if necessary) and calls Game.step on the encapsulates Game. 
	 * Called by the KaboomView about 60 times per second. 
	 * 
	 */
	public void timerTick(){
		if(!kaboom.isOver()){
			
		kaboom.step();
		}
		if (this.newLocation.getX() > this.test.getX()){
			kaboom.moveBucketRight();
		}
		if (this.newLocation.getX() < this.test.getX()){
			kaboom.moveBucketLeft();
		}
		test = newLocation;
	}


}
