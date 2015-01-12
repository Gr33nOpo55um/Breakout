import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.List;

import javax.swing.JPanel;

public class Ball extends BaseObjects implements BreakoutSettings {

	// directions of the ball
	private int xdir;
	private int ydir;

	static int ballSpeed = 3;
	int ballDimension = 13;

	// loading image
	// protected String ball = "/images/ball.png";

	// initalise bricks and paddle
	private Paddle paddle;
	private List<Brick> bricks;

	/**
	 * @param paddle
	 * @param bricks
	 */
	public Ball(Paddle paddle, List<Brick> bricks) {

		this.paddle = paddle;
		this.bricks = bricks;

		xdir = ballSpeed;
		ydir = -ballSpeed;

		resetState();

	}

	/**
	 * This method contain the ball movement including the collision detection
	 */
	public void move()

	{
		x += xdir;
		y += ydir;

		// wall collision detections
		if (this.getRoundBall().getMinX() <= 0) {

			setXDir(ballSpeed);
			Sounds.play(Sounds.collisionSound);

		}

		if (this.getRoundBall().getMaxX() >= FrameWidth) {
			setXDir(-ballSpeed);
			Sounds.play(Sounds.collisionSound);

		}

		if (this.getRoundBall().getMaxY() - heigth <= 0) {

			setYDir(ballSpeed);
			Sounds.play(Sounds.collisionSound);

		}

		if (this.getRoundBall().getMaxY() >= FrameHeight - 2 * ballDimension) {

			if (getDonkeyModeVal() == true) {
				setYDir(-ballSpeed);

			} else {
				gameOver = true;
				Sounds.play(Sounds.collisionSound);
			}
		}

		if (this.getRoundBall().getMaxY() > 0) {
		}

		int ballPosLeft = (int) this.getRoundBall().getMinX();
		int ballHeight = (int) this.getRoundBall().getHeight();
		int ballWidth = (int) this.getRoundBall().getWidth();
		int ballPosTop = (int) this.getRoundBall().getMinY();

		Point pointRight = new Point(ballPosLeft + ballWidth + 1, ballPosTop);
		Point pointLeft = new Point(ballPosLeft - 1, ballPosTop);
		Point pointTop = new Point(ballPosLeft, ballPosTop - 1);
		Point pointBottom = new Point(ballPosLeft, ballPosTop + ballHeight + 1);

		// if paddle meets the ball
		if (this.getRoundBall().intersects(paddle.getRectPaddle())) {

			if (paddle.getRectPaddle().contains(pointBottom)) {

				this.setYDir(-ballSpeed);
				Sounds.play(Sounds.collisionSound);

			}

		}

		// collision detection for all 30 bricks
		for (Brick brick : bricks) {

			// if ball collidate with brick
			Rectangle brickRect = brick.getRectBrick();

			if (this.getRoundBall().intersects(brick.getRectBrick())) {
				// takes the most left position X of the ball, cast it to int
				// and write to ballPosLeft
				if (brick.destroyed > 0) {

					if (brickRect.contains(pointBottom)) {
						this.setYDir(-ballSpeed);
						Sounds.play(Sounds.collisionSound);

					}
					if (brickRect.contains(pointTop)) {
						this.setYDir(ballSpeed);
						Sounds.play(Sounds.collisionSound);

					}
					if (brickRect.contains(pointRight)) {
						this.setXDir(-ballSpeed);
						Sounds.play(Sounds.collisionSound);

					}
					if (brickRect.contains(pointLeft)) {
						this.setXDir(ballSpeed);
						Sounds.play(Sounds.collisionSound);

					}

					// if Brick is getting destroyed counter of bricks destroyed
					// increases and destroyed is set to true.

					brick.setDestroyCounterMinusOne();
					if (brick.isDestroyed() < 1) {
						PointsCalc.doSpecialAction(brick.specialFunction);
					}

					// Prints Console output for showing the special function of
					// only used for debugging
					// System.out.println(pointRight);

				}

			}
		}

	}

	/**
	 * Coordinates of Ball by gamestart. Random generated
	 */
	public void resetState() {

		// create two random numbers
		int xStart = (int) (Math.random() * (FrameWidth - 100)) + 10;
		int yStart = (int) (Math.random() * (FrameHeight - 200)) + 170;
		// Create random number for x Position

		x = xStart;
		y = yStart;
	}

	/**
	 * @return direction x of ball
	 */
	public int getXDir() {
		return xdir;

	}

	/**
	 * @return y direction of ball
	 */
	public int getYDir() {
		return ydir;
	}

	/**
	 * @param y
	 *            sets y direction of ball
	 */
	public void setYDir(int y) {
		ydir = y;

	}

	/**
	 * @param x
	 *            sets x direction of ball
	 */
	public void setXDir(int x) {
		xdir = x;
	}

	/**
	 * @return ellipse coordinates of ball
	 */
	Double getRoundBall() {
		// return new Rectangle(x, y, ballDimension, ballDimension);
		return new Ellipse2D.Double(x, y, ballDimension, ballDimension);
	}

	/*
	 * Rectangle2D getBounds2D() { // TODO Auto-generated method stub return
	 * null; }
	 */

	/**
	 * @param speed
	 *            increases speed of ball
	 */
	public static void setBallSpeed(int speed) {
		ballSpeed = speed;
	}

	/**
	 * @param g
	 *            Graphic object
	 * @param panel
	 */
	public void paint(Graphics g, JPanel panel) {

		Graphics2D g2d = (Graphics2D) g;
		// Assume x, y, and diameter are instance variables.
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, ballDimension, ballDimension);
		g2d.setColor(Color.cyan);
		g2d.fill(circle);
	}

}
