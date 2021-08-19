package br.com.italogas.marsrovers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import br.com.italogas.marsrovers.entities.Plateau;
import br.com.italogas.marsrovers.entities.Rover;
import br.com.italogas.marsrovers.util.Logger;
import br.com.italogas.marsrovers.util.Util;

/**
 * App main loop
 * @author italo.guedes.a.silva
 *
 */
public class Main {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		if(args.length > 0) {
			System.out.println("Reading from file: " + args[0]); // will print the variable
			File file = new File(args[0]);
			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		if(br == null) {
			// input from command line for tests
	        br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		// input from command line for tests
        //br = new BufferedReader(new InputStreamReader(System.in));
        
        String line;
        boolean firstInput = true;
        boolean roverPositionInput = false;
        
        Plateau pla = new Plateau();
        Rover r = new Rover();
        
        try {
        	// user must type 'end' to finish execution in case of cli
            while (!(line = br.readLine()).equalsIgnoreCase("end"))
            {
                String[] tokens = line.split("\\s");

                if(firstInput && Util.checkInputTokensValidPlateuDimensions(tokens)) {
                	pla.setWidth(Integer.parseInt(tokens[0]));
                	pla.setHeight(Integer.parseInt(tokens[1]));
                	firstInput = false;
                	roverPositionInput = true;
                	Logger.log("Plateu dimensions: upper right X: " + pla.getWidth() + ", upper right Y: " + pla.getHeight());
                } else if(roverPositionInput && Util.checkInputTokensValidRoverPosition(tokens)) {
                	r = new Rover();
                	r.setX(Integer.parseInt(tokens[0]));
                	r.setY(Integer.parseInt(tokens[1]));
                	r.setOrientation(tokens[2]);
                	pla.addRover(r);
                	roverPositionInput = false;
                	Logger.log("Rover X: " + r.getX() + ", Rover Y: " + r.getY() + ", Orientation: " + r.getOrientation());
                } else if(!firstInput && !roverPositionInput && Util.checkInputTokensValidDirections(tokens)) {
                	//do calc here
                	String[] directions = tokens[0].split("(?!^)");
                	r.move(directions);
                	roverPositionInput = true;
                } else {
                	System.out.println("Invalid input! ");
                }
            }
            Logger.log(pla.toString());
            List<Rover> rovers = pla.getRovers();
            for(Rover rover : rovers) { 
            	System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getOrientation());
        	}
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}

}
