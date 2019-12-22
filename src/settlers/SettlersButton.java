package settlers;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class SettlersButton extends Button{
	
	public SettlersButton(String text, int width, String normal, String onMouse) {
		this(text, width, 50, normal, onMouse);
	}
	
	public SettlersButton(String text, int width, int height, String normal, String onMouse) {
		super(text);
		setPrefSize(width, height);
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
	
	public SettlersButton(double x, double y, String text, int width, String normal, String onMouse) {
		this(x, y, text, width, 60, normal, onMouse);
	}
	
	public SettlersButton(double x, double y, String text, int width, int height, String normal, String onMouse) {
		this(text, width, height, normal, onMouse);
		setTranslateX(x);
		setTranslateY(y);
	}
}

