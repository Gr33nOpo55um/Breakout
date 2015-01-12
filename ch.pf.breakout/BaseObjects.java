public class BaseObjects {

	// public static int ballSpeed = 3;

	protected int x = 0;
	protected int y = 0;

	protected int width;
	protected int heigth;
	boolean gameOver = false;
	static boolean donkeyModeEnabled = false;

	/**
	 * @param newValue
	 */
	public static void setDonkeyMode(boolean newValue) {

		donkeyModeEnabled = newValue;
	}

	/**
	 * @return if donkey mode is enabled
	 */
	public static boolean getDonkeyModeVal() {

		return donkeyModeEnabled;
	}

	/**
	 * @param x
	 *            set value
	 */
	public void setX(int x) {

		this.x = x;
	}

	/**
	 * @param y
	 *            set value
	 */
	public void setY(int y) {

		this.y = y;

	}

	/**
	 * @return X
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return height
	 */
	public int getHeight() {
		return heigth;
	}

}
