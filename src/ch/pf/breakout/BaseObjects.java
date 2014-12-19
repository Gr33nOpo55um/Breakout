package ch.pf.breakout;

import java.awt.Image;

public class BaseObjects {

	// protected static int brickWidth = 40;
	// protected static int brickHeight = 20;
	// protected static int brickGap = 20;

	public static int ballSpeed = 3;

	// Maximum right positions
	//public static int PADDLE_RIGHT = 340;
	public static final int BALL_RIGHT = 500; // 500 entspricht FrameWidth

	protected java.awt.Image image;

	protected int x = 0;
	protected int y = 0;

	protected int width;
	protected int heigth;
	public boolean gameOver = false;

	public void setX(int x) {

		this.x = x;

	}

	public void setY(int y) {

		this.y = y;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return heigth;
	}

	Image getImage() {
		return image;
	}

	
	
	
	
//	Rectangle getBallRect() {
//		return new Rectangle(x, y,circl , image.getHeight(null));
//	}
//	
}
