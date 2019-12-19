package settlers;

import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class HexagonalButton extends Button{

	public HexagonalButton() {
		super();
		getStyleClass().add("hex-button");
		setPrefSize(150,150);
		this.setBorder(new Border(new BorderStroke(Color.ANTIQUEWHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
	}

}
