package tris;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Match {

	private Player player1;
	private Player player2;
	private int gamesToPlay;
	private int playedGames = 0;
	private int winPlayer1Games = 0;
	private int winPlayer2Games = 0;
	private int drawnGames = 0;
	
	public int getWinPlayer2Games() {
		return winPlayer2Games;
	}
	public int getWinPlayer1Games() {
		return winPlayer1Games;
	}
	public int getDrawnGames() {
		return drawnGames;
	}
	public Player getPlayer1() {
		return player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public int gamesToPlay() {
		return gamesToPlay;
	}
	public int getPlayedGames() {
		return playedGames;
	}
	
	public Match(Board board, Player p1, Player p2, int games) {
		this.player1 = p1;
		this.player2 = p2;
		this.gamesToPlay = games;
	}

	public Match(Properties configuration) throws FileNotFoundException, IOException {
		player1 = PlayerFactory.getInstance(configuration);
		player2 = PlayerFactory.getInstance(configuration);
		gamesToPlay = Integer.parseInt(configuration.getProperty("match_games"));
	}
	
	public void play() throws InterruptedException {
		if (gamesToPlay == 1) {
			playSingleGame();
			return;
		}
		
		while (playedGames < gamesToPlay) {
			playSingleGame();
			playedGames++;
			TrisUI.displayMatchResult(this);
		}
	}
	
	private void playSingleGame() throws InterruptedException {
		Board board = new Board();
		
		TrisUI.displayBoard(board);
		Player playerToMove = player1;

		while (true) {
			gameTurn(playerToMove, board);

			if (board.isGameOver())
				break;

			playerToMove = (playerToMove == player1 ? player2 : player1);
		}

		TrisUI.displayEndOfGameMessage(board);
		updateScore(board);
	}
	
	private void updateScore(Board board) {
		if (board.getWinner() == null) 
			drawnGames++;
		else if (board.getWinner().equals(player1))
			winPlayer1Games++;
		else 
			winPlayer2Games++;
	}
	
	private void gameTurn(Player player, Board board) throws InterruptedException {
		TrisUI.displayPlayerToMoveMessage(player);
		Move m = player.play(board);
		TrisUI.displayMovePlayedMessage(player, m);
		board.update(m);
		TrisUI.displayBoard(board);
	}

}
