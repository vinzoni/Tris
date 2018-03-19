package tris;

public class BoardView {

	static final int DISPLAY_BOARD_DURATION_MILLIS = 1000;

	public void display(Board board) throws InterruptedException {
		System.out.println();
		System.out.println("                   ");
		System.out.println(" 3   " + board.get(0,0) + " | " + board.get(0,1) + " | " + board.get(0,2) + "  ");
		System.out.println("    --- --- --- ");
		System.out.println(" 2   " + board.get(1,0) + " | " + board.get(1,1) + " | " + board.get(1,2) + "  ");
		System.out.println("    --- --- --- ");
		System.out.println(" 1   " + board.get(2,0) + " | " + board.get(2,1) + " | " + board.get(2,2) + "  ");
		System.out.println("                   ");
		System.out.println("     a   b   c  ");
		System.out.println();
		
		Thread.sleep(DISPLAY_BOARD_DURATION_MILLIS);
	}
}
