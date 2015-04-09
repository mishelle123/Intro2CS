
/**
 * 
 * This class implements an X,Y coordinate
 *position on grid.
 *
 * @author mishelle
 */
public class Point {
	/**
	 * The x coordinate.
	 */
	private double x;
	/**
	 * The y coordinate.
	 */
	private double y;

	//constructor -  Creates a new point with X and Y coordinates (0,0).

	public Point(){
		this.x=0;
		this.y=0;

	}
	/**
	 * constructs a position given x,y coordinates.
	 * @param posX the x coordinate.
	 * @param posY the y coordinate.
	 */
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	//methods
	/**Returns the x coordinate of this point.
	 *  
	 * @return the x coordinate.
	 */
	public double getX(){
		return x;
	}
	/** 
	 * Returns the y coordinate of this point.
	 *  
	 * @return the y coordinate.
	 */
	public double getY(){
		return y;
	}
	/**
	 * Returns a new point which is the result of multiplying this point
	 * by the given multiplier.
	 *  
	 * @param multiplier
	 * @return newPoint
	 */
	public Point multiply(double multiplier){
		double x= this.x*multiplier;
		double y= this.y*multiplier;
		Point newPoint = new Point(x,y);
		return newPoint;
	}
	/**plus - Returns a new point which is the result of adding this point and the
	//point given as parameter.
	 * 
	 *@param point other
	 *@return other
	 */
	public Point plus(Point other){
        if(other==null){
            return null;
        }
		double x = this.x+other.x;
		double y = this.y+other.y;
		Point newPoint = new Point(x,y);
		return newPoint;
	}
	//public void print(){
		//	System.out.println("x"+this.x+"y"+this.y);
	//}

}
