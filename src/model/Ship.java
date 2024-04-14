package model;

public class Ship {

	private int sizeShip;
	private boolean isAlive;
	private TypeShip type;
	
	public Ship( int sizeShip, boolean isAlive) {
		
		this.isAlive = isAlive;
		this.sizeShip = sizeShip;
	}

	public int getSizeShip() {
		return sizeShip;
	}

	public void setSizeShip(int sizeShip) {
		this.sizeShip = sizeShip;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public TypeShip getType() {
		return type;
	}

	public void setType(TypeShip type) {
		this.type = type;
	}
	
	
}
