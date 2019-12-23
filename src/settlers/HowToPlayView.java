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

public class HowToPlayView extends View{

	ScrollPane scrollPane;
	HBox everything;
	Image background;
	ImageView mv;
	BackButton backButton;
	Text text;
	Label label;
	VBox paneComponents;
	
	public HowToPlayView(HowToPlayController howToPlayController) {
		
		super(howToPlayController);
		backButton = new BackButton();
		backButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				goToMainMenu();
			}
			
		});
		
		label = new Label("How To Play?");
		label.setFont(Font.font("Cambria",FontWeight.BOLD, FontPosture.REGULAR, 50));
		label.setTextFill(Color.DARKGOLDENROD);
		
		text = new Text("\tHere will be written details on how to play");
		text.setFont(Font.font("Cambria",FontWeight.NORMAL, FontPosture.REGULAR, 12));
		
		paneComponents = new VBox();
		paneComponents.getChildren().addAll(label, text);
		paneComponents.setSpacing(10);
		paneComponents.setPadding(new Insets(50, 0, 0, 80));
		

		
		ScrollPane pane = new ScrollPane();
		//pane.getStyleClass().add("scroll-pane");
		pane.getStylesheets().add("settlers.css");
		
		pane.setFocusTraversable(false);
		pane.setPrefSize(800, Program.HEIGHT);
		pane.setTranslateX(200);
		pane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
		pane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
		pane.setStyle("-fx-background-color: transparent");
		pane.setContent(paneComponents);
		
		everything = new HBox();
		everything.getChildren().addAll(backButton, pane);

		background = new Image("img3.jpg");
		if (Program.MODE == "pirates") {
			background = new Image("pirate2.jpg");
		}
		
		mv = new ImageView(background);
		mv.setFitWidth(Program.WIDTH);
		mv.setFitHeight(Program.HEIGHT);
		getChildren().addAll(mv, everything);

	}

}