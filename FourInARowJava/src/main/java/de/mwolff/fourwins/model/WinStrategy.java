package de.mwolff.fourwins.model;

public class WinStrategy {

	FourWinModel model;

	public WinStrategy(FourWinModel model) {
		this.model = model;
	}

	public char isWin() {
		if (isHorizontalWin() || isVerticalWin() || isDiagonalRightLeftWin()
				|| isDiagonalLeFtRightWin())
			return model.getLastColor();
		return '*';
	}

	private boolean isDiagonalRightLeftWin() {

		// Find left begin
		int coinRow = model.getLastRow();
		int coinColumn = model.getLastColumn();

		try {
			for (;;) {
				coinRow--;
				coinColumn++;
				model.getColor(coinRow, coinColumn);
				if ((coinRow == 0) || (coinColumn == FourWinModel.column)) {
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// End of row
		}

		// count same color
		char currentField = '_';
		int zaehler = 0;
		try {
			for (;;) {
				char current = model.getColor(coinRow++, coinColumn--);
				zaehler = setCorrectCounter(currentField, zaehler, current);
				currentField = current;
				if (zaehler == 4)
					break;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// End of row
		}

		return strategyWins(zaehler);
	}

	private boolean isDiagonalLeFtRightWin() {

		// Find left begin
		int coinRow = model.getLastRow();
		int coinColumn = model.getLastColumn();

		try {
			for (;;) {
				coinRow--;
				coinColumn--;
				model.getColor(coinRow, coinColumn);
				if ((coinRow == 0) || (coinColumn == 0)) {
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//
		}

		// count same color
		char currentField = '_';
		int zaehler = 0;
		try {
			for (;;) {
				char current = model.getColor(coinRow++, coinColumn++);
				zaehler = setCorrectCounter(currentField, zaehler, current);
				currentField = current;
				if (zaehler == 4)
					break;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// End of row
		}

		return strategyWins(zaehler);
	}

	private boolean isVerticalWin() {
		char currentField = '_';
		int zaehler = 0;
		for (int row = 0; row < FourWinModel.row; row++) {
			char current = model.getColor(row, model.getLastColumn());
			zaehler = setCorrectCounter(currentField, zaehler, current);
			currentField = current;
		}
		return strategyWins(zaehler);
	}

	private boolean isHorizontalWin() {
		char currentField = '_';
		int zaehler = 0;
		for (int column = 0; column < FourWinModel.column; column++) {
			char current = model.getColor(model.getLastRow(), column);
			zaehler = setCorrectCounter(currentField, zaehler, current);
			currentField = current;
		}

		return strategyWins(zaehler);
	}

	private boolean strategyWins(int zaehler) {
		return zaehler >= 4;
	}

	private int setCorrectCounter(char currentField, int zaehler, char current) {
		if ((current == currentField) && (current != '*')) {
			zaehler++;
		} else if ((current != currentField) && (current != '*')) {
			zaehler = 1;
		}
		return zaehler;
	}
}
