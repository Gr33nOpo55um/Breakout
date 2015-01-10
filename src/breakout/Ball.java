package breakout;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ball extends BaseObjects implements BreakoutSettings {

	// directions of the ball
	private static int xdir;
	private static int ydir;

	// loading image
	protected String ball = "/images/ball.png";

	// initalise bricks and paddle
	private Paddle paddle;
	private List<Brick> bricks;

	static int bricksDestroyCount = 0;

	public Ball(Paddle paddle, List<Brick> bricks) {

		this.paddle = paddle;
		this.bricks = bricks;

		xdir = ballSpeed;
		ydir = -ballSpeed;
		ImageIcon ii = new ImageIcon(this.getClass().getResource(ball));
		image = ii.getImage();

		width = image.getWidth(null);
		heigth = image.getHeight(null);

		resetState();

	}

	public void move()

	{
		x += xdir;
		y += ydir;

		if (this.getRect().getMinX() <= 0) {

			setXDir(ballSpeed);
		}

		if (this.getRect().getMaxX() >= BALL_RIGHT) {
			setXDir(-ballSpeed);
		}

		if (this.getRect().getMaxY() - heigth <= 0) {

			setYDir(ballSpeed);
		}

		if (this.getRect().getMaxY() >= frameHeight) {

			gameOver = true;
		}

		if (this.getRect().getMaxY() > 0) {
		}

		int ballPosLeft = (int) this.getRect().getMinX();
		int ballHeight = (int) this.getRect().getHeight();
		int ballWidth = (int) this.getRect().getWidth();
		int ballPosTop = (int) this.getRect().getMinY();

		Point pointRight = new Point(ballPosLeft + ballWidth + 1, ballPosTop);
		Point pointLeft = new Point(ballPosLeft - 1, ballPosTop);
		Point pointTop = new Point(ballPosLeft, ballPosTop - 1);
		Point pointBottom = new Point(ballPosLeft, ballPosTop + ballHeight + 1);

		// if paddle meets the ball
		if (this.getRect().intersects(paddle.getRect())) {

			if (paddle.getRect().contains(pointBottom)) {

				Ball.setYDir(-ballSpeed);
			}

		}

		// for all 30 bricks
		for (Brick brick : bricks) {

			// if ball collidate with brick
			Rectangle brickRect = brick.getRect();

			if (this.getRect().intersects(brickRect)) {
				// takes the most left position X of the ball, cast it to int
				// and write to ballPosLeft

				if (brick.destroyed == false) {

					if (brickRect.contains(pointBottom)) {
						Ball.setYDir(-ballSpeed);
					}
					if (brickRect.contains(pointTop)) {
						Ball.setYDir(ballSpeed);
					}
					if (brickRect.contains(pointRight)) {
						Ball.setXDir(-ballSpeed);
					}
					if (brickRect.contains(pointLeft)) {
						Ball.setXDir(ballSpeed);
					}

					brick.setDestroyed(true);
					bricksDestroyCount++;
					// increase variable of destroyed bricks
					// write it into field

				}

			}
		}

	}

	public void resetState() {

		// Create random number for x Position
		Random xRand = new Random();
		int leftStart = 10;
		int rightStart = FrameWidth - 10;
		int xStart = xRand.nextInt(rightStart - leftStart) + leftStart;
		
		// Create random number for y Position
		Random yRand = new Random();
		int bottomStart = 300;
		int hightStart = frameHeight - 20;
		int yStart = yRand.nextInt(hightStart - bottomStart) + bottomStart;

		x = xStart;
		y = yStart;
	}

	public int getXDir() {
		return xdir;

	}

	public static int getBricksDestroyedCount() {
		return bricksDestroyCount;

	}

	public int getYDir() {
		return ydir;
	}

	public static void setYDir(int y) {
		ydir = y;

	}

	public static void setXDir(int x) {
		xdir = x;
	}

	public void paint(Graphics g, JPanel panel) {

		// Graphics2D g2d = (Graphics2D) g;
		// // Assume x, y, and diameter are instance variables.
		// Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 13, 13);
		// g2d.fill(circle);

		g.drawImage(image, x, y, panel);
	}

}
