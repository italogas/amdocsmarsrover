package com.italogas.marsrovers.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.italogas.marsrovers.entities.Orientation;
import br.com.italogas.marsrovers.entities.Plateau;
import br.com.italogas.marsrovers.entities.Rover;

class AppTest {
	
	Plateau pla = new Plateau(5, 5);
	Rover r = new Rover(1, 2, Orientation.N);

	@Test
	void testRotation() {		
		String[] moves = {"R","R","R","R"};
		// full rotation
		r.move(moves);
		assertEquals(Orientation.N.toString(), r.getOrientation());
	}
	
	@Test
	void testReverseRotation() {
		String[] movesReverse = {"L","L","L","L"};
		// full reverse rotation
		r.move(movesReverse);
		assertEquals(Orientation.N.toString(), r.getOrientation());
	}
	
	@Test
	void testMovementRight() {
		String[] movesRight = {"R","M"};
		// full reverse rotation
		r.move(movesRight);
		assertEquals(2, r.getX());
	}
	
	@Test
	void testMovementLeft() {
		String[] movesLeft = {"L","M"};
		// full reverse rotation
		r.move(movesLeft);
		assertEquals(0, r.getX());
	}

}
