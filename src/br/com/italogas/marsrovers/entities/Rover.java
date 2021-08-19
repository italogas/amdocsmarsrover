package br.com.italogas.marsrovers.entities;

import br.com.italogas.marsrovers.util.Logger;

public class Rover {

	private int x;
	private int y;
	private Orientation orientation;
	public static final String MOVEMENT = "M";
	
	public Rover() {}
	
	public Rover(int x, int y, Orientation orientation) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	
	public int getX() {	return x; }
	
	public void setX(int x) { this.x = x; }
	
	public int getY() { return y; }
	
	public void setY(int y) { this.y = y; }
	
	public String getOrientation() { return orientation.toString(); }
	
	public void setOrientation(String orientation) {
    	switch(orientation.toUpperCase()){
			case "N": 
				this.orientation = Orientation.N;
				break;
			case "S": 
				this.orientation = Orientation.S;
				break;
			case "E": 
				this.orientation = Orientation.E;
				break;
			case "W": 
				this.orientation = Orientation.W;
				break;
    	}
	}
	
	public void move(String[] moves){
		for (String move : moves) 
    	{ 
			Logger.log("Processing move: " + move);
    	    if(move.equalsIgnoreCase(Direction.L.toString())) {
    	    	switch(this.orientation){
    	    		case N: 
    	    			this.orientation = Orientation.W;
    	    			break;
    	    		case S: 
    	    			this.orientation = Orientation.E;
    	    			break;
    	    		case E: 
    	    			this.orientation = Orientation.N;
    	    			break;
    	    		case W: 
    	    			this.orientation = Orientation.S;
    	    			break;
    	    	}
    	    } else if(move.equalsIgnoreCase(Direction.R.toString())) {
					switch(this.orientation){
						case N: 
							this.orientation = Orientation.E;
							break;
						case S: 
							this.orientation = Orientation.W;
							break;
						case E: 
							this.orientation = Orientation.S;
							break;
						case W: 
							this.orientation = Orientation.N;
							break;
					}
    	    } else if(move.equalsIgnoreCase(MOVEMENT)) {
					switch(this.orientation){
						case N: 
							this.y = this.y + 1;
							break;
						case S: 
							this.y = this.y - 1;
							break;
						case E: 
							this.x = this.x + 1;
							break;
						case W: 
							this.x = this.x - 1;
							break;
					}
    	    } else {
    	    	Logger.log("Invalid input!");
    	    }
    	}
	}
	
	@Override
	public String toString() {
    	return "X: " + this.x + ", Y: " + this.y + ", Orientation: " + this.orientation;
	}
}
