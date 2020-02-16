package game.Map;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Tile {

	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private int image;
	
	public Tile(int image, int x, int y, int width, int height) {
		this.image = image;
		
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
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
		return new Rectangle(x*width, y*height, width, height);
	}
	
}
