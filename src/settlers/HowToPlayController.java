package settlers;

public class HowToPlayController extends ViewController{

	public HowToPlayController(ViewControllerController viewControllerController) {
		super(viewControllerController);
		setView(new HowToPlayView(this));
	}

	
}
