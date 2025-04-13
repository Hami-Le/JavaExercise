
import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    private List<Point> points;

    public PolyLine() {
        points = new ArrayList<>();
    }

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    public void appendPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public void appendPoint(Point point) {
        points.add(point);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point p : points) {
            sb.append(p.toString());
        }
        sb.append("}");
        return sb.toString();
    }

    public double getLength() {
        double totalLength = 0.0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            totalLength += p1.distance(p2);
        }
        return totalLength;
    }
}