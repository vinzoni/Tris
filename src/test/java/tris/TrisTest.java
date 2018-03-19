package tris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TrisTest {
	
	Board board = new Board();
	final Player player1 = new TestingPlayer("Bob", 'X');
	final Player player2 = new TestingPlayer("Alice", '0');
	
	@Test
	public void drawEmptyBoard() throws InterruptedException {
		BoardView view = new BoardView();
		view.display(board);
	}

	@Test
	public void playAMove() {
		player1.play(board);
	}

	@Test
	public void updateBoard() throws InterruptedException {
		Move m = new Move(player1, "a1");
		board.update(m);
	}

	@Test
	public void noWinner() throws InterruptedException {
		Move m = new Move(player1, "a1");
		board.update(m);
		assertNull(board.getWinner());
	}

	@Test
	public void playerWonOnFirstRow() throws InterruptedException {
		board.update(new Move(player1, "a3"));
		board.update(new Move(player1, "b3"));
		board.update(new Move(player1, "c3"));
		assertEquals(player1, board.getWinner());
		assertTrue(board.isGameOver());
	}

	@Test
	public void playerWonOnSecondRow() throws InterruptedException {
		board.update(new Move(player1, "a2"));
		board.update(new Move(player1, "b2"));
		board.update(new Move(player1, "c2"));
		assertEquals(player1, board.getWinner());
		assertTrue(board.isGameOver());
	}

	@Test
	public void playerWonOnThirdRow() throws InterruptedException {
		board.update(new Move(player1, "a1"));
		board.update(new Move(player1, "b1"));
		board.update(new Move(player1, "c1"));
		assertEquals(player1, board.getWinner());
		assertTrue(board.isGameOver());
	}
	
	@Test
	public void playerWonOnFirstCol() throws InterruptedException {
		board.update(new Move(player1, "a1"));
		board.update(new Move(player1, "a2"));
		board.update(new Move(player1, "a3"));
		assertEquals(player1, board.getWinner());
		assertTrue(board.isGameOver());
	}

	@Test
	public void playerWonOnFirstDiagonal() throws InterruptedException {
		board.update(new Move(player1, "a3"));
		board.update(new Move(player1, "b2"));
		board.update(new Move(player1, "c1"));
		assertEquals(player1, board.getWinner());
		assertTrue(board.isGameOver());
	}

	@Test
	public void playerWonOnSecondDiagonal() throws InterruptedException {
		board.update(new Move(player1, "a1"));
		board.update(new Move(player1, "b2"));
		board.update(new Move(player1, "c3"));
		assertEquals(player1, board.getWinner());
		assertTrue(board.isGameOver());
	}

	@Test
	public void noGameOver() throws InterruptedException {
		Move m = new Move(player1, "a1");
		board.update(m);
		assertTrue(!board.isGameOver());
	}

	@Test
	public void gameDrawn() throws InterruptedException {
		board.update(new Move(player1, "a1"));
		board.update(new Move(player2, "b2"));
		board.update(new Move(player1, "a3"));
		board.update(new Move(player2, "a2"));
		board.update(new Move(player1, "b1"));
		board.update(new Move(player2, "b3"));
		board.update(new Move(player1, "c2"));
		board.update(new Move(player2, "c1"));
		board.update(new Move(player1, "c3"));
		assertTrue(board.isGameDrawn());
		assertTrue(board.isGameOver());
	}
}

class TestingPlayer extends Player {

	TestingPlayer(String name, char symbol) {
		super(name, symbol);
	}
	
	public Move play(Board board) {
		return new Move(this, "a1");
	}
}


