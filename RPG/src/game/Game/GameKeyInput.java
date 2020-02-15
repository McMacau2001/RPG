package game.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyInput extends KeyAdapter {

	private Game game;
	
	public GameKeyInput(Game game) {
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		game.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		game.keyReleased(e);
	}
}
