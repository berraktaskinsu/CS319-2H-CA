package settlers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import java.util.*;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NewGameView extends View{
	
	//private NewGameController newGameController;
	
	Image background;
	ImageView mv;
	//Group root;
	HBox everything,addButtons;
	BackButton backButton;
	Pane pane;
	VBox paneComponents, playerEntries;
	SettlersButton StartGame, AddBot, AddPlayer, RollDice;
	private PlayerProperty[] players;
	private int numberOfPlayers;
	

	public NewGameView(NewGameController newGameController) {
		
		super(newGameController);
		//this.newGameController = newGameController;
		numberOfPlayers = 0;
		
		backButton = new BackButton();
		backButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				newGameController.goToMainMenu();
			}
			
		});
		
		AddPlayer = new SettlersButton("Add Player", 200, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
		AddPlayer.setTextFill(Color.WHITE);
		AddPlayer.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				numberOfPlayers++;
				
				TextField nameField = new TextField();
				nameField.setPrefSize(200, 60);
				nameField.setStyle("-fx-background-color: rgba(94, 48, 38, 0.5); -fx-text-inner-color: white;");
				nameField.setFont(Font.font("Cambria",30));
				nameField.setPromptText("Player " + numberOfPlayers);
				ColorPicker colorPicker = new ColorPicker();
				colorPicker.setStyle("-fx-color-label-visible: false ; -fx-color-rect-width: 60px; -fx-color-rect-height: 60px;");
				colorPicker.setPrefSize(46, 60);
				SettlersButton deleteButton = new SettlersButton("x", 60, "-fx-background-color: rgba(104, 13, 13, 0);", "-fx-background-color: rgba(104, 13, 13, 1);");
				deleteButton.setTextFill(Color.WHITE);
				
				ImageView playerIcon = new ImageView(new Image("user1.png"));
				playerIcon.setId("user1.png");
				playerIcon.setFitWidth(60);
				playerIcon.setFitHeight(60);
				playerIcon.setOnMouseClicked( new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						TilePane iconChooser = new TilePane();
						iconChooser.getStyleClass().add("icon-chooser");
						iconChooser.setOnMouseExited(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								getChildren().remove(iconChooser);
								everything.setDisable(false);
							}
						});					
						for (int i = 0 ; i < 17 ; i++) {
							ImageView temp = new ImageView(new Image("user" + (i + 1) + ".png"));
							temp.setId("user" + (i + 1) + ".png");
							temp.setFitWidth(60);
							temp.setFitHeight(60);
							temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent event) {
									playerIcon.setImage(temp.getImage());
									playerIcon.setId(temp.getId());
									iconChooser.setVisible(false);
									//root.getChildren().remove(iconChooser);
									everything.setDisable(false);
								}
							});
							iconChooser.getChildren().add(temp);
						}
						
						iconChooser.setPrefColumns(5);
						iconChooser.setStyle("-fx-background-color: rgba(104, 13, 13, 0.55);");
						Bounds boundsInScene = playerIcon.localToScene(playerIcon.getBoundsInLocal());
						iconChooser.setTranslateX(boundsInScene.getMinX());
						iconChooser.setTranslateY(boundsInScene.getMaxY() + 20);
						getChildren().add(iconChooser);
						everything.setDisable(true);
					}
				});
				
				HBox playerEntry = new HBox();
				playerEntry.getChildren().addAll(playerIcon,nameField, colorPicker, deleteButton);
				playerEntry.setId("" + numberOfPlayers);
				playerEntry.setSpacing(10);
				playerEntries.getChildren().add(playerEntry);
				
				if (numberOfPlayers >= 3) {
					StartGame.setVisible(true);
					if (numberOfPlayers == 4) {
						AddPlayer.setVisible(false);
						AddBot.setVisible(false);
					}
				}
			
				deleteButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						playerEntries.getChildren().remove(playerEntry);
						numberOfPlayers--;
						if (numberOfPlayers < 3) {
							StartGame.setVisible(false);
						}
						if (numberOfPlayers == 3) {
							AddPlayer.setVisible(true);
							AddBot.setVisible(true);
						}
					}
				});
			}
		});
		
		AddBot = new SettlersButton("Add Bot", 200, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
		AddBot.setTextFill(Color.WHITE);
		AddBot.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				numberOfPlayers++;
				
				TextField nameField = new TextField();
				nameField.setPrefSize(200, 50);
				nameField.setStyle("-fx-background-color: rgba(94, 48, 38, 0.5); -fx-text-inner-color: white;");
				nameField.setFont(Font.font("Cambria",30));
				nameField.setPromptText("Player " + numberOfPlayers + " (Bot)");
				ColorPicker colorPicker = new ColorPicker();
				colorPicker.setStyle("-fx-color-label-visible: false ; -fx-color-rect-width: 60px; -fx-color-rect-height: 60px;");
				colorPicker.setPrefSize(46, 60);
				SettlersButton deleteButton = new SettlersButton("x", 60, "-fx-background-color: rgba(104, 13, 13, 0);", "-fx-background-color: rgba(104, 13, 13, 1);");
				deleteButton.setTextFill(Color.WHITE);
				ImageView botIcon = new ImageView(new Image("bot_icon.png"));
				botIcon.setId("bot_icon.png");
				botIcon.setFitWidth(60);
				botIcon.setFitHeight(60);
		
				HBox playerEntry = new HBox();
				playerEntry.getChildren().addAll(botIcon, nameField, colorPicker, deleteButton);
				playerEntry.setId("" + numberOfPlayers);
				playerEntry.setSpacing(10);
				playerEntries.getChildren().add(playerEntry);
				
				if (numberOfPlayers >= 3) {
					StartGame.setVisible(true);
					if (numberOfPlayers == 4) {
						AddPlayer.setVisible(false);
						AddBot.setVisible(false);
					}
				}
				deleteButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						playerEntries.getChildren().remove(playerEntry);
						numberOfPlayers--;
						if (numberOfPlayers < 3) {
							StartGame.setVisible(false);
						}
						if (numberOfPlayers == 3) {
							AddPlayer.setVisible(true);
							AddBot.setVisible(true);
						}
					}
				});
			}
		});
		
		StartGame = new SettlersButton(60, 0, "Roll Dice", 300, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
		StartGame.setVisible(false);
		StartGame.setTextFill(Color.WHITE);
		StartGame.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				players = new PlayerProperty[numberOfPlayers];
				for (int i = 0 ; i < numberOfPlayers ; i++) {
					Color color = ((ColorPicker) ((HBox) playerEntries.getChildren().get(i)).getChildren().get(2)).getValue();
					String name = ((TextField) ((HBox) playerEntries.getChildren().get(i)).getChildren().get(1)).getText();
					ImageView icon = ((ImageView) ((HBox) playerEntries.getChildren().get(i)).getChildren().get(0));
					players[i] = new PlayerProperty(color, name, icon);
					
				}
				backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						goToNewGame();
					}
				});
				Label prompt = new Label(players[0].getName() + " rolls a dice!");
				prompt.setFont(Font.font("Cambria",FontWeight.BOLD, FontPosture.REGULAR, 30));
				prompt.setTextFill(Color.WHITE);
				ImageView die1View = new ImageView("die3.png");
				ImageView die2View = new ImageView("die4.png");
				VBox playerTurns = new VBox();
				playerTurns.setPrefSize(400, 300);
				playerTurns.setSpacing(20);
				SettlersButton continueButton = new SettlersButton(50, 0, "Continue", 300, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");

				continueButton.setVisible(false);
				
				SettlersButton rollDice = new SettlersButton(80, 0, "Roll Dice", 180, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
				rollDice.setTextFill(Color.WHITE);	
				
				rollDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						rollDice.setVisible(false);
						DiceController dice = new DiceController();
						dice.rollDice();
						int diceValue = dice.getSum();
						prompt.setText(players[0].getName() + " rolled " + diceValue + "!");
						die1View.setImage(dice.getDie1View().getImage());
						die2View.setImage(dice.getDie2View().getImage());
						updatePlayerTurns(players[0], diceValue, playerTurns);
						// Somehow wait for 2 seconds.
					    Duration startDuration = Duration.ZERO;
					    Duration endDuration = Duration.seconds(1);
						KeyValue startKeyValue = new KeyValue(prompt.textProperty(), players[0].getName() + " rolled " + diceValue + "!");
				        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
				        KeyValue endKeyValue = new KeyValue(prompt.textProperty(), players[1].getName() + " rolls the dice!");
				        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
				        Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);       
				        // Let the animation run forever
				        timeline.setCycleCount(1);
				        // Run the animation
				        timeline.play();
				        startKeyValue = new KeyValue(rollDice.visibleProperty(), false);
				        startKeyFrame = new KeyFrame(startDuration, startKeyValue);
				        endKeyValue = new KeyValue(rollDice.visibleProperty(), true);
				        endKeyFrame = new KeyFrame(endDuration, endKeyValue);
				        timeline = new Timeline(startKeyFrame, endKeyFrame);       
				        // Let the animation run forever
				        timeline.setCycleCount(1);
				        // Run the animation
				        timeline.play();
						
						prompt.setText(players[1].getName() + " rolls the dice!");
						rollDice.setVisible(true);
						rollDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								//timeline.stop();
								dice.rollDice();
								int diceValue = dice.getSum();
								prompt.setText(players[1].getName() + " rolled " + diceValue + "!");
								die1View.setImage(dice.getDie1View().getImage());
								die2View.setImage(dice.getDie2View().getImage());
								updatePlayerTurns(players[1], diceValue, playerTurns);
								// Somehow wait for 2 seconds.
							    Duration startDuration = Duration.ZERO;
							    Duration endDuration = Duration.seconds(1);
								KeyValue startKeyValue = new KeyValue(prompt.textProperty(), players[1].getName() + " rolled " + diceValue + "!");
						        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
						        KeyValue endKeyValue = new KeyValue(prompt.textProperty(), players[2].getName() + " rolls the dice!");
						        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
						        Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);       
						        // Let the animation run forever
						        timeline.setCycleCount(1);
						        // Run the animation
						        timeline.play();
						        startKeyValue = new KeyValue(rollDice.visibleProperty(), false);
						        startKeyFrame = new KeyFrame(startDuration, startKeyValue);
						        endKeyValue = new KeyValue(rollDice.visibleProperty(), true);
						        endKeyFrame = new KeyFrame(endDuration, endKeyValue);
						        timeline = new Timeline(startKeyFrame, endKeyFrame);       
						        // Let the animation run forever
						        timeline.setCycleCount(1);
						        // Run the animation
						        timeline.play();
								
								prompt.setText(players[2].getName() + " rolls the dice!");
								rollDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
									@Override
									public void handle(MouseEvent event) {
										//timeline.stop();
										dice.rollDice();
										int diceValue = dice.getSum();
										prompt.setText(players[2].getName() + " rolled " + diceValue + "!");
										die1View.setImage(dice.getDie1View().getImage());
										die2View.setImage(dice.getDie2View().getImage());
										updatePlayerTurns(players[2], diceValue, playerTurns);
										
										// Somehow wait for 2 seconds.
										if (numberOfPlayers == 4) {
											Duration startDuration = Duration.ZERO;
										    Duration endDuration = Duration.seconds(1);
											KeyValue startKeyValue = new KeyValue(prompt.textProperty(), players[2].getName() + " rolled " + diceValue + "!");
									        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
									        KeyValue endKeyValue = new KeyValue(prompt.textProperty(), players[3].getName() + " rolls the dice!");
									        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
									        Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);       
									        // Let the animation run forever
									        timeline.setCycleCount(1);
									        // Run the animation
									        timeline.play();
									        startKeyValue = new KeyValue(rollDice.visibleProperty(), false);
									        startKeyFrame = new KeyFrame(startDuration, startKeyValue);
									        endKeyValue = new KeyValue(rollDice.visibleProperty(), true);
									        endKeyFrame = new KeyFrame(endDuration, endKeyValue);
									        timeline = new Timeline(startKeyFrame, endKeyFrame);       
									        // Let the animation run forever
									        timeline.setCycleCount(1);
									        // Run the animation
									        timeline.play();
									        prompt.setText(players[3].getName() + " rolls the dice!");
											rollDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
												@Override
												public void handle(MouseEvent event) {
													//timeline.stop();
													dice.rollDice();
													int diceValue = dice.getSum();
													prompt.setText(players[3].getName() + " rolled " + diceValue + "!");
													die1View.setImage(dice.getDie1View().getImage());
													die2View.setImage(dice.getDie2View().getImage());
													updatePlayerTurns(players[3], diceValue, playerTurns);
													
													//checkEqualRolls(playerTurns, rollDice, paneComponents);
													rollDice.setVisible(false);
													continueButton.setVisible(true);
												}
											});
										} else {
											//checkEqualRolls(playerTurns, rollDice, paneComponents);
											rollDice.setVisible(false);
											continueButton.setVisible(true);
										}
									}
								});
							}
						});
					}
				});
				
				
				
				HBox diceView = new HBox(die1View, die2View);
				diceView.setSpacing(10);
				diceView.setTranslateX(120);
				rollDice.setTranslateX(100);
				playerTurns.setTranslateX(20);
				prompt.setTranslateX(85);
				paneComponents = new VBox();
				paneComponents.getChildren().addAll(prompt, diceView, rollDice, playerTurns, continueButton);
				paneComponents.setSpacing(30);
				paneComponents.setTranslateY(-50);
				pane.getChildren().set(0, paneComponents);
				
				continueButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						for (int i = 0 ; i < numberOfPlayers ; i++) {
							Color color = ((ColorPicker) ((HBox) playerTurns.getChildren().get(i)).getChildren().get(2)).getValue();
							String name = ((Label) ((HBox) playerTurns.getChildren().get(i)).getChildren().get(1)).getText();
							ImageView icon = ((ImageView) ((HBox) playerTurns.getChildren().get(i)).getChildren().get(0));
							players[i] = new PlayerProperty(color, name, icon);
							
						}
						//((NewGameController) viewController).setGame();
						GameModel game = new GameModel(players);
						goToGame(game);
						//GameModel gameModel = new GameModel(players);
						//GameView gameView = new GameView(gameModel);
					}
				});
				
			}
		});
		
		addButtons = new HBox();
		addButtons.getChildren().addAll(AddPlayer, AddBot);
		addButtons.setSpacing(20);
		
		playerEntries = new VBox();
		playerEntries.setSpacing(20);
		playerEntries.setTranslateX(50);
		playerEntries.setPrefSize(400, 400);
		
		paneComponents = new VBox();
		paneComponents.getChildren().addAll(playerEntries, addButtons, StartGame);
		paneComponents.setSpacing(20);
		
		pane = new Pane();
		pane.getChildren().add(paneComponents);
		pane.setStyle("-fx-background-color: rgba(225, 225, 225, 0);");
		pane.setPrefSize(500, 500);
		pane.setTranslateY(200);
		pane.setTranslateX(400);
		
		everything = new HBox();
		everything.getChildren().addAll(backButton, pane);
		
		background = new Image("img4.jpg");
		mv = new ImageView(background);
		mv.setFitWidth(Program.WIDTH);
		mv.setFitHeight(Program.HEIGHT);
		
		getChildren().addAll(mv,everything);
		
	}
	
	private void updatePlayerTurns(PlayerProperty player, int diceValue, VBox playerTurns) {
		Label nameLabel = new Label(player.getName());
		nameLabel.setPrefSize(200, 60);
		nameLabel.setTextFill(Color.WHITE);
		nameLabel.setFont(Font.font("Cambria",30));
		ColorPicker colorPicker = new ColorPicker(player.getColor());
		colorPicker.setStyle("-fx-color-label-visible: false ; -fx-color-rect-width: 60px; -fx-color-rect-height: 60px;");
		colorPicker.setPrefSize(46, 60);
		ImageView playerIcon = player.getIcon();
		Label value = new Label("" + diceValue);
		value.setPrefSize(60, 60);
		value.setTextFill(Color.WHITE);
		value.setFont(Font.font("Cambria",30));
		
		//playerIcon.setFitWidth(40);
		//playerIcon.setFitHeight(40);
		playerIcon.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				TilePane iconChooser = new TilePane();
				iconChooser.getStyleClass().add("icon-chooser");
				iconChooser.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						getChildren().remove(iconChooser);
						everything.setDisable(false);
					}
				});					
				for (int i = 0 ; i < 17 ; i++) {
					ImageView temp = new ImageView(new Image("user" + (i + 1) + ".png"));
					temp.setId("user" + (i + 1) + ".png");
					temp.setFitWidth(60);
					temp.setFitHeight(60);
					temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							playerIcon.setImage(temp.getImage());
							iconChooser.setVisible(false);
							//root.getChildren().remove(iconChooser);
							everything.setDisable(false);
						}
					});
					iconChooser.getChildren().add(temp);
				}
				
				iconChooser.setPrefColumns(5);
				iconChooser.setStyle("-fx-background-color: rgba(104, 13, 13, 0.55);");
				Bounds boundsInScene = playerIcon.localToScene(playerIcon.getBoundsInLocal());
				iconChooser.setTranslateX(boundsInScene.getMinX());
				iconChooser.setTranslateY(boundsInScene.getMaxY() + 20);
				getChildren().add(iconChooser);
				everything.setDisable(true);
			}
		});
		
		HBox playerTurn = new HBox();
		playerTurn.getChildren().addAll(playerIcon, nameLabel, colorPicker, value);
		playerTurn.setId("" + numberOfPlayers);
		playerTurn.setSpacing(10);
		boolean found = false;
		for (int i = 0 ; i < playerTurns.getChildren().size() ; i++) {
			int other = Integer.parseInt(((Label) (((HBox) playerTurns.getChildren().get(i)).getChildren().get(3))).getText());
			if (other <= diceValue) {
				playerTurns.getChildren().add(i, playerTurn);
				found = true;
				break;
			}
		}
		if (!found) {
			playerTurns.getChildren().add(playerTurn);
		}
	}
	

	
	

}

