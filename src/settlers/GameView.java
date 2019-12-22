package settlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.jfoenix.controls.JFXButton;

import java.util.Collection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GameView extends View{
	
	Image background;
	ImageView mv;
	BackButton backButton;
	Group all, everything;
	Pane board;
	HexButton[] hexes, water;
	PathButton[] paths;
	CornerButton[] corners;
	Group boardGroup, pathGroup, cornerGroup, hexGroup, waterGroup, tokenGroup, playerButtons;
	Pane playerPane;
	HBox shufflers;
	SettlersButton okButton, shuffleButton;

	public GameView(GameController gameController) {
		
		super(gameController);
		initialize();
		((GameController) viewController).setView(this);
		((GameController) viewController).loadView(this);
		
		
	}
	
	private void initialize() {
		
		backButton = new BackButton();
		backButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				((GameController) viewController).sendQuitAlert();
			}
		});
		
		shuffleButton = new SettlersButton("Shuffle Board", 300, "-fx-background-color: rgba(33, 33, 33, 0.70);", "-fx-background-color: rgba(33, 33, 33, 1)");
		shuffleButton.setTextFill(Color.WHITE);
		shuffleButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {	
				((GameController) viewController).shuffleBoard();
			}
		});
		
		okButton = new SettlersButton("OK", 100, "-fx-background-color: rgba(33, 33, 33, 0.70);", "-fx-background-color: rgba(33, 33, 33, 1)");
		okButton.setTextFill(Color.WHITE);
		okButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				((GameController) viewController).startGame();
				
			}	
		});
		
		shufflers = new HBox();
		shufflers.getChildren().addAll(shuffleButton, okButton);
		shufflers.setTranslateX(300);
		shufflers.setTranslateY(400);
		shufflers.setSpacing(20);
		
		initializeBoard(); // board
		boardGroup = new Group();
		boardGroup.getChildren().addAll(board, shufflers);
		boardGroup.setTranslateX(190);
		boardGroup.setTranslateY(60);
		
		initializePlayers(); // playerButtons
		everything = new Group();
		everything.getChildren().addAll(playerButtons, boardGroup);

		all = new Group();
		all.getChildren().addAll(backButton, everything);
		
		background = new Image("img6.jpg");
		mv = new ImageView(background);
		mv.setFitWidth(Program.WIDTH);
		mv.setFitHeight(Program.WIDTH);
		getChildren().addAll(mv, all);
		

	}
	private void initializeBoard() {
		
		board = new Pane();
		board.setPrefSize(1050,792);
		initializeWater();
		initializeHexes();
		initializePaths();
		initializeCorners();
		//board.getChildren().addAll(initializeWater(), initializeHexes(), initializePaths(), initializeCorners());
		board.getChildren().get(2).setVisible(false);
		board.getChildren().get(3).setVisible(false);
	}
	private void initializeWater() {
		
		waterGroup = new Group();
		water = new HexButton[18];
		
		for (int i = 0 ; i < water.length ; i++) {
			water[i] = new HexButton("Water Hex");
		}
		
		water[0].setTranslateX(225);
		water[0].setTranslateY(0);
		water[1].setTranslateX(375);
		water[1].setTranslateY(0);		
		water[2].setTranslateX(525);
		water[2].setTranslateY(0);
		water[3].setTranslateX(675);
		water[3].setTranslateY(0);
		water[4].setTranslateX(150);
		water[4].setTranslateY(107);
		water[5].setTranslateX(750);
		water[5].setTranslateY(107);
		water[6].setTranslateX(75);
		water[6].setTranslateY(214);
		water[7].setTranslateX(825);
		water[7].setTranslateY(214);
		
		water[8].setTranslateX(0);
		water[8].setTranslateY(321);
		water[9].setTranslateX(900);
		water[9].setTranslateY(321);
		
		water[10].setTranslateX(75);
		water[10].setTranslateY(428);
		water[11].setTranslateX(825);
		water[11].setTranslateY(428);
		water[12].setTranslateX(150);
		water[12].setTranslateY(535);
		water[13].setTranslateX(750);
		water[13].setTranslateY(535);
		water[14].setTranslateX(225);
		water[14].setTranslateY(642);
		water[15].setTranslateX(375);
		water[15].setTranslateY(642);
		water[16].setTranslateX(525);
		water[16].setTranslateY(642);
		water[17].setTranslateX(675);
		water[17].setTranslateY(642);
		
		for (int i = 0 ; i < water.length ; i++) {
			waterGroup.getChildren().add(water[i]);
		}
		board.getChildren().add(waterGroup);
	}
	private void initializeHexes() {
		
		hexGroup = new Group();
		hexes = new HexButton[19];
		for (int i = 0 ; i < 3 ; i++ ) {
			hexes[i] = new HexButton("Hills");
		}
		for (int i = 3 ; i < 6 ; i++ ) {
			hexes[i] = new HexButton("Mountains");
		}
		for (int i = 6 ; i < 10 ; i++ ) {
			hexes[i] = new HexButton("Forest");
		}
		for (int i = 10 ; i < 14 ; i++ ) {
			hexes[i] = new HexButton("Pasture");
		}
		for (int i = 14 ; i < 18 ; i++ ) {
			hexes[i] = new HexButton("Fields");
		}
		hexes[18] = new HexButton("Desert");
		//viewController.setView(this);
		//hexGroup = ((GameController) viewController).shuffleHexes();
		Random rgen = new Random();	
		for (int i = 0; i < hexes.length ; i++) {
		    int randomPosition = rgen.nextInt(hexes.length);
		    HexButton temp = hexes[i];
		    hexes[i] = hexes[randomPosition];
		    hexes[randomPosition] = temp;
		}
		for (int i = 0 ; i < hexes.length ; i++) {
			if (i < 3) {
				hexes[i].setTranslateX(150*(i + 2));
				hexes[i].setTranslateY(107);
			} else if (i < 7) {
				hexes[i].setTranslateX(75 + 150*(i - 2));
				hexes[i].setTranslateY(214);
			} else if (i < 12) {
				hexes[i].setTranslateX(150*(i - 6));
				hexes[i].setTranslateY(321);
			} else if (i < 16) {
				hexes[i].setTranslateX(75 + 150*(i - 11));
				hexes[i].setTranslateY(428);
			} else if (i < 19) {
				hexes[i].setTranslateX(150*(i-14));
				hexes[i].setTranslateY(535);
			}
		}
		HexButton[] temp = new HexButton[19];
		temp[0] = hexes[0];
		temp[1] = hexes[1];
		temp[2] = hexes[2];
		temp[3] = hexes[6];
		temp[4] = hexes[11];
		temp[5] = hexes[15];
		temp[6] = hexes[18];
		temp[7] = hexes[17];
		temp[8] = hexes[16];
		temp[9] = hexes[12];
		temp[10] = hexes[7];
		temp[11] = hexes[3];
		temp[12] = hexes[4];
		temp[13] = hexes[5];
		temp[14] = hexes[10];
		temp[15] = hexes[14];
		temp[16] = hexes[13];
		temp[17] = hexes[8];
		temp[18] = hexes[9];
		hexes = temp;
		initializeTokens();
		for (int i = 0 ; i < hexes.length ; i++) {
			hexes[i].setHexId(i+1);
			hexGroup.getChildren().add(i,hexes[i]);
		}
		board.getChildren().add(hexGroup);
		
	}
	private void initializeTokens() {
		
		int[] tokens = {5,2,6,3,8,10,9,12,11,4,8,10,9,4,5,6,3,11};
		for (int i = 0, j = 0 ; i < hexes.length ; i++) {
			if (hexes[i].getCurrentType() == "Desert") {
				hexes[i].setToken(7);
			} else {
				hexes[i].setToken(tokens[j]);
				j++;
			}
		}
	}
	private void initializeCorners() {	
		corners = new CornerButton[54];
		cornerGroup = new Group();
		
		for (int in = 0 ; in < corners.length ; in++) {
			final int i = in;
			corners[i] = new CornerButton(i+1);
			corners[i].setVisible(false);
			//corners[i].getStyleClass().add("corner-button");
			if (i < 3) {
				corners[i].setTranslateX(210 + 150 * (i + 1));
				corners[i].setTranslateY(90);
			} else if (i < 7) {
				corners[i].setTranslateX(135 + 150 * (i - 2));
				corners[i].setTranslateY(133);
			} else if (i < 11) {
				corners[i].setTranslateX(135 + 150 * (i - 6));
				corners[i].setTranslateY(197);
			} else if (i < 16) {
				corners[i].setTranslateX(60 + 150 * (i - 10));
				corners[i].setTranslateY(240);
			} else if (i < 21) {
				corners[i].setTranslateX(60 + 150 * (i - 15));
				corners[i].setTranslateY(304);
			} else if (i < 27) {
				corners[i].setTranslateX(-15 + 150 * (i - 20));
				corners[i].setTranslateY(347);
			} else if (i < 33) {
				corners[i].setTranslateX(-15 + 150 * (i - 26));
				corners[i].setTranslateY(411);
			} else if (i < 38) {
				corners[i].setTranslateX(60 + 150 * (i - 32));
				corners[i].setTranslateY(454);
			} else if (i < 43) {
				corners[i].setTranslateX(60 + 150 * (i - 37));
				corners[i].setTranslateY(518);
			} else if (i < 47) {
				corners[i].setTranslateX(135 + 150 * (i - 42));
				corners[i].setTranslateY(561);
			} else if (i < 51) {
				corners[i].setTranslateX(135 + 150 * (i - 46));
				corners[i].setTranslateY(625);
			} else if (i < 54) {
				corners[i].setTranslateX(210 + 150 * (i - 50));
				corners[i].setTranslateY(668);
			} 
			cornerGroup.getChildren().add(corners[i]);
		}
		board.getChildren().add(cornerGroup);
	}
	private void initializePaths() {

		paths = new PathButton[72];
		pathGroup = new Group();
		for (int in = 0 ; in < paths.length ; in++) {
			final int i = in;
			paths[i] = new PathButton(i+1);
			paths[i].setVisible(false);
			if (i < 3) {
				paths[i].setTranslateX(155 + 150*(i + 1));
				paths[i].setTranslateY(110);
			} else if (i < 7) {
				paths[i].setTranslateX(80 + 150 * (i - 2));
				paths[i].setTranslateY(217);
			} else if (i < 12) {
				paths[i].setTranslateX(5 + 150 * (i - 6));
				paths[i].setTranslateY(324);
			} else if (i < 17) {
				paths[i].setTranslateX(80 + 150 * (i - 11));
				paths[i].setTranslateY(431);
			} else if (i < 21) {
				paths[i].setTranslateX(155 + 150 * (i - 16));
				paths[i].setTranslateY(538);
			} else if (i < 24) {
				paths[i].setTranslateX(230 + 150 * (i - 20));
				paths[i].setTranslateY(645);
			} else if (i < 27) {
				paths[i].setTranslateX(230 + 150 * (i - 23));
				paths[i].setTranslateY(110);
			} else if (i < 31) {
				paths[i].setTranslateX(155 + 150 * (i - 26));
				paths[i].setTranslateY(217);
			} else if (i < 36) {
				paths[i].setTranslateX(80 + 150 * (i - 30));
				paths[i].setTranslateY(324);
			} else if (i < 41) {
				paths[i].setTranslateX(5 + 150 * (i - 35));
				paths[i].setTranslateY(431);
			} else if (i < 45) {
				paths[i].setTranslateX(80 + 150 * (i - 40));
				paths[i].setTranslateY(538);
			} else if (i < 48) {
				paths[i].setTranslateX(155 + 150 * (i - 44));
				paths[i].setTranslateY(645);
			} else if (i < 52) {
				paths[i].setTranslateX(120 + 150 * (i - 47));
				paths[i].setTranslateY(170);
			} else if (i < 57) {
				paths[i].setTranslateX(45 + 150 * (i - 51)) ;
				paths[i].setTranslateY(277);
			} else if (i < 63) {
				paths[i].setTranslateX(-30 + 150 * (i - 56));
				paths[i].setTranslateY(384);
			} else if (i < 68) {
				paths[i].setTranslateX(45 + 150 * (i - 62));
				paths[i].setTranslateY(491);
			} else if (i < 72) {
				paths[i].setTranslateX(120 + 150 * (i - 67));
				paths[i].setTranslateY(598);
			}
			
			
			pathGroup.getChildren().add(paths[i]);
			paths[i].setOnMouseClicked( new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					paths[i].setStyle("-fx-background-color: rgba(33, 33, 33, 1);");
					paths[i].setOnMouseExited( new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							
						}
					});
					paths[i].setOnMouseEntered( new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							
						}
					});
				}		
			});
		}
		board.getChildren().add(pathGroup);
	}
	private void initializePlayers() {
		
		//PlayerButton[] playerButtons = ((ModelAccesibleViewController) viewController).getPlayerButtons();
		
		Player[] players = ((ModelAccessibleViewController) viewController).getGame().getPlayers();
		
		Circle[] playerStatus = new Circle[players.length];
		for (int i = 0 ; i < playerStatus.length ; i++) {
			playerStatus[i] = new Circle();
			playerStatus[i].setVisible(false);
			playerStatus[i].setRadius(20);
			playerStatus[i].setFill(Color.RED);
		}
		
		
		if (players.length == 3) {
			PlayerButton player1Button = new PlayerButton(players[0].getIcon(), players[0].getName(), players[0].getColor());
			playerStatus[0].setCenterX(90);
			playerStatus[0].setCenterY(170);
			
			PlayerButton player2Button = new PlayerButton(players[1].getIcon(), players[1].getName(), players[1].getColor());
			playerStatus[1].setCenterX(1355);
			playerStatus[1].setCenterY(170);
			
			PlayerButton player3Button = new PlayerButton(players[2].getIcon(), players[2].getName(), players[2].getColor());
			playerStatus[2].setCenterX(1355);
			playerStatus[2].setCenterY(770);
			
			player1Button.setTranslateX(120);
			player1Button.setTranslateY(100);
			player2Button.setTranslateX(1175);
			player2Button.setTranslateY(100);
			player3Button.setTranslateX(1175);
			player3Button.setTranslateY(700);
			playerButtons = new Group();
			//playerButtons.getChildren().addAll(player1Button, player2Button, player3Button);
			playerButtons.getChildren().addAll(player1Button,playerStatus[0], player2Button, playerStatus[1], player3Button,playerStatus[2]);
			
		} else if (players.length == 4){
			
			PlayerButton player1Button = new PlayerButton(players[0].getIcon(), players[0].getName(), players[0].getColor());
			player1Button.setPlayerId(1);
			
			playerStatus[0].setCenterX(90);
			playerStatus[0].setCenterY(170);
		
	        player1Button.setOnMouseClicked( new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					
					Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
					//HBox cards = new HBox();
					//cards.add()
					backButton.setVisible(false);
					playerPane = new Pane();
					playerPane.setStyle("-fx-background-color: rgba(58, 51, 49, 0.5);");
					playerPane.setPrefSize(primaryScreenBounds.getWidth()/2 + 10,primaryScreenBounds.getHeight());
					playerPane.setTranslateX(0);
					playerPane.setTranslateY(0);
					
					SettlersButton closeButton = new SettlersButton("Close", 120, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
					closeButton.setTranslateX(20);
					closeButton.setTranslateY(20);
					closeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							backButton.setVisible(true);
							everything.setDisable(false);
							all.getChildren().remove(playerPane);
						}
					});
					playerPane.getChildren().add(closeButton);
					all.getChildren().add(playerPane);
					everything.setDisable(true);	
				}
				
			});
			
			PlayerButton player2Button = new PlayerButton(players[1].getIcon(), players[1].getName(), players[1].getColor());
			playerStatus[1].setCenterX(1355);
			playerStatus[1].setCenterY(170);
			
			PlayerButton player3Button = new PlayerButton(players[2].getIcon(), players[2].getName(), players[2].getColor());
			playerStatus[2].setCenterX(1355);
			playerStatus[2].setCenterY(770);
	
			PlayerButton player4Button = new PlayerButton(players[3].getIcon(), players[3].getName(), players[3].getColor());
			playerStatus[3].setCenterX(90);
			playerStatus[3].setCenterY(770);
		
			player1Button.setTranslateX(120);
			player1Button.setTranslateY(100);
			player2Button.setTranslateX(1175);
			player2Button.setTranslateY(100);
			player4Button.setTranslateX(120);
			player4Button.setTranslateY(700);
			player3Button.setTranslateX(1175);
			player3Button.setTranslateY(700);
			playerButtons = new Group();
			playerButtons.getChildren().addAll(player1Button,playerStatus[0], player2Button, playerStatus[1], player3Button,playerStatus[2], player4Button, playerStatus[3]);
			//everything.getChildren().addAll(playerStatus[0],playerStatus[1],playerStatus[2],playerStatus[3]);
		}
		
	}
}

