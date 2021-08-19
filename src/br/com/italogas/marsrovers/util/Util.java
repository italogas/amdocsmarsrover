package br.com.italogas.marsrovers.util;

public class Util {
	
	public static boolean checkInputTokensValidPlateuDimensions(String[] tokens) {		
		if((tokens.length == 2) && isNumeric(tokens[0]) && isNumeric(tokens[1])) {
			return true;
		} 		
		return false;
	}
	
	public static boolean checkInputTokensValidRoverPosition(String[] tokens) {
		if(tokens.length == 3 && isNumeric(tokens[0]) && isNumeric(tokens[1]) && isValidOrientation(tokens[2])) {
			return true;
		} 
		return false;
	}
	
	public static boolean checkInputTokensValidDirections(String[] tokens) {
		if(tokens.length == 1 && isAlpha(tokens[0])) {
			return true;
		} 
		return false;
	}
	
	public static boolean checkOutsideBoundaries(int roverX, int roverY, int upperRightX, int upperRightY) {
		if(roverX <= 0 || roverX >= upperRightX || roverY <= 0 || roverY >= upperRightY) {
			return true;
		} 
		return false;
	}
	
	public static boolean isNumeric(String str) { 
		try {  
			Integer.parseInt(str);  
			return true;
		} catch(NumberFormatException e){  
			return false;  
		}  
	}
	
	public static boolean isValidOrientation(String str) { 
	    if(str.equalsIgnoreCase("N") || str.equalsIgnoreCase("S") || str.equalsIgnoreCase("E") || str.equalsIgnoreCase("W")) {
	    	return true;
	    } 
	    return false;
	}
	
	public static boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
	}
}
