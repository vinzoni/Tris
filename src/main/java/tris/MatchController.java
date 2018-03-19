package tris;

public class MatchController {

	private Match model;
	private MatchView view;
	
	public MatchController(Match model, MatchView view) {
		this.model = model;
		this.view = view;
		model.subscribe(this);
	}
	
	public void notifyGameEnd(
			Player player1, 
			Player player2,
			Board board,
			int playedGames, 
			int gamesToPlay, 
			int winPlayer1Games, 
			int winPlayer2Games, 
			int drawnGames) throws InterruptedException {
		view.displayEndOfGameMessage(board);
		view.displayMatchScore(player1, player2, 
		playedGames, gamesToPlay, winPlayer1Games, winPlayer2Games, drawnGames);
}
//	public void notifyGameEnd(
//					MatchScore score,
//					Board board
//					) throws InterruptedException {
//		view.displayEndOfGameMessage(board);
//		view.displayMatchScore(player1, player2, 
//				playedGames, gamesToPlay, winPlayer1Games, winPlayer2Games, drawnGames);
//	}

	public void notifyGameStart(BoardController boardController) throws InterruptedException {
		boardController.notifyGameStart();
	}
 
	public void notifyMovePlayed(Player player, Move move) throws InterruptedException {
		view.displayMovePlayedMessage(player, move);
	}

	public void notifyPlayerOnTheMove(Player player) throws InterruptedException {
		view.displayPlayerToMoveMessage(player);
	}
}
