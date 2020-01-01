package Geometry;

public class Point {

	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point otherPoint) {
		double dx = otherPoint.x - this.x;
		double dy = otherPoint.y - this.y;
		return Math.sqrt(dx * dx + dy * dy);
		}
	
	public boolean isToTheLeftOf(Point q, Point r) {
		double ax = r.getX() - q.getX();
		double ay = r.getY() - q.getY();
		double bx = x - q.getX();
		double by = y - q.getY();
		return (ax * by - ay * bx > 0.0);
		}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
