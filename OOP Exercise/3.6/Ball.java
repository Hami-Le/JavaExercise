
public class Ball {
	private float x, y;
    private int radius;
    private float xDelta, yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        double radian = Math.toRadians(direction);
        this.xDelta = (float) (speed * Math.cos(radian));
        this.yDelta = (float) (-speed * Math.sin(radian));
    }

    public float getX() { return x; }
    public float getY() { return y; }
    public int getRadius() { return radius; }
    public float getXDelta() { return xDelta; }
    public float getYDelta() { return yDelta; }

    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }
    public void setRadius(int radius) { this.radius = radius; }
    public void setXDelta(float xDelta) { this.xDelta = xDelta; }
    public void setYDelta(float yDelta) { this.yDelta = yDelta; }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    public String toString() {
        return "Ball at (" + x + ", " + y + ") of velocity (" + xDelta + ", " + yDelta + ")";
    }
}
