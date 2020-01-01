package Geometry;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		System.out.println("Beginning");
		Point a = new Point(3.0, 2.0);
		Point b = new Point(5.0, -2.0);
		ArrayList<Point> points = new ArrayList<Point>();
		points.add(a);
		points.add(b);
		
		Polygon polygon = new Polygon(points);
		
		
	
	}

}


