package settlers;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class PlayerButton extends HexagonalButton{
	BackgroundImage backgroundImage;
	Background background;
	VBox info;
	Label playerName;
	ImageView playerIcon;
	Image img;
	private int playerId;
	

	public PlayerButton(ImageView icon, String name, Color color) {
		BackgroundFill backgroundFill = new BackgroundFill(color, new CornerRadii(1), new Insets(5,5,5,5));
		background = new Background(backgroundFill);
        setBackground(background);
        
        playerIcon = icon;
        playerName = new Label(name);
        playerName.setFont(Font.font("Cambria",FontWeight.BOLD, FontPosture.REGULAR, 20));
        playerName.getStyleClass().add("player-name");
        playerName.setPrefSize(100, 40);
        playerName.setTextFill(Color.WHITE);
        playerName.setTranslateX(-5);
        
        info = new VBox();
        playerIcon.setFitWidth(85);
        playerIcon.setFitHeight(85);
        info.getChildren().addAll(playerIcon, playerName);
        info.setTranslateX(20);
        info.setTranslateY(15);
        setGraphic(info);
        //InnerShadow shadow = new InnerShadow(10, Color.BLACK);
        //this.setStyle("-fx-inner-shadow: 0px 0px 10px 10px rgba(33,33,33,0.7);");
        setOnMouseEntered(new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent event) {
                //setEffect(shadow);
                
            }
        });
        
        setOnMouseExited(new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent event) {
        		//setEffect(null);
        	}
        });

	}


	public int getPlayerId() {
		return playerId;
	}


	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

}
