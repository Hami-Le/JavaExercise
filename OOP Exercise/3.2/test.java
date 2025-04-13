
public class test {
	public static void main(String[] args) {
        MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3);
        MyPolynomial p2 = new MyPolynomial(3.0, 4.0);

        System.out.println("Polynomial 1: " + p1);
        System.out.println("Polynomial 2: " + p2);
        System.out.println("Degree of Polynomial 1: " + p1.getDegree());
        System.out.println("Evaluation of Polynomial 1 at x=2: " + p1.evaluate(2));
        System.out.println("Sum: " + p1.add(p2));
        System.out.println("Product: " + p1.multiply(p2));
    }
}
