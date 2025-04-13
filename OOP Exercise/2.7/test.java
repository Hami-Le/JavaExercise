
public class test {
	public static void main(String[] args) {
        // Tạo đối tượng MyLine bằng tọa độ
        MyLine line1 = new MyLine(1, 1, 4, 5);

        // Tạo đối tượng MyLine bằng MyPoint
        MyPoint p1 = new MyPoint(2, 3);
        MyPoint p2 = new MyPoint(6, 7);
        MyLine line2 = new MyLine(p1, p2);

        // In thông tin của hai đoạn thẳng
        System.out.println(line1);
        System.out.println(line2);

        // Kiểm tra các phương thức getter và setter
        System.out.println("Begin X of line1: " + line1.getBeginX());
        System.out.println("End Y of line2: " + line2.getEndY());

        // Đổi tọa độ điểm đầu của line1
        line1.setBeginXY(0, 0);
        System.out.println("After changing begin of line1: " + line1);

        // Kiểm tra chiều dài của đoạn thẳng
        System.out.println("Length of line1: " + line1.getLength());

        // Kiểm tra độ dốc của đoạn thẳng
        System.out.println("Gradient of line1: " + line1.getGradient());
    }
}
