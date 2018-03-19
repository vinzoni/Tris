package tris;

import java.util.Properties;

public class MatchView {

	static final int DISPLAY_MATCH_RESULT_DURATION_MILLIS = 2000;
	static final int DISPLAY_MOVE_DURATION_MILLIS = 1000;

	private Properties properties;
	
	public MatchView(Properties properties) {
		this.properties = properties;
	}
	
	public void displayMatchScore(Player player1, Player player2, int playedGames, int gamesToPlay, 
			int player1Wins, int player2Wins, int drawns) throws InterruptedException {
		System.out.println();
		System.out.println("================================================================");
		System.out.printf("%-20s: %s - %s%n", "Match ", player1.getName(), player2.getName());
		System.out.printf("%-20s: %d/%d%n",  "Partite giocate ", playedGames, gamesToPlay);
		System.out.printf("%s%-11s: %d%n", "Vittorie ", player1.getName(), player1Wins);
		System.out.printf("%-20s: %d%n", "Pareggi", drawns);
		System.out.printf("%s%-11s: %d%n", "Vittorie ", player2.getName(), player2Wins);
		System.out.println("================================================================");
		System.out.println();
		Thread.sleep(DISPLAY_MATCH_RESULT_DURATION_MILLIS);
	}

	public void displayEndOfGameMessage(Board b) {
		System.out.println();
		System.out.println("================================================================");
		if (b.isGameDrawn())
			System.out.println("Partita Pari");
		else
			System.out.println("Vince " + b.getWinner().getName());
		System.out.println("================================================================");
		System.out.println();
	}

	public void displayMovePlayedMessage(Player player, Move move) throws InterruptedException {
		System.out.println(player.getName() + " gioca " + move.toString());
		Thread.sleep(DISPLAY_MOVE_DURATION_MILLIS);

	}
	
	public void displayPlayerToMoveMessage(Player player) {
		System.out.println("Muove " + player.getName());
	}
	
}
