package settlers;

public class ModelAccessibleViewController extends ViewController{
	
	protected GameModel game;

	public ModelAccessibleViewController(ViewControllerController viewControllerController, GameModel game) {
		super(viewControllerController);
		setGame(game);
		// TODO Auto-generated constructor stub
	}

	public GameModel getGame() {
		return game;
	}

	private void setGame(GameModel game) {
		this.game = game;
	}


	

}
