namespace FourInARow
{
	using System;

	/// <summary>The game.</summary>
	public class Game
	{
		private readonly Board board = new Board();
		private int lastPlayer;

		/// <summary>The make move.</summary>
		/// <param name="player">The player.</param>
		/// <param name="column">The column.</param>
		/// <returns>The <see cref="bool"/>.</returns>
		/// <exception cref="InvalidOperationException">Thrown if player throws twice, an invalid players throws or the move was not possible.</exception>
		public bool MakeMove(int player, int column)
		{
			if (player < 1 || player > 2)
			{
				throw new InvalidOperationException("Only players 1 and 2 are allowed.");
			}

			if (this.lastPlayer == player)
			{
				throw new InvalidOperationException("Player is not allowed to make another move.");
			}

			this.lastPlayer = player;

			int row = this.board.ThrowIntoColumn(player, column);

			if (row == -1)
			{
				throw new InvalidOperationException("Move is invalid.");
			}

			return this.PlayerHasWon(player, column, row);
		}

		/// <summary>The player has won.</summary>
		/// <param name="player">The player.</param>
		/// <param name="column">The column.</param>
		/// <param name="row">The row.</param>
		/// <returns>The <see cref="bool"/>.</returns>
		private bool PlayerHasWon(int player, int column, int row)
		{
			bool hasWon = false;
			if (this.board[column, row] == player)
			{
				hasWon = this.CheckHorizontal(player, column, row) ||
					this.CheckVertical(player, column, row) ||
					this.CheckDiagonal(player, column, row);
			}

			return hasWon;
		}

		/// <summary>The check diagonal.</summary>
		/// <param name="player">The player.</param>
		/// <param name="column">The column.</param>
		/// <param name="row">The row.</param>
		/// <returns>The <see cref="bool"/>.</returns>
		private bool CheckDiagonal(int player, int column, int row)
		{
			bool enoughChips = false;

			int chipsLeftDown = this.CountChips(player, column, row, -1, -1, 0);
			int chipsRightUp = this.CountChips(player, column, row, 1, 1, 0);

			if (chipsLeftDown + chipsRightUp < 3)
			{
				int chipsLeftUp = this.CountChips(player, column, row, -1, 1, 0);
				int chipsRightDown = this.CountChips(player, column, row, 1, -1, 0);

				enoughChips = chipsLeftUp + chipsRightDown >= 3;
			}
			else
			{
				enoughChips = true;
			}

			return enoughChips;
		}

		/// <summary>The check vertical.</summary>
		/// <param name="player">The player.</param>
		/// <param name="column">The column.</param>
		/// <param name="row">The row.</param>
		/// <returns>The <see cref="bool"/>.</returns>
		private bool CheckVertical(int player, int column, int row)
		{
			int chipsDown = this.CountChips(player, column, row, 0, -1, 0);
			int chipsUp = this.CountChips(player, column, row, 0, 1, 0);

			return chipsUp + chipsDown >= 3;
		}

		/// <summary>The check horizontal.</summary>
		/// <param name="player">The player.</param>
		/// <param name="column">The column.</param>
		/// <param name="row">The row.</param>
		/// <returns>The <see cref="bool"/>.</returns>
		private bool CheckHorizontal(int player, int column, int row)
		{
			int chipsLeft = this.CountChips(player, column, row, -1, 0, 0);
			int chipsRight = this.CountChips(player, column, row, 1, 0, 0);

			return chipsLeft + chipsRight >= 3;
		}

		/// <summary>The count chips.</summary>
		/// <param name="player">The player.</param>
		/// <param name="column">The column.</param>
		/// <param name="row">The row.</param>
		/// <param name="deltaColumn">The delta column.</param>
		/// <param name="deltaRow">The delta row.</param>
		/// <param name="chips">The chips.</param>
		/// <returns>The <see cref="int"/>.</returns>
		private int CountChips(int player, int column, int row, int deltaColumn, int deltaRow, int chips)
		{
			column += deltaColumn;
			row += deltaRow;

			return this.board[column, row] != player 
				? chips 
				: this.CountChips(player, column, row, deltaColumn, deltaRow, ++chips);
		}
	}
}