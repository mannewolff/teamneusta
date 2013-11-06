package de.neusta.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	private Game game = new Game();

	@Test
	public void testInitialPlayerYellow() {
		assertEquals("Player yellow to move.", game.status());
	}

	@Test
	public void testFirtMoveAnPlayerRedToGo() throws Exception {
		game.move(1);
		assertEquals("Player red to move.", game.status());
	}

	@Test
	public void testVerticalWin() throws Exception {
		playSequence(new int[] { 1, 2, 1, 2, 1, 2, 1 });
		assertEquals("Player yellow won.", game.status());
	}

	private void playSequence(int[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			game.move(sequence[i]);
		}
	}

	@Test
	public void testSimpleHorizontalWinRed() throws Exception {
		playSequence(new int[] { 6, 1, 1, 2, 2, 3, 3, 4 });
		assertEquals("Player red won.", game.status());
	}

	@Test
	public void testHorizontalWin() throws Exception {
		playSequence(new int[] { 1, 1, 3, 3, 4, 4, 2 });
		assertEquals("Player yellow won.", game.status());
	}

	@Test
	public void testDiagonalWinUp() throws Exception {
		playSequence(new int[] { 1, 2, 2, 1, 3, 3, 4, 4, 4, 1, 4, 2, 3 });
		assertEquals("Player yellow won.", game.status());
	}

	@Test
	public void testDiagonalWinDown() throws Exception {
		playSequence(new int[] { 4, 3, 3, 4, 2, 2, 1, 1, 1, 4, 1, 3, 2 });
	}

}
