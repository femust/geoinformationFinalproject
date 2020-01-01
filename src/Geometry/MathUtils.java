package Geometry;


public class MathUtils {

	static public double crossProduct(Point p1, Point p2)
	{
		return p1.getX() * p2.getY() - p1.getY() * p2.getX();
	}
	
	
}
