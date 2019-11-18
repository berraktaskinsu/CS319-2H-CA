package com.berrak.settlers;

public class GameBoard {
	
	private int[] numOfCitiesOnBoard;
	private int[] numOfSettlementsOnBoard;
	private int[] numOfRoadsOnBoard;
	private Hex[] hexes;
	
	
	public GameBoard(int numOfPlayers) {
		numOfCitiesOnBoard = new int[numOfPlayers];
		numOfSettlementsOnBoard = new int[numOfPlayers];
		numOfRoadsOnBoard = new int[numOfPlayers];
		hexes = new Hex[19];
	}
	
	public boolean addCity(int playerNo, int cornerNo) {
		numOfCitiesOnBoard[playerNo]++;
		return true;
	}
	
	public boolean addSettlement(int playerNo, int cornerNo) {
		numOfSettlementsOnBoard[playerNo]++;
		return true;
	}
	
	public boolean addRoad(int playerNo, int pathNo) {
		numOfRoadsOnBoard[playerNo]++;
		return true;
	}

}
