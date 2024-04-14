package presenter;

import model.Game;
import view.ViewBattleship;

public class Presenter  {
	
	private ViewBattleship view;
	private Game game;
	
	public Presenter() {
		this.view = new ViewBattleship();
		this.playGame();
	}

	private void playGame() {
		//view.init();
		view.generateMainPanel();
		view.getPrincipalFrame().setVisible(true);
		//view.getFrameGame().setVisible(true);
	}

}
