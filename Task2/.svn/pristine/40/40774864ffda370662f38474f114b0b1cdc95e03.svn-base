package ua.nure.zharkov.Task2;

public class Circle {
	
	protected double xPos;
	protected double yPos;
	protected double rValue;
	
	public double getxPos() {
		return xPos;
	}
	
	public double getyPos() {
		return yPos;
	}
	
	public double getrValue() {
		return rValue;
	}
	
	public Circle(double x, double y, double r) {
		this.xPos = x;
		this.yPos = y;
		this.rValue = r;
	}
	
	public void move(double dx, double dy) {
		this.xPos += dx;
		this.yPos += dy;
	}
	
	public boolean isInside(double x, double y) { 
		return pathLength(x, y) < powTwo(rValue);
	}
	
	public boolean isInside(Circle c) {
		return (pathLength(c.getxPos(), c.getyPos()) + powTwo(c.getrValue())) < powTwo(rValue);
	}
	
	private double powTwo(double ex) {
		return ex * ex;
	}
	
	public double pathLength(double dx, double dy) {
		double pathX = powTwo(xPos - dx);
		double pathY = powTwo(yPos - dy);
		return pathX + pathY;
	}
	
	@Override
	public String toString() {
		StringBuilder data = new StringBuilder("Circle");
		data.append(" (");
		data.append(xPos);
		data.append(", ");
		data.append(yPos);
		data.append(", ");
		data.append(rValue);
		data.append(")");
		return data.toString();
	}
	
	public void print() {
		System.out.println(this);
	}

	public static void main(String[] args) {	
		System.out.println("~~~ c");
	    Circle circler = new Circle(0, 0, 1);
	    circler.print();
	    System.out.println("~~~ c.move(1, 1)");
	    circler.move(1, 1);
	    circler.print();
	    System.out.println("~~~ c.isInside(1, 1)");
	    System.out.println(circler.isInside(1, 1));
	    System.out.println("~~~ c.isInside(10, 1)");
	    System.out.println(circler.isInside(10, 1));
	    System.out.println("~~~ c2");
	    Circle circleo = new Circle(1, 1, 2);
	    circleo.print();
	    System.out.println("~~~ c.isInside(c2)");
	    System.out.println(circler.isInside(circleo));
	    System.out.println("~~~ c2.isInside(c)");
	    System.out.println(circleo.isInside(circler));
	}

}
