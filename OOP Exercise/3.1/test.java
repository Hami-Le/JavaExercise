
public class test {
	public static void main(String[] args) {
        MyComplex c1 = new MyComplex(1.1, 2.2);
        MyComplex c2 = new MyComplex(3.3, 4.4);

        System.out.println("Number 1: " + c1);
        System.out.println("Number 2: " + c2);

        System.out.println("Magnitude of c1: " + c1.magnitude());
        System.out.println("Argument of c1 (radians): " + c1.argument());

        System.out.println("c1 + c2 = " + c1.addNew(c2));
        System.out.println("c1 - c2 = " + c1.subtractNew(c2));
        System.out.println("c1 * c2 = " + c1.multiply(new MyComplex(c2.getReal(), c2.getImag())));
        System.out.println("c1 / c2 = " + c1.divide(new MyComplex(c2.getReal(), c2.getImag())));
        System.out.println("Conjugate of c1: " + c1.conjugate());
    }
}
