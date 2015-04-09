/**
 * A rectangle in the x/y plane, with sides parallel to the axes. 
 * Important: y coordinates increase in the down direction and decrease 
 * in the up direction.
 * 
 * @author mishelle
 */


public class Rectangle {
	private Point topLeft = new Point ();
	private double height=0, width=0;

	/**
	 * Constructs a new Rectangle with the given top-left and bottom-right corners. 
	 * 
	 * @param topLeft - the top-left corner of this Rectangle.
	 * @param bottomRight - the bottom-right corner of this Rectangle.
	 */
	public Rectangle(Point topLeft, Point bottomRight){
		this.topLeft = topLeft;
		height = bottomRight.getY() - topLeft.getY();
		width = bottomRight.getX() - topLeft.getX();

	}

	/**
	 * Constructs a new Rectangle with the given dimensions the top-left corner.
	 * 
	 * @param topLeft - the top left corner of this Rectangle.
	 * @param width - the width of this Rectangle.
	 * @param height - the height of this Rectangle.
	 */
	public Rectangle(Point topLeft, double width, double height){
		this.topLeft = topLeft;
		this.height = height;
		this.width = width;
	}
	/**
	 * Constructs a copy of the given Rectangle. 
	 * 
	 * @param rectangle - the Rectangle to copy.
	 */
	public Rectangle(Rectangle rectangle){
		this.topLeft = rectangle.topLeft;
		this.height = rectangle.height;
		this.width = rectangle.width;
	}

	/**
	 * Returns the four corners of this Rectangle. 
	 * 
	 * @return an array of the corners of this rectangle. 
	 * The first point in this array is the top-left corner of this Rectangle,
	 * and following it are the other corners in clockwise order.
	 */
	public Point[] getCorners(){
		Point[] corners = new Point[4];
		corners[0] = this.topLeft;
		corners[1] = new Point(topLeft.getX()+width,topLeft.getY());
		corners[2] = new Point(topLeft.getX()+width,topLeft.getY()+ height);
		corners[3] = new Point(topLeft.getX(),topLeft.getY() + height);
		return corners;

	}
	
	/**
	 * Gets the height of this Rectangle. 
	 * 
	 * @return the height of this Rectangle.
	 */
	public double getHeight(){
		return height;
	}

	/**
	 * Returns the top-left point of this Rectangle. 
	 * 
	 * @return the top-left point of this Rectangle.
	 */
	public Point getTopLeft(){
		return topLeft;
	}
	
	/**
	 * Returns the width of this Rectangle. 
	 * 
	 * @return the width of this Rectangle.
	 */
	public double getWidth(){
		return width;
	}

	/**
	 * Determines whether a point is inside this Rectangle (including on the edges). 
	 * 
	 * @param p - the Point to check.
	 * @return whether the p is inside this Rectangle (including on the edges).
	 */
	public boolean isPointInside(Point p){
	
		if( p.getX()>=topLeft.getX() && 
			p.getX()<=(topLeft.getX() + width) &&
			p.getY()>=topLeft.getY() && 
			p.getY()<=(topLeft.getY() + height)) 
		{
			return true;	
		}
		
		return false;

	}
	
	/**
	 * Sets the height of this Rectangle, keeping the top side in place. 
	 * 
	 * @param height - the new height for this Rectangle.
	 */
	public void setHeight(double height){
		this.height = height;

	}
	
	/**
	 * Sets the width of this Rectangle, keeping the left side in place.
	 * 
	 * @param width- the new width for this Rectangle.
	 */
	public void setWidth(double width){
		this.width = width;
	}
	
	/**
	 * Sets the top-left corner of this Rectangle.
	 * 
	 * @param topLeft - the new top-left corner for this Rectangle.
	 */
	public void setTopLeft(Point topLeft){
		this.topLeft = topLeft;
	}



	 

}
