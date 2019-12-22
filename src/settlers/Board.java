package settlers;

public class Board {
	
	private Hex[] hexes;
	private Path[] paths;
	private Corner[] corners;
	
	public Board(Hex[] hexes, Path[] paths, Corner[] corners) {
		setHexes(hexes);
		setPaths(paths);
		setCorners(corners);
	}

	public Hex[] getHexes() {
		return hexes;
	}

	public void setHexes(Hex[] hexes) {
		this.hexes = hexes;
	}

	public Path[] getPaths() {
		return paths;
	}

	public void setPaths(Path[] paths) {
		this.paths = paths;
	}

	public Corner[] getCorners() {
		return corners;
	}

	public void setCorners(Corner[] corners) {
		this.corners = corners;
	}
	
	
	
}
