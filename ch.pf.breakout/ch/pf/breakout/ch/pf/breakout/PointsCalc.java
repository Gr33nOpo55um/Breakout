package ch.pf.breakout.ch.pf.breakout;

public class PointsCalc {

	private static int bricksDestroyCount = 0;
	private static int pointsCalc = 0;

	public static void doSpecialAction(int specialFunction) {
		/*
		 * 
		 * case 0: //normal add points case 1: //addtional points case 2:
		 * //ballspeedincrease case 3: //ballspeedecreases case 4:
		 * //paddlegetssmaler
		 */
		switch (specialFunction) {
		case 0:
			setPointsCount(20);
			break;
		case 1:
			setPointsCount(40);
			break;
		case 2:
			Ball.setBallSpeed(4);
			break;// ballspeedincrease
		case 3:
			Ball.setBallSpeed(3);
			break;// ballspeedecreases
		case 4:
			Paddle.setPaddleWidth(100);
			break; // paddlegetssmaler

		case 5:
			// new Ball
			break;

		}
		setBricksDestroyedCount(1);

	}

	public static int getBricksDestroyedCount() {
		return bricksDestroyCount;

	}

	public static void setBricksDestroyedCount(int increaseBricksDestroyed) {

		bricksDestroyCount += increaseBricksDestroyed;

		if (bricksDestroyCount == 30) {
			// Abbruchbedinung muss hier noch rein
		}
	}

	public static int getPointsCount() {
		return pointsCalc;

	}

	public static void setPointsCount(int increasePoints) {

		pointsCalc += increasePoints;

	}

}
