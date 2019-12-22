package settlers;

import javafx.scene.Group;

public class View extends Group {

	protected ViewController viewController;
	
	public View(ViewController viewController) {
		setViewController(viewController);
	}

	public ViewController getViewController() {
		return viewController;
	}

	public void setViewController(ViewController viewController) {
		this.viewController = viewController;
	}
	
	public void goToMainMenu() {
		viewController.goToMainMenu();
	}
	
	public void goToSettings() {
		viewController.goToSettings();
	}
	
	public void goToHowToPlay() {
		viewController.goToHowToPlay();
	}
	
	public void goToNewGame() {
		viewController.goToNewGame();
	}
	
	public void goToGame(GameModel game) {
		viewController.goToGame(game);
	}
	

}