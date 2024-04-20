package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
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
			this.game = new Game(view.getName().getText(),Integer.parseInt(view.getSize().getText()));
			this.addListenerButtons();
		}else if(e.getSource() == view.getNextButton()) {
			this.disableButtons();
			view.generateGamePanel();
			this.addListenerButtons();
			game.randomShips(5, game.getOponent());
			game.randomShips(4,game.getOponent());
			game.randomShips(3,game.getOponent());
			game.randomShips(3,game.getOponent());
			game.randomShips(2,game.getOponent());
			//this.fieldValue();
			
			//TOMAR LA OPCION DE BARCO Y DIRECCION ESCOGIDA
		}else if(e.getSource()==view.getPortaavion()){
			sizeShip = 5;
		}else if(e.getSource()==view.getAcorazado()){
			sizeShip = 4;
		}else if(e.getSource()==view.getDestructor()){
			sizeShip = 3;
		}else if(e.getSource()==view.getSubmarino()){
			sizeShip = 2;
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
				if (sizeShip!=0 && game.validatePosition(row, column, sizeShip, direction, view.getButtons().length, game.getPlayer())) {
					game.putShip(row, column, sizeShip, direction, this.game.getPlayer());
					this.fieldValue();
					view.getBoardPlayer().repaint();
				}
			//SI EL ORIGEN DE LA ACCION ES UN BOTON DEL TABLERO DE LA MAQUINA (COMIENZO DEL JUEGO)
			}else if(cord[2].equals("MAQUINA")){
				this.game.attackField(row,column);
				//this.valueofopponent();
				game.attackPlayer(10);
				this.fieldValue();
			}
			//EVALUAR LA POSICION DEL BOTON QUE SE OPRIMIO, SI ES DE MAQUINA, ATACA, SI ES DE JUGADOR UBICA BARCO
		}
	}

	private void disableButtons() {
		for (int i = 0; i < view.getButtons().length; i++) {
			for (int j = 0; j < view.getButtons()[i].length; j++) {
				view.getButtons()[i][j].setEnabled(false);
			}
		}
	}

	private void valueofopponent() {
		for (int i = 0; i < view.getButtons().length; i++) {
			for (int j = 0; j < view.getButtons()[i].length; j++) {
				System.out.println(game.getPlayer().getBoard().getPlayerFields()[i][j].isFree());
			}
		}
	}

	private void fieldValue() {
		//recorrer el tablero y actualizar el estado de acuerdo a si hay un barco o no
		for (int i = 0; i < view.getButtons().length; i++) {
			for (int j = 0; j < view.getButtons()[i].length; j++) {
				if (!game.getPlayer().getBoard().getPlayerFields()[i][j].isFree()) {
					view.setColorButton(i, j, "SHIP");
					view.getButtons()[i][j].setEnabled(false);
				}else if (!game.getOponent().getBoard().getPlayerFields()[i][j].isFree()) {
					view.setColorButton(i, j, "MACHINE");
				}
				if (game.getOponent().getBoard().getPlayerFields()[i][j].isAttacked()) {
					view.setColorButton(i, j, "ATTACK");
				}
				if (game.getPlayer().getBoard().getPlayerFields()[i][j].isAttacked())
					view.setColorButton(i, j, "ATMAQ");
			}
		}
	}

	private void addListenerButtons () {
		for (int i = 0; i < view.getButtons().length; i++) {
			for (int j = 0; j < view.getButtons()[i].length; j++) {
				view.getButtons()[i][j].addActionListener(this);
			}
		}
	}
	
	private void playGame() {
		view.register();
	//	this.game = new Game(view.getName().getText(), 10, 10, 5);
		//view.generatePanelOptions();
		//view.locateShips();
		//view.generateShipsPanel();
		view.getPrincipalFrame().setVisible(true);
		
		//view.getFrameGame().setVisible(true);
	}
}
	
