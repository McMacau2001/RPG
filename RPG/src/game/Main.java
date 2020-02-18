package game;

import game.Game.Game;


public class Main {

	public static final int WIDTH = 420;
	public static final int HEIGHT = WIDTH / 12 *9;
	public static final int SCALE = 2;
	public static final float ZOOM = 1f;
	public static final String TITLE = "RPG Game";
	
	public static final int SPRITESIZE = 64;
	
	/*
	 * FUNÇÃO RESPNSÁVEL POR INCIAR O PROGRAMA 
	 */
	
	public static void main(String args[]) {
		
		//INSTANCIA DO JOGO
		Game game = new Game();
		game.start();
		
		
	}
	
}
