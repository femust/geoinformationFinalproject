package Geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Polygon {
	private ArrayList<Point> points;
	private ArrayList<Point> boundingBox;
	private double minX;
	private double maxX;
	private double minY;
	private double maxY;
	
	public Polygon(ArrayList<Point> points) {
		this.points = points;
		
		maxX =  Collections.max(points, Comparator.comparing(s -> s.getX())).getX();
		minX =  Collections.min(points, Comparator.comparing(s -> s.getX())).getX();
		maxY = Collections.max(points, Comparator.comparing(s -> s.getY())).getY();
		minY = Collections.min(points, Comparator.comparing(s -> s.getY())).getY();
		
		boundingBox = new ArrayList<Point>();
		boundingBox.add(new Point(minX , minY));
		boundingBox.add(new Point(minX , maxY));
		boundingBox.add(new Point(maxX , minY));
		boundingBox.add(new Point(maxX , maxY));
				
		}
	
	public List<Point> getBoundingBox(){
		return boundingBox;
	}
	
	public int getNumberOfPoints(){
		return points.size();
	}
	
	public double computePerimeter()
	{
		double perimeter = 0.0;
		for (int i = 0; i < points.size(); i ++)
		{
			var currentPoint = points.get(i);
			var nextPoint = points.get(i+1 % (points.size()-1));
			perimeter = perimeter + currentPoint.distance(nextPoint);
		}	
		return perimeter;
	}
	
	public double computeArea()
	{
		double area = 0.0;
		for (int i = 0; i < points.size(); i ++)
		{
			var currentPoint = points.get(i);
			var nextPoint = points.get(i+1 % (points.size()-1));
			area = area + MathUtils.crossProduct(currentPoint, nextPoint)/2.0;
		}	
		return area;
	}
	
	public boolean isInBoundingBox(Point point) {
		var isOkX = (point.getX() >= minX) && (point.getX() <= maxX);
		var isOkY = (point.getY() >= minY) && (point.getY() <= maxY);		
		return isOkX && isOkY;
	}
	
	public boolean isInPolygon(Point point, boolean useBoundingBox)
	{
		boolean isInPolygon = false;
		if (useBoundingBox)
		{
			boolean isInBox = isInBoundingBox(point);
			if (!isInBox) {
				return isInPolygon;
			}
			isInPolygon = checkInPolygon(point);
		}
		if (!useBoundingBox)
		{
			isInPolygon = checkInPolygon(point);
		}
		return isInPolygon;
	}
	
	private boolean checkInPolygon(Point point)
	{
		int counter = 0;
	    for (int i = 0; i < points.size(); i++) {
			Point q = points.get(i);
			Point r = points.get((i + 1) % points.size());
			//if qr points up and contains y-coord of p:
			if (q.getY() <= point.getY() && r.getY() > point.getY() ) {
			if (point.isToTheLeftOf(q, r)) counter++;
		}
			//if qr points down and contains y-coord of p:
		if (q.getY() > point.getY() && r.getY() <= point.getY()) {
			if (point.isToTheLeftOf(r, q)) counter++;}
		}
	return (counter % 2 == 1);
		
	}
	
}
