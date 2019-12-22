package settlers;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class PlayerPane extends Pane {
	
	private SettlersButton closeButton, endTurnButton, settlementButton, roadButton, cityButton;
	private int playerId;
	private VBox buttonsV;
	private VBox settlement, road, city;
	private HBox placables, resourceCards, developmentCards, cardsOnTable;
	private VBox totalCards;
	private VBox all, cards;
	public PlayerPane(int playerId) {
		
		setPlayerId(playerId);
		
		setStyle("-fx-background-color: rgba(58, 51, 49, 0.5);");
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		setPrefSize(primaryScreenBounds.getWidth()/2 + 10,primaryScreenBounds.getHeight());
		setTranslateX(0);
		setTranslateY(0);
		
		closeButton = new SettlersButton("Close", 120, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
		closeButton.setTranslateX(20);
		closeButton.setTranslateY(20);
		
		//closeButton.setPrefSize(120, 40);
		//closeButton.setMouseTransparent(false);
		
		
		endTurnButton = new SettlersButton("End Turn ", 300, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
		endTurnButton.setTranslateX(175);
		endTurnButton.setPrefSize(300, 30);
		settlementButton = new SettlersButton("Place Settlement", 220, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
		settlementButton.setPrefSize(220, 30);
		roadButton = new SettlersButton("Place Road", 180, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
		roadButton.setPrefSize(180, 30);
		cityButton = new SettlersButton("Place City", 180, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
		cityButton.setPrefSize(180, 30);
		HBox buttons = new HBox();
		buttons.setSpacing(30);
		buttons.setTranslateX(0);
		
		buttons.getChildren().addAll(settlementButton, roadButton, cityButton);
		
		buttonsV = new VBox();
		buttonsV.setSpacing(20);
		buttonsV.setTranslateX(20);
		//buttonsV.setTranslateY(700);
		buttonsV.getChildren().addAll(buttons, endTurnButton);
		//buttonsV.setVisible(false);
		
		
		ImageView settlementView = new ImageView(new Image("settlement_view.jpeg"));
		settlementView.setFitWidth(65);
		settlementView.setFitHeight(65);
		Label settlementLabel = new Label("settlement");
		settlementLabel.setFont(new Font("Cambria", 20));
		settlementLabel.setTextFill(Color.WHITE);
		Label settlementNumber = new Label("");
		settlement = new VBox();
		settlement.setSpacing(20);
		settlement.getChildren().addAll(settlementView, settlementLabel, settlementNumber);
		
		ImageView roadView = new ImageView(new Image("road_view.png"));
		roadView.setFitWidth(65);
		roadView.setFitHeight(65);
		Label roadLabel = new Label("road");
		roadLabel.setFont(new Font("Cambria", 20));
		roadLabel.setTextFill(Color.WHITE);
		Label roadNumber = new Label("");
		road = new VBox();
		road.setSpacing(20);
		road.getChildren().addAll(roadView, roadLabel, roadNumber);
		
		ImageView cityView = new ImageView(new Image("road_view.png"));
		cityView.setFitWidth(65);
		cityView.setFitHeight(65);
		Label cityLabel = new Label("city");
		cityLabel.setFont(new Font("Cambria", 20));
		cityLabel.setTextFill(Color.WHITE);
		Label cityNumber = new Label("");
		city = new VBox();
		city.setSpacing(20);
		city.getChildren().addAll(cityView, cityLabel, cityNumber);
		
		placables = new HBox();
		placables.setSpacing(60);
		placables.setTranslateX(100);
		placables.getChildren().addAll(settlement, road, city);
		
		placables.setTranslateY(20);
		
		HBox other = new HBox();
		other.getChildren().addAll(closeButton, placables);
		
		resourceCards = new HBox();
		resourceCards.setSpacing(23);
		VBox newCard;
		ImageView cardImage;
		Label cardType;
		Label cardNumber;
		for (int i = 0 ; i < 5 ; i++) {
			newCard = new VBox();
			cardType = new Label();
			cardNumber = new Label("0");
			if (i == 0) {
				cardImage = new ImageView(new Image("sheep_card.jpg"));
				cardType.setText("Wool");
				
			} else if (i == 1) {
				cardImage = new ImageView(new Image("lumber_card.jpg"));
				cardType.setText("Lumber");
			} else if (i == 2) {
				cardImage = new ImageView(new Image("brick_card.jpg"));
				cardType.setText("Brick");
			} else if (i == 3) {
				cardImage = new ImageView(new Image("wheat_card.jpg"));
				cardType.setText("Grain");
			} else {
				cardImage = new ImageView(new Image("ore_card.jpg"));
				cardType.setText("Ore");
			}
			cardType.setTextFill(Color.WHITE);
			cardNumber.setTextFill(Color.WHITE);
			cardType.setFont(new Font("Cambria", 20));
			cardNumber.setFont(new Font("Cambria", 20));
			cardImage.setFitWidth(90);
			cardImage.setFitHeight(135);
			newCard.getChildren().addAll(cardImage, cardType, cardNumber);
			resourceCards.getChildren().add(newCard);
		}

		developmentCards = new HBox();
		developmentCards.setSpacing(23);
		VBox newCard2;
		ImageView cardImage2;
		Label cardType2;
		Label cardNumber2;
		for (int i = 0 ; i < 5 ; i++) {
			newCard2 = new VBox();
			cardType2 = new Label();
			cardNumber2 = new Label("0");
			if (i == 0) {
				cardImage2 = new ImageView(new Image("dev1.jpg"));
				cardType2.setText("Knight");
			} else if (i == 1) {
				cardImage2 = new ImageView(new Image("dev2.jpg"));
				cardType2.setText("Victory\nPoint");
			} else if (i == 2) {
				cardImage2 = new ImageView(new Image("dev3.jpg"));
				cardType2.setText("Road\nBuilding");
			} else if (i == 3) {
				cardImage2 = new ImageView(new Image("dev4.jpg"));
				cardType2.setText("Year Of\nPlenty");
			} else {
				cardImage2 = new ImageView(new Image("dev5.jpg"));
				cardType2.setText("Monopoly");
			}
			cardType2.setTextFill(Color.WHITE);
			cardNumber2.setTextFill(Color.WHITE);
			cardType2.setFont(new Font("Cambria", 20));
			cardNumber2.setFont(new Font("Cambria", 20));
			cardImage2.setFitWidth(90);
			cardImage2.setFitHeight(135);
			newCard2.getChildren().addAll(cardImage2, cardType2, cardNumber2);
			developmentCards.getChildren().add(newCard2);
		}
		
		cardsOnTable = new HBox();
		cardsOnTable.setSpacing(23);
		VBox newCard3;
		ImageView cardImage3;
		Label cardType3;
		Label cardNumber3;
		for (int i = 0 ; i < 5 ; i++) {
			newCard3 = new VBox();
			cardType3 = new Label();
			cardNumber3 = new Label("0");
			if (i == 0) {
				cardImage3 = new ImageView(new Image("sheep_card.jpg"));
				cardType3.setText("Wool");
				
			} else if (i == 1) {
				cardImage3 = new ImageView(new Image("lumber_card.jpg"));
				cardType3.setText("Lumber");
			} else if (i == 2) {
				cardImage3 = new ImageView(new Image("brick_card.jpg"));
				cardType3.setText("Brick");
			} else if (i == 3) {
				cardImage3 = new ImageView(new Image("wheat_card.jpg"));
				cardType3.setText("Grain");
			} else {
				cardImage3 = new ImageView(new Image("ore_card.jpg"));
				cardType3.setText("Ore");
			}
			cardType3.setTextFill(Color.WHITE);
			cardNumber3.setTextFill(Color.WHITE);
			cardType3.setFont(new Font("Cambria", 20));
			cardNumber3.setFont(new Font("Cambria", 20));
			cardImage3.setFitWidth(90);
			cardImage3.setFitHeight(135);
			newCard3.getChildren().addAll(cardImage3, cardType3, cardNumber3);
			cardsOnTable.getChildren().add(newCard3);
		}
		
		cards = new VBox();
		cards.getChildren().addAll(resourceCards, developmentCards,cardsOnTable);
		
		ImageView cardBack = new ImageView(new Image("back_view.jpg"));
		cardBack.setFitWidth(115);
		cardBack.setFitHeight(145);
		Label totalNumber = new Label("");
		totalCards = new VBox();
		
		totalCards.getChildren().addAll(cardBack, totalNumber);
		
		Group changables = new Group();
		changables.getChildren().addAll(cards, totalCards);
		changables.setTranslateX(50);
		
		all = new VBox();
		all.setSpacing(50);
		all.getChildren().addAll(other, changables, buttonsV);
		
		
		setContentVisible(false);
		
		getChildren().addAll(all);
		setVisible(false);

	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	public SettlersButton getCloseButton() {
		return closeButton;
	}
	
	public SettlersButton getEndTurnButton() {
		return endTurnButton;
	}
	
	public SettlersButton getSettlementButton() {
		return settlementButton;
	}
	
	public SettlersButton getRoadButton() {
		return roadButton;
	}
	
	public SettlersButton getCityButton() {
		return cityButton;
	}
	
	public void setContentVisible(boolean flag) {
		buttonsV.setVisible(flag);
		totalCards.setVisible(!flag);
		cards.setVisible(flag);
		/*cityButton.setVisible(true);
		roadButton.setVisible(true);
		settlementButton.setVisible(true);
		endTurnButton.setVisible(true);*/
		//closeButton.setVisible(flag);
		
	}
	
	public void addResourceCard(String type) {
		int i;
		boolean found = false;
		for (i = 0 ; i < resourceCards.getChildren().size(); i++) {
			VBox cardi = (VBox) resourceCards.getChildren().get(i);
			Label labeli = (Label) cardi.getChildren().get(1);
			Label numberi = (Label) cardi.getChildren().get(2);
			if ( labeli.getText() == type ) {
				numberi.setText("" + (Integer.parseInt(numberi.getText()) + 1));
				break;
			}
		}/*
		if (!found) {
			VBox newCard = new VBox();
			Label newCardType = new Label(type);
			Label number = new Label("1");
			newCard.getChildren().addAll(resourceCard, newCardType, number);
			resourceCards.getChildren().add(newCard);
		}*/
		
	}
	
	
}
