package settlers;

public class ViewController {
	
	protected ViewControllerController viewControllerController;
	protected View view;

	public ViewController(ViewControllerController viewControllerController) {
		setViewControllerController(viewControllerController);
	}

	public ViewControllerController getViewControllerController() {
		return viewControllerController;
	}

	public void setViewControllerController(ViewControllerController viewControllerController) {
		this.viewControllerController = viewControllerController;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
		
	}
	
	public void goToMainMenu() {
		viewControllerController.goToMainMenu();
	}
	
	public void goToSettings() {
		viewControllerController.goToSettings();
	}
	
	public void goToHowToPlay() {
		viewControllerController.goToHowToPlay();
	}
	
	public void goToGame(GameModel game) {
		viewControllerController.goToGame(game);
	}
	
	public void goToNewGame() {
		viewControllerController.goToNewGame();
	}
	

}