/*
package settlers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import java.util.*;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NewGameView extends View{
	
	//private NewGameController newGameController;
	
	Image background;
	ImageView mv;
	//Group root;
	HBox everything,addButtons;
	BackButton backButton;
	Pane pane;
	VBox paneComponents, playerEntries;
	SettlersButton StartGame, AddBot, AddPlayer, RollDice;
	private PlayerProperty[] players;
	private int numberOfPlayers;
	

	public NewGameView(NewGameController newGameController) {
		
		super(newGameController);
		//this.newGameController = newGameController;
		numberOfPlayers = 0;
		
		backButton = new BackButton();
		backButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				newGameController.goToMainMenu();
			}
			
		});
		
		AddPlayer = new SettlersButton("Add Player", 200, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
		AddPlayer.setTextFill(Color.WHITE);
		AddPlayer.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				numberOfPlayers++;
				
				TextField nameField = new TextField();
				nameField.setPrefSize(200, 60);
				nameField.setStyle("-fx-background-color: rgba(94, 48, 38, 0.5); -fx-text-inner-color: white;");
				nameField.setFont(Font.font("Cambria",30));
				nameField.setPromptText("Player " + numberOfPlayers);
				ColorPicker colorPicker = new ColorPicker();
				colorPicker.setStyle("-fx-color-label-visible: false ; -fx-color-rect-width: 60px; -fx-color-rect-height: 60px;");
				colorPicker.setPrefSize(46, 60);
				SettlersButton deleteButton = new SettlersButton("x", 60, "-fx-background-color: rgba(104, 13, 13, 0);", "-fx-background-color: rgba(104, 13, 13, 1);");
				deleteButton.setTextFill(Color.WHITE);
				
				ImageView playerIcon = new ImageView(new Image("user1.png"));
				playerIcon.setId("user1.png");
				playerIcon.setFitWidth(60);
				playerIcon.setFitHeight(60);
				playerIcon.setOnMouseClicked( new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						TilePane iconChooser = new TilePane();
						iconChooser.getStyleClass().add("icon-chooser");
						iconChooser.setOnMouseExited(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								getChildren().remove(iconChooser);
								everything.setDisable(false);
							}
						});					
						for (int i = 0 ; i < 17 ; i++) {
							ImageView temp = new ImageView(new Image("user" + (i + 1) + ".png"));
							temp.setId("user" + (i + 1) + ".png");
							temp.setFitWidth(60);
							temp.setFitHeight(60);
							temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent event) {
									playerIcon.setImage(temp.getImage());
									playerIcon.setId(temp.getId());
									iconChooser.setVisible(false);
									//root.getChildren().remove(iconChooser);
									everything.setDisable(false);
								}
							});
							iconChooser.getChildren().add(temp);
						}
						
						iconChooser.setPrefColumns(5);
						iconChooser.setStyle("-fx-background-color: rgba(104, 13, 13, 0.55);");
						Bounds boundsInScene = playerIcon.localToScene(playerIcon.getBoundsInLocal());
						iconChooser.setTranslateX(boundsInScene.getMinX());
						iconChooser.setTranslateY(boundsInScene.getMaxY() + 20);
						getChildren().add(iconChooser);
						everything.setDisable(true);
					}
				});
				
				HBox playerEntry = new HBox();
				playerEntry.getChildren().addAll(playerIcon,nameField, colorPicker, deleteButton);
				playerEntry.setId("" + numberOfPlayers);
				playerEntry.setSpacing(10);
				playerEntries.getChildren().add(playerEntry);
				
				if (numberOfPlayers >= 3) {
					StartGame.setVisible(true);
					if (numberOfPlayers == 4) {
						AddPlayer.setVisible(false);
						AddBot.setVisible(false);
					}
				}
			
				deleteButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						playerEntries.getChildren().remove(playerEntry);
						numberOfPlayers--;
						if (numberOfPlayers < 3) {
							StartGame.setVisible(false);
						}
						if (numberOfPlayers == 3) {
							AddPlayer.setVisible(true);
							AddBot.setVisible(true);
						}
					}
				});
			}
		});
		
		AddBot = new SettlersButton("Add Bot", 200, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
		AddBot.setTextFill(Color.WHITE);
		AddBot.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				numberOfPlayers++;
				
				TextField nameField = new TextField();
				nameField.setPrefSize(200, 50);
				nameField.setStyle("-fx-background-color: rgba(94, 48, 38, 0.5); -fx-text-inner-color: white;");
				nameField.setFont(Font.font("Cambria",30));
				nameField.setPromptText("Player " + numberOfPlayers + " (Bot)");
				ColorPicker colorPicker = new ColorPicker();
				colorPicker.setStyle("-fx-color-label-visible: false ; -fx-color-rect-width: 60px; -fx-color-rect-height: 60px;");
				colorPicker.setPrefSize(46, 60);
				SettlersButton deleteButton = new SettlersButton("x", 60, "-fx-background-color: rgba(104, 13, 13, 0);", "-fx-background-color: rgba(104, 13, 13, 1);");
				deleteButton.setTextFill(Color.WHITE);
				ImageView botIcon = new ImageView(new Image("bot_icon.png"));
				botIcon.setId("bot_icon.png");
				botIcon.setFitWidth(60);
				botIcon.setFitHeight(60);
		
				HBox playerEntry = new HBox();
				playerEntry.getChildren().addAll(botIcon, nameField, colorPicker, deleteButton);
				playerEntry.setId("" + numberOfPlayers);
				playerEntry.setSpacing(10);
				playerEntries.getChildren().add(playerEntry);
				
				if (numberOfPlayers >= 3) {
					StartGame.setVisible(true);
					if (numberOfPlayers == 4) {
						AddPlayer.setVisible(false);
						AddBot.setVisible(false);
					}
				}
				deleteButton.setOnMouseClicked( new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						playerEntries.getChildren().remove(playerEntry);
						numberOfPlayers--;
						if (numberOfPlayers < 3) {
							StartGame.setVisible(false);
						}
						if (numberOfPlayers == 3) {
							AddPlayer.setVisible(true);
							AddBot.setVisible(true);
						}
					}
				});
			}
		});
		
		StartGame = new SettlersButton(60, 0, "Roll Dice", 300, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
		StartGame.setVisible(false);
		StartGame.setTextFill(Color.WHITE);
		StartGame.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				players = new PlayerProperty[numberOfPlayers];
				for (int i = 0 ; i < numberOfPlayers ; i++) {
					Color color = ((ColorPicker) ((HBox) playerEntries.getChildren().get(i)).getChildren().get(2)).getValue();
					String name = ((TextField) ((HBox) playerEntries.getChildren().get(i)).getChildren().get(1)).getText();
					ImageView icon = ((ImageView) ((HBox) playerEntries.getChildren().get(i)).getChildren().get(0));
					players[i] = new PlayerProperty(color, name, icon);
					
				}
				backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						goToNewGame();
					}
				});
				Label prompt = new Label(players[0].getName() + " rolls a dice!");
				prompt.setFont(Font.font("Cambria",FontWeight.BOLD, FontPosture.REGULAR, 30));
				prompt.setTextFill(Color.WHITE);
				ImageView die1View = new ImageView("die3.png");
				ImageView die2View = new ImageView("die4.png");
				VBox playerTurns = new VBox();
				playerTurns.setPrefSize(400, 300);
				playerTurns.setSpacing(20);
				SettlersButton continueButton = new SettlersButton(50, 0, "Continue", 300, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");

				continueButton.setVisible(false);
				
				SettlersButton rollDice = new SettlersButton(80, 0, "Roll Dice", 180, "-fx-background-color: rgba(139, 0, 0, 0.55);", "-fx-background-color: rgba(42, 62, 30, 0.55)");
				rollDice.setTextFill(Color.WHITE);	
				
				rollDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						rollDice.setVisible(false);
						DiceController dice = new DiceController();
						dice.rollDice();
						int diceValue = dice.getSum();
						prompt.setText(players[0].getName() + " rolled " + diceValue + "!");
						die1View.setImage(dice.getDie1View().getImage());
						die2View.setImage(dice.getDie2View().getImage());
						updatePlayerTurns(players[0], diceValue, playerTurns, false, 0);
						// Somehow wait for 2 seconds.
					    Duration startDuration = Duration.ZERO;
					    Duration endDuration = Duration.seconds(1);
						KeyValue startKeyValue = new KeyValue(prompt.textProperty(), players[0].getName() + " rolled " + diceValue + "!");
				        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
				        KeyValue endKeyValue = new KeyValue(prompt.textProperty(), players[1].getName() + " rolls the dice!");
				        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
				        Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);       
				        // Let the animation run forever
				        timeline.setCycleCount(1);
				        // Run the animation
				        timeline.play();
				        startKeyValue = new KeyValue(rollDice.visibleProperty(), false);
				        startKeyFrame = new KeyFrame(startDuration, startKeyValue);
				        endKeyValue = new KeyValue(rollDice.visibleProperty(), true);
				        endKeyFrame = new KeyFrame(endDuration, endKeyValue);
				        timeline = new Timeline(startKeyFrame, endKeyFrame);       
				        // Let the animation run forever
				        timeline.setCycleCount(1);
				        // Run the animation
				        timeline.play();
						
						prompt.setText(players[1].getName() + " rolls the dice!");
						rollDice.setVisible(true);
						rollDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								//timeline.stop();
								dice.rollDice();
								int diceValue = dice.getSum();
								prompt.setText(players[1].getName() + " rolled " + diceValue + "!");
								die1View.setImage(dice.getDie1View().getImage());
								die2View.setImage(dice.getDie2View().getImage());
								updatePlayerTurns(players[1], diceValue, playerTurns,false, 0);
								// Somehow wait for 2 seconds.
							    Duration startDuration = Duration.ZERO;
							    Duration endDuration = Duration.seconds(1);
								KeyValue startKeyValue = new KeyValue(prompt.textProperty(), players[1].getName() + " rolled " + diceValue + "!");
						        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
						        KeyValue endKeyValue = new KeyValue(prompt.textProperty(), players[2].getName() + " rolls the dice!");
						        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
						        Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);       
						        // Let the animation run forever
						        timeline.setCycleCount(1);
						        // Run the animation
						        timeline.play();
						        startKeyValue = new KeyValue(rollDice.visibleProperty(), false);
						        startKeyFrame = new KeyFrame(startDuration, startKeyValue);
						        endKeyValue = new KeyValue(rollDice.visibleProperty(), true);
						        endKeyFrame = new KeyFrame(endDuration, endKeyValue);
						        timeline = new Timeline(startKeyFrame, endKeyFrame);       
						        // Let the animation run forever
						        timeline.setCycleCount(1);
						        // Run the animation
						        timeline.play();
								
								prompt.setText(players[2].getName() + " rolls the dice!");
								rollDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
									@Override
									public void handle(MouseEvent event) {
										//timeline.stop();
										dice.rollDice();
										int diceValue = dice.getSum();
										prompt.setText(players[2].getName() + " rolled " + diceValue + "!");
										die1View.setImage(dice.getDie1View().getImage());
										die2View.setImage(dice.getDie2View().getImage());
										updatePlayerTurns(players[2], diceValue, playerTurns, false, 0);
										
										// Somehow wait for 2 seconds.
										if (numberOfPlayers == 4) {
											Duration startDuration = Duration.ZERO;
										    Duration endDuration = Duration.seconds(1);
											KeyValue startKeyValue = new KeyValue(prompt.textProperty(), players[2].getName() + " rolled " + diceValue + "!");
									        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
									        KeyValue endKeyValue = new KeyValue(prompt.textProperty(), players[3].getName() + " rolls the dice!");
									        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
									        Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);       
									        // Let the animation run forever
									        timeline.setCycleCount(1);
									        // Run the animation
									        timeline.play();
									        startKeyValue = new KeyValue(rollDice.visibleProperty(), false);
									        startKeyFrame = new KeyFrame(startDuration, startKeyValue);
									        endKeyValue = new KeyValue(rollDice.visibleProperty(), true);
									        endKeyFrame = new KeyFrame(endDuration, endKeyValue);
									        timeline = new Timeline(startKeyFrame, endKeyFrame);       
									        // Let the animation run forever
									        timeline.setCycleCount(1);
									        // Run the animation
									        timeline.play();
									        prompt.setText(players[3].getName() + " rolls the dice!");
											rollDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
												@Override
												public void handle(MouseEvent event) {
													//timeline.stop();
													dice.rollDice();
													int diceValue = dice.getSum();
													prompt.setText(players[3].getName() + " rolled " + diceValue + "!");
													die1View.setImage(dice.getDie1View().getImage());
													die2View.setImage(dice.getDie2View().getImage());
													updatePlayerTurns(players[3], diceValue, playerTurns, false, 0);
													
													checkEqualRolls(playerTurns, rollDice, paneComponents, prompt, die1View, die2View);
													//rollDice.setVisible(false);
													//continueButton.setVisible(true);
												}
											});
										} else {
											checkEqualRolls(playerTurns, rollDice, paneComponents, prompt, die1View, die2View);
											//rollDice.setVisible(false);
											//continueButton.setVisible(true);
										}
									}
								});
							}
						});
					}
				});
				
				
				
				HBox diceView = new HBox(die1View, die2View);
				diceView.setSpacing(10);
				diceView.setTranslateX(120);
				rollDice.setTranslateX(100);
				playerTurns.setTranslateX(20);
				prompt.setTranslateX(85);
				paneComponents = new VBox();
				paneComponents.getChildren().addAll(prompt, diceView, rollDice, playerTurns, continueButton);
				paneComponents.setSpacing(30);
				paneComponents.setTranslateY(-50);
				pane.getChildren().set(0, paneComponents);
				
				continueButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						for (int i = 0 ; i < numberOfPlayers ; i++) {
							Color color = ((ColorPicker) ((HBox) playerTurns.getChildren().get(i)).getChildren().get(2)).getValue();
							String name = ((Label) ((HBox) playerTurns.getChildren().get(i)).getChildren().get(1)).getText();
							ImageView icon = ((ImageView) ((HBox) playerTurns.getChildren().get(i)).getChildren().get(0));
							players[i] = new PlayerProperty(color, name, icon);
							
						}
						GameModel game = new GameModel(players);
						goToGame(game);
						//GameModel gameModel = new GameModel(players);
						//GameView gameView = new GameView(gameModel);
					}
				});
				
			}
		});
		
		addButtons = new HBox();
		addButtons.getChildren().addAll(AddPlayer, AddBot);
		addButtons.setSpacing(20);
		
		playerEntries = new VBox();
		playerEntries.setSpacing(20);
		playerEntries.setTranslateX(50);
		playerEntries.setPrefSize(400, 400);
		
		paneComponents = new VBox();
		paneComponents.getChildren().addAll(playerEntries, addButtons, StartGame);
		paneComponents.setSpacing(20);
		
		pane = new Pane();
		pane.getChildren().add(paneComponents);
		pane.setStyle("-fx-background-color: rgba(225, 225, 225, 0);");
		pane.setPrefSize(500, 500);
		pane.setTranslateY(200);
		pane.setTranslateX(400);
		
		everything = new HBox();
		everything.getChildren().addAll(backButton, pane);
		
		background = new Image("img4.jpg");
		mv = new ImageView(background);
		mv.setFitWidth(Program.WIDTH);
		mv.setFitHeight(Program.HEIGHT);
		
		getChildren().addAll(mv,everything);
		
	}
	
	private void updatePlayerTurns(PlayerProperty player, int diceValue, VBox playerTurns, boolean flag, int indexOfPl) {
		Label nameLabel = new Label(player.getName());
		nameLabel.setPrefSize(200, 60);
		nameLabel.setTextFill(Color.WHITE);
		nameLabel.setFont(Font.font("Cambria",30));
		ColorPicker colorPicker = new ColorPicker(player.getColor());
		colorPicker.setStyle("-fx-color-label-visible: false ; -fx-color-rect-width: 60px; -fx-color-rect-height: 60px;");
		colorPicker.setPrefSize(46, 60);
		ImageView playerIcon = player.getIcon();
		Label value = new Label("" + diceValue);
		value.setPrefSize(60, 60);
		value.setTextFill(Color.WHITE);
		value.setFont(Font.font("Cambria",30));
		
		//playerIcon.setFitWidth(40);
		//playerIcon.setFitHeight(40);
		playerIcon.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				TilePane iconChooser = new TilePane();
				iconChooser.getStyleClass().add("icon-chooser");
				iconChooser.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						getChildren().remove(iconChooser);
						everything.setDisable(false);
					}
				});					
				for (int i = 0 ; i < 17 ; i++) {
					ImageView temp = new ImageView(new Image("user" + (i + 1) + ".png"));
					temp.setId("user" + (i + 1) + ".png");
					temp.setFitWidth(60);
					temp.setFitHeight(60);
					temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							playerIcon.setImage(temp.getImage());
							iconChooser.setVisible(false);
							//root.getChildren().remove(iconChooser);
							everything.setDisable(false);
						}
					});
					iconChooser.getChildren().add(temp);
				}
				
				iconChooser.setPrefColumns(5);
				iconChooser.setStyle("-fx-background-color: rgba(104, 13, 13, 0.55);");
				Bounds boundsInScene = playerIcon.localToScene(playerIcon.getBoundsInLocal());
				iconChooser.setTranslateX(boundsInScene.getMinX());
				iconChooser.setTranslateY(boundsInScene.getMaxY() + 20);
				getChildren().add(iconChooser);
				everything.setDisable(true);
			}
		});
		
		HBox playerTurn = new HBox();
		playerTurn.getChildren().addAll(playerIcon, nameLabel, colorPicker, value);
		playerTurn.setId("" + numberOfPlayers);
		playerTurn.setSpacing(10);
		boolean found = false;
		if ( flag == false) {
			for (int i = 0 ; i < playerTurns.getChildren().size() ; i++) {
				int other = Integer.parseInt(((Label) (((HBox) playerTurns.getChildren().get(i)).getChildren().get(3))).getText()); 
				if (other <= diceValue) {
					playerTurns.getChildren().add(i, playerTurn);
					found = true;
					break;
				}
			}
			if (!found) {
				playerTurns.getChildren().add(playerTurn);
			}
		}
		else {
			playerTurns.getChildren().remove(indexOfPl);
			playerTurns.getChildren().add(indexOfPl, playerTurn);
		}
		

	}
	
	private void checkEqualRolls(VBox playerTurns, SettlersButton rollDice, VBox paneComponents, Label prompt, ImageView die1View,ImageView die2View ) {
		ArrayList<Integer> turnsList=new ArrayList<Integer>();
		
		for (int i = 0 ; i < playerTurns.getChildren().size() ; i++) {
			int prev = Integer.parseInt(((Label) (((HBox) playerTurns.getChildren().get(i)).getChildren().get(3))).getText()); 
			//System.out.println("other1 is "  + prev);
			Integer prev1 = new Integer(prev);
			turnsList.add(prev1);
		}

		int dupIndex1 = 1;
		int dupIndex2 = 2;
		int dupIndex3 = -17;
		boolean allTheSame = false;

		if( allTheSame != true && dupIndex1 > 0) {
			if(dupIndex3 > 0) {
				prompt.setText(players[dupIndex1].getName() + " and " + players[dupIndex2].getName() + " and " + players[dupIndex3].getName() +" must roll again!");
			}
			else {
				prompt.setText(players[dupIndex1].getName() + " and " + players[dupIndex2].getName() + " must roll again!");
			}
			
			rollDice.setVisible(true);
			rollDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					rollDice.setVisible(false);
					DiceController dice = new DiceController();
					dice.rollDice();
					int diceValue1 = dice.getSum();
					prompt.setText(players[dupIndex1].getName() + " rolled " + diceValue1 + "!");
					die1View.setImage(dice.getDie1View().getImage());
					die2View.setImage(dice.getDie2View().getImage());
					//updatePlayerTurns(players[dupIndex1], diceValue, playerTurns); //send the indexes here i guess?
					// Somehow wait for 2 seconds.
				    Duration startDuration = Duration.ZERO;
				    Duration endDuration = Duration.seconds(1);
					KeyValue startKeyValue = new KeyValue(prompt.textProperty(), players[dupIndex1].getName() + " rolled " + diceValue1 + "!");
			        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
			        KeyValue endKeyValue = new KeyValue(prompt.textProperty(), players[dupIndex2].getName() + " rolls the dice!");
			        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
			        Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);       
			        // Let the animation run forever
			        timeline.setCycleCount(1);
			        // Run the animation
			        timeline.play();
			        startKeyValue = new KeyValue(rollDice.visibleProperty(), false);
			        startKeyFrame = new KeyFrame(startDuration, startKeyValue);
			        endKeyValue = new KeyValue(rollDice.visibleProperty(), true);
			        endKeyFrame = new KeyFrame(endDuration, endKeyValue);
			        timeline = new Timeline(startKeyFrame, endKeyFrame);       
			        // Let the animation run forever
			        timeline.setCycleCount(1);
			        // Run the animation
			        timeline.play();
					
					prompt.setText(players[dupIndex2].getName() + " rolls the dice!");
					
					rollDice.setVisible(true);
					rollDice.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							//timeline.stop();
							dice.rollDice();
							int diceValue2 = dice.getSum();
							prompt.setText(players[dupIndex2].getName() + " rolled " + diceValue2 + "!");
							die1View.setImage(dice.getDie1View().getImage());
							die2View.setImage(dice.getDie2View().getImage());
							
							updatePlayerTurns(players[dupIndex2], diceValue2, playerTurns, true, 2);
							
							checkEqualRolls(playerTurns, rollDice, paneComponents, prompt, die1View, die2View);
							}
						});
					}
					
				});
			}
		}

}
*/





