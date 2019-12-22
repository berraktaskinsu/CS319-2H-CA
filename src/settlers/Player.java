package settlers;


import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Player {

	private ImageView icon;
	private String name;
	private Color color;
	
	public Player(String playerName, ImageView icon, Color color) {
		this.setName(playerName);
		this.setIcon(icon);
		this.setColor(color);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageView getIcon() {
		return icon;
	}

	public void setIcon(ImageView icon) {
		this.icon = icon;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
