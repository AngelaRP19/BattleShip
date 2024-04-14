package model;

public class Game {

	private Player player;
	private Player oponent;
	
	public Game(String nombre, int f, int c, int numShip) {
		this.player = new Player(nombre, f, c, numShip);
		this.player = new Player("maquina", f, c, numShip);
	}
	// dos jugadores cada uno con sus barcos
	//ubicar los barcos aleatoriamente para el oponente
	//validar las posiciones 
	//si se encuentra una parte del barco a partir de la toma de celdas aleatorias, se evaluan 
}
