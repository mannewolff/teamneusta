namespace FourInARow.Tests
{
	using NUnit.Framework;

	/// <summary>The board tests.</summary>
	[TestFixture]
	public class BoardTests
	{
		private Board board;

		/// <summary>The set up.</summary>
		[SetUp]
		public void SetUp()
		{
			this.board = new Board();
		}

		/// <summary>The create board test.</summary>
		[Test]
		public void CreateBoardTest()
		{
			Board newBoard = new Board();
			Assert.IsNotNull(newBoard);
		}

		/// <summary>The throw into first column.</summary>
		[Test]
		public void ThrowIntoFirstColumn()
		{
			int row = this.board.ThrowIntoColumn(1, 0);

			Assert.AreEqual(row, 0);
		}

		/// <summary>The throw into first column twice.</summary>
		[Test]
		public void ThrowIntoFirstColumnTwice()
		{
			int firstThrow = this.board.ThrowIntoColumn(1, 0);
			int secondThrow = this.board.ThrowIntoColumn(2, 0);

			Assert.AreEqual(0, firstThrow);
			Assert.AreEqual(1, secondThrow);
		}

		/// <summary>The get value from board.</summary>
		[Test]
		public void GetValueFromBoard()
		{
			int value = this.board[0, 0];

			Assert.AreEqual(0, value);
		}

		/// <summary>The get value from board after throw.</summary>
		[Test]
		public void GetValueFromBoardAfterThrow()
		{
			int row = this.board.ThrowIntoColumn(1, 0);
			int value = this.board[0, row];

			Assert.AreEqual(0, row);
			Assert.AreEqual(1, value);
		}
	}
}