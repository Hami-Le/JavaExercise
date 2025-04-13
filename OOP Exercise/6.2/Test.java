
public class Test {
	public static void main(String[] args) {
        GeometricObject c1 = new Circle(4.0);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());
        
        GeometricObject p1 = new Rectangle(2.0, 3.0);
        System.out.println(p1);
        System.out.println("Area: " + p1.getArea());
        System.out.println("Perimeter: " + p1.getPerimeter());
    }
}
