/**
 * Class whose instances represent circles in the x/y plane. 
 * Circles can be moved by setting a new center point, and resized by setting 
 * a new radius. 
 * 
 * @author mishelle
 *
 */
public class Circle{

	private double r=0;

	private Point centerPoint = new Point ();


	/**
	 *  Constructs a new Circle with the given center and radius.
	 *  
	 * @param center - the center Point of this Circle.
	 * @param radius - the radius of this Circle.
	 */
	public Circle(Point center, double radius){ // if r =x
		centerPoint = center;
		r = radius;
	}

	/**
	 * Constructs a copy of the given Circle.
	 * 
	 * @param circle - the Circle to copy.
	 */
	public Circle(Circle circle){
		this.centerPoint = circle.centerPoint;
		this.r = circle.r;
	}

	/**
	 * Returns the current center Point of this Circle. 
	 * 
	 * @return the center Point of this Circle.
	 */
	public Point getCenter(){
		return centerPoint;
	}

	/**
	 * Returns the radius of this Circle.
	 * 
	 * @return the radius of this Circle.
	 */
	public double getRadius(){
		return r;
	}

	/**
	 * Determines whether the given point
	 * is inside this Circle (including on the perimeter). 
	 * @param p - the Point to check.
	 * @return whether p is inside this circle (including on the perimeter).
	 */
	public boolean isPointInside(Point p){
		double a = centerPoint.getX();
		double b = centerPoint.getY();
		double distance = Math.sqrt((p.getX() - a)*(p.getX() - a) + (p.getY()- b)*(p.getY()- b));
		if(distance<=r && r>0){
			return true;
		}
		return false;
	}
	
	/**
	 * Set the center Point of this Circle. 
	 * 
	 * @param center - the center for this Circle.
	 */
	public void setCenter(Point center){ 
		centerPoint = center;
	}
	
	/**
	 * Sets the radius of this Circle. 
	 * 
	 * @param radius -  the new radius for this Circle.
	 */
	public void setRadius(double radius){ 
		r = radius;

	}

}