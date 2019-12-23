package settlers;


import java.util.ArrayList;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Player {

	private ImageView icon;
	private String name;
	private Color color;
	private int numberOfRoads;
	private int numberOfSettlements;
	private int numberOfCities;
	
	private ArrayList<Card> hand;
	private ArrayList<DevelopmentCard> front; // knight
	private boolean strongestArmy;
	private boolean longestRoad;
	
	/*private ArrayList<ResourceCard> lumberCards;
	private int numberOfLumberCards;
	private ArrayList<ResourceCard> grainCards;
	private int numberOfGrainCards;
	private ArrayList<ResourceCard> oreCards;
	private int numberOfOreCards;
	private ArrayList<ResourceCard> brickCards;
	private int numberOfBrickCards;
	private ArrayList<ResourceCard> woolCards;
	private int numberOfWoolCards;*/
	
	private int numberOfCards;
	
	
	public Player(String playerName, ImageView icon, Color color) {
		hand = new ArrayList<Card>();
		setName(playerName);
		setIcon(icon);
		setColor(color);
		setNumberOfRoads(15);
		setNumberOfSettlements(5);
		setNumberOfCities(5);
		setNumberOfCards(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageView getIcon() {
		return icon;
	}

	public void setIcon(ImageView icon) {
		this.icon = icon;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getNumberOfRoads() {
		return numberOfRoads;
	}

	public void setNumberOfRoads(int numberOfRoads) {
		this.numberOfRoads = numberOfRoads;
	}

	public int getNumberOfSettlements() {
		return numberOfSettlements;
	}

	public void setNumberOfSettlements(int numberOfSettlements) {
		this.numberOfSettlements = numberOfSettlements;
	}

	public int getNumberOfCities() {
		return numberOfCities;
	}

	public void setNumberOfCities(int numberOfCities) {
		this.numberOfCities = numberOfCities;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public ArrayList<DevelopmentCard> getFront() {
		return front;
	}

	public void setFront(ArrayList<DevelopmentCard> front) {
		this.front = front;
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}

	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}

	public boolean hasStrongestArmy() {
		return strongestArmy;
	}

	public void setStrongestArmy(boolean strongestArmy) {
		this.strongestArmy = strongestArmy;
	}

	public boolean hasLongestRoad() {
		return longestRoad;
	}

	public void setLongestRoad(boolean longestRoad) {
		this.longestRoad = longestRoad;
	}
	
	/*public boolean takeCard(Card card) {
		if (card instanceof ResourceCard) {
			if (((ResourceCard) card).getType() == "lumber") {
				lumberCards.add((ResourceCard) card);
				setNumberOfLumberCards(getNumberOfLumberCards() + 1);
			} else if (((ResourceCard) card).getType() == "grain") {
				grainCards.add((ResourceCard) card);
				setNumberOfGrainCards(getNumberOfGrainCards() + 1);
			} else if (((ResourceCard) card).getType() == "ore") {
				oreCards.add((ResourceCard) card);
				setNumberOfOreCards(getNumberOfOreCards() + 1);
			} else if (((ResourceCard) card).getType() == "brick") {
				brickCards.add((ResourceCard) card);
				setNumberOfBrickCards(getNumberOfBrickCards() + 1);
			} else if (((ResourceCard) card).getType() == "wool") {
				woolCards.add((ResourceCard) card);
				setNumberOfWoolCards(getNumberOfWoolCards() + 1);
			}
			return true;
		} else if (card instanceof DevelopmentCard) {
			developmentCards.add((DevelopmentCard) card);
			setNumberOfDevelopmentCards(getNumberOfDevelopmentCards() + 1);
			return true;
		}
		return false;
	}*/

}
