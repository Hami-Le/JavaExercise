
public class test {
	public static void main(String[] args) {
        Point p1 = new Point(3.5f, 5.5f);
        System.out.println("Point: " + p1);

        MovablePoint mp1 = new MovablePoint(2.0f, 3.0f, 1.0f, 1.5f);
        System.out.println("MovablePoint (Before move): " + mp1);

        mp1.move();
        System.out.println("MovablePoint (After move): " + mp1);
    }
}
