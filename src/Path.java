package com.berrak.settlers;

public class Path {
	
	private boolean occupied;
	private int id;

	public Path() {
		occupied = false;
		id = -1;
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

}
