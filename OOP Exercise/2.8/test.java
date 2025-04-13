
public class test {
	public static void main(String[] args) {
        MyCircle circle1 = new MyCircle(3, 4, 5);

        MyPoint center = new MyPoint(7, 8);
        MyCircle circle2 = new MyCircle(center, 10);

        System.out.println(circle1);
        System.out.println(circle2);

        System.out.println("Circle1 Radius: " + circle1.getRadius());
        System.out.println("Circle2 Center X: " + circle2.getCenterX());

        circle1.setCenterXY(0, 0);
        System.out.println("After changing center of circle1: " + circle1);

        System.out.println("Area of circle1: " + circle1.getArea());
        System.out.println("Circumference of circle1: " + circle1.getCircumference());

        System.out.println("Distance between circle1 and circle2: " + circle1.distance(circle2));
    }
}
