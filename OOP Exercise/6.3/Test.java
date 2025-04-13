
public class Test {
	public static void main(String[] args) {
        MovablePoint p1 = new MovablePoint(5, 5, 2, 3);

        System.out.println("Initial position: " + p1);
        
        p1.moveUp();
        System.out.println("After moveUp: " + p1);
        
        p1.moveDown();
        System.out.println("After moveDown: " + p1);
        
        p1.moveLeft();
        System.out.println("After moveLeft: " + p1);
        
        p1.moveRight();
        System.out.println("After moveRight: " + p1);
    }
}
