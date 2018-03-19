package tris;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TrisFactory {

	public static Match getMatchInstance(Properties properties) throws FileNotFoundException, IOException {
		MatchView view = new MatchView(properties);
		Match model = new Match(properties);
		new MatchController(model, view);
		return model;
	}
	
	public static Board getBoardInstance() {
		BoardView view = new BoardView();
		Board model = new Board();
		new BoardController(model, view);
		return model;
	}
}
