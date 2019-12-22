package settlers;
import javafx.application.Application;
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

public class MainMenuView extends View{
	SettlersButton howToPlay, settings, newGame, quitGame;
	VBox buttons, everything;
	Text title;
	Image background;
	ImageView mv;
	
	public MainMenuView(MainMenuController mainMenuController) {
		
		super(mainMenuController);
		
		howToPlay = new SettlersButton("How To Play?", 300, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
		settings = new SettlersButton("Setings", 300, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
		newGame = new SettlersButton("New Game", 300, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
		quitGame = new SettlersButton("Quit Game", 300, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
		howToPlay.setTextFill(Color.WHITE);
		settings.setTextFill(Color.WHITE);
		newGame.setTextFill(Color.WHITE);
		quitGame.setTextFill(Color.WHITE);
		
		
		howToPlay.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				goToHowToPlay();
			}
			
		});
		
		settings.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				goToSettings();
			}
			
		});
		
		newGame.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				goToNewGame();
				
			}
			
		});
		
		quitGame.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
			}
			
		});
		
		buttons = new VBox();
		buttons.setSpacing(20);
		buttons.getChildren().addAll(newGame, settings, howToPlay, quitGame);
		buttons.setPadding(new Insets(120, 0, 0, 20));
		
		title = new Text("Settlers of Catan");
		title.setFill(Color.DARKRED);
		title.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.REGULAR, 150));
		
		everything = new VBox();
		everything.getChildren().addAll(title, buttons);
		everything.setPadding(new Insets(100, 0, 0, 50));
		
		background = new Image("img1.png");
		mv = new ImageView(background);
		mv.setFitWidth(Program.WIDTH);
		mv.setFitHeight(Program.HEIGHT);
		this.getChildren().addAll(mv,everything);
		
	}
	
}
