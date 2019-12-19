package settlers;

public class MainMenuController extends ViewController {
	
	

	public MainMenuController(ViewControllerController viewControllerController) {
		super(viewControllerController);
		setView(new MainMenuView(this));
	}

	

}
