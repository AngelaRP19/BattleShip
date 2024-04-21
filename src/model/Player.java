package model;

public class Player {

	private Board board;
	private String name;
	
	public Player(String nombre,int size) {
		this.board = new Board(size);
		this.name = nombre;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean shipAttacked(int i, int j) {
		boolean shipAttacked = false;
		if(this.board.getPlayerFields()[i][j].isAttacked() && !this.board.getPlayerFields()[i][j].isFree())
			shipAttacked = true;
		return shipAttacked;
	}

	
	
	
}
