package ch.pf.breakout.ch.pf.breakout;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.sound.sampled.Clip;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sounds {
	public static Clip backgroundMusic = getSound("/sounds/background.wav");

	private static Clip getSound(String path) {

		URL url = Sounds.class.getResource(path);
		Clip clip = null;
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		return clip;

	}

	public static void play(Clip clip) {
		if (clip.isActive()) {
			clip.stop();
		}

		clip.setFramePosition(0);
		clip.start();
	}

	public static void loop(Clip clip) {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public static void stop(Clip clip) {
		clip.stop();
	}

	/*
	 * public static final AudioClip BREAKOUTSOUND =
	 * Applet.newAudioClip(Sounds.class
	 * .getResource("/sounds/background_converted.wav"));
	 * 
	 * private static String _music;
	 * 
	 * public static void loopMusic(String music) { _music = music; switch
	 * (music) { case "CTYPE": { Sounds.BREAKOUTSOUND.play(); } break;
	 * 
	 * } }
	 * 
	 * public static void stopMusic() { switch (_music) { case "ATYPE": {
	 * Sounds.BREAKOUTSOUND.stop(); } break;
	 * 
	 * }
	 * 
	 * }
	 */
}
