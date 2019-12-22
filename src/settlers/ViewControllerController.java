package settlers;

import javafx.scene.Scene;

public class ViewControllerController {
	
	private Scene scene;
	private ViewController viewController;

	public ViewControllerController(Scene scene) {
		setScene(scene);
	}

	public ViewController getViewController() {
		return viewController;
	}

	public void setViewController(ViewController viewController) {
		this.viewController = viewController;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void goToMainMenu() {
		setViewController(new MainMenuController(this));
		refresh();
	}
	
	public void goToSettings() {
		setViewController(new SettingsController(this));
		refresh();
	}
	
	public void goToHowToPlay() {
		setViewController(new HowToPlayController(this));
		refresh();
	}
	
	public void goToNewGame() {
		setViewController(new NewGameController(this));
		refresh();
	}
	
	public void goToGame(GameModel game) {
		setViewController(new GameController(this, game));
		refresh();
	}
	
	public void refresh() {
		scene.setRoot(viewController.getView());
		
	}


	
	

}
