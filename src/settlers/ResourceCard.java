package settlers;

public class ResourceCard implements Card{
	
	private String type;

	public ResourceCard(String type) {
		setType(type);
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	
}
