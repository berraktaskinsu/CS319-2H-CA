package com.berrak.settlers;
import java.util.ArrayList;
import java.util.Random;

public class Player {
	
	// Attributes
	
	private String name;
	private int numOfCards;
	private int points;
	private boolean isTurn;
	private boolean longestRoad;
	private boolean largestArmy;
	private int currentDice;
	private String color;
	
	private ArrayList<Card> hand;
	private ArrayList<DevelopmentCard> front;
	private int settlements_in;
	private int cities_in;
	private int roads_in;
	
	// Constructors
	
	public Player(String name) {
		setName(name);
		setNumOfCards(0);
		setPoints(0);
		setIsTurn(false);
		setLongestRoad(false);
		setLargestArmy(false);
		
		hand = new ArrayList<Card>();
		front = new ArrayList<DevelopmentCard>();
		setSettlements_in(5);
		setCities_in(4);
		setRoads_in(15);
	}
	
	// Getters and Setters
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumOfCards() {
		return numOfCards;
	}
	
	public void setNumOfCards(int numOfCards) {
		this.numOfCards = numOfCards;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public boolean getIsTurn() {
		return isTurn;
	}

	public void setIsTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public boolean getLongestRoad() {
		return longestRoad;
	}

	public void setLongestRoad(boolean longestRoad) {
		this.longestRoad = longestRoad;
	}

	public boolean getLargestArmy() {
		return largestArmy;
	}

	public void setLargestArmy(boolean largestArmy) {
		this.largestArmy = largestArmy;
	}

	public int getSettlements_in() {
		return settlements_in;
	}

	public void setSettlements_in(int settlements_in) {
		this.settlements_in = settlements_in;
	}

	public int getCities_in() {
		return cities_in;
	}

	public void setCities_in(int cities_in) {
		this.cities_in = cities_in;
	}

	public int getRoads_in() {
		return roads_in;
	}

	public void setRoads_in(int roads_in) {
		this.roads_in = roads_in;
	}

	public int getCurrentDice() {
		return currentDice;
	}

	public void setCurrentDice(int currentDice) {
		this.currentDice = currentDice;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// Methods
	
	public void rollDice() {
		Random generator1 = new Random();
		Random generator2 = new Random();
		int die1 = generator1.nextInt(6);
		int die2 = generator2.nextInt(6);
		setCurrentDice(die1  + die2);
	}




	
	
	
	
	
	

}
