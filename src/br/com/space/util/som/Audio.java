package br.com.space.util.som;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import br.com.space.util.log.Log;

/**
 * @author Neto
 *
 */
public class Audio {

	private static Clip clip;

	private Audio() {
	}

	/**
	 * @param pFile
	 * @param repeat
	 * @param volume
	 */
	public static void play(String pFile, boolean repeat, Float volume) {

		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(pFile).getAbsoluteFile());

			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.stop();
			setVolume(volume);

			if (!repeat) {
				clip.loop(0);

			} else {
				clip.loop(Clip.LOOP_CONTINUOUSLY);

			}

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			Log.writeLog("Audio.tocarAudio() :: Erro ao reproduziar o audio " + e);
			e.printStackTrace();
		}

	}

	public static void stop() {
		if (clip != null) {
			clip.stop();
			clip.close();

		}
	}

	public static void setVolume(Float volume) {
		Float defaul = 0.9f;
		if (volume < 0f || volume > 1f) {
			volume = defaul;
			Log.writeLog("Audio.setVolume() :: Volume invalido, atribuido valor default " + defaul);
		}
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		float range = gainControl.getMaximum() - gainControl.getMinimum();
		float gain = (range * volume) + gainControl.getMinimum();
		gainControl.setValue(gain);
	}

	public static float getVolume() {
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		return (float) Math.pow(10f, gainControl.getValue() / 20f);
	}
}
