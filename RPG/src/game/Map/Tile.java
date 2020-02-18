package game.Map;

import java.awt.Rectangle;

public class Tile {

	private int x;
	private int y;
	
	private int image;
	
	private Rectangle bounds;
	
	public Tile(int image, int x, int y, int width, int height) {
		this.image = image;
		
		this.x = x;
		this.y = y;
		
		this.bounds = new Rectangle(x*width, y*height, width, height);
	}
	
	public int getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
}
