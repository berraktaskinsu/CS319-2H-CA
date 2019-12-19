package settlers;

import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class BackButton extends SettlersButton{

	public BackButton() {
		super("Back", 120, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
		initialize();
	}
	
	public void initialize() {
		if (Program.LANGUAGE == "English") {
			setText("Back");
		} else if (Program.LANGUAGE == "Turkish") {
			setText("Geri");
		} else if (Program.LANGUAGE == "Azerbaijani") {
			setText("Geri");
		} else if (Program.LANGUAGE == "Russian") {
			setText("назад");
		}
		
		setTranslateX(20);
		setTranslateY(20);
	}
}

