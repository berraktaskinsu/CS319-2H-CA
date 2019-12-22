package settlers;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class PathButton extends Button{

	private int pathId;
	
	public PathButton(int pathId) {
		getStyleClass().add("path-button");
		setPathId(pathId);
		setPrefSize(60,10);
		setStyle("-fx-background-color: transparent;");
		
		if (pathId <= 24) {
			setRotate(330);
		} else if (pathId <= 48) {
			setRotate(30);
		} else if (pathId <= 72) {
			setRotate(90);
		}
		
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

	public int getPathId() {
		return pathId;
	}

	public void setPathId(int pathId) {
		this.pathId = pathId;
	}
}
