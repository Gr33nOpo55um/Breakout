package breakout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Paddle extends BaseObjects implements BreakoutSettings {

	// writes path of paddle image to paddle
	String paddle = "/images/paddle.png";

	// move direction variable
	int dx;

	public Paddle() {

		ImageIcon ii = new ImageIcon(this.getClass().getResource(paddle));
		image = ii.getImage();

		width = image.getWidth(null);
		heigth = image.getHeight(null);

		resetState();

	}

	public void move() {

		x += dx;

		if (x <= 4)
			x = 4;
		if (x >= BaseObjects.PADDLE_RIGHT)
			x = BaseObjects.PADDLE_RIGHT;

	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = -4;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = -4;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = 4;
		}

	}

	// default location of paddle
	public void resetState() {

		x = (FrameWidth - width) / 2;
		y = frameHeight - heigth * 3;
	}

	public void paint(Graphics g, JPanel panel) {
		// Draw the image of the craft
		// g.drawImage(image, x, y, panel);

		g.drawImage(image, x, y, panel);

	}

}
