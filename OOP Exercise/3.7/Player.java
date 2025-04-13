
public class Player {
	private int number;
    private float x, y, z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.setX(x);
        this.setY(y);
    }

    public void move(float xDisp, float yDisp) {
        setX(getX() + xDisp);
        setY(getY() + yDisp);
    }

    public void jump(float zDisp) {
        z += zDisp;
    }

    public boolean near(Ball ball) {
        double distance = Math.sqrt(Math.pow(ball.getX() - getX(), 2) + Math.pow(ball.getY() - getY(), 2) + Math.pow(ball.getZ() - z, 2));
        return distance < 8;
    }

    public void kick(Ball ball) {
        if (near(ball)) {
            ball.setXYZ(ball.getX() + 5, ball.getY() + 5, ball.getZ()); // Giả định đá bóng đi 5 đơn vị
            System.out.println("Ball kicked!");
        } else {
            System.out.println("Ball too far to kick!");
        }
    }

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
