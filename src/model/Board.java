package model;

import java.util.ArrayList;

public class Board {

	private Field [][] playerFields;
	private ArrayList <Ship> ships;
	private int rows;
	private int columns;
	private int numShips;
	
	public Board(int size) {
		this.rows = size;
		this.columns = size;
		this.playerFields = new Field[rows][columns];
		this.initBoard();
	}
	public Board( int f, int c, int numShips) {
		this.rows = f;
		this.columns = c;
		this.playerFields = new Field[f][c];
		this.numShips = numShips;
		this.ships = new ArrayList<Ship>();
		this.initBoard();
	}
	

	private void initBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				playerFields[i][j] = new Field (i,j, true, false);
			}
		}
	}
	public Field[][] getPlayerFields() {
		return playerFields;
	}
	public void setPlayerFields(Field[][] playerFields) {
		this.playerFields = playerFields;
	}
	public ArrayList<Ship> getShips() {
		return ships;
	}
	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public int getNumShips() {
		return numShips;
	}
	public void setNumShips(int numShips) {
		this.numShips = numShips;
	}
	
	
}
