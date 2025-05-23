
public class Rectangle implements GeometricObject{
	private double width, length;

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", length=" + length + "]";
	}

	@Override
	public double getArea() {
		return length*width;
	}

	@Override
	public double getPerimeter() {
		return 2*(length+width);
	}
}
