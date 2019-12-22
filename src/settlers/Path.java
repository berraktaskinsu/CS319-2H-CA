package settlers;

import javafx.scene.paint.Color;

public class Path {
	private int[] containingHexes;
	private int[] neighbourCorners;
	private boolean occupied;
	private Color color;
	
	public Path(Color color, boolean occupied) {
		setOccupied(occupied);
		setColor(color);
	}
	
	
	public int[] getContainingHexes() {
		return containingHexes;
	}
	public void setContainingHexes(int[] containingHexes) {
		this.containingHexes = containingHexes;
	}
	public int[] getNeighbourCorners() {
		return neighbourCorners;
	}
	public void setNeighbourCorners(int[] neighbourCorners) {
		this.neighbourCorners = neighbourCorners;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
