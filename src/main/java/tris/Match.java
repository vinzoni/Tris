package tris;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Match {

	private Player player1;
	private Player player2;
	private int gamesToPlay = 0;
	private int playedGames = 0;
	private int winPlayer1Games = 0;
	private int winPlayer2Games = 0;
	private int drawnGames = 0;
	private MatchController controller = null;
	private BoardController bcontroller = null;
	
	public void subscribe(MatchController controller) {
		this.controller = controller;
	}
	
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
	
	public Match(Properties configuration) throws FileNotFoundException, IOException {
		player1 = PlayerFactory.getInstance(configuration);
		player2 = PlayerFactory.getInstance(configuration);
		gamesToPlay = Integer.parseInt(configuration.getProperty("match_games"));
	}
	
	public void play() throws InterruptedException {
		while (playedGames < gamesToPlay) {
			Board board = playSingleGame();
			playedGames++;
			if (controller != null) controller.notifyGameEnd(player1, player2, board, playedGames, gamesToPlay, winPlayer1Games, winPlayer2Games, drawnGames);
		}
	}
	
	private Board playSingleGame() throws InterruptedException {
		Board board = TrisFactory.getBoardInstance();
		
		if (bcontroller != null) bcontroller.notifyGameStart();
		
		Player playerToMove = player1;

		while (true) {
			gameTurn(playerToMove, board);

			if (board.isGameOver())
				break;

			playerToMove = (playerToMove == player1 ? player2 : player1);
		}

		updateScore(board);
		return board;
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
		if (controller != null) controller.notifyPlayerOnTheMove(player);
		Move m = player.play(board);
		if (controller != null) controller.notifyMovePlayed(player, m);
		board.update(m);
	}

}
