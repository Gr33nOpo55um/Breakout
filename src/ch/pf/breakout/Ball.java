package ch.pf.breakout;

import java.awt.Color;
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
	private int xdir;
	private int ydir;

	int ballDimension = 13;

	// loading image
	protected String ball = "/images/ball.png";

	// initalise bricks and paddle
	private Paddle paddle;
	private List<Brick> bricks;

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

		if (this.getRectBall().getMinX() <= 0) {

			setXDir(ballSpeed);
		}

		if (this.getRectBall().getMaxX() >= BALL_RIGHT) {
			setXDir(-ballSpeed);
		}

		if (this.getRectBall().getMaxY() - heigth <= 0) {

			setYDir(ballSpeed);
		}

		if (this.getRectBall().getMaxY() >= frameHeight) {

			gameOver = true;
		}

		if (this.getRectBall().getMaxY() > 0) {
		}

		int ballPosLeft = (int) this.getRectBall().getMinX();
		int ballHeight = (int) this.getRectBall().getHeight();
		int ballWidth = (int) this.getRectBall().getWidth();
		int ballPosTop = (int) this.getRectBall().getMinY();

		Point pointRight = new Point(ballPosLeft + ballWidth + 1, ballPosTop);
		Point pointLeft = new Point(ballPosLeft - 1, ballPosTop);
		Point pointTop = new Point(ballPosLeft, ballPosTop - 1);
		Point pointBottom = new Point(ballPosLeft, ballPosTop + ballHeight + 1);

		// if paddle meets the ball
		if (this.getRectBall().intersects(paddle.getRectPaddle())) {

			if (paddle.getRectPaddle().contains(pointBottom)) {

				this.setYDir(-ballSpeed);
			}

		}

		// for all 30 bricks
		for (Brick brick : bricks) {

			// if ball collidate with brick
			Rectangle brickRect = brick.getRectBrick();

			if (this.getRectBall().intersects(brick.getRectBrick())) {
				// takes the most left position X of the ball, cast it to int
				// and write to ballPosLeft
				if (brick.destroyed == false) {

					if (brickRect.contains(pointBottom)) {
						this.setYDir(-ballSpeed);
					}
					if (brickRect.contains(pointTop)) {
						this.setYDir(ballSpeed);
					}
					if (brickRect.contains(pointRight)) {
						this.setXDir(-ballSpeed);
					}
					if (brickRect.contains(pointLeft)) {
						this.setXDir(ballSpeed);
					}

					// if Brick is getting destroyed counter of bricks destroyed
					// increases and destroyed is set to true.

					brick.setDestroyed(true);

					PointsCalc.doSpecialAction(brick.specialFunction);

					// Prints Console output for showing the special function of
					// only for debugging

					// System.out.println(pointsCalc);

				}

			}
		}

	}

	public void resetState() {

		// will replace the random generator from further below
		// int tempRandX = (int) (Math.random() * 100) + 1;
		// int tempRandY = (int) (Math.random() * 100) + 1;
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

	public int getYDir() {
		return ydir;
	}

	public void setYDir(int y) {
		ydir = y;

	}

	public void setXDir(int x) {
		xdir = x;
	}

	Rectangle getRectBall() {
		return new Rectangle(x, y, ballDimension, ballDimension);
	}

	public static void setBallSpeed(int speed) {
		ballSpeed = speed;
	}

	public void paint(Graphics g, JPanel panel) {

		Graphics2D g2d = (Graphics2D) g;
		// Assume x, y, and diameter are instance variables.
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, ballDimension, ballDimension);
		g2d.setColor(Color.cyan);
		g2d.fill(circle);

		// g.drawImage(image, x, y, panel);
	}

}
