package settlers;



public class GameModel {

	private int numberOfPlayers;
	private Player[] players;
	private Bank bank;
	private Board board;
	private int playerInTurn;
	
	
	public GameModel(PlayerProperty[] playerProperties) {
		
		this.setNumberOfPlayers(playerProperties.length);
		players = new Player[getNumberOfPlayers()];
		 
		for (int i = 0 ; i < getNumberOfPlayers() ; i++) {
			PlayerProperty playerProperty = playerProperties[i];
			Player player = new Player(playerProperty.getName(), playerProperty.getIcon(), playerProperty.getColor());
			players[i] = player;
			/*for (int j = 0 ; j < 18 ; j++) {
				Player player = new Player(playerProperty.getName(), playerProperty.getIcon(), playerProperty.getColor());
				players[i] = player;
			}*/
		}
		createBank();
		setPlayerInTurn(1);
		
	}
	
	public void createBoard(Hex[] hexes, Path[] paths, Corner[] corners) {
		board = new Board(hexes, paths, corners);
	}
	
	public void createBank() {
		bank = new Bank();
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

	public int getPlayerInTurn() {
		return playerInTurn;
	}

	public void setPlayerInTurn(int playerInTurn) {
		this.playerInTurn = playerInTurn;
	}
	
	public int nextTurn(int cycle) {
		if (cycle == 1) {
			if (getPlayerInTurn() < 4) {
				setPlayerInTurn(getPlayerInTurn() + 1);
			} else if (getPlayerInTurn() == 4) {
				return cycle + 1;
			}
		} else if (cycle == 2) {
			if (getPlayerInTurn() > 1) {
				setPlayerInTurn(getPlayerInTurn() - 1);
			} else if (getPlayerInTurn() == 1) {
				return cycle + 1;
			}
		} else {
			if (getPlayerInTurn() == 4) {
				setPlayerInTurn(1);
			} else {
				setPlayerInTurn(getPlayerInTurn() + 1);
			}
		}
		return cycle;
	}
	
}
