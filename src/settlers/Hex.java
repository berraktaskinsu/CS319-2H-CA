package settlers;

public class Hex {

	private String type;
	private int token;
	private int[] corners;
	private int[] paths;
	private boolean occupiedByThief;
	
	public Hex(String type, int token, boolean occupiedByThief) {
		setType(type);
		setToken(token);
		//setCorners(corners);
		//setPaths(paths);
		setOccupiedByThief(occupiedByThief);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}
	
	public int[] getCorners() {
		return corners;
	}

	public void setCorners(int[] corners) {
		this.corners = corners;
	}

	public int[] getPaths() {
		return paths;
	}

	public void setPaths(int[] paths) {
		this.paths = paths;
	}

	public boolean isOccupiedByThief() {
		return occupiedByThief;
	}

	public void setOccupiedByThief(boolean occupiedByThief) {
		this.occupiedByThief = occupiedByThief;
	}


	
	
	
	
	
}
