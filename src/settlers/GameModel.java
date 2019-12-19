package settlers;



public class GameModel {

	private int numberOfPlayers;
	private Player[] players;
	//private Bank bank;
	private Board board;
	
	
	public GameModel(PlayerProperty[] playerProperties) {
		
		this.setNumberOfPlayers(playerProperties.length);
		players = new Player[getNumberOfPlayers()];
		 
		for (int i = 0 ; i < getNumberOfPlayers() ; i++) {
			PlayerProperty playerProperty = playerProperties[i];
			for (int j = 0 ; j < 18 ; j++) {
				Player player = new Player(playerProperty.getName(), playerProperty.getIcon(), playerProperty.getColor());
				players[i] = player;
			}
		}
	}
	
	public void createBoard(Hex[] hexes, Path[] paths, Corner[] corners) {
		board = new Board(hexes, paths, corners);
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

}
