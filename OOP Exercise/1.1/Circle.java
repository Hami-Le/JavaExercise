
public class Circle {
	private double radius;
	private String color;

	public Circle() {
		radius = 1.0;
		color="red";
	}
	
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}

	public Circle(double r) {
		radius = r;
		color="red";
	}
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + "]";
	}
}
