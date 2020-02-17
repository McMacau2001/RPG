package game.Map.Camera;

import game.Main;
import game.Entities.Entity;
import game.Entities.Player.Player;
import game.Game.Game;

public class Camera {
	
	private Game game;
	
	private float xOffset;
	private float yOffset;
	
	public Camera(Game game, float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void move(float x, float y) {
		this.xOffset += x;
		this.yOffset += y;
	}
	
	public void centerOnLocation(int x, int y) {
		xOffset = (float)x - (Main.WIDTH * Main.SCALE / 2) / Main.ZOOM;
		yOffset = (float)y - (Main.HEIGHT * Main.SCALE / 2) / Main.ZOOM;
	}
	
	public float getxOffset() {
		return xOffset;
	}
	
	public float getyOffset() {
		return yOffset;
	}

}
