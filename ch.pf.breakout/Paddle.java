import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Paddle extends BaseObjects implements BreakoutSettings {

	int paddleDirectionX;
	static int paddleWidth = FrameWidth / 3;
	int paddleHeigth = 15;

	public Paddle() {
		resetState();
	}

	public void move() {

		x += paddleDirectionX;

		if (x <= 4)
			x = 4;
		if (x >= FrameWidth - paddleWidth)
			x = FrameWidth - paddleWidth;

	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			paddleDirectionX = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			paddleDirectionX = 0;
		}

	}

	public void setPaddlePosition(int dx) {
		paddleDirectionX = dx;

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			setPaddlePosition(-4);
		}

		if (key == KeyEvent.VK_RIGHT) {
			setPaddlePosition(-4);
		}
		if (key == KeyEvent.VK_RIGHT) {
			setPaddlePosition(4);
		}

	}

	// default location of paddle
	public void resetState() {

		x = (FrameWidth - paddleWidth) / 2;
		y = FrameHeight - paddleHeigth * 3;
	}

	Rectangle getRectPaddle() {
		return new Rectangle(x, y, paddleWidth, paddleHeigth);
	}

	public static void setPaddleWidth(int width) {
		paddleWidth = width;
	}

	public void paint(Graphics g, JPanel panel) {
		// Draw the image of the craft
		// g.drawImage(image, x, y, panel);

		Graphics2D g2d = (Graphics2D) g;
		Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, paddleWidth, paddleHeigth);
		g2d.setColor(Color.orange);
		g2d.fill(rectangle);

		// g.drawImage(image, x, y, panel);

	}

}
