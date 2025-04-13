
public class test {
	public static void main(String[] args) {
        Point2D p2d = new Point2D(3.5f, 4.5f);
        System.out.println("Point2D: " + p2d);
        System.out.println("XY Array: " + java.util.Arrays.toString(p2d.getXY()));

        Point3D p3d = new Point3D(1.2f, 3.4f, 5.6f);
        System.out.println("Point3D: " + p3d);
        System.out.println("XYZ Array: " + java.util.Arrays.toString(p3d.getXYZ()));

     
        p3d.setXYZ(7.8f, 9.1f, 2.3f);
        System.out.println("Updated Point3D: " + p3d);
        System.out.println("Updated XYZ Array: " + java.util.Arrays.toString(p3d.getXYZ()));
    }
}
