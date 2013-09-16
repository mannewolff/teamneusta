package de.mwolff.fourwins.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStrategy {

	private FourWinModel model = new FourWinModel();
	private WinStrategy win = new WinStrategy(model);

	/*
	 * Ziel: Gewinnstrategie - Horizentaler Gewinn
	 */
	@Test
	public void testWinsFourInARowPerStrategys() throws Exception {
		model.setCoin('R', 2);
		model.setCoin('R', 3);
		model.setCoin('R', 4);
		model.setCoin('R', 5);
		assertEquals('R', win.isWin());
	}

	/*
	 * Ziel: Gewinnstrategie - Vertikalerr Gewinn
	 */
	@Test
	public void testWinsFourInAColumnPerStrategys() throws Exception {
		model.setCoin('R', 3);
		model.setCoin('R', 3);
		model.setCoin('R', 3);
		model.setCoin('R', 3);
		assertEquals('R', win.isWin());
	}

	/*
	 * Ziel: Gewinnstrategie - Diagonaler Gewinn von links unten nach rechts
	 * oben
	 */
	@Test
	public void testWinsFourInDiagonalLuNachRoPerStrategys() throws Exception {
		model.setCoin('R', 2);
		model.setCoin('G', 3);
		model.setCoin('R', 3);
		model.setCoin('G', 4);
		model.setCoin('G', 4);
		model.setCoin('R', 4);
		model.setCoin('G', 5);
		model.setCoin('G', 5);
		model.setCoin('G', 5);
		model.setCoin('R', 5);
		assertEquals('R', win.isWin());
	}

	/*
	 * Ziel: Gewinnstrategie - Diagonaler Gewinn von rechts unten nach links
	 * oben
	 */
	@Test
	public void testWinsFourInDiagonalReNachLiPerStrategys() throws Exception {
		model.setCoin('R', 6);
		model.setCoin('G', 5);
		model.setCoin('R', 5);
		model.setCoin('G', 4);
		model.setCoin('G', 4);
		model.setCoin('R', 4);
		model.setCoin('G', 3);
		model.setCoin('G', 3);
		model.setCoin('G', 3);
		model.setCoin('R', 3);
		assertEquals('R', win.isWin());
	}
}
