
public class test {
	public static void main(String[] args) {
        Shape shape = new Shape("blue", false);
        System.out.println(shape);

        Circle circle = new Circle(2.5, "red", true);
        System.out.println(circle);
        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Circle Perimeter: " + circle.getPerimeter());

        Rectangle rectangle = new Rectangle(3.0, 4.5, "yellow", false);
        System.out.println(rectangle);
        System.out.println("Rectangle Area: " + rectangle.getArea());
        System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());

        Square square = new Square(5.0, "purple", true);
        System.out.println(square);
        System.out.println("Square Area: " + square.getArea());
        System.out.println("Square Perimeter: " + square.getPerimeter());

        square.setWidth(7.0);
        System.out.println("After changing side: " + square);
    }
}
