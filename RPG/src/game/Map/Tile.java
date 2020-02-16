package game.Map;


public class Tile {

	private int x;
	private int y;
	
	private int image;
	
	public Tile(int image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
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
	
}
