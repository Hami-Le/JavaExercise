
public class TestLine {
	public static void main(String[] args) {
        Line l1 = new Line(0, 0, 3, 4);
        System.out.println(l1);
        System.out.println("Length: " + l1.getLength());
        System.out.println("Gradient: " + l1.getGradient());
    }
}
