/**
 * @author Silas Stegm�ller
 */
public class BaseObjects {

    // public static int ballSpeed = 3;

    static boolean donkeyModeEnabled = false;
    protected int x = 0;
    protected int y = 0;
    protected int width;
    protected int heigth;
    boolean gameOver = false;

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
     * @return X
     */
    public int getX() {
        return x;
    }

    /**
     * @param x set value
     */
    public void setX(int x) {

        this.x = x;
    }

    /**
     * @return Y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y set value
     */
    public void setY(int y) {

        this.y = y;

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
