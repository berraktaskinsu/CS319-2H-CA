package com.berrak.settlers;

public class DevelopmentCard extends Card{
	
	private String type;

	public DevelopmentCard(String type) {
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
