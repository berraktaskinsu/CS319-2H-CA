package settlers;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

public class Program extends Application {
	
	static double HEIGHT;
	static double WIDTH;
	static String LANGUAGE;
	static String MODE = "normal";
	
	@Override
	public void start(Stage stage) {
		try {
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
			HEIGHT = primaryScreenBounds.getMaxY();
			WIDTH = primaryScreenBounds.getMaxX();
			
			
			//Pane root = (Pane) FXMLLoader.load(getClass().getResource("Settlers.fxml"));
			stage.setFullScreen(true);
			Group root = new Group();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("settlers.css").toExternalForm());
			stage.setScene(scene);
			ViewControllerController viewControllerController = new ViewControllerController(scene);
			viewControllerController.goToMainMenu();
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		music();
		
	}
	
	public static void music() {
		
		File file = new File("//Users//Berrak//Desktop//music.wav");
		AudioInputStream audioStream;
		try {
			audioStream = AudioSystem.getAudioInputStream(file);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip audioClip;
			try {
				audioClip = (Clip) AudioSystem.getLine(info);
				audioClip.open(audioStream);
				audioClip.loop(Clip.LOOP_CONTINUOUSLY);
				audioClip.start();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	
	}
	
	
}
