package ch.pf.breakout;

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
		case 1:
			setPointsCount(40);
		case 2:
			Ball.setBallSpeed(10); // ballspeedincrease
		case 3:
			Ball.setBallSpeed(5);// ballspeedecreases
		case 4:
			Paddle.setPaddleWidth(100); // paddlegetssmaler
		case 5: // additional ball

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
