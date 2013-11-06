package de.neusta.kata;

public class Game {

	private static final int EMPTY = 0;
	private static final int WINRANGE = 4;
	private static final int ROW = 7;
	private static final int COLUMN = 6;
	private static final int RED = 2;
	private static final int YELLOW = 1;
	private int player = YELLOW;
	private int[][] board = new int[COLUMN][ROW];
	private int counter;

	public String status() {
		if (counter >= WINRANGE) {
			return printWinnerStatus();
		} else
			return printPlayerStatus();
	}

	public void move(int column) {

		int realColumn = column - 1;
		int row = findNextFreeRow(realColumn);
		setStone(realColumn, row);

		verticalWin(realColumn, row);

		if (counter < 4) {
			horizontalWin(realColumn, row);
		}

		if (counter < 4) {
			diagonalWinUp(realColumn, row);
		}

		if (counter < 4) {
			diagonalWinDown(realColumn, row);
		}
		switchPlayer();
	}

	private void diagonalWinDown(int realColumn, int row) {
		counter = 1;
		counter += isWin(realColumn - 1, row - 1, 0, +1, +1);
		counter += isWin(realColumn + 1, row + 1, 0, -1, -1);
	}

	private void diagonalWinUp(int realColumn, int row) {
		counter = 1;
		counter += isWin(realColumn - 1, row - 1, 0, -1, -1);
		counter += isWin(realColumn + 1, row + 1, 0, +1, +1);
	}

	private void horizontalWin(int column, int row) {
		counter = 1;
		counter += isWin(column - 1, row, 0, -1, 0);
		counter += isWin(column + 1, row, 0, +1, 0);
	}

	private void verticalWin(int column, int row) {
		counter = isWin(column, row, 0, 0, -1);
	}

	private int isWin(int column, int row, int actCounter, int directx,
			int directy) {
		int myCounter = actCounter;
		if ((row == -1) || (column == -1) || (row == ROW) || (column == COLUMN))
			return myCounter;
		if (board[column][row] == player)
			myCounter++;
		else
			return myCounter;
		return isWin(column + directx, row + directy, myCounter, directx,
				directy);
	}

	private String printWinnerStatus() {
		if (player == YELLOW)
			return "Player red won.";
		else
			return "Player yellow won.";
	}

	private void switchPlayer() {
		if (player == YELLOW)
			player = RED;
		else
			player = YELLOW;
	}

	private String printPlayerStatus() {
		return (player == YELLOW) ? "Player yellow to move."
				: "Player red to move.";
	}

	private void setStone(int column, int row) {
		board[column][row] = player;
	}

	private int findNextFreeRow(int column) {
		int row;
		for (row = 0; row < ROW; row++) {
			if (board[column][row] == EMPTY)
				break;
		}
		return row;
	}

}
