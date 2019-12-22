package settlers;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class CornerButton extends Button{
	
	private int cornerId;

	public CornerButton(int cornerId) {
		getStyleClass().add("corner-button");
		setPrefSize(30,30);
		setStyle("-fx-background-color: transparent");
		setCornerId(cornerId);
		// TODO Auto-generated constructor stub
		setOnMouseEntered( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setStyle("-fx-background-color: rgba(33, 33, 33, 0.55);");
			}
			
		});
		setOnMouseExited( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setStyle("-fx-background-color: transparent;");
			}
			
		});
	}

	public int getCornerId() {
		return cornerId;
	}

	public void setCornerId(int cornerId) {
		this.cornerId = cornerId;
	}

}
