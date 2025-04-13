
public class test {
	public static void main(String[] args) {
        Ball ball = new Ball(0, 0, 0);
        Player player1 = new Player(7, 3, 4);
        
        System.out.println("Initial Ball Position: " + ball);
        System.out.println("Player Position: (" + player1.getX() + ", " + player1.getY() + ")");

        System.out.println("Player near ball? " + player1.near(ball));
        player1.kick(ball);
        
        player1.move(2, 3);
        System.out.println("Player moved to: (" + player1.getX() + ", " + player1.getY() + ")");
        System.out.println("Player near ball? " + player1.near(ball));
        player1.kick(ball);

        System.out.println("Final Ball Position: " + ball);
    }
}
