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
// LANGUAGE 

public class SettingsView extends View{

	MenuButton menuButton;
	MenuItem item1;
	MenuItem item2;
	MenuItem item3;
	Label language;
	Label colorBlindnessMode;
	Label volume;
	BackButton backButton;
	HBox selection1;
	HBox selection2;
	HBox selection3;
	HBox everything;
	Pane pane;
	CheckBox checkBox;
	Slider slider;
	VBox selections;
	Image background;
	ImageView mv;
	
	
	public SettingsView(SettingsController settingsController) {
		
		super(settingsController);
		
		String lang1, lang2, lang3, lang4, langLabel, colorLabel, volumeLabel, backLabel;
		

		if (Program.LANGUAGE == "English") {
			lang1 = "English";
			lang2 = "Turkish";
			lang3 = "Azerbaijani";
			lang4 = "Russian";
			langLabel = "Language:";
			colorLabel = "Color Blindness Mode:";
			volumeLabel = "Volume:";
		} else if (Program.LANGUAGE == "Turkish") {
			lang1 = "Türkçe";
			lang2 = "İngilizce";
			lang3 = "Azerice";
			lang4 = "Rusça";
			langLabel = "Dil:";
			colorLabel = "Renk Körlüğü Modu:";
			volumeLabel = "Ses:";
		} else if (Program.LANGUAGE == "Azerbaijani") {
			lang1 = "Azerice";
			lang2 = "İngilis";
			lang3 = "Türkçe";
			lang4 = "Rus";
			langLabel = "Dil:";
			colorLabel = "Rəng korluq rejimi:";
			volumeLabel = "Həcmi:";	
		} else {
			lang1 = "русский";
			lang2 = "английский";
			lang3 = "турецкий";
			lang4 = "азербайджанец";
			langLabel = "язык:";
			colorLabel = "Режим дальтонизма:";
			volumeLabel = "объем:";
		}
		
		item1 = new MenuItem(lang2);
		item2 = new MenuItem(lang3);
		item3 = new MenuItem(lang4);
		menuButton = new MenuButton(lang1, null, item1, item2, item3);
		menuButton.setFont(Font.font("Cambria",FontWeight.NORMAL, FontPosture.REGULAR, 25));
		language = new Label(langLabel);
		language.setFont(Font.font("Cambria",FontWeight.BOLD, FontPosture.REGULAR, 30));
		language.setTextFill(Color.WHITE);
		
		item1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	if (item1.getText() == "Turkish" || item1.getText() == "Türkçe" || item1.getText() == "турецкий") {
		    		Program.LANGUAGE = "Turkish";
			    	goToSettings();
		    	} else if (item1.getText() == "Azerbaijani" || item1.getText() == "Azerice" || item1.getText() == "азербайджанец") {
		    		Program.LANGUAGE = "Azerbaijani";
		    		goToSettings();
		    	} else if (item1.getText() == "английский" || item1.getText() == "İngilizce" || item1.getText() == "İngilis") {
		    		Program.LANGUAGE = "English";
		    		goToSettings();
		    	} else if (item1.getText() == "Russian" || item1.getText() == "Rus" || item1.getText() == "Rusça") {
		    		Program.LANGUAGE = "Russian";
		    		goToSettings();
		    	}
		    }
		});
		
		item2.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	if (item2.getText() == "Turkish" || item2.getText() == "Türkçe" || item2.getText() == "турецкий") {
		    		Program.LANGUAGE = "Turkish";
		    		goToSettings();
		    	} else if (item2.getText() == "Azerbaijani" || item2.getText() == "Azerice" || item2.getText() == "азербайджанец") {
		    		Program.LANGUAGE = "Azerbaijani";
		    		goToSettings();
		    	} else if (item2.getText() == "английский" || item2.getText() == "İngilizce" || item2.getText() == "İngilis") {
		    		Program.LANGUAGE = "English";
		    		goToSettings();
		    	} else if (item2.getText() == "Russian" || item2.getText() == "Rus" || item2.getText() == "Rusça") {
		    		Program.LANGUAGE = "Russian";
		    		goToSettings();
		    	}
		    }
		});
		
		item3.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	if (item3.getText() == "Turkish" || item3.getText() == "Türkçe" || item3.getText() == "турецкий") {
		    		Program.LANGUAGE = "Turkish";
		    		goToSettings();
		    	} else if (item3.getText() == "Azerbaijani" || item3.getText() == "Azerice" || item3.getText() == "азербайджанец") {
		    		Program.LANGUAGE = "Azerbaijani";
		    		goToSettings();
		    	} else if (item3.getText() == "английский" || item3.getText() == "İngilizce" || item3.getText() == "İngilis") {
		    		Program.LANGUAGE = "English";
		    		goToSettings();
		    	} else if (item3.getText() == "Russian" || item3.getText() == "Rus" || item3.getText() == "Rusça") {
		    		Program.LANGUAGE = "Russian";
		    		goToSettings();
		    	}
		    }
		});
		
		selection1 = new HBox();
		selection1.getChildren().addAll(language, menuButton);
		selection1.setSpacing(20);
		
		checkBox = new CheckBox();
		colorBlindnessMode = new Label(colorLabel);
		colorBlindnessMode.setFont(Font.font("Cambria",FontWeight.BOLD, FontPosture.REGULAR, 30));
		colorBlindnessMode.setTextFill(Color.WHITE);
		selection2 = new HBox();
		selection2.getChildren().addAll(colorBlindnessMode, checkBox);
		selection2.setSpacing(20);
		
		slider = new Slider(0, 100, 0);
		volume = new Label(volumeLabel);
		volume.setFont(Font.font("Cambria",FontWeight.BOLD, FontPosture.REGULAR, 30));
		volume.setTextFill(Color.WHITE);
		selection3 = new HBox();
		selection3.getChildren().addAll(volume, slider);
		selection3.setSpacing(20);
		
		selections = new VBox();
		selections.getChildren().addAll(selection1, selection2, selection3);
		selections.setSpacing(100);
		selections.setPadding(new Insets(100, 0, 0, 100));
		
		backButton = new BackButton();
		backButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				goToMainMenu();
			}
			
		});
		
		pane = new Pane();
		pane.getChildren().addAll(selections);
		pane.setStyle("-fx-background-color: rgba(58, 51, 49, 0.5);");
		pane.setPrefSize(500, 500);
		pane.setTranslateY(200);
		pane.setTranslateX(390);
		
		everything = new HBox();
		everything.getChildren().addAll(backButton, pane);
		
		background = new Image("img2.jpg");
		mv = new ImageView(background);
		mv.setFitWidth(Program.WIDTH);
		mv.setFitHeight(Program.HEIGHT);
		this.getChildren().addAll(mv,everything);
		
		
	}

}

