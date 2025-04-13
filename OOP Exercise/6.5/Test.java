
public class Test {
	public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        System.out.println("Initial Circle: " + c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());
        
        ResizableCircle rc1 = new ResizableCircle(10.0);
        System.out.println("Initial ResizableCircle: " + rc1);
        System.out.println("Area: " + rc1.getArea());
        System.out.println("Perimeter: " + rc1.getPerimeter());

        rc1.resize(50);
        System.out.println("After resizing by 50%: " + rc1);
        System.out.println("Area: " + rc1.getArea());
        System.out.println("Perimeter: " + rc1.getPerimeter());

        rc1.resize(200);
        System.out.println("After resizing by 200%: " + rc1);
        System.out.println("Area: " + rc1.getArea());
        System.out.println("Perimeter: " + rc1.getPerimeter());
    }
}
