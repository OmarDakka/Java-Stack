
public class Circle extends GeometricObject {
	private double radius;
	
	public Circle() {
		
	}
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	public Circle(double radius, String color1, boolean filled) {
		super();
		this.radius =radius;
		setColor(color1);
		setFilled(filled);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return ((radius*radius)*3.14); 
	}
	
	public double getPerimeter() {
		return ((2*3.14)*radius);
	}
	
	public double getDiameter() {
		return (2*radius);
	}
	
	public void printCircle() {
		System.out.println(getRadius() + " " + getColor() + " " + isFilled());
	}
}
