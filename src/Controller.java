package com.berrak.settlers;
import java.util.Random;
public class Controller {
	
	// Attributes
	
	private Player[] players;
	private Player[] playersByTurn;
	private Bank bank;
	private GameBoard board;
	private int numOfPlayers;
	
	public Controller(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
		players = new Player[numOfPlayers];
	}
	
	public void playFirstTurn(int playerNo) {
		Player currentPlayer = playersByTurn[playerNo-1];
		putProperties(currentPlayer);
		
	}
	
	public void putProperties(int playerNo, Player currentPlayer, int pathNo, int cornerNo) {
		currentPlayer.setSettlements_in(currentPlayer.getSettlements_in() - 1);
		currentPlayer.setRoads_in(currentPlayer.getRoads_in() - 1);
		board.addSettlement(playerNo, cornerNo);
		board.addRoad(playerNo, pathNo);
		
	}
	
	public void playSecondTurn(int playerNo) {
		
	}
	
	public void detectPlayerTurns() {
		int[] diceValues = new int[numOfPlayers];
		for (int i = 0 ; i < numOfPlayers ; i++) {
			diceValues[i] = players[i].getCurrentDice();
		}
		
		Player max, min, mid;
		if (numOfPlayers >= 3) {
			if (players[1].getCurrentDice() <= players[2].getCurrentDice()) {
				if (players[1].getCurrentDice() <= players[3].getCurrentDice()) {
					min = players[1];
					if (players[2].getCurrentDice() <= players[3].getCurrentDice()) {
						max = players[3];
						mid = players[2];
					} else {
						max = players[2];
						mid = players[3];
					}
				} else {
					min = players[3];
					max = players[2];
					mid = players[1];
				}
			} else {
				if (players[1].getCurrentDice() <= players[3].getCurrentDice()) {
					min = players[2];
					max = players[3];
					mid = players[1];
				} else {
					max = players[1];
					if (players[2].getCurrentDice() <= players[3].getCurrentDice()) {
						mid = players[3];
						min = players[2];
					} else {
						mid = players[2];
						min = players[3];
					}
				}
			}
			playersByTurn[1] = max;
			playersByTurn[2] = mid;
			playersByTurn[3] = min;
			
			if (numOfPlayers == 4) {
				Player last = players[4];
				if (last.getCurrentDice() <= min.getCurrentDice()) {
					playersByTurn[1] = max;
					playersByTurn[2] = mid;
					playersByTurn[3] = min;
					playersByTurn[4] = last;
				} else if (max.getCurrentDice() <= last.getCurrentDice()){
					playersByTurn[1] = last;
					playersByTurn[2] = max;
					playersByTurn[3] = mid;
					playersByTurn[4] = min;
				} else if (mid.getCurrentDice() <= last.getCurrentDice() && last.getCurrentDice() <= max.getCurrentDice() ){
					playersByTurn[1] = max; 
					playersByTurn[2] = last;
					playersByTurn[3] = mid;
					playersByTurn[4] = min;
				} else {
					playersByTurn[1] = max; 
					playersByTurn[2] = mid;
					playersByTurn[3] = last;
					playersByTurn[4] = min;
				}
			}
		}				

	}
	
}
