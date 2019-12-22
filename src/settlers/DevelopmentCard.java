package settlers;

public class DevelopmentCard implements Card{

	private String type;
	
	public DevelopmentCard(String type) {
		setType(type);
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}



}
