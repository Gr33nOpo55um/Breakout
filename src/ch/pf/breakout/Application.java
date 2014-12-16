package ch.pf.breakout;

import javax.swing.JFrame;

public class Application implements BreakoutSettings {

	public Application() {

		// TODO Auto-generated method stub

		JFrame frame = new JFrame();

		frame.setSize(FrameWidth, frameHeight);
		frame.add(new Board());
		frame.setTitle(GameName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		// place the window in the middle of the screen.
		frame.setLocationRelativeTo(null);

		// This command would change the default place of the frame
		// frame.setBounds(screen.width/4,screen.height/4,
		// screen.width/2,screen.height/2);

		frame.setVisible(true);

	}

	public static void main(String[] args) {

		new Application();

	}

}
