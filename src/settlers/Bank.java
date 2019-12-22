package settlers;

import java.util.ArrayList;

public class Bank {

	
	private ArrayList<ResourceCard> lumberCards;
	private int numberOfLumberCards;
	private ArrayList<ResourceCard> grainCards;
	private int numberOfGrainCards;
	private ArrayList<ResourceCard> oreCards;
	private int numberOfOreCards;
	private ArrayList<ResourceCard> brickCards;
	private int numberOfBrickCards;
	private ArrayList<ResourceCard> woolCards;
	private int numberOfWoolCards;
	
	private ArrayList<DevelopmentCard> developmentCards;
	private int numberOfDevelopmentCards;
	
	public Bank() {
		
		lumberCards = new ArrayList<ResourceCard>(19);
		for (int i = 0 ; i < 19 ; i++) {
			lumberCards.add(new ResourceCard("lumber"));
		}
		setNumberOfLumberCards(lumberCards.size());
		grainCards = new ArrayList<ResourceCard>(19);
		for (int i = 0 ; i < 19 ; i++) {
			grainCards.add(new ResourceCard("grain"));
		}
		setNumberOfGrainCards(grainCards.size());
		oreCards = new ArrayList<ResourceCard>(19);
		for (int i = 0 ; i < 19 ; i++) {
			oreCards.add(new ResourceCard("ore"));
		}
		setNumberOfOreCards(oreCards.size());
		brickCards = new ArrayList<ResourceCard>(19);
		for (int i = 0 ; i < 19 ; i++) {
			brickCards.add(new ResourceCard("brick"));
		}
		setNumberOfBrickCards(brickCards.size());
		woolCards = new ArrayList<ResourceCard>(19);
		for (int i = 0 ; i < 19 ; i++) {
			woolCards.add(new ResourceCard("wool"));
		}
		setNumberOfWoolCards(woolCards.size());
		
		developmentCards = new ArrayList<DevelopmentCard>(25);
		for (int i = 0 ; i < 25 ; i++) {
			if (i < 14) {
				developmentCards.add(new DevelopmentCard("knight"));
			} else if (i < 19) {
				developmentCards.add(new DevelopmentCard("victory point"));
			} else if (i < 21) {
				developmentCards.add(new DevelopmentCard("road building"));
			} else if (i < 23) {
				developmentCards.add(new DevelopmentCard("year of plenty"));
			} else {
				developmentCards.add(new DevelopmentCard("monopoly"));
			}
		}
		setNumberOfDevelopmentCards(developmentCards.size());
		
		
		
	}

	public int getNumberOfLumberCards() {
		return numberOfLumberCards;
	}

	public void setNumberOfLumberCards(int numberOfLumberCards) {
		this.numberOfLumberCards = numberOfLumberCards;
	}

	public int getNumberOfGrainCards() {
		return numberOfGrainCards;
	}

	public void setNumberOfGrainCards(int numberOfGrainCards) {
		this.numberOfGrainCards = numberOfGrainCards;
	}

	public int getNumberOfOreCards() {
		return numberOfOreCards;
	}

	public void setNumberOfOreCards(int numberOfOreCards) {
		this.numberOfOreCards = numberOfOreCards;
	}

	public int getNumberOfBrickCards() {
		return numberOfBrickCards;
	}

	public void setNumberOfBrickCards(int numberOfBrickCards) {
		this.numberOfBrickCards = numberOfBrickCards;
	}

	public int getNumberOfWoolCards() {
		return numberOfWoolCards;
	}

	public void setNumberOfWoolCards(int numberOfWoolCards) {
		this.numberOfWoolCards = numberOfWoolCards;
	}

	public int getNumberOfDevelopmentCards() {
		return numberOfDevelopmentCards;
	}

	public void setNumberOfDevelopmentCards(int numberOfDevelopmentCards) {
		this.numberOfDevelopmentCards = numberOfDevelopmentCards;
	}
	
	public ResourceCard giveLumberCard() {
		
		ResourceCard lumberCard =  null;
		if (getNumberOfLumberCards() > 0) {
			lumberCard = lumberCards.get(0);
			setNumberOfLumberCards(getNumberOfLumberCards() - 1);
			lumberCards.remove(0);
		}
		return lumberCard;
	}
	
	public ResourceCard giveGrainCard() {
		
		ResourceCard grainCard =  null;
		if (getNumberOfGrainCards() > 0) {
			grainCard = grainCards.get(0);
			setNumberOfGrainCards(getNumberOfGrainCards() - 1);
			grainCards.remove(0);
		}
		return grainCard;
	}
	public ResourceCard giveOreCard() {
		
		ResourceCard oreCard =  null;
		if (getNumberOfOreCards() > 0) {
			oreCard = oreCards.get(0);
			setNumberOfOreCards(getNumberOfOreCards() - 1);
			oreCards.remove(0);
		}
		return oreCard;
	}
	public ResourceCard giveBrickCard() {
		
		ResourceCard brickCard =  null;
		if (getNumberOfBrickCards() > 0) {
			brickCard = brickCards.get(0);
			setNumberOfBrickCards(getNumberOfBrickCards() - 1);
			brickCards.remove(0);
		}
		return brickCard;
	}
	public ResourceCard giveWoolCard() {
		
		ResourceCard woolCard =  null;
		if (getNumberOfWoolCards() > 0) {
			woolCard = woolCards.get(0);
			setNumberOfWoolCards(getNumberOfWoolCards() - 1);
			woolCards.remove(0);
		}
		return woolCard;
	}
	
	public DevelopmentCard giveDevelopmentCard() {
		
		DevelopmentCard developmentCard =  null;
		if (getNumberOfDevelopmentCards() > 0) {
			developmentCard = developmentCards.get(0);
			setNumberOfDevelopmentCards(getNumberOfDevelopmentCards() - 1);
			developmentCards.remove(0);
		}
		return developmentCard;

	}
	
	public boolean takeCard(Card card) {
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
	}
	
	
	
	
	
	
	
	
	
	
}
