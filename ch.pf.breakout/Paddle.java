import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

/**
 * @author Silas
 *
 */
/**
 * @author Silas
 *
 */
/**
 * @author Silas
 *
 */
/**
 * @author Silas
 *
 */
/**
 * @author Silas
 *
 */

/**
 * @author Silas
 */
public class Paddle extends BaseObjects implements BreakoutSettings {

    static int paddleDirectionX;
    static int paddleWidth = FrameWidth / 3;
    int paddleHeigth = 15;

    /**
     *
     */
    public Paddle() {
        resetState();
    }

    public static void setPaddlePosition(int dx) {
        paddleDirectionX = dx;

    }

    /**
     * @param width set paddle witdh
     */
    public static void setPaddleWidth(int width) {
        paddleWidth = width;
    }

    /**
     * Control Paddle movement
     */
    public void move() {

        x += paddleDirectionX;

        if (x <= 4)
            x = 4;
        if (x >= FrameWidth - paddleWidth)
            x = FrameWidth - paddleWidth;

    }

    /**
     * @param e set paddle directions by movents
     */
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            paddleDirectionX = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            paddleDirectionX = 0;
        }

    }

    /**
     * default location of paddle
     */
    public void resetState() {

        x = (FrameWidth - paddleWidth) / 2;
        y = FrameHeight - paddleHeigth * 3;
    }

    Rectangle getRectPaddle() {
        return new Rectangle(x, y, paddleWidth, paddleHeigth);
    }

    /**
     * @param g
     * @param panel
     */
    public void paint(Graphics g, JPanel panel) {
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, paddleWidth, paddleHeigth);

        g2d.setColor(Color.orange);
        g2d.fill(rectangle);
    }
}
