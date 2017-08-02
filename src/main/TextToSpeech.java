package main;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {

	private static final String VOICENAME="kevin";
	private Voice voice;

	public TextToSpeech(){
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		VoiceManager voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice(VOICENAME);
	}

	public void speak(String text){
		voice.speak(text);
	}
	public void close(){
		voice.deallocate();
	}
	public void open(){
		voice.allocate();
	}
}
