package tris;

import java.util.List;
import java.util.Random;

public abstract class Player 
{
	private String name;
	private char symbol;
	
	Player(String name, char symbol) 
	{
		this.name = name;
		this.symbol = symbol;
	}
	
	char getSymbol() 
	{
		return symbol;
	}
	
	public abstract Move play(Board board);
	
	public String getName() 
	{
		return name;
	}
}

class HumanPlayer extends Player {

	HumanPlayer(String name, char symbol) {
		super(name, symbol);
	}
	
	public Move play(Board board) {
		return TrisUI.readMove(this);
	}
}

class AIPlayer extends Player {

	AIPlayer(String name, char symbol) {
		super(name, symbol);
	}
	
	public Move play(Board board) {
		List<Move> moves = board.getAvailableMoves(this);
		
		Random rand = new Random();
	    Move randomMove = moves.get(rand.nextInt(moves.size()));
		return randomMove;
	}
}
