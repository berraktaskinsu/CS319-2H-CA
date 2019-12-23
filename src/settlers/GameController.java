package settlers;

import java.util.Optional;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.scene.control.Alert.AlertType;

public class GameController extends ModelAccessibleViewController {
	
	private Scene scene;
	private ImageView background;
	private Group all, everything, playerGroup, boardGroup, waterGroup, hexGroup, cornerGroup, pathGroup;
	private BackButton backButton; 
	private Pane board;
	private HBox shufflers;
	private HexButton[] hexButtons;
	private CornerButton[] cornerButtons;
	private PathButton[] pathButtons;
	private SettlersButton shuffleButton, okButton;
	private PlayerButton[] playerButtons;
	private Circle[] playerStatus;
	private Corner[] corners;
	private Path[] paths;
	private Hex[] hexes;
	private PlayerPane[] playerPanes;
	private SettlersButton[] closeButtons, settlementButtons, roadButtons, cityButtons, endTurnButtons;
	
	private Player[] players;
	private int playerInTurn;
	private int cycle;
	
	public GameController(ViewControllerController viewControllerController, GameModel game) {
		super(viewControllerController, game);
		setView(new GameView(this));
		loadModel();
	}
	
	public void sendQuitAlert() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Quit Game");
		alert.setHeaderText("You are about to quit the game and loose all progress.");
		alert.setContentText("Are you sure you want to continue?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			goToMainMenu();
		} 
	}
	
	public void loadView(GameView gameView) {
		setView(gameView);
		scene = view.getScene();
		background = (ImageView) view.getChildren().get(0); 
		all = (Group) view.getChildren().get(1);
		backButton = (BackButton) all.getChildren().get(0);
		everything = (Group) all.getChildren().get(1);
		playerGroup = (Group) everything.getChildren().get(0);
		playerButtons = new PlayerButton[game.getNumberOfPlayers()];
		playerStatus = new Circle[game.getNumberOfPlayers()];
		int j = 0;
		int k = 0;
		for (int i = 0 ; i < playerGroup.getChildren().size() ; i++) {
			if (i % 2 == 0) {
				playerButtons[j] = (PlayerButton) playerGroup.getChildren().get(i);
				j++;
			} else {
				playerStatus[k] = (Circle) playerGroup.getChildren().get(i);
				k++;
			}
		}
		boardGroup = (Group) everything.getChildren().get(1);
		board = (Pane) boardGroup.getChildren().get(0);
		shufflers = (HBox) boardGroup.getChildren().get(1);
		shuffleButton = (SettlersButton) shufflers.getChildren().get(0);
		okButton = (SettlersButton) shufflers.getChildren().get(1);
		waterGroup = (Group) board.getChildren().get(0);
		hexGroup = (Group) board.getChildren().get(1);
		pathGroup = (Group) board.getChildren().get(2);
		cornerGroup = (Group) board.getChildren().get(3);
		hexButtons = new HexButton[19];
		for (int i = 0 ; i < hexButtons.length ; i++) {
			hexButtons[i] = (HexButton) hexGroup.getChildren().get(i);
		}
		cornerButtons = new CornerButton[54];
		for (int i = 0 ; i < cornerButtons.length ; i++) {
			cornerButtons[i] = (CornerButton) cornerGroup.getChildren().get(i);
		}
		pathButtons = new PathButton[72];
		for (int i = 0 ; i < pathButtons.length ; i++) {
			pathButtons[i] = (PathButton) pathGroup.getChildren().get(i);
		}
	}
	
	public void loadModel() {
		players = game.getPlayers();
		playerInTurn = game.getPlayerInTurn();
	}
	
	public void startGame() {
		shuffleButton.setVisible(false);
		okButton.setVisible(false);
		board.getChildren().get(2).setVisible(true);
		board.getChildren().get(3).setVisible(true);
		createBoard();
		initializePlayers();
		for (int i = 0 ; i < game.getNumberOfPlayers() ; i++) {
			playerStatus[i].setVisible(true);
		}
		playerStatus[playerInTurn - 1].setFill(Color.GREEN);
	}
	
	public void shuffleBoard() {
		for (int i = 0 ; i < hexButtons.length ; i++) {
			hexGroup.getChildren().remove(hexButtons[i]);
		}
		Random rgen = new Random();	
		for (int i = 0; i < hexButtons.length ; i++) {
		    int randomPosition = rgen.nextInt(hexButtons.length);
		    HexButton temp = hexButtons[i];
		    hexButtons[i] = hexButtons[randomPosition];
		    hexButtons[randomPosition] = temp;
		}
		for (int i = 0 ; i < hexButtons.length ; i++) {
			if (i < 3) {
				hexButtons[i].setTranslateX(150*(i + 2));
				hexButtons[i].setTranslateY(107);
			} else if (i < 7) {
				hexButtons[i].setTranslateX(75 + 150*(i - 2));
				hexButtons[i].setTranslateY(214);
			} else if (i < 12) {
				hexButtons[i].setTranslateX(150*(i - 6));
				hexButtons[i].setTranslateY(321);
			} else if (i < 16) {
				hexButtons[i].setTranslateX(75 + 150*(i - 11));
				hexButtons[i].setTranslateY(428);
			} else if (i < 19) {
				hexButtons[i].setTranslateX(150*(i-14));
				hexButtons[i].setTranslateY(535);
			}
		}
		HexButton[] temp = new HexButton[19];
		temp[0] = hexButtons[0];
		temp[1] = hexButtons[1];
		temp[2] = hexButtons[2];
		temp[3] = hexButtons[11];
		temp[4] = hexButtons[12];
		temp[5] = hexButtons[13];
		temp[6] = hexButtons[3];
		temp[7] = hexButtons[10];
		temp[8] = hexButtons[17];
		temp[9] = hexButtons[18];
		temp[10] = hexButtons[14];
		temp[11] = hexButtons[4];
		temp[12] = hexButtons[9];
		temp[13] = hexButtons[16];
		temp[14] = hexButtons[15];
		temp[15] = hexButtons[5];
		temp[16] = hexButtons[8];
		temp[17] = hexButtons[7];
		temp[18] = hexButtons[6];
		hexButtons = temp;
		int[] tokens = {5,2,6,3,8,10,9,12,11,4,8,10,9,4,5,6,3,11};
		for (int i = 0, j = 0 ; i < hexButtons.length ; i++) {
			if (hexButtons[i].getCurrentType() == "Desert") {
				hexButtons[i].setToken(7);
			} else {
				hexButtons[i].setToken(tokens[j]);
				j++;
			}
		}
		for (int i = 0 ; i < hexButtons.length ; i++) {
			hexButtons[i].setHexId(i+1);
			hexGroup.getChildren().add(i,hexButtons[i]);
		}
		board.getChildren().set(1, hexGroup);
	}
	
	public void createBoard() {
		hexes = new Hex[hexButtons.length];
		for (int i = 0 ; i < hexButtons.length ; i++) {
			HexButton hexButton = hexButtons[i];
			String type = hexButton.getCurrentType();
			int token = hexButton.getToken();
			boolean occupiedByThief = false;
			if (token == 7) {
				occupiedByThief = true;
			}
			hexes[i] = new Hex(type, token, occupiedByThief);	
		}
		corners = new Corner[cornerButtons.length];
		for (int i = 0 ; i < cornerButtons.length ; i++) {
			corners[i] = new Corner(null, 0);
		}
		paths = new Path[pathButtons.length];
		for (int i = 0 ; i < pathButtons.length ; i++) {
			paths[i] = new Path(null, false);
		}
		
		hexes[0].setCorners(new int[] {3, 0, 4, 8, 12, 7});
		hexes[1].setCorners(new int[] {4, 1, 5, 9, 13, 8});
		hexes[2].setCorners(new int[] {5, 2, 6, 10, 14, 9});
		hexes[3].setCorners(new int[] {14, 10, 15, 20, 25, 19});
		hexes[4].setCorners(new int[] {25, 20, 26, 32, 37, 31});
		hexes[5].setCorners(new int[] {36, 31, 37, 42, 46, 41});
		hexes[6].setCorners(new int[] {45, 41, 46, 50, 53, 49});
		hexes[7].setCorners(new int[] {44, 40, 45, 49, 52, 48});
		hexes[8].setCorners(new int[] {43, 39, 44, 48, 51, 47});
		hexes[9].setCorners(new int[] {33, 28, 34, 39, 43, 38});
		hexes[10].setCorners(new int[] {21, 16, 22, 28, 33, 27});
		hexes[11].setCorners(new int[] {11, 7, 12, 17, 22, 16});
		hexes[12].setCorners(new int[] {12, 8, 13, 18, 23, 17});
		hexes[13].setCorners(new int[] {13, 9, 14, 19, 24, 18});
		hexes[14].setCorners(new int[] {24, 19, 25, 31, 36, 30});
		hexes[15].setCorners(new int[] {35, 30, 36, 41, 45, 40});
		hexes[16].setCorners(new int[] {34, 29, 35, 40, 44, 39});
		hexes[17].setCorners(new int[] {22, 17, 23, 29, 34, 28});
		hexes[18].setCorners(new int[] {23, 18, 24, 30, 35, 29});
		
		hexes[0].setPaths(new int[] {0, 24, 49, 4, 27, 48});
		hexes[1].setPaths(new int[] {1, 25, 50, 5, 28, 49});
		hexes[2].setPaths(new int[] {2, 26, 51, 6, 29, 50});
		hexes[3].setPaths(new int[] {6, 30, 56, 11, 34, 55});
		hexes[4].setPaths(new int[] {11, 35, 62, 16, 40, 61});
		hexes[5].setPaths(new int[] {15, 40, 67, 20, 44, 66});
		hexes[6].setPaths(new int[] {19, 44, 71, 23, 47, 70});
		hexes[7].setPaths(new int[] {18, 43, 70, 22, 46, 69});
		hexes[8].setPaths(new int[] {17, 42, 69, 21, 45, 68});
		hexes[9].setPaths(new int[] {12, 37, 64, 17, 41, 63});
		hexes[10].setPaths(new int[] {7, 31, 58, 12, 36, 57});
		hexes[11].setPaths(new int[] {3, 27, 53, 8, 31, 52});
		hexes[12].setPaths(new int[] {4, 28, 54, 9, 32, 53});
		hexes[13].setPaths(new int[] {5, 29, 55, 10, 33, 54});
		hexes[14].setPaths(new int[] {10, 34, 61, 15, 39, 60});
		hexes[15].setPaths(new int[] {14, 39, 66, 19, 43, 65});
		hexes[16].setPaths(new int[] {13, 38, 65, 18, 42, 64});
		hexes[17].setPaths(new int[] {8, 32, 59, 13, 37, 58});
		hexes[18].setPaths(new int[] {9, 33, 60, 14, 38, 59});
		
		corners[0].setContainingHexes(new int[] {-1, -1, 0});
		corners[1].setContainingHexes(new int[] {-1, -1, 1});
		corners[2].setContainingHexes(new int[] {-1, -1, 2});
		corners[3].setContainingHexes(new int[] {-1, 0, -1});
		corners[4].setContainingHexes(new int[] {-1, 1, 0});
		corners[5].setContainingHexes(new int[] {-1, 2, 1});
		corners[6].setContainingHexes(new int[] {-1, 1, 2});
		corners[7].setContainingHexes(new int[] {-1, 0, 11});
		corners[8].setContainingHexes(new int[] {0, 1, 12});
		corners[9].setContainingHexes(new int[] {1, 2, 13});
		corners[10].setContainingHexes(new int[] {2, -1, 3});
		corners[11].setContainingHexes(new int[] {-1, 11, -1});
		corners[12].setContainingHexes(new int[] {0, 12, 11});
		corners[13].setContainingHexes(new int[] {1, 13, 12});
		corners[14].setContainingHexes(new int[] {2, 3, 13});
		corners[15].setContainingHexes(new int[] {-1, -1, 3});
		corners[16].setContainingHexes(new int[] {-1, 11, 10});
		corners[17].setContainingHexes(new int[] {11, 12, 17});
		corners[18].setContainingHexes(new int[] {12, 13, 18});
		corners[19].setContainingHexes(new int[] {13, 3, 14});
		corners[20].setContainingHexes(new int[] {3, -1, 4});
		corners[21].setContainingHexes(new int[] {-1, 10, -1});
		corners[22].setContainingHexes(new int[] {11, 17, 10});
		corners[23].setContainingHexes(new int[] {12, 18, 17});
		corners[24].setContainingHexes(new int[] {13, 14, 18});
		corners[25].setContainingHexes(new int[] {3, 4, 14});
		corners[26].setContainingHexes(new int[] {-1, -1, 4});
		corners[27].setContainingHexes(new int[] {-1, 10, -1});
		corners[28].setContainingHexes(new int[] {10, 17, 9});
		corners[29].setContainingHexes(new int[] {17, 18, 16});
		corners[30].setContainingHexes(new int[] {18, 15, 16});
		corners[31].setContainingHexes(new int[] {14, 4, 5});
		corners[32].setContainingHexes(new int[] {4, -1, -1});
		corners[33].setContainingHexes(new int[] {10, 9, -1});
		corners[34].setContainingHexes(new int[] {17, 16, 9});
		corners[35].setContainingHexes(new int[] {18, 15, 16});
		corners[36].setContainingHexes(new int[] {14, 5, 15});
		corners[37].setContainingHexes(new int[] {4, -1, -1});
		corners[38].setContainingHexes(new int[] {-1, 9, -1});
		corners[39].setContainingHexes(new int[] {9, 16, 8});
		corners[40].setContainingHexes(new int[] {16, 15, 7});
		corners[41].setContainingHexes(new int[] {15, 5, 6});
		corners[42].setContainingHexes(new int[] {5, -1, -1});
		corners[43].setContainingHexes(new int[] {9, 8, -1});
		corners[44].setContainingHexes(new int[] {16, 7, 8});
		corners[45].setContainingHexes(new int[] {15, 6, 7});
		corners[46].setContainingHexes(new int[] {5, -1, 6});
		corners[47].setContainingHexes(new int[] {-1, 8, -1});
		corners[48].setContainingHexes(new int[] {8, 7, -1});
		corners[49].setContainingHexes(new int[] {7, 6, -1});
		corners[50].setContainingHexes(new int[] {6, -1, -1});
		corners[51].setContainingHexes(new int[] {8, -1, -1});
		corners[52].setContainingHexes(new int[] {7, -1, -1});
		corners[53].setContainingHexes(new int[] {6, -1, -1});
		
		
		corners[0].setNeighbourPaths(new int[] {-1, 24, 0});
		corners[1].setNeighbourPaths(new int[] {-1, 25, 1});
		corners[2].setNeighbourPaths(new int[] {-1, 26, 2});
		corners[3].setNeighbourPaths(new int[] {-1, 0, 48});
		corners[4].setNeighbourPaths(new int[] {24, 1, 49});
		corners[5].setNeighbourPaths(new int[] {25, 2, 50});
		corners[6].setNeighbourPaths(new int[] {26, -1, 51});
		corners[7].setNeighbourPaths(new int[] {48, 27, 3});
		corners[8].setNeighbourPaths(new int[] {49, 28, 4});
		corners[9].setNeighbourPaths(new int[] {50, 29, 5});
		corners[10].setNeighbourPaths(new int[] {51, 30, 6});
		corners[11].setNeighbourPaths(new int[] {-1, 3, 52});
		corners[12].setNeighbourPaths(new int[] {27, 4, 53});
		corners[13].setNeighbourPaths(new int[] {28, 5, 54});
		corners[14].setNeighbourPaths(new int[] {29, 6, 55});
		corners[15].setNeighbourPaths(new int[] {30, -1, 56});
		corners[16].setNeighbourPaths(new int[] {52, 31, 7});
		corners[17].setNeighbourPaths(new int[] {53, 32, 8});
		corners[18].setNeighbourPaths(new int[] {54, 33, 9});
		corners[19].setNeighbourPaths(new int[] {55, 34, 10});
		corners[20].setNeighbourPaths(new int[] {56, 35, 11});
		corners[21].setNeighbourPaths(new int[] {-1, 7, 57});
		corners[22].setNeighbourPaths(new int[] {31, 8, 58});
		corners[23].setNeighbourPaths(new int[] {32, 9, 59});
		corners[24].setNeighbourPaths(new int[] {33, 10, 60});
		corners[25].setNeighbourPaths(new int[] {34, 11, 61});
		corners[26].setNeighbourPaths(new int[] {35, -1, 62});
		corners[27].setNeighbourPaths(new int[] {57, 36, -1});
		corners[28].setNeighbourPaths(new int[] {58, 37, 12});
		corners[29].setNeighbourPaths(new int[] {59, 38, 13});
		corners[30].setNeighbourPaths(new int[] {60, 39, 14});
		corners[31].setNeighbourPaths(new int[] {61, 40, 15});
		corners[32].setNeighbourPaths(new int[] {62, -1, 16});
		corners[33].setNeighbourPaths(new int[] {36, 12, 63});
		corners[34].setNeighbourPaths(new int[] {37, 13, 64});
		corners[35].setNeighbourPaths(new int[] {38, 14, 65});
		corners[36].setNeighbourPaths(new int[] {39, 15, 66});
		corners[37].setNeighbourPaths(new int[] {40, 16, 67});
		corners[38].setNeighbourPaths(new int[] {63, 41, -1});
		corners[39].setNeighbourPaths(new int[] {64, 42, 17});
		corners[40].setNeighbourPaths(new int[] {65, 43, 18});
		corners[41].setNeighbourPaths(new int[] {66, 44, 19});
		corners[42].setNeighbourPaths(new int[] {67, -1, 20});
		corners[43].setNeighbourPaths(new int[] {41, 17, 68});
		corners[44].setNeighbourPaths(new int[] {42, 18, 69});
		corners[45].setNeighbourPaths(new int[] {43, 19, 70});
		corners[46].setNeighbourPaths(new int[] {44, 20, 71});
		corners[47].setNeighbourPaths(new int[] {68, 45, -1});
		corners[48].setNeighbourPaths(new int[] {69, 46, 21});
		corners[49].setNeighbourPaths(new int[] {70, 47, 22});
		corners[50].setNeighbourPaths(new int[] {71, -1, 23});
		corners[51].setNeighbourPaths(new int[] {45, 21, -1});
		corners[52].setNeighbourPaths(new int[] {46, 22, -1});
		corners[53].setNeighbourPaths(new int[] {47, 23, -1});
		
		
		
		paths[0].setContainingHexes(new int[] {-1, 0});
		paths[1].setContainingHexes(new int[] {-1, 1});
		paths[2].setContainingHexes(new int[] {-1, 2});
		paths[3].setContainingHexes(new int[] {-1, 11});
		paths[4].setContainingHexes(new int[] {0, 12});
		paths[5].setContainingHexes(new int[] {1, 13});
		paths[6].setContainingHexes(new int[] {2, 3});
		paths[7].setContainingHexes(new int[] {-1, 10});
		paths[8].setContainingHexes(new int[] {11, 17});
		paths[9].setContainingHexes(new int[] {12, 18});
		paths[10].setContainingHexes(new int[] {13, 14});
		paths[11].setContainingHexes(new int[] {3, 4});
		paths[12].setContainingHexes(new int[] {10, 9});
		paths[13].setContainingHexes(new int[] {17, 16});
		paths[14].setContainingHexes(new int[] {18, 15});
		paths[15].setContainingHexes(new int[] {14, 5});
		paths[16].setContainingHexes(new int[] {4, -1});
		paths[17].setContainingHexes(new int[] {9, 8});
		paths[18].setContainingHexes(new int[] {16, 7});
		paths[19].setContainingHexes(new int[] {15, 6});
		paths[20].setContainingHexes(new int[] {5, -1});
		paths[21].setContainingHexes(new int[] {8, -1});
		paths[22].setContainingHexes(new int[] {7, -1});
		paths[23].setContainingHexes(new int[] {6, -1});
		paths[24].setContainingHexes(new int[] {-1, 0});
		paths[25].setContainingHexes(new int[] {-1, 1});
		paths[26].setContainingHexes(new int[] {-1, 2});
		paths[27].setContainingHexes(new int[] {0, 11});
		paths[28].setContainingHexes(new int[] {1, 12});
		paths[29].setContainingHexes(new int[] {2, 13});
		paths[30].setContainingHexes(new int[] {-1, 3});
		paths[31].setContainingHexes(new int[] {11, 10});
		paths[32].setContainingHexes(new int[] {12, 8});
		paths[33].setContainingHexes(new int[] {13, 18});
		paths[34].setContainingHexes(new int[] {3, 14});
		paths[35].setContainingHexes(new int[] {-1, 4});
		paths[36].setContainingHexes(new int[] {10, -1});
		paths[37].setContainingHexes(new int[] {17, 9});
		paths[38].setContainingHexes(new int[] {18, 16});
		paths[39].setContainingHexes(new int[] {14, 15});
		paths[40].setContainingHexes(new int[] {4, 5});
		paths[41].setContainingHexes(new int[] {9, -1});
		paths[42].setContainingHexes(new int[] {16, 8});
		paths[43].setContainingHexes(new int[] {15, 7});
		paths[44].setContainingHexes(new int[] {5, 6});
		paths[45].setContainingHexes(new int[] {8, -1});
		paths[46].setContainingHexes(new int[] {7, -1});
		paths[47].setContainingHexes(new int[] {6, -1});
		paths[48].setContainingHexes(new int[] {-1, 0});
		paths[49].setContainingHexes(new int[] {0, 1});
		paths[50].setContainingHexes(new int[] {1, 2});
		paths[51].setContainingHexes(new int[] {2, -1});
		paths[52].setContainingHexes(new int[] {-1, 11});
		paths[53].setContainingHexes(new int[] {11, 12});
		paths[54].setContainingHexes(new int[] {12, 13});
		paths[55].setContainingHexes(new int[] {13, 3});
		paths[56].setContainingHexes(new int[] {3, -1});
		paths[57].setContainingHexes(new int[] {-1, 10});
		paths[58].setContainingHexes(new int[] {10, 17});
		paths[59].setContainingHexes(new int[] {17, 18});
		paths[60].setContainingHexes(new int[] {18, 14});
		paths[61].setContainingHexes(new int[] {14, 4});
		paths[62].setContainingHexes(new int[] {4, -1});
		paths[63].setContainingHexes(new int[] {-1, 9});
		paths[64].setContainingHexes(new int[] {9, 16});
		paths[65].setContainingHexes(new int[] {16, 15});
		paths[66].setContainingHexes(new int[] {15, 5});
		paths[67].setContainingHexes(new int[] {5, -1});
		paths[68].setContainingHexes(new int[] {-1, 8});
		paths[69].setContainingHexes(new int[] {8, 7});
		paths[70].setContainingHexes(new int[] {7, 6});
		paths[71].setContainingHexes(new int[] {6, -1});
		
		paths[0].setNeighbourCorners(new int[] {0, 3});
		paths[1].setNeighbourCorners(new int[] {1, 4});
		paths[2].setNeighbourCorners(new int[] {2, 5});
		paths[3].setNeighbourCorners(new int[] {7, 11});
		paths[4].setNeighbourCorners(new int[] {8, 12});
		paths[5].setNeighbourCorners(new int[] {9, 13});
		paths[6].setNeighbourCorners(new int[] {10, 14});
		paths[7].setNeighbourCorners(new int[] {16, 21});
		paths[8].setNeighbourCorners(new int[] {17, 22});
		paths[9].setNeighbourCorners(new int[] {18, 23});
		paths[10].setNeighbourCorners(new int[] {19, 24});
		paths[11].setNeighbourCorners(new int[] {20, 25});
		paths[12].setNeighbourCorners(new int[] {28, 33});
		paths[13].setNeighbourCorners(new int[] {29, 34});
		paths[14].setNeighbourCorners(new int[] {30, 35});
		paths[15].setNeighbourCorners(new int[] {31, 36});
		paths[16].setNeighbourCorners(new int[] {32, 37});
		paths[17].setNeighbourCorners(new int[] {39, 43});
		paths[18].setNeighbourCorners(new int[] {40, 44});
		paths[19].setNeighbourCorners(new int[] {41, 45});
		paths[20].setNeighbourCorners(new int[] {42, 46});
		paths[21].setNeighbourCorners(new int[] {48, 51});
		paths[22].setNeighbourCorners(new int[] {49, 52});
		paths[23].setNeighbourCorners(new int[] {50, 53});
		paths[24].setNeighbourCorners(new int[] {0, 4});
		paths[25].setNeighbourCorners(new int[] {1, 5});
		paths[26].setNeighbourCorners(new int[] {2, 6});
		paths[27].setNeighbourCorners(new int[] {7, 12});
		paths[28].setNeighbourCorners(new int[] {8, 13});
		paths[29].setNeighbourCorners(new int[] {9, 14});
		paths[30].setNeighbourCorners(new int[] {10, 15});
		paths[31].setNeighbourCorners(new int[] {16, 22});
		paths[32].setNeighbourCorners(new int[] {17, 23});
		paths[33].setNeighbourCorners(new int[] {18, 24});
		paths[34].setNeighbourCorners(new int[] {19, 25});
		paths[35].setNeighbourCorners(new int[] {20, 26});
		paths[36].setNeighbourCorners(new int[] {27, 33});
		paths[37].setNeighbourCorners(new int[] {28, 34});
		paths[38].setNeighbourCorners(new int[] {29, 35});
		paths[39].setNeighbourCorners(new int[] {30, 36});
		paths[40].setNeighbourCorners(new int[] {31, 37});
		paths[41].setNeighbourCorners(new int[] {38, 43});
		paths[42].setNeighbourCorners(new int[] {39, 44});
		paths[43].setNeighbourCorners(new int[] {40, 45});
		paths[44].setNeighbourCorners(new int[] {43, 46});
		paths[45].setNeighbourCorners(new int[] {47, 51});
		paths[46].setNeighbourCorners(new int[] {48, 52});
		paths[47].setNeighbourCorners(new int[] {49, 53});
		paths[48].setNeighbourCorners(new int[] {3, 7});
		paths[49].setNeighbourCorners(new int[] {4, 8});
		paths[50].setNeighbourCorners(new int[] {5, 9});
		paths[51].setNeighbourCorners(new int[] {6, 10});
		paths[52].setNeighbourCorners(new int[] {11, 16});
		paths[53].setNeighbourCorners(new int[] {12, 17});
		paths[54].setNeighbourCorners(new int[] {13, 18});
		paths[55].setNeighbourCorners(new int[] {14, 19});
		paths[56].setNeighbourCorners(new int[] {15, 20});
		paths[57].setNeighbourCorners(new int[] {21, 27});
		paths[58].setNeighbourCorners(new int[] {22, 28});
		paths[59].setNeighbourCorners(new int[] {23, 29});
		paths[60].setNeighbourCorners(new int[] {24, 30});
		paths[61].setNeighbourCorners(new int[] {25, 31});
		paths[62].setNeighbourCorners(new int[] {26, 31});
		paths[63].setNeighbourCorners(new int[] {33, 38});
		paths[64].setNeighbourCorners(new int[] {34, 39});
		paths[65].setNeighbourCorners(new int[] {35, 40});
		paths[66].setNeighbourCorners(new int[] {36, 41});
		paths[67].setNeighbourCorners(new int[] {37, 42});
		paths[68].setNeighbourCorners(new int[] {43, 47});
		paths[69].setNeighbourCorners(new int[] {44, 48});
		paths[70].setNeighbourCorners(new int[] {45, 49});
		paths[71].setNeighbourCorners(new int[] {46, 50});
		
		game.createBoard(hexes, paths, corners);
		
	}

	public void initializePlayers() {
		
		playerPanes = new PlayerPane[game.getNumberOfPlayers()];
		closeButtons = new SettlersButton[game.getNumberOfPlayers()];
		settlementButtons = new SettlersButton[game.getNumberOfPlayers()];
		roadButtons = new SettlersButton[game.getNumberOfPlayers()];
		cityButtons = new SettlersButton[game.getNumberOfPlayers()];
		endTurnButtons = new SettlersButton[game.getNumberOfPlayers()];
		cycle = 1;
		
		for (int i = 0 ; i < game.getNumberOfPlayers() ; i++) {
			final int j = i;
			playerPanes[i] = new PlayerPane(i + 1);
			closeButtons[i] = playerPanes[i].getCloseButton();
			roadButtons[i] = playerPanes[i].getRoadButton();
			cityButtons[i] = playerPanes[i].getCityButton();
			settlementButtons[i] = playerPanes[i].getSettlementButton();
			endTurnButtons[i] = playerPanes[i].getEndTurnButton();
			
			closeButtons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					backButton.setVisible(true);
					everything.setDisable(false);
					playerPanes[j].setVisible(false);
				}
			});
			
			endTurnButtons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					backButton.setVisible(true);
					everything.setDisable(false);
					playerPanes[j].setVisible(false);
					cycle = game.nextTurn(cycle);
					int prev = playerInTurn;
					playerInTurn = game.getPlayerInTurn();
					updateTurn(prev);
				}
			});
			
			settlementButtons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					backButton.setVisible(true);
					everything.setDisable(false);
					playerPanes[j].setVisible(false);
					for (int i = 0 ; i < 54 ; i++) {
						cornerButtons[i].setVisible(true);
					}
					settlementSetUp();
				}
			});
			
			roadButtons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					backButton.setVisible(true);
					everything.setDisable(false);
					playerPanes[j].setVisible(false);
					for (int i = 0 ; i < 72 ; i++) {
						pathButtons[i].setVisible(true);
					}
					roadSetUp();
				}
			});
			
			cityButtons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
				
				}
			});
			
			all.getChildren().add(playerPanes[i]);
			
			VBox paneAll = (VBox) playerPanes[i].getChildren().get(0);
			HBox other = (HBox) paneAll.getChildren().get(0);
			Pane changables = (Pane) paneAll.getChildren().get(1);
			Pane changableButtons = (Pane) paneAll.getChildren().get(3);
			
			String name = playerButtons[i].getName();
			ImageView icon = playerButtons[i].getIcon();
			Color color = playerButtons[i].getColor();
			ImageView newIcon = new ImageView(icon.getImage());
			PlayerButton playerView = new PlayerButton(newIcon, name, color, true);
			playerView.setTranslateX(20);
			playerView.setTranslateY(20);
			other.getChildren().add(playerView);
			
			VBox totalCard = (VBox) changables.getChildren().get(1);
			Label totalLabel = (Label) totalCard.getChildren().get(0);
			totalLabel.setText(totalLabel.getText() + name);
			
			SettlersButton tradeButton = (SettlersButton) changableButtons.getChildren().get(1);
			tradeButton.setText(tradeButton.getText() + name);
			
			playerButtons[j].setOnMouseClicked( new EventHandler<MouseEvent>() {
				@Override
				
				public void handle(MouseEvent event) {
					if (playerInTurn == j + 1) {
						
						playerPanes[j].setContentVisible(true);
					}
					backButton.setVisible(false);
					playerPanes[j].setVisible(true);				
					everything.setDisable(true);	
				}
			});
		}
		
		/*for (int i = 0 ; i < game.getNumberOfPlayers() ; i++) {
			
		}*/
		
	}
	
	public void settlementSetUp() {

		SettlersButton confirmButton = new SettlersButton("Confirm Selection", 300, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
	    confirmButton.setTranslateX(568);
	    confirmButton.setTranslateY(748);
	    view.getChildren().add(confirmButton);
		for (int i = 0 ; i < 54 ; i++) {
			final int j = i;
			CornerButton firstButton = cornerButtons[j];
			firstButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					firstButton.getStyleClass().remove("corner-button");
					firstButton.getStyleClass().add("settlement");
					Color color = players[playerInTurn -1].getColor();
					firstButton.setStyle("-fx-background-color: rgba("+ (int) (color.getRed() * 225) +", " + (int) (color.getGreen() * 225) + ", " + (int) (color.getBlue() * 225) + ", 1);");
					firstButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			        	@Override
						public void handle(MouseEvent event) {
			        		// Do nothing
			        	}
			        });
					firstButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			        	@Override
						public void handle(MouseEvent event) {
			        		// Do nothing
			        	}
			        });
			        for (int k = 0 ; k < 54 ; k++) {
			        	final int l = k;
			        	CornerButton secondButton = cornerButtons[l];
			        	recursiveSettlementHelper(firstButton, secondButton);
			        	
			        }
			       
			        confirmButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							for (int k = 0 ; k < 54 ; k++) {
								cornerButtons[k].setOnMouseClicked(new EventHandler<MouseEvent>() {
									@Override
									public void handle(MouseEvent event) {
										
									}
								});
								cornerButtons[k].setOnMouseExited(new EventHandler<MouseEvent>() {
									@Override
									public void handle(MouseEvent event) {
										
									}
								});
								cornerButtons[k].setOnMouseEntered(new EventHandler<MouseEvent>() {
									@Override
									public void handle(MouseEvent event) {
										
									}
								});
							}
							view.getChildren().remove(confirmButton);
						}
					});
					
				}
			});
		}
	}
	
	public void roadSetUp() {
		for (int i = 0 ; i < 72 ; i++) {
			final int j = i;
			PathButton firstButton = pathButtons[j];
			firstButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					//firstButton.getStyleClass().remove("corner-button");
					//firstButton.getStyleClass().add("settlement");
					Color color = players[playerInTurn -1].getColor();
					firstButton.setStyle("-fx-background-color: rgba("+ (int) (color.getRed() * 225) +", " + (int) (color.getGreen() * 225) + ", " + (int) (color.getBlue() * 225) + ", 1);");
					firstButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			        	@Override
						public void handle(MouseEvent event) {
			        		// Do nothing
			        	}
			        });
					firstButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			        	@Override
						public void handle(MouseEvent event) {
			        		// Do nothing
			        	}
			        });
			        for (int k = 0 ; k < 54 ; k++) {
			        	final int l = k;
			        	PathButton secondButton = pathButtons[l];
			        	recursiveRoadHelper(firstButton, secondButton);
			        	
			        }
			        SettlersButton confirmButton = new SettlersButton("Confirm Selection", 300, "-fx-background-color: rgba(225, 225, 225, 0.55);", "-fx-background-color: rgba(225, 225, 225, 0.8);");
			        confirmButton.setTranslateX(568);
			        confirmButton.setTranslateY(748);
			        confirmButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							for (int k = 0 ; k < 72 ; k++) {
								pathButtons[k].setOnMouseClicked(new EventHandler<MouseEvent>() {
									@Override
									public void handle(MouseEvent event) {
										
									}
								});
								pathButtons[k].setOnMouseExited(new EventHandler<MouseEvent>() {
									@Override
									public void handle(MouseEvent event) {
										
									}
								});
								pathButtons[k].setOnMouseEntered(new EventHandler<MouseEvent>() {
									@Override
									public void handle(MouseEvent event) {
										
									}
								});
								
							}
							confirmButton.setVisible(false);
						}
					});
					view.getChildren().add(confirmButton);
				}
			});
		}
	}
	
	public void recursiveSettlementHelper(CornerButton firstButton, CornerButton secondButton) {
		
		secondButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				secondButton.getStyleClass().remove("corner-button");
				secondButton.getStyleClass().add("settlement");
				Color color = players[playerInTurn -1].getColor();
				secondButton.setStyle("-fx-background-color: rgba("+ (int) (color.getRed() * 225) +", " + (int) (color.getGreen() * 225) + ", " + (int) (color.getBlue() * 225) + ", 1);");
				secondButton.setOnMouseExited(new EventHandler<MouseEvent>() {
		        	@Override
					public void handle(MouseEvent event) {
		        		// Do nothing
		        	}
		        });
				secondButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
		        	@Override
					public void handle(MouseEvent event) {
		        		// Do nothing
		        	}
		        });
				
				firstButton.getStyleClass().remove("settlement");
				firstButton.getStyleClass().add("corner-button");
				firstButton.setStyle("-fx-background-color: transparent;");
				firstButton.setOnMouseEntered( new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						firstButton.setStyle("-fx-background-color: rgba(33, 33, 33, 0.55);");
					}
					
				});
				firstButton.setOnMouseExited( new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						firstButton.setStyle("-fx-background-color: transparent;");
					}
					
				});
				
				for (int s = 0 ; s < 54 ; s++) {
					final int r = s;
					CornerButton thirdButton = cornerButtons[r];
					recursiveSettlementHelper(secondButton, thirdButton);
				}
				
			}
    	});
		
		
	}
	
	public void recursiveRoadHelper(PathButton firstButton, PathButton secondButton) {
		
		secondButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//secondButton.getStyleClass().remove("corner-button");
				//secondButton.getStyleClass().add("settlement");
				Color color = players[playerInTurn -1].getColor();
				secondButton.setStyle("-fx-background-color: rgba("+ (int) (color.getRed() * 225) +", " + (int) (color.getGreen() * 225) + ", " + (int) (color.getBlue() * 225) + ", 1);");
				secondButton.setOnMouseExited(new EventHandler<MouseEvent>() {
		        	@Override
					public void handle(MouseEvent event) {
		        		// Do nothing
		        	}
		        });
				secondButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
		        	@Override
					public void handle(MouseEvent event) {
		        		// Do nothing
		        	}
		        });
				
				//firstButton.getStyleClass().remove("settlement");
				//firstButton.getStyleClass().add("corner-button");
				firstButton.setStyle("-fx-background-color: transparent;");
				firstButton.setOnMouseEntered( new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						firstButton.setStyle("-fx-background-color: rgba(33, 33, 33, 0.55);");
					}
					
				});
				firstButton.setOnMouseExited( new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						firstButton.setStyle("-fx-background-color: transparent;");
					}
					
				});
				
				for (int s = 0 ; s < 72 ; s++) {
					final int r = s;
					PathButton thirdButton = pathButtons[r];
					recursiveRoadHelper(secondButton, thirdButton);
				}
				
			}
    	});
		
		
	}

	public void updateTurn(int prev) {
		if (prev == -1) {
			
		} else {
			playerStatus[prev - 1].setFill(Color.RED);
			playerStatus[playerInTurn - 1].setFill(Color.GREEN);
			
			
			playerPanes[prev - 1].setContentVisible(false);
			
			
			
		}
	}

	
	
	
	
}
