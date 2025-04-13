
public class Test {
	public static void main(String[] args) {
        MovablePoint p1 = new MovablePoint(5, 5, 2, 3);
        System.out.println("Initial Point: " + p1);
        
        p1.moveUp();
        System.out.println("After moveUp: " + p1);
        
        p1.moveDown();
        System.out.println("After moveDown: " + p1);
        
        p1.moveLeft();
        System.out.println("After moveLeft: " + p1);
        
        p1.moveRight();
        System.out.println("After moveRight: " + p1);

        System.out.println();

        MovableCircle c1 = new MovableCircle(10, 10, 2, 2, 5);
        System.out.println("Initial Circle: " + c1);
        
        c1.moveUp();
        System.out.println("After moveUp: " + c1);
        
        c1.moveDown();
        System.out.println("After moveDown: " + c1);
        
        c1.moveLeft();
        System.out.println("After moveLeft: " + c1);
        
        c1.moveRight();
        System.out.println("After moveRight: " + c1);
    }
}
