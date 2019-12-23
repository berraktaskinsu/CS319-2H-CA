package settlers;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class SettlersButton extends Button{
	
	public SettlersButton(String text, int width, String normal, String onMouse) {
		super(text);
		setPrefSize(width, 50);
		setStyle(normal);
		setFont(Font.font("Cambria", 25));
		
		this.setOnMouseEntered( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setStyle(onMouse);
			}
			
		});
		
		this.setOnMouseExited( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setStyle(normal);
			}
		});
	}
}

