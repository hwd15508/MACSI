package main;

import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Main {

	public static VoiceRecognition vr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creates Configuration and LiveSpeechRecognizer Objects for VoiceRecognition
		vr = new VoiceRecognition();

		//Waiting to start
		proc_start();
	}

	public static void proc_start(){
		SpeechResult start_result;
		LiveSpeechRecognizer start = vr.getStartRec();
		start.startRecognition(true);
		while((start_result=start.getResult())!=null){
			String command = start_result.getHypothesis();
			if(command.equalsIgnoreCase("macsi open up")||
					command.equalsIgnoreCase("open up macsi")||
					command.equalsIgnoreCase("time to go to work macsi")||
					command.equalsIgnoreCase("wake up macsi")||
					command.equalsIgnoreCase("macsi I need you")||
					command.equalsIgnoreCase("I need you macsi")){
				start.stopRecognition();
				proc_main();
			}
		}
	}

	public static void proc_main(){
		TextToSpeech tts = new TextToSpeech();
		tts.open();
		tts.speak("Awake and at your service sir.");
		SpeechResult main_result;
		LiveSpeechRecognizer main = vr.getMainRec();
		main.startRecognition(true);
		while((main_result=main.getResult())!=null){
			String command = main_result.getHypothesis();
			if(command.equalsIgnoreCase("time to go to bed macsi")||
					command.equalsIgnoreCase("I'm good for now macsi")||
					command.equalsIgnoreCase("macsi shut down")||
					command.equalsIgnoreCase("macsi off")){
				tts.speak("Goodbye and good luck sir.");
				main.stopRecognition();
				tts.close();
				proc_start();
			}
		}
	}
}
