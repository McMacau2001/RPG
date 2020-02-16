package game;

import game.Game.Game;
import game.Map.TiledMap.TiledMap;
import game.Map.TiledMap.TiledMapLoader;

public class Main {

	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 *9;
	public static final int SCALE = 2 ;
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
