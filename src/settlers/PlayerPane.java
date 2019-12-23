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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class PlayerPane extends Pane {
	
	private SettlersButton closeButton, endTurnButton, settlementButton, roadButton, cityButton, tradeButton;
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
		
		endTurnButton = new SettlersButton("End Turn ", 300, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
		endTurnButton.setTranslateX(155);
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
		buttonsV.getChildren().addAll(buttons, endTurnButton);
		
		
		ImageView settlementView = new ImageView(new Image("settlement_view.png"));
		settlementView.setFitWidth(65);
		settlementView.setFitHeight(65);
		Label settlementLabel = new Label("settlement");
		settlementLabel.setFont(new Font("Cambria", 20));
		settlementLabel.setTextFill(Color.WHITE);
		
		Circle settlementCircle = new Circle();
		settlementCircle.setRadius(20);
		settlementCircle.setLayoutX(25);
		settlementCircle.setLayoutY(47);
		settlementCircle.setOpacity(0.3);
		Text settlementText = new Text ("0");
		settlementText.setLayoutX(25);
		settlementText.setLayoutY(47);
		settlementText.setFont(new Font("Cambria", 20));
		settlementText.setFill(Color.WHITE);
		StackPane settlementStack = new StackPane();
		settlementStack.getChildren().addAll(settlementView, settlementCircle, settlementText);
		//settlementStack.setPrefSize(90, 135);
		settlementStack.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				settlementCircle.setOpacity(0.8);
			}
		});
		settlementStack.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				settlementCircle.setOpacity(0.3);
			}
		});
		settlement = new VBox();
		settlement.setSpacing(20);
		settlement.getChildren().addAll(settlementStack, settlementLabel);
		
		ImageView roadView = new ImageView(new Image("road_view.png"));
		roadView.setFitWidth(65);
		roadView.setFitHeight(65);
		Label roadLabel = new Label("road");
		roadLabel.setFont(new Font("Cambria", 20));
		roadLabel.setTextFill(Color.WHITE);
		
		Circle roadCircle = new Circle();
		roadCircle.setRadius(20);
		roadCircle.setLayoutX(25);
		roadCircle.setLayoutY(47);
		roadCircle.setOpacity(0.3);
		Text roadText = new Text ("0");
		roadText.setLayoutX(25);
		roadText.setLayoutY(47);
		roadText.setFont(new Font("Cambria", 20));
		roadText.setFill(Color.WHITE);
		StackPane roadStack = new StackPane();
		roadStack.getChildren().addAll(roadView, roadCircle, roadText);
		//roadStack.setPrefSize(90, 135);
		roadStack.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				roadCircle.setOpacity(0.8);
			}
		});
		roadStack.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				roadCircle.setOpacity(0.3);
			}
		});
		
		road = new VBox();
		road.setSpacing(20);
		road.getChildren().addAll(roadStack, roadLabel);
		
		ImageView cityView = new ImageView(new Image("city_view.jpg"));
		cityView.setFitWidth(65);
		cityView.setFitHeight(65);
		Label cityLabel = new Label("city");
		cityLabel.setFont(new Font("Cambria", 20));
		cityLabel.setTextFill(Color.WHITE);
		Circle cityCircle = new Circle();
		cityCircle.setRadius(20);
		cityCircle.setLayoutX(25);
		cityCircle.setLayoutY(47);
		cityCircle.setOpacity(0.3);
		Text cityText = new Text ("0");
		cityText.setLayoutX(25);
		cityText.setLayoutY(47);
		cityText.setFont(new Font("Cambria", 20));
		cityText.setFill(Color.WHITE);
		StackPane cityStack = new StackPane();
		cityStack.getChildren().addAll(cityView, cityCircle, cityText);
		//cityStack.setPrefSize(90, 135);
		cityStack.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				cityCircle.setOpacity(0.8);
			}
		});
		cityStack.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				cityCircle.setOpacity(0.3);
			}
		});
		city = new VBox();
		city.setSpacing(20);
		city.getChildren().addAll(cityStack, cityLabel);
		
		
		
		
		placables = new HBox();
		placables.setSpacing(30);
		placables.setTranslateY(20);
		placables.getChildren().addAll(settlement, road, city);
		
		if (Program.MODE == "pirates") {
			ImageView pirateView = new ImageView(new Image("pirate_ship.png"));
			pirateView.setFitWidth(65);
			pirateView.setFitHeight(65);
			Label pirateLabel = new Label("pirate");
			pirateLabel.setFont(new Font("Cambria", 20));
			pirateLabel.setTextFill(Color.WHITE);
			Circle pirateCircle = new Circle();
			pirateCircle.setRadius(20);
			pirateCircle.setLayoutX(25);
			pirateCircle.setLayoutY(47);
			pirateCircle.setOpacity(0.3);
			Text pirateText = new Text ("0");
			pirateText.setLayoutX(25);
			pirateText.setLayoutY(47);
			pirateText.setFont(new Font("Cambria", 20));
			pirateText.setFill(Color.WHITE);
			StackPane pirateStack = new StackPane();
			pirateStack.getChildren().addAll(pirateView, pirateCircle, pirateText);
			//cityStack.setPrefSize(90, 135);
			pirateStack.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					pirateCircle.setOpacity(0.8);
				}
			});
			pirateStack.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					pirateCircle.setOpacity(0.3);
				}
			});
			VBox pirate = new VBox();
			pirate.setSpacing(20);
			pirate.getChildren().addAll(pirateStack, pirateLabel); 
			placables.getChildren().add(pirate);
		}
		
		HBox other = new HBox();
		other.setSpacing(30);
		other.getChildren().addAll(closeButton, placables);
		
		resourceCards = new HBox();
		resourceCards.setSpacing(23);
		//VBox newCard;
		ImageView cardImage;
		//Label cardNumber;
		
		for (int i = 0 ; i < 5 ; i++) {
			//newCard = new VBox();
			//cardNumber = new Label("0");
			if (i == 0) {
				cardImage = new ImageView(new Image("sheep_card.jpg"));
			} else if (i == 1) {
				cardImage = new ImageView(new Image("lumber_card.jpg"));
			} else if (i == 2) {
				cardImage = new ImageView(new Image("brick_card.jpg"));
			} else if (i == 3) {
				cardImage = new ImageView(new Image("wheat_card.jpg"));
			} else {
				cardImage = new ImageView(new Image("ore_card.jpg"));
			}
			cardImage.setFitWidth(90);
			cardImage.setFitHeight(135);
			Circle circle = new Circle();
			circle.setRadius(20);
			Text text = new Text("0");
			circle.setLayoutX(25);
			circle.setLayoutY(47);
			circle.setOpacity(0.3);
			
			text.setLayoutX(25);
			text.setLayoutY(47);
			text.setFont(new Font("Cambria", 20));
			text.setFill(Color.WHITE);
			StackPane stack = new StackPane();
			stack.setPrefSize(90, 135);
			stack.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					circle.setOpacity(0.8);
				}
			});
			stack.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					circle.setOpacity(0.3);
				}
			});
			stack.getChildren().addAll(cardImage, circle, text);
			
			//cardNumber.setTextFill(Color.WHITE);
			//cardNumber.setFont(new Font("Cambria", 20));
			
			//newCard.getChildren().addAll(cardImage, stack);
			resourceCards.getChildren().add(stack);
		}

		developmentCards = new HBox();
		developmentCards.setSpacing(23);
		//VBox newCard2;
		ImageView cardImage2;
		//Label cardNumber2;
		for (int i = 0 ; i < 5 ; i++) {
			//newCard2 = new VBox();
			//cardNumber2 = new Label("0");
			if (i == 0) {
				cardImage2 = new ImageView(new Image("dev1.jpg"));
			} else if (i == 1) {
				cardImage2 = new ImageView(new Image("dev2.jpg"));
			} else if (i == 2) {
				cardImage2 = new ImageView(new Image("dev3.jpg"));
			} else if (i == 3) {
				cardImage2 = new ImageView(new Image("dev4.jpg"));
			} else {
				cardImage2 = new ImageView(new Image("dev5.jpg"));
			}
			cardImage2.setFitWidth(90);
			cardImage2.setFitHeight(135);
			Circle circle = new Circle();
			circle.setRadius(20);
			Text text = new Text("0");
			circle.setLayoutX(25);
			circle.setLayoutY(47);
			circle.setOpacity(0.3);
			
			text.setLayoutX(25);
			text.setLayoutY(47);
			text.setFont(new Font("Cambria", 20));
			text.setFill(Color.WHITE);
			StackPane stack = new StackPane();
			stack.setPrefSize(90, 135);
			stack.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					circle.setOpacity(0.8);
				}
			});
			stack.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					circle.setOpacity(0.3);
				}
			});
			stack.getChildren().addAll(cardImage2, circle, text);
			developmentCards.getChildren().add(stack);
		}
		
		
		
		cardsOnTable = new HBox();
		cardsOnTable.setSpacing(23);
		/*VBox newCard3;
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
		}*/
		
		cards = new VBox();
		cards.setSpacing(50);
		cards.getChildren().addAll(resourceCards, developmentCards );
		
		ImageView cardBack = new ImageView(new Image("back_view.png"));
		//Label totalNumber = new Label("");
		Label totalLabel = new Label("Total Number of Cards of ");
		totalLabel.setTextFill(Color.WHITE);
		totalLabel.setFont(new Font("Cambria", 20));
		cardBack.setFitWidth(90);
		cardBack.setFitHeight(135);
		Circle totalCircle = new Circle();
		totalCircle.setRadius(20);
		Text totalText = new Text("0");
		totalCircle.setLayoutX(25);
		totalCircle.setLayoutY(47);
		totalCircle.setOpacity(0.3);
		
		totalText.setLayoutX(25);
		totalText.setLayoutY(47);
		totalText.setFont(new Font("Cambria", 20));
		totalText.setFill(Color.WHITE);
		StackPane totalStack = new StackPane();
		totalStack.setPrefSize(90, 135);
		totalStack.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				totalCircle.setOpacity(0.8);
			}
		});
		totalStack.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				totalCircle.setOpacity(0.3);
			}
		});
		totalStack.getChildren().addAll(cardBack, totalCircle, totalText);
		totalStack.setTranslateX(20);
		
		totalCards = new VBox();
		totalCards.getChildren().addAll(totalLabel, totalStack);
		totalCards.setSpacing(10);
		totalCards.setTranslateX(150);
		totalCards.setTranslateY(20);
		
		Pane changables = new Pane();
		changables.setStyle("-fx-background-color: rgba(0,0,0,0);");
		changables.getChildren().addAll(cards, totalCards);
		changables.setTranslateX(50);
		
		tradeButton = new SettlersButton("Trade with ", 300, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
		tradeButton.setTranslateX(170);
		tradeButton.setPrefSize(300, 30);
		
		Pane changableButtons = new Pane();
		changableButtons.setStyle("-fx-background-color: rgba(0,0,0,0);");
		changableButtons.getChildren().addAll(buttonsV, tradeButton);
		
		all = new VBox();
		all.setSpacing(50);
		all.getChildren().addAll(other, changables,  cardsOnTable, changableButtons);
		
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
		tradeButton.setVisible(!flag);
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
		//boolean found = false;
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
