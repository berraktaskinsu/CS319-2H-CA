package settlers;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class HexButton extends HexagonalButton{
	
	private String currentType;
	private Image currentImage;
	private int hexId;
	private int token;
	BackgroundImage backgroundImage;
	ImageView tokenImage;
	Background background;
	
	public HexButton(String type) {
		super();
		setImage(type);
	}

	public boolean setImage(String type) {
		if (type == "Hills") {
			setCurrentType(type);
			currentImage = new Image("hills2_canvas.jpg");
		} else if (type == "Forest") {
			setCurrentType(type);
			currentImage = new Image("forest_canvas.jpg");
		} else if (type == "Mountains") {
			setCurrentType(type);
			currentImage = new Image("mountain_canvas.jpg");
		} else if (type == "Fields") {
			setCurrentType(type);
			currentImage = new Image("field_canvas.jpg");
		} else if (type == "Pasture") {
			setCurrentType(type);
			currentImage = new Image("pasture_canvas.jpg");
		} else if (type == "Desert") {
			setCurrentType("Desert");
			currentImage = new Image("desert_canvas.jpg");
		} else if (type == "Water Hex") {
			setCurrentType("Water Hex");
			currentImage = new Image("ocean_canvas.jpg");
		} else {
			return false;
		}
		backgroundImage = new BackgroundImage(currentImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		background = new Background(backgroundImage);
        setBackground(background);
        return true;
	}

	public String getCurrentType() {
		return currentType;
	}

	private void setCurrentType(String currentType) {
		this.currentType = currentType;
	}

	public int getHexId() {
		return hexId;
	}

	public void setHexId(int hexId) {
		this.hexId = hexId;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		backgroundImage = new BackgroundImage(currentImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		tokenImage = new ImageView(new Image(token + ".png"));
		tokenImage.setFitHeight(60);
		tokenImage.setFitWidth(60);
		background = new Background(backgroundImage);
		
        setBackground(background);
        this.setGraphic(tokenImage);
		this.token = token;
	
	}
	
}
