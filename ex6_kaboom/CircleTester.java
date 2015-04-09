
import static org.junit.Assert.*;
import org.junit.Test;

public class CircleTester {
	private final static double EPSILON = 0.00001;

	// test the constructor
	@Test
	public void testConstructor(){
		Point p = new Point(5,2);
		double radius = 3;
		Circle c1 = new Circle(p,radius);
		//assertNull(c1);
		assertEquals(c1.getCenter().getX(), p.getX(), EPSILON);
		assertEquals(c1.getCenter().getY(), p.getY(), EPSILON);
		assertEquals(c1.getRadius(), radius, EPSILON);
	}

	// tests the copy constructor
	@Test public void testCopyConstructor(){
		Point p = new Point(5,2);
		Circle c1 = new Circle(p,2);
		//assertNull(c1);
		Circle c2= new Circle(c1);
		assertEquals(c1.getCenter().getX(), c2.getCenter().getX(), EPSILON);
		assertEquals(c1.getCenter().getY(), c2.getCenter().getY(), EPSILON);
		assertEquals(c1.getRadius(), c2.getRadius(), EPSILON);
	}

	// tests the getRadius method
	@Test
	public void testGetRadius(){
		Point p = new Point(5,2);
		Circle c1 = new Circle(p,0);
		Circle c2 = new Circle(p,2);
		assertEquals(0, c1.getRadius(),EPSILON);
		assertEquals(2, c2.getRadius(),EPSILON);



	}
	
	//tests the pointInside method
	@Test
	public void testIsPointInside(){
		//assertNotNull(c1);
		Point testPointInside = new Point(0,0);
		Circle c1 = new Circle(testPointInside,1);
		assertTrue(c1.isPointInside(testPointInside));
		Point testPointOutside = new Point(3,3);
		assertFalse(c1.isPointInside(testPointOutside));
		Point testPointPerimeter= new Point(1,0);
		assertTrue(c1.isPointInside(testPointPerimeter));
	
		
	}
	
	// tests the getCenter method
	@Test
	public void testgetCenter(){
		Point p = new Point(5,2);
		Circle c1 = new Circle(p,0);
		//assertNull(p);
		assertEquals(p.getX(), c1.getCenter().getX(),EPSILON);
		assertEquals(p.getY(), c1.getCenter().getY(),EPSILON);
	}

	// tests the setRadius method
	public void testSetRadius(){
		Point p = new Point(5,2);
		double radius = 3;
		Circle c1 = new Circle(p,radius);
		c1.setRadius(7);
		assertEquals(7,c1.getRadius(),EPSILON);
	}

	// tests the setCenter method
	public void testSetCenter(){
		Point center = new Point(5,2);
		Circle c1 = new Circle(center,5);
		Point newCenter = new Point(5,2);
		c1.setCenter(newCenter);
		assertEquals(3,c1.getCenter().getX(),EPSILON);
		assertEquals(3,c1.getCenter().getY(),EPSILON);
	}
}