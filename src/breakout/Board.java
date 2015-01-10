package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	List<Brick> bricks;
	Paddle paddle;
	Ball ball;
	Ball ball2;

	private Timer timer;

	public Board() {

		addKeyListener(new TAdapter());

		setFocusable(true);

		bricks = new ArrayList<>(30);

		setBackground(Color.white);

		// enable better graphics
		setDoubleBuffered(true);

		gameInit();
		//
		timer = new Timer(10, this);
		timer.start();

	}

	// method initialize game objetcts as bricks, ball, etc.
	public void gameInit() {

		paddle = new Paddle();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				bricks.add(new Brick(j * 80 + 30, i * 30 + 50));
			}

		}
		ball = new Ball(paddle, bricks);
	}

	public void bonusAchivement() {
		ball2 = new Ball(paddle, bricks);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		onAction();
	}

	void onAction() {
		paddle.move();
		ball.move();
		repaint();

	}

	// This method paints everything
	public void paint(Graphics g) {
		super.paint(g);

		// Changes font and paint the Bricks counter
		int fontsizeGameCounter = 20;
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Arial", Font.BOLD, fontsizeGameCounter));
		g.drawString("You destroyed " + Ball.getBricksDestroyedCount() + " Bricks ", 120, 40);

		// draw bricks
		for (Brick brick : bricks) {
			if (!brick.isDestroyed()) {
				g.drawImage(brick.getImage(), brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight(), this);
			}
		}

		paddle.paint(g, this);
		ball.paint(g, this);

		if (ball.gameOver == true) {
			int fontsizeGameOver = 30;
			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD, fontsizeGameOver));
			g.drawString("Game over", BreakoutSettings.FrameWidth / 3, BreakoutSettings.frameHeight / 2);

		}
	}

	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			paddle.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
				onAction();
			paddle.keyPressed(e);
		}

	}

}
