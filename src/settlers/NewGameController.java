package settlers;

public class NewGameController extends ViewController{

	public NewGameController(ViewControllerController viewControllerController) {
		super(viewControllerController);
		setView(new NewGameView(this));
	}



}
