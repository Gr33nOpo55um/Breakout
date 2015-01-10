public class BaseObjects {

	// public static int ballSpeed = 3;

	protected int x = 0;
	protected int y = 0;

	protected int width;
	protected int heigth;
	boolean gameOver = false;
	static boolean donkeyModeEnabled = false;

	public static void setDonkeyMode(boolean newValue) {

		donkeyModeEnabled = newValue;
	}
	
	public static boolean getDonkeyModeVal() {

		return donkeyModeEnabled ;
	}	

	public void setX(int x) {

		this.x = x;
	}

	public void setY(int y) {

		this.y = y;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return heigth;
	}

}
