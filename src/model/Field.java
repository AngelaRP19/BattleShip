package model;

public class Field {

	private int row;
	private int column;
	private boolean free;
	private boolean attacked;
	
	public Field() {
		this.row = 0;
		this.column = '-';
		this.free = true;
		this.attacked = false;
	}
	public Field(int fila, int columna, boolean libre, boolean atacada) {
		this.row = fila;
		this.column = columna;
		this.free = libre;
		this.attacked = atacada;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	public boolean isAttacked() {
		return attacked;
	}
	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}

	
	
}
