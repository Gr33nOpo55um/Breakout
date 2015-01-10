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

	static List<Brick> bricks;
	Paddle paddle;
	Ball ball;
	Ball ball2;

	int xBrick = 20;
	int yBrick = 40;
	Boolean gameRunning = true;
	Boolean gamePaused = false;
	private Timer timer;

	public Board() {

		addKeyListener(new TAdapter());

		setFocusable(true);

		bricks = new ArrayList<Brick>(30);

		setBackground(Color.DARK_GRAY);

		// enable better graphics
		setDoubleBuffered(true);

		gameInit();
		//
		timer = new Timer(12, this);
		timer.start();

	}

	// method initialize game objetcts as bricks, ball, etc.
	public void gameInit() {

		paddle = new Paddle();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				bricks.add(new Brick(j * BreakoutSettings.FrameWidth / 7 + BreakoutSettings.FrameWidth / 14, i
						* BreakoutSettings.FrameHeight / 20 + BreakoutSettings.FrameHeight / 12, xBrick, yBrick));
			}
		}

		ball = new Ball(paddle, bricks);
	}

	// Method reset destroyed count of Bricks
	public static void gameResetWin() {

		for (Brick brick : bricks) {
			brick.destroyed = 2;
		}
	}

	// Method for Pause game
	public void gamePause() {
		if (gamePaused == false) {
			timer.stop();
			gamePaused = true;
		} else {
			timer.restart();
			gamePaused = false;

		}

	}

	public void bonusAchivement() {
		ball2 = new Ball(paddle, bricks);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		paddle.move();
		ball.move();
		repaint();
		Sounds.loop(Sounds.backgroundMusic);

	}

	// This method paints everything
	public void paint(Graphics g) {
		super.paint(g);

		/*
		 * MenuBar menuBar; Menu menu, submenu; MenuItem mExit, mReset;
		 * 
		 * menuBar = new MenuBar(); //Create the menu menu = new Menu("Menu");
		 * 
		 * //Create submenu submenu=new Menu("Sub Menu");
		 * 
		 * mExit = new MenuItem("Exit"); mReset = new MenuItem("Reset");
		 * 
		 * menu.add(mReset); menu.add(mExit);
		 * 
		 * setMenuBar(menuBar);
		 */

		// Changes font and paint the Bricks counter and pointCounter
		// int fontsizeGameCounter = 20;
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("Bricks destroyed: " + PointsCalc.getBricksDestroyedCount(), 4, 12);
		g.drawString("Points :" + PointsCalc.getPointsCount(), 4, 24);
		// g.setFont(new Font("Arial", Font.BOLD, fontsizeGameCounter));
		// g.drawString("You destroyed " + PointsCalc.getBricksDestroyedCount()
		// + " Bricks and made " + PointsCalc.getPointsCount() + " Points", 20,
		// 40);
		g.drawString("Level: " + PointsCalc.getGameLevel(), BreakoutSettings.FrameWidth - 70, 12);
		// draw bricks
		for (Brick brick : bricks) {
			if (brick.isDestroyed() > 0) {
				brick.paint(g, this, brick.x, brick.y);
			}
		}

		paddle.paint(g, this);
		ball.paint(g, this);

		if (ball.gameOver == true) {
			int fontsizeGameOver = 30;
			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD, fontsizeGameOver));
			g.drawString("Game over", BreakoutSettings.FrameWidth / 3, BreakoutSettings.FrameHeight / 2);
			Sounds.stop(Sounds.backgroundMusic);
			timer.stop();
			Sounds.play(Sounds.explossionSound);

		}

		// if (gamePaused == true) {
		// int fontsizePause = 30;
		// g.setColor(Color.red);
		// g.setFont(new Font("Arial", Font.BOLD, fontsizePause));
		// g.drawString("Pause", BreakoutSettings.FrameWidth / 3,
		// BreakoutSettings.FrameHeight / 2);
		// }

	}

	class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			paddle.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			// Move Paddle
			if (key == KeyEvent.VK_LEFT) {
				Paddle.setPaddlePosition(-4);
			}
			if (key == KeyEvent.VK_RIGHT) {
				Paddle.setPaddlePosition(-4);
			}
			if (key == KeyEvent.VK_RIGHT) {
				Paddle.setPaddlePosition(4);
			}

			// Make Pause
			if (key == KeyEvent.getExtendedKeyCodeForChar(80)) {
				gamePause();
			}

		}

		/*
		 * public void keyPressed1(KeyEvent e) { if (e.getKeyCode() ==
		 * KeyEvent.VK_SPACE) actionPerformed(null);
		 * 
		 * keyPressed(e); }
		 */
	}
}
