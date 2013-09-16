package de.mwolff.fourwins.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestModel {

	private FourWinModel model = new FourWinModel();

	/*
	 * Ziel: Einen Stein in eine bestimmte Reihe legen (in diesem Fall die erste
	 * ganz unten). L�uft dieser Test gr�n, sollte jede Spalte in Reihe 1
	 * getestet sein, sprich der Test gr�n laufen. Es werden keine Tests
	 * implementiert, bei denen der Test gr�n l�uft.
	 */
	@Test
	public void testMoveColumnOne() throws Exception {
		model.setCoin('R', 1);
		assertTrue(model.isCoin('R', 1, 1));
	}

	/*
	 * Ziel: Zwei Steine in die gleiche Spalte legen. Der Stein sollte dann ganz
	 * nach unten fallen.
	 */
	@Test
	public void testMoveTwoInOneColumn() throws Exception {
		model.setCoin('R', 1);
		model.setCoin('R', 1);
		assertTrue(model.isCoin('R', 2, 1));
	}

	/*
	 * Ziel: Fehler bei ung�ltiger Spalte.
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testInvalidColumn() throws Exception {
		model.setCoin('R', 0);
	}

}
