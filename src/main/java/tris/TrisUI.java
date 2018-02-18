package tris;

import java.util.Scanner;

public class TrisUI {
	static public Move readMove(Player player) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci la tua mossa (es. a2): ");
		String move = sc.nextLine();
		return new Move(player, move);
	}

	static public void displayBoard(Board b) throws InterruptedException {
		b.display();
		Thread.sleep(1000);
	}
	
	static public void displayPlayerToMoveMessage(Player player) {
		System.out.println("Tocca a " + player.getName());
	}

	static public void displayMovePlayedMessage(Player player, Move move) throws InterruptedException {
		System.out.println(player.getName() + " gioca " + move.toString());
		Thread.sleep(1000);
	}

	static public void displayMatchResult(Match match) throws InterruptedException {
		System.out.println();
		System.out.println("================================================================");
		System.out.printf("%-20s: %s - %s%n", "Match ", match.getPlayer1().getName(), match.getPlayer2().getName());
		System.out.printf("%-20s: %d/%d%n",  "Partite giocate ", match.getPlayedGames(), match.gamesToPlay());
		System.out.printf("%s%-11s: %d%n", "Vittorie ", match.getPlayer1().getName(), match.getWinPlayer1Games());
		System.out.printf("%-20s: %d%n", "Pareggi", match.getDrawnGames());
		System.out.printf("%s%-11s: %d%n", "Vittorie ", match.getPlayer2().getName(), match.getWinPlayer2Games());
		System.out.println("================================================================");
		System.out.println();
		Thread.sleep(2000);
	}
	
	static public void displayEndOfGameMessage(Board b) {
		System.out.println();
		System.out.println("================================================================");
		if (b.isGameDrawn())
			System.out.println("Partita Pari");
		else
			System.out.println("Vince " + b.getWinner().getName() + ", complimenti!");
		System.out.println("================================================================");
		System.out.println();
	}
}
