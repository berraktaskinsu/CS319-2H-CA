package settlers;

import javafx.scene.paint.Color;

public class Corner {
	private int[] containingHexes;
	private int[] neighbourPaths;
	private Color color;
	private int occupied;
	
	public Corner(Color color, int occupied){
		
		setColor(color);
		setOccupied(occupied);
	}

	public int[] getContainingHexes() {
		return containingHexes;
	}

	public void setContainingHexes(int[] containingHexes) {
		this.containingHexes = containingHexes;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getOccupied() {
		return occupied;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public int[] getNeighbourPaths() {
		return neighbourPaths;
	}

	public void setNeighbourPaths(int[] neighbourPaths) {
		this.neighbourPaths = neighbourPaths;
	}
	
	public boolean isOccupied() {
		return (occupied == 0);
	}
}
