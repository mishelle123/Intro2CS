
import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTester {
	private final static double EPSILON = 0.00001;

	//tests the first Counstructor
	@Test
	public void testConstructor(){
		Point topLeft = new Point(0,1);
		Rectangle rec = new Rectangle(topLeft, 1, 1);
		assertEquals(1, rec.getWidth(),EPSILON);
		assertEquals(1, rec.getHeight(),EPSILON);
		assertEquals(topLeft.getX(), rec.getTopLeft().getX(),EPSILON);
		assertEquals(topLeft.getY(), rec.getTopLeft().getY(),EPSILON);
	}

	//tests the second constructor (with two Points)
	@Test
	public void testConstructorPoints(){
		Point topLeft = new Point(0,1);
		Point bottomRight = new Point(1,1);
		Rectangle rec = new Rectangle(topLeft, bottomRight);
		Point[] p = rec.getCorners();
		Point bottomRight2 = p[2];
		assertEquals(topLeft.getX(), rec.getTopLeft().getX(),EPSILON);
		assertEquals(topLeft.getY(), rec.getTopLeft().getY(),EPSILON);
		assertEquals(bottomRight.getX(), bottomRight2.getX(), EPSILON);
		assertEquals(bottomRight.getY(), bottomRight2.getY(), EPSILON);
	}

	//tests the third constructor
	@Test
	public void copyConstructor(){
		Point topLeft = new Point(0,1);
		Rectangle rec = new Rectangle(topLeft, 1,2);
		Rectangle rec2 = new Rectangle(rec);
		assertEquals(rec.getTopLeft().getX(),rec2.getTopLeft().getX(),EPSILON);
		assertEquals(rec.getTopLeft().getY(),rec2.getTopLeft().getY(),EPSILON);
		assertEquals(rec.getWidth(),rec2.getWidth(),EPSILON);
		assertEquals(rec.getHeight(),rec2.getHeight(),EPSILON);
		
	}

	//tests the getCorners Method
	@Test
	public void testGetCorners(){
		Point topLeft = new Point(1,1);
		Point bottomRight = new Point(2,2);
		Point topRight = new Point(2,1);
		Point bottomLeft = new Point(1,2);
		Rectangle rec = new Rectangle(topLeft, bottomRight);
		Point[] p = rec.getCorners();
		Point topLeft0 = p[0];
		Point topRight1 = p[1];
		Point bottomRight2 = p[2];
		Point bottomLeft3 = p[3];
		assertEquals(topLeft.getX(), topLeft0.getX(), EPSILON);
		assertEquals(topLeft.getY(), topLeft0.getY(), EPSILON);
		assertEquals(bottomRight.getX(), bottomRight2.getX(), EPSILON);
		assertEquals(bottomRight.getY(), bottomRight2.getY(), EPSILON);
		assertEquals(topRight.getX(), topRight1.getX(), EPSILON);
		assertEquals(topRight.getY(), topRight1.getY(), EPSILON);
		assertEquals(bottomLeft.getX(), bottomLeft3.getX(), EPSILON);
		assertEquals(bottomLeft.getY(), bottomLeft3.getY(), EPSILON);
	}

	//tests the isPointInside method
	@Test
	public void testIsPointInside(){
		// checks a normal square
		Point topLeft = new Point(0,0);
		Point bottomRight = new Point(3,3);
		Rectangle rec = new Rectangle(topLeft, bottomRight);
		// point inside
		Point pointInside = new Point(1,1); 
		// point on edge
		Point pointEdge = new Point(0,0);
		// point outside
		Point pointOutside = new Point(5,5);
		assertTrue(rec.isPointInside(pointInside));
		assertTrue(rec.isPointInside(pointEdge));
		assertFalse(rec.isPointInside(pointOutside));
	}

	//tests the getTopLeft method
	@Test
	public void testGetTopLeft(){
		Point topLeft = new Point(-1,-1);
		Rectangle rec = new Rectangle(topLeft, 5 ,3);
		Point topLeftcos = rec.getTopLeft();
		assertEquals(topLeft.getX(), topLeftcos.getX(), EPSILON);
		assertEquals(topLeft.getY(), topLeftcos.getY(), EPSILON);
	}

	//tests the setTopLeft Method;
	@Test
	public void testSetTopLeft(){
		Point topLeft = new Point(5,5);
		Rectangle rec = new Rectangle(topLeft, 6 ,2);
		Point newTopLeft = new Point(3,3);
		rec.setTopLeft(newTopLeft); //// ok?
		Point[] p = rec.getCorners();
		Point topLeft0 = p[0];
		Point topRight1 = p[1];
		Point bottomRight2 = p[2];
		Point bottomLeft3 = p[3];
		assertEquals(3, topLeft0.getX(), EPSILON);
		assertEquals(3, topLeft0.getY(), EPSILON);
		assertEquals(9, topRight1.getX(), EPSILON);
		assertEquals(3, topRight1.getY(), EPSILON);
		assertEquals(9, bottomRight2.getX(), EPSILON);
		assertEquals(5, bottomRight2.getY(), EPSILON);
		assertEquals(3, bottomLeft3.getX(), EPSILON);
		assertEquals(5, bottomLeft3.getY(), EPSILON);
	}

	//tests the setHeight method
	@Test
	public void testSetHeight(){
		Point topLeft = new Point(0,0);
		Rectangle rec = new Rectangle(topLeft, 1 ,1);	
		rec.setHeight(2);
		Point[] p = rec.getCorners();
		Point bottomRight2 = p[2];
		Point bottomLeft3 = p[3];
		assertEquals(1, bottomRight2.getX(), EPSILON);
		assertEquals(2, bottomRight2.getY(), EPSILON);
		assertEquals(0, bottomLeft3.getX(), EPSILON);
		assertEquals(2, bottomLeft3.getY(), EPSILON);

	}

	//tests the setWidth method
	@Test
	public void testSetWidth(){
		Point topLeft = new Point(0,0);
		Rectangle rec = new Rectangle(topLeft, 4 ,6);	
		rec.setWidth(8);
		Point[] p = rec.getCorners();
		Point topRight1 = p[1];
		Point bottomRight2 = p[2];
		assertEquals(8, topRight1.getX(), EPSILON);
		assertEquals(0, topRight1.getY(), EPSILON);
		assertEquals(8, bottomRight2.getX(), EPSILON);
		assertEquals(6, bottomRight2.getY(), EPSILON);
	}

	//tests the getHeight method
	@Test
	public void testGetHeight(){
		Point topLeft = new Point(2,2);
		Rectangle rec = new Rectangle(topLeft,5,3);
		assertEquals(3, rec.getHeight(),EPSILON);
	}

	//tests the getWidth method
	@Test
	public void testGetWidth(){
		Point topLeft = new Point(2,2);
		Rectangle rec = new Rectangle(topLeft,5,3);
		assertEquals(5, rec.getWidth(),EPSILON);
	}

}