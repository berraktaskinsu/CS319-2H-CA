package com.berrak.settlers;

public class ResourceCard extends Card{
	
	private String type;

	public ResourceCard(String type) {
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
