package tris;

public class BoardController {

	private Board model;
	private BoardView view;
	
	public BoardController(Board model, BoardView view) {
		this.model = model;
		this.view = view;
		model.subscribe(this);
	}

	public void notifyGameStart() throws InterruptedException {
		view.display(model);
	}
	public void notifyBoardUpdate() throws InterruptedException {
		view.display(model);
	}
}
