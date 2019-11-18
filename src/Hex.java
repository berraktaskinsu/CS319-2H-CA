package com.berrak.settlers;

public class Hex {
	
	private String type;
	private Corner[] corners;
	private Path[] paths;

	public Hex() {
		setType("");
		corners = new Corner[6];
		paths = new Path[6];
		for (int i = 0 ; i < 6 ; i++) {
			corners[i] = i+1;
		}
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Corner getCorner(int hexCornerId) {
		return corners[hexCornerId];
	}
	
	public Path getPath(int hexPathId) {
		return paths[hexPathId];
	}


	

}
