package ch.pf.breakout.ch.pf.breakout;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sounds {

	public static final AudioClip BREAKOUTSOUND = Applet.newAudioClip(Sounds.class.getResource("/Breakout/src/sounds/donkey.wav"));

	private static String _music;

	public static void loopMusic(String music) {
		_music = music;
		switch (music) {
		case "CTYPE": {
			Sounds.BREAKOUTSOUND.loop();
		}
			break;

		}
	}

	public static void stopMusic() {
		switch (_music) {
		case "ATYPE": {
			Sounds.BREAKOUTSOUND.stop();
		}
			break;

		}

	}

}
