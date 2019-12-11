package MiniTennis;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundTest {
	public static void main(String[] args) throws Exception {

		URL url = SoundTest.class.getResource("back.wav");
		AudioClip clip = Applet.newAudioClip(url);
		AudioClip clip2 = Applet.newAudioClip(url);
		clip.play();
		Thread.sleep(1000);
		clip2.loop();
		Thread.sleep(20000);
		clip2.stop();
		
		System.out.println("end");
	}
}
