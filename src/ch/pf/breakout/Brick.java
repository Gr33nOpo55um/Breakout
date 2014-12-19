package ch.pf.breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Brick extends BaseObjects {

	String brickie = "/images/brick.png";

	// variable for destroyed bricks if true they disappear
	boolean destroyed;

	/*
	 * 0 = no Special Options, 1 = Special Points, 2 = Ballspeed increase, 3 =
	 * Paddle gets smaller,
	 * 
	 * 
	 * case 0: //normal add points case 1: //addtional points case 2:
	 * //ballspeedincrease case 3: //ballspeedecreases case 4:
	 * //paddlegetssmaler
	 */
	int specialFunction = 0;

	public Brick(int x, int y, int xBrick, int yBrick) {
		this.x = x;
		this.y = y;

		// ImageIcon ii = new ImageIcon(this.getClass().getResource(brickie));
		// image = ii.getImage();

		width = xBrick;
		heigth = yBrick;

		int tempRand = (int) (Math.random() * 100) + 1;

		System.out.println(tempRand);

		if (tempRand <= 5) {

			specialFunction = 1;
		}

		if (tempRand > 5 && tempRand <= 10) {

			specialFunction = 2;
		}
		if (tempRand > 10 && tempRand <= 15) {

			specialFunction = 3;
		}
		if (tempRand > 15 && tempRand <= 20) {

			specialFunction = 4;
		}
		if (tempRand > 20 && tempRand <= 25) {

			specialFunction = 5;
		}

		destroyed = false;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	Rectangle getRectBrick() {
		return new Rectangle(x, y, width, heigth);
	}

	public void paint(Graphics g, JPanel panel, int x, int y) {

		Graphics2D g2d = (Graphics2D) g;

		Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, 40, 20);
		switch (specialFunction) {
		case 0:
			g2d.setColor(Color.orange);
			break;
		case 1:
			g2d.setColor(Color.MAGENTA);
			break;
		case 2:
			g2d.setColor(Color.CYAN);
			break;
		case 3:
			g2d.setColor(Color.BLACK);
			break;
		case 4:
			g2d.setColor(Color.blue);
			break;
		case 5: // additional ball
			g2d.setColor(Color.red);
			break;

		}
		g2d.fill(rectangle);
	}

}
