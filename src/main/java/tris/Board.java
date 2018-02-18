package tris;

import java.util.ArrayList;
import java.util.List;

public class Board {
	static private final int LEN = 3;
	char [][] board = new char[LEN][LEN];
	int moveCounter = 0;
	Move lastMovePlayed = null;
	
	Board() {
		for (int i=0; i<LEN; ++i) {
			for (int j=0; j<LEN; ++j) {
				board[j][i] = ' ';
			}
		}
	}
	
	public void display() {
		System.out.println();
		System.out.println("                   ");
		System.out.println(" 3   " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "  ");
		System.out.println("    --- --- --- ");
		System.out.println(" 2   " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "  ");
		System.out.println("    --- --- --- ");
		System.out.println(" 1   " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "  ");
		System.out.println("                   ");
		System.out.println("     a   b   c  ");
		System.out.println();
	}

	public void update(Move m) {
		moveCounter++;
		lastMovePlayed = m;
		
		int row = (int) ('3' - m.toString().charAt(1));
		int col = (int) (m.toString().charAt(0) - 'a');
				
		board[row][col] = m.symbol();
	}

	public List<Move> getAvailableMoves(Player p) {
		
		ArrayList<Move> moves = new ArrayList<Move>();
		
		for (int row=0; row<LEN; ++row) {
			for (int col=0; col<LEN; ++col) {
				if (board[row][col] == ' ') {
					String movestr = String.format("%c%c", 'a' + col, '3' - row);
					moves.add(new Move(p, movestr));
				}
			}
		}
		return moves;
	}
	

	public boolean isGameOver() {
		return (getWinner() != null) || (isGameDrawn());
	}
	
	public boolean isGameDrawn() {
		return (getWinner() == null) && (isFull());
	}

	public Player getWinner() {
		for (int i=0; i<LEN; ++i) {
			if (checkWinOnRow(i)) return lastMovePlayed.player();
			if (checkWinOnCol(i)) return lastMovePlayed.player();
		}
		if (checkWinOnDiagonal_a3_c1()) return lastMovePlayed.player();
		if (checkWinOnDiagonal_a1_c3()) return lastMovePlayed.player();
		
		return null;
	}
	
	private boolean checkWinOnRow(int rownum) {
		for (int i=0; i<LEN; ++i)
			if (board[rownum][i] != lastMovePlayed.symbol())
				return false;
		
		return true;
	}
	private boolean checkWinOnCol(int colnum) {
		for (int i=0; i<LEN; ++i)
			if (board[i][colnum] != lastMovePlayed.symbol())
				return false;
		
		return true;
	}

	private boolean checkWinOnDiagonal_a3_c1() {
		for (int i=0; i<LEN; ++i)
			if (board[i][i] != lastMovePlayed.symbol())
				return false;
		
		return true;
	}

	private boolean checkWinOnDiagonal_a1_c3() {
		for (int i=0; i<LEN; ++i)
			if (board[i][LEN - 1 - i] != lastMovePlayed.symbol())
				return false;
		
		return true;
	}
	
	private boolean isFull() {
		return moveCounter == 9;		
	}
}
