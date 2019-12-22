package settlers;

public class SettingsController extends ViewController{

	public SettingsController(ViewControllerController viewControllerController) {
		super(viewControllerController);
		setView(new SettingsView(this));
	}
	
}
