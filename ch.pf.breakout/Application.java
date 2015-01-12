import javax.swing.JFrame;

public class Application implements BreakoutSettings {

	public Application() {

		JFrame frame = new JFrame();
		frame.setSize(FrameWidth, FrameHeight);
		frame.add(new Board());
		frame.setTitle(GameName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		// place the window in the middle of the screen.
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}

	/**
	 * @param args
	 *            start Application Method
	 */
	public static void main(String[] args) {

		new Application();

	}

}
