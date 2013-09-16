package de.mwolff.fourwins.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFourWinsController {

	private FourWinsController controller = new FourWinsController();

	@Test
	public void testFirstMoveRed() {
		assertEquals("Gelb ist an der Reihe", controller.move("Rot", 1));
	}

	@Test
	public void testFirstMoveYellow() throws Exception {
		assertEquals("Rot ist an der Reihe", controller.move("Gelb", 1));
	}

	@Test
	public void testWonRed() throws Exception {
		assertEquals("Gelb ist an der Reihe", controller.move("Red", 1));
		assertEquals("Rot ist an der Reihe", controller.move("Gelb", 1));
		assertEquals("Gelb ist an der Reihe", controller.move("Red", 2));
		assertEquals("Rot ist an der Reihe", controller.move("Gelb", 2));
		assertEquals("Gelb ist an der Reihe", controller.move("Red", 3));
		assertEquals("Rot ist an der Reihe", controller.move("Gelb", 3));
		assertEquals("Rot hat gewonnen.", controller.move("Red", 4));
	}

	@Test
	public void testWonYellow() throws Exception {
		assertEquals("Rot ist an der Reihe", controller.move("Gelb", 1));
		assertEquals("Gelb ist an der Reihe", controller.move("Red", 1));
		assertEquals("Rot ist an der Reihe", controller.move("Gelb", 2));
		assertEquals("Gelb ist an der Reihe", controller.move("Red", 2));
		assertEquals("Rot ist an der Reihe", controller.move("Gelb", 3));
		assertEquals("Gelb ist an der Reihe", controller.move("Red", 3));
		assertEquals("Gelb hat gewonnen.", controller.move("Gelb", 4));
	}
	
	
	@Test
	public void testComplicatedGame() throws Exception {
		String message = controller.move("Red", 3);
		printOut(message);
	
		message = controller.move("Gelb", 4);
		printOut(message);

		message = controller.move("Red", 4);
		printOut(message);

		message = controller.move("Gelb", 3);
		printOut(message);

		message = controller.move("Red", 4);
		printOut(message);

		message = controller.move("Gelb", 5);
		printOut(message);

		message = controller.move("Red", 3);
		printOut(message);

		message = controller.move("Gelb", 4);
		printOut(message);

		message = controller.move("Red", 5);
		printOut(message);

		message = controller.move("Gelb", 5);
		printOut(message);

		message = controller.move("Red", 6);
		printOut(message);

		message = controller.move("Gelb", 3);
		printOut(message);

		message = controller.move("Red", 6);
		printOut(message);

		message = controller.move("Gelb", 2);
		printOut(message);

		message = controller.move("Red", 6);
		printOut(message);

		message = controller.move("Gelb", 6);
		printOut(message);

		message = controller.move("Red", 5);
		printOut(message);

		message = controller.move("Gelb", 7);
		printOut(message);

		message = controller.move("Red", 7);
		printOut(message);
	}

	private void printOut(String message) {
		System.out.println(controller.toString());
		System.out.println(message);
		System.out.println("");
		System.out.println("");
	}
}
