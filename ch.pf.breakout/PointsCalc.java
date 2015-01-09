
public class PointsCalc implements BreakoutSettings {

	private static int bricksDestroyCount = 0;
	private static int pointsCalc = 0;
	private static int currentGameLevel = 1;

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
			Paddle.setPaddleWidth((int) (FrameWidth * 0.2));
			break; // paddlegetssmaler

		case 5:
			// new Ball
			break;
		case 6:
			Paddle.setPaddleWidth((int) (FrameWidth * 0.4));
			break; // paddlegetssmaler

		}
		setBricksDestroyedCount(1);

	}

	public static int getBricksDestroyedCount() {
		return bricksDestroyCount;

	}

	public static void setBricksDestroyedCount(int increaseBricksDestroyed) {

		bricksDestroyCount += increaseBricksDestroyed;

		// this will be a bug if you play more than two rounds
		if (bricksDestroyCount == 30 * getGameLevel()) {
			Board.gameResetWin();
			increaseGameLevel();
		}
	}

	public static int getPointsCount() {
		return pointsCalc;

	}

	public static int getGameLevel() {
		return currentGameLevel;

	}

	public static void increaseGameLevel() {

		currentGameLevel++;
	}

	public static void increaseGameLevel(int increaseLevel) {
		currentGameLevel += increaseLevel;
	}

	public static void setPointsCount(int increasePoints) {

		pointsCalc += increasePoints;

	}

}
