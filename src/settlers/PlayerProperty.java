package settlers;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class PlayerProperty {
	
	private Color color;
	private String name;
	private ImageView icon;

	public PlayerProperty(Color color, String name, ImageView icon) {
		setColor(color);
		setName(name);
		setIcon(icon);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setIcon(ImageView icon) {
		this.icon = icon;
	}
	
	public ImageView getIcon() {
		return icon;
	}
}
