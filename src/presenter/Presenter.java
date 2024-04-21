package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
import model.Player;
import view.ViewBattleship;

public class Presenter implements ActionListener {
	
	private ViewBattleship view;
	private Game game;
	
	public Presenter() {
		this.view = new ViewBattleship();
		
		view.getStartButton().addActionListener(this);
		view.getNextButton().addActionListener(this);
		
		view.getAcorazado().addActionListener(this);
		view.getPortaavion().addActionListener(this);
		view.getDestructor().addActionListener(this);
		view.getDestructor2().addActionListener( this);
		view.getSubmarino().addActionListener(this);
		
		view.getTop().addActionListener(this);
		view.getBottom().addActionListener(this);
		view.getLeft().addActionListener(this);
		view.getRight().addActionListener(this);
		
		this.playGame();
		
	}

	int sizeShip = 0;
	String direction = "";
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 
		if (e.getSource()==view.getStartButton()) {
			view.locateShips();
			this.game = new Game(view.getName().getText(),(int) view.getSizeBoards().getSelectedItem());
			this.addListenerButtons();
		}else if(e.getSource() == view.getNextButton()) {
			this.disableButtons();
			view.generateGamePanel();
			this.addListenerButtons();
			this.locateRandomShips(game.getOponent());
			
			
			//TOMAR LA OPCION DE BARCO Y DIRECCION ESCOGIDA
		}else if(e.getSource()==view.getPortaavion()){
			sizeShip = 5;
			view.getPortaavion().setEnabled(false);
		}else if(e.getSource()==view.getAcorazado()){
			sizeShip = 4;
			view.getAcorazado().setEnabled(false);
		}else if(e.getSource()==view.getDestructor()){
			sizeShip = 3;
			view.getDestructor().setEnabled(false);
		}else if(e.getSource()==view.getDestructor2()) {
			sizeShip = 3;
			view.getDestructor2().setEnabled(false);
		}else if(e.getSource()==view.getSubmarino()){
			sizeShip = 2;
			view.getSubmarino().setEnabled(false);
		}else if(e.getSource()==view.getTop()){
			direction = "top";
		}else if(e.getSource()==view.getBottom()){
			direction = "bottom";
		}else if(e.getSource()==view.getLeft()){
			direction = "left";
		}else if(e.getSource()==view.getRight()){
			direction = "right";
		}else{
			//System.out.println(e.getActionCommand());
			String position = e.getActionCommand();
			String[] cord = position.split("-");
			int row = Integer.parseInt(cord[0]);
			int column = Integer.parseInt(cord[1]) ;
	
			//SI ESTA EN EL TABLERO DEL JUGADOR (PARA UBICAR LOS BARCOS)
			if (cord[2].equals("PLAYER")) {
				if (sizeShip!=0 && game.validatePosition(row, column, sizeShip, direction, view.getButtonsMachine().length, game.getPlayer())) {
					game.putShip(row, column, sizeShip, direction, this.game.getPlayer());
					this.fieldValue();
					view.getBoardPlayer().repaint();
				}
			//SI EL ORIGEN DE LA ACCION ES UN BOTON DEL TABLERO DE LA MAQUINA (COMIENZO DEL JUEGO)
			}else if(cord[2].equals("MAQUINA")){
				
				this.game.attackField(row,column);
				game.attackPlayer(view.getButtonsPlayer().length);
				this.fieldValue();
				if(game.evaluateLosse(game.getPlayer())){
					view.finishGame("MÁQUINA");
					
				}else if(game.evaluateLosse(game.getOponent())){
					view.finishGame("player");
					
				}
			}
		}
	}

	private void locateRandomShips(Player p) {
		game.randomShips(5, p);
		game.randomShips(4, p);
		game.randomShips(3, p);
		game.randomShips(3, p);
		game.randomShips(2, p);
	}

	private void disableButtons() {
		for (int i = 0; i < view.getButtonsPlayer().length; i++) {
			for (int j = 0; j < view.getButtonsPlayer()[i].length; j++) {
				view.getButtonsPlayer()[i][j].setEnabled(false);
			}
		}
	}

	private void fieldValue() {
		//RECORRE LOS TABLEROS Y LOS ACTUALIZA DE ACUERDO A SU ESTADO
		for (int i = 0; i < view.getButtonsMachine().length; i++) {
			for (int j = 0; j < view.getButtonsMachine()[i].length; j++) {
				if (!game.getPlayer().getBoard().getPlayerFields()[i][j].isFree()) {
					view.setColorButton(i, j, "SHIP_PLAYER");
					view.getButtonsPlayer()[i][j].setEnabled(false);
				}
				if (!game.getOponent().getBoard().getPlayerFields()[i][j].isFree()) {
					view.setColorButton(i, j, "SHIP_MACHINE");
				}
				if (game.getOponent().getBoard().getPlayerFields()[i][j].isAttacked()) {
					view.setColorButton(i, j, "ATTACK_MACHINE");
				}
				if (game.getPlayer().getBoard().getPlayerFields()[i][j].isAttacked())
					view.setColorButton(i, j, "ATTACK_PLAYER");
				
				if (game.getPlayer().shipAttacked(i,j)) {
					view.setColorButton(i, j, "SHIP_PLAYER_ATTACKED");
				}
				if (game.getOponent().shipAttacked(i,j)) {
					view.setColorButton(i, j, "SHIP_MACHINE_ATTACKED");
				}
			}
		}
	}

	private void addListenerButtons () {
		for (int i = 0; i < view.getButtonsMachine().length; i++) {
			for (int j = 0; j < view.getButtonsMachine()[i].length; j++) {
				view.getButtonsMachine()[i][j].addActionListener(this);
			}
		}
	}
	
	private void playGame() {
		view.register();
		view.getPrincipalFrame().setVisible(true);
	}
}
	
