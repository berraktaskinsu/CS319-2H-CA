package com.berrak.settlers;

public class Corner {
	
	private boolean occupied;
	private int id;
	private int[] containingHexes;

	public Corner() {
		occupied = false;
		id = -1;
		containingHexes = new int[6];
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getContainingHexes() {
		return containingHexes;
	}

	public void setContainingHexes(int[] containingHexes) {
		this.containingHexes = containingHexes;
	}

}
