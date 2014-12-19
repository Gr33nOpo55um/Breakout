package ch.pf.breakout.ch.pf.breakout;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Brick extends BaseObjects {

	String brickie = "/images/brick.png";

	// variable for destroyed bricks if 0 they disappear / 2 means fully there /
	// 1 means half destroyed / 0 means destroyed
	int destroyed;

	// case 0: //normal add points case 1: //addtional points case
	// 2/ballspeedincrease case 3 /ballspeedecreases case 4 /paddlegetssmaler

	int specialFunction;
	Color brickColor;

	public Brick(int x, int y, int xBrick, int yBrick) {
		this.x = x;
		this.y = y;

		width = xBrick;
		heigth = yBrick;

		int tempRand = (int) (Math.random() * 100) + 1;

		//System.out.println(tempRand);

		if (tempRand <= 5) {
			specialFunction = 1;
			brickColor = Color.orange;
		}

		else if (tempRand > 5 && tempRand <= 10) {
			specialFunction = 2;
			brickColor = Color.magenta;
		} else if (tempRand > 10 && tempRand <= 15) {
			specialFunction = 3;
			brickColor = Color.blue;
		} else if (tempRand > 15 && tempRand <= 20) {
			specialFunction = 4;
			brickColor = Color.yellow;
		} else if (tempRand > 20 && tempRand <= 25) {
			specialFunction = 5;
			brickColor = Color.green;
		} else {
			specialFunction = 0;
			brickColor = Color.magenta;
		}
		destroyed = 2;
	}

	public int isDestroyed() {
		return this.destroyed;
	}

	public void setDestroyCounterMinusOne() {
		this.destroyed--;
	}

	Rectangle getRectBrick() {
		return new Rectangle(x, y, width, heigth);
	}

	public void paint(Graphics g, JPanel panel, int x, int y) {

		Graphics2D g2d = (Graphics2D) g;

		Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, 40, 20);
		if (isDestroyed() == 1) {
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 3 * 0.1f));
		}
		g2d.setPaint(brickColor);

		g2d.fill(rectangle);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 10 * 0.1f));

	}

}