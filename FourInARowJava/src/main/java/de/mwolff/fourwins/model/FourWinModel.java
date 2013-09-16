package de.mwolff.fourwins.model;

public class FourWinModel {

	public static final int column = 7;
	public static final int row = 6;
	private char[][] field = new char[row][column];

	private int lastRow = -1;
	private int lastColumn = -1;
	private char lastColor = '*';

	public FourWinModel() {
		for (int rowCount = 0; rowCount < row; rowCount++) {
			for (int columnCount = 0; columnCount < column; columnCount++) {
				field[rowCount][columnCount] = '*';
			}
		}
	}

	public void setCoin(char color, int column) {
		int row = getNextRowEmpty(column);
		setField(color, column, row);
	}

	public boolean isCoin(char color, int row, int column) {
		return field[row - 1][column - 1] == color;
	}

	private void setField(char color, int column, int row) {
		field[row][column - 1] = color;
		lastRow = row;
		lastColumn = column - 1;
		lastColor = color;
	}

	private int getNextRowEmpty(int column) {
		int i = 0;
		while (i < row) {
			if (field[i][column - 1] == '*')
				break;
			i++;
		}
		return i;
	}

	public int getLastRow() {
		return lastRow;
	}

	public int getLastColumn() {
		return lastColumn;
	}

	public char getLastColor() {
		return lastColor;
	}

	public char getColor(int row, int column) {
		return field[row][column];
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		
	    for (int r = row - 1; r >= 0; r--) {
	    	for (int col = 0; col < column; col++) {
	    		result.append(field[r][col]);
	    	}
	    	result.append("\n");
	    }
		return result.toString();
	}
}
