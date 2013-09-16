namespace FourInARow.Tests
{
	using System;
	using NUnit.Framework;

	/// <summary>The game tests.</summary>
	[TestFixture]
	public class GameTests
	{
		private Game game;

		/// <summary>The set up.</summary>
		[SetUp]
		public void SetUp()
		{
			this.game = new Game();
		}

		/// <summary>The create game test.</summary>
		[Test]
		public void CreateGameTest()
		{
			Game newGame = new Game();
			Assert.IsNotNull(newGame);
		}

		/// <summary>The make move test.</summary>
		[Test]
		public void MakeMoveTest()
		{
			bool hasWon = this.game.MakeMove(1, 0);

			Assert.IsFalse(hasWon);
		}

		/// <summary>The four in a column wins the game.</summary>
		[Test]
		public void FourInAColumnWinsTheGame()
		{
			Assert.IsFalse(this.game.MakeMove(1, 0));
			Assert.IsFalse(this.game.MakeMove(2, 1));
			Assert.IsFalse(this.game.MakeMove(1, 0));
			Assert.IsFalse(this.game.MakeMove(2, 1));
			Assert.IsFalse(this.game.MakeMove(1, 0));
			Assert.IsFalse(this.game.MakeMove(2, 1));
			Assert.IsTrue(this.game.MakeMove(1, 0));
		}

		/// <summary>The four in a row wins the game.</summary>
		[Test]
		public void FourInARowWinsTheGame()
		{
			Assert.IsFalse(this.game.MakeMove(1, 0));
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.IsFalse(this.game.MakeMove(1, 1));
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.IsFalse(this.game.MakeMove(1, 2));
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.IsTrue(this.game.MakeMove(1, 3));
		}

		/// <summary>The four in a row w wont win because of different player.</summary>
		[Test]
		public void FourInARowWWontWinBecauseOfDifferentPlayer()
		{
			Assert.IsFalse(this.game.MakeMove(1, 0));
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.IsFalse(this.game.MakeMove(1, 1));
			Assert.IsFalse(this.game.MakeMove(2, 2));
			Assert.IsFalse(this.game.MakeMove(1, 3));
		}

		/// <summary>The four in a row wins from right.</summary>
		[Test]
		public void FourInARowWinsFromRight()
		{
			Assert.IsFalse(this.game.MakeMove(1, 6));
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.IsFalse(this.game.MakeMove(1, 5));
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.IsFalse(this.game.MakeMove(1, 4));
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.IsTrue(this.game.MakeMove(1, 3));
		}

		/// <summary>The four in a diagonal line from left down to right up wins from right.</summary>
		[Test]
		public void FourInADiagonalLineFromLeftDownToRightUpWinsFromRight()
		{
			Assert.IsFalse(this.game.MakeMove(1, 0));
			Assert.IsFalse(this.game.MakeMove(2, 1));
			Assert.IsFalse(this.game.MakeMove(1, 1));
			Assert.IsFalse(this.game.MakeMove(2, 2));
			Assert.IsFalse(this.game.MakeMove(1, 6));
			Assert.IsFalse(this.game.MakeMove(2, 2));
			Assert.IsFalse(this.game.MakeMove(1, 2));
			Assert.IsFalse(this.game.MakeMove(2, 3));
			Assert.IsFalse(this.game.MakeMove(1, 6));
			Assert.IsFalse(this.game.MakeMove(2, 3));
			Assert.IsFalse(this.game.MakeMove(1, 6));
			Assert.IsFalse(this.game.MakeMove(2, 3));
			Assert.IsTrue(this.game.MakeMove(1, 3));
		}

		/// <summary>The four in a diagonal line from left up to right down wins from right.</summary>
		[Test]
		public void FourInADiagonalLineFromLeftUpToRightDownWinsFromRight()
		{
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.IsFalse(this.game.MakeMove(1, 6));
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.IsFalse(this.game.MakeMove(1, 6));
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.IsFalse(this.game.MakeMove(1, 0));
			Assert.IsFalse(this.game.MakeMove(2, 1));
			Assert.IsFalse(this.game.MakeMove(1, 6));
			Assert.IsFalse(this.game.MakeMove(2, 1));
			Assert.IsFalse(this.game.MakeMove(1, 1));
			Assert.IsFalse(this.game.MakeMove(2, 2));
			Assert.IsFalse(this.game.MakeMove(1, 2));
			Assert.IsFalse(this.game.MakeMove(2, 6));
			Assert.IsTrue(this.game.MakeMove(1, 3));
		}

		/// <summary>The player cannot throw twice.</summary>
		[Test]
		public void PlayerCannotThrowTwice()
		{
			Assert.IsFalse(this.game.MakeMove(1, 0));
			Assert.Throws<InvalidOperationException>(() => this.game.MakeMove(1, 0), 
				"Player is not allowed to make another move.");
		}

		/// <summary>The cannot play with three players.</summary>
		[Test]
		public void CannotPlayWithThreePlayers()
		{
			Assert.IsFalse(this.game.MakeMove(1, 0));
			Assert.IsFalse(this.game.MakeMove(2, 0));
			Assert.Throws<InvalidOperationException>(() => this.game.MakeMove(3, 0), 
				"Only players 1 and 2 are allowed.");
		}

		/// <summary>The cannot throw into column with index seven.</summary>
		[Test]
		public void CannotThrowIntoColumnWithIndexSeven()
		{
			Assert.Throws<InvalidOperationException>(() => this.game.MakeMove(1, 7), 
				"Move is invalid.");
		}

		/// <summary>The cannot throw into same column seven times.</summary>
		[Test]
		public void CannotThrowIntoSameColumnSevenTimes()
		{
			this.game.MakeMove(1, 0);
			this.game.MakeMove(2, 0);
			this.game.MakeMove(1, 0);
			this.game.MakeMove(2, 0);
			this.game.MakeMove(1, 0);
			this.game.MakeMove(2, 0);
			Assert.Throws<InvalidOperationException>(() => this.game.MakeMove(1, 0), 
				"Move is invalid.");
		}
	}
}