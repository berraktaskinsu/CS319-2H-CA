package com.berrak.settlers;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
	
	// Attributes
	
	private ArrayList<DevelopmentCard> developmentCards;
	private int numOfOreCards;
	private int numOfLumberCards;
	private int numOfBrickCards;
	private int numOfWoolCards;
	private int numOfWheatCards;
	
	// Constructors

	public Bank() {
		setNumOfOreCards(25);
		setNumOfLumberCards(25);
		setNumOfBrickCards(25);
		setNumOfWoolCards(25);
		setNumOfWheatCards(25);
		developmentCards = new ArrayList<DevelopmentCard>() {
			{
				for (int i = 0 ; i < 14 ; i++) {
					add(new DevelopmentCard("Knight"));
				}
				for (int i = 0 ; i < 2 ; i++) {
					add(new DevelopmentCard("Road Building"));
				}
				for (int i = 0 ; i < 5 ; i++) {
					add(new DevelopmentCard("VictoryPoint"));
				}	
			}
		};
	}
	
	// Getters and Setters
	
	public int getNumOfOreCards() {
		return numOfOreCards;
	}

	public void setNumOfOreCards(int numOfOreCards) {
		this.numOfOreCards = numOfOreCards;
	}

	public int getNumOfLumberCards() {
		return numOfLumberCards;
	}

	public void setNumOfLumberCards(int numOfLumberCards) {
		this.numOfLumberCards = numOfLumberCards;
	}

	public int getNumOfBrickCards() {
		return numOfBrickCards;
	}

	public void setNumOfBrickCards(int numOfBrickCards) {
		this.numOfBrickCards = numOfBrickCards;
	}
	
	public int getNumOfWoolCards() {
		return numOfWoolCards;
	}

	public void setNumOfWoolCards(int numOfWoolCards) {
		this.numOfWoolCards = numOfWoolCards;
	}

	public int getNumOfWheatCards() {
		return numOfWheatCards;
	}

	public void setNumOfWheatCards(int numOfWheatCards) {
		this.numOfWheatCards = numOfWheatCards;
	}
	
	// Methods
	
	public void takeDevelopmentCard(DevelopmentCard takenCard) {
		developmentCards.add(takenCard);
	}
	
	public DevelopmentCard giveDevelopmentCard() {
		if ( developmentCards.size() > 0 ) {
			Random generator = new Random();
			int index = generator.nextInt(developmentCards.size());
			DevelopmentCard givenCard = developmentCards.get(index);
			developmentCards.remove(index);
			return givenCard;
		} else {
			return null;
		}
	}
	
	public void takeResourceCard(String resourceCardType) {
		if (resourceCardType == "Ore") {
			numOfOreCards++;
		} else if (resourceCardType == "Lumber") {
			numOfLumberCards++;
		} else if (resourceCardType == "Brick") {
			numOfBrickCards++;
		} else if (resourceCardType == "Wool") {
			numOfWoolCards++;
		} else if (resourceCardType == "Wheat") {
			numOfWheatCards++;
		}
	}
	
	public boolean giveResourceCard(String resourceCardType) {
		if (resourceCardType == "Ore") {
			if (numOfOreCards > 0) {
				numOfOreCards--;
				return true;
			} else {
				return false;
			}
		} else if (resourceCardType == "Lumber") {
			if (numOfLumberCards > 0) {
				numOfLumberCards--;
				return true;
			} else {
				return false;
			}
		} else if (resourceCardType == "Brick") {
			if (numOfBrickCards > 0) {
				numOfBrickCards--;
				return true;
			} else {
				return false;
			}
		} else if (resourceCardType == "Wool") {
			if (numOfWoolCards > 0) {
				numOfWoolCards--;
				return true;
			} else {
				return false;
			}
		} else if (resourceCardType == "Wheat") {
			if (numOfWheatCards > 0) {
				numOfWheatCards--;
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
