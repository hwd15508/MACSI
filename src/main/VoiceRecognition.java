package main;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import java.io.IOException;

public class VoiceRecognition {

	private Configuration start_conf;
	private Configuration main_conf;
	private LiveSpeechRecognizer start_rec;
	private LiveSpeechRecognizer main_rec;

	public VoiceRecognition(){
		start_conf = new Configuration();
		start_conf.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		start_conf.setDictionaryPath("resources/start.dic");
		start_conf.setLanguageModelPath("resources/start.lm");
		try{
			start_rec = new LiveSpeechRecognizer(start_conf);
		}catch(IOException ioe){
			System.err.println("Could not create LiveSpeechRecognizer: start_rec");
		}

		main_conf = new Configuration();
		main_conf.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		main_conf.setDictionaryPath("resources/main.dic");
		main_conf.setLanguageModelPath("resources/main.lm");
		try{
			main_rec = new LiveSpeechRecognizer(main_conf);
		}catch(IOException ioe){
			System.err.println("Could not create LiveSpeechRecognizer: main_rec");
		}
	}

	public LiveSpeechRecognizer getStartRec(){
		return start_rec;
	}

	public LiveSpeechRecognizer getMainRec(){
		return main_rec;
	}
}
