package game;

import game.Game.Game;

public class Main {

	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 *9;
	public static final int SCALE = 2;
	public static final String TITLE = "RPG Game";
	
	/*
	 * FUNÇÃO RESPNSÁVEL POR INCIAR O PROGRAMA 
	 */
	
	public static void main(String args[]) {
		
		//INSTANCIA DO JOGO
		Game game = new Game();
		game.start();
		
		
	}
	
}
