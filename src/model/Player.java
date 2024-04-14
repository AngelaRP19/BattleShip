package model;

public class Player {

	private Board board;
	private String name;
	
	public Player(String nombre, int f, int c, int numShips) {
		this.board = new Board(f,c,numShips);
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

	
	
	
}
