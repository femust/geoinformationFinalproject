package Geometry;

import java.util.ArrayList;
import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Beginning");

		//config  - do you want to use boundig box?
		boolean boundingBox = true;
		//end o config
		PrintWriter writer;
		if (boundingBox) {
			writer = new PrintWriter("withBoundingBox.txt");
		} else {
			writer = new PrintWriter("withoutBoundingBox.txt");
		}
		List<Long> time = new ArrayList<>();

		
		Point center = new Point(0,0);
		Point vertex1 = new Point(0,1);
		Point pointToCheck = new Point(0,-0.99999995);
		var theta0 = Math.atan2(vertex1.getY() - center.getY(), vertex1.getX() - center.getX());
		var radius = vertex1.distance(center);
		
		for (int n = 3 ; n < 10001 ; n++)
		{
			long startTime = System.nanoTime();
			ArrayList<Point> points = new ArrayList<Point>();
			for (int i = 0; i < n ; i ++)
			{
				Point pointToAdd = new Point(center.getX() + radius * Math.cos((2 * Math.PI * i / n) + theta0),
						center.getY() + radius * Math.sin((2 * Math.PI * i / n)+ theta0));
				points.add(pointToAdd);
			}
			Polygon polygon = new Polygon(points);
			polygon.isInPolygon(pointToCheck, boundingBox);
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			time.add(totalTime);
			writer.println(totalTime);

		}
		writer.close();
		System.out.println("End Process");
	
		
		
		
	
	}

}


