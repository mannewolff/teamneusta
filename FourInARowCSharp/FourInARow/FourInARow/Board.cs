namespace FourInARow
{
	/// <summary>The board.</summary>
	public class Board
	{
		private const int Columns = 7;
		private const int Rows = 6;
		private readonly int[,] board = new int[Columns, Rows];

		/// <summary>The this.</summary>
		/// <param name="column">The column.</param>
		/// <param name="row">The row.</param>
		/// <returns>The <see cref="int"/>.</returns>
		public int this[int column, int row]
		{
			get
			{
				int value;
				if (column >= 0 && column < Columns && row >= 0 && row < Rows)
				{
					value = this.board[column, row];
				}
				else
				{
					value = -1;
				}

				return value;
			}

			private set
			{
				if (column >= 0 && column < Columns && row >= 0 && row < Rows)
				{
					this.board[column, row] = value;
				}
			}
		}

		/// <summary>The throw into column.</summary>
		/// <param name="player">The player.</param>
		/// <param name="column">The column.</param>
		/// <returns>The <see cref="int"/>.</returns>
		public int ThrowIntoColumn(int player, int column)
		{
			int row = 0;

			int value = this[column, row];
			while (value != 0)
			{
				row++;
				value = this[column, row];

				if (value == -1)
				{
					row = -1;
					break;
				}
			}

			this[column, row] = player;

			return row;
		}
	}
}