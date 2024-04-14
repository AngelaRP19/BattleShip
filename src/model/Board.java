package model;

import java.util.ArrayList;

public class Board {

	private Field [][] playerFields;
	private Field [][] oponentFields;
	private ArrayList <Ship> ships;
	private int rows;
	private int columns;
	private int numShips;
	
	public Board(int f, int c) {
		this.rows = f;
		this.columns = c;
	}
	public Board( int f, int c, int numShips) {
		this.rows = f;
		this.columns = c;
		this.playerFields = new Field[f][c];
		this.oponentFields = new Field[f][c];
		this.numShips = numShips;
		this.ships = new ArrayList<Ship>();
	}
	
	private void createShips() {
		ships.add(new Ship(5, true));
		ships.add(new Ship(4, true));
		ships.add(new Ship(3, true));
		ships.add(new Ship(3, true));
		ships.add(new Ship(2, true));
	}
	private void initializaBoard() {
		
		char col = 'A';
		for (int i = 0; i < rows; i++) {
			
			for (int j = 0; j < columns; j++) {
				playerFields[i][j] = new Field (col, j+1, true, false);
				oponentFields[i][j] = new Field (col, j+1, true, false);
			}
			col++;
		}
	}
	
	
}
