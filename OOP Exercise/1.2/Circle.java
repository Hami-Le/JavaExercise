
public class Circle {
	private double radius;
	
	public Circle() {
		radius=1.0;
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return 3.14*radius*radius;
	}
	
	public double getCircumference() {
		return 2*Math.PI*radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

}
