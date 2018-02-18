package tris;

public class Move {

	private Player player;
	private String move;
	
	public Move(Player player, String move) {
		this.player = player;
		this.move = move;
	}
	
	public Player player() {
		return player;
	}
	
	public char symbol() {
		return player.getSymbol();
	}
	
	public String toString() {
		return move;
	}
	
//	public int row() {
//		return (int) ('3' - move.charAt(1));
//	}
//	
//	public int col() {
//		return (int) (move.charAt(0) - 'a');
//	}
	
}
