package ch.pf.breakout.ch.pf.breakout;

//import javax.sound.sampled.Clip;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sounds {
	public static Clip backgroundMusic = getSound("/sounds/Strong-man-electro-track.wav");

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

}
