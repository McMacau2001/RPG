package game.Map.TiledMap;

import java.awt.image.BufferedImage;


public class TiledSetSource {

	private int columns;
	
	private int tilewidth;
	private int tileheight;
	
	private int tilecount;
	
	private String image;
	private BufferedImage img;
	
	public void init() {
		TiledImageLoader loader = new TiledImageLoader();
		img = loader.loadImage(image);
	}
	
	public int getColumns() {
		return img.getWidth()/tilewidth;
	}
	
	public int getRows() {
		return img.getHeight()/tileheight;
	}
	
	public int getTilecount() {
		return tilecount;
	}
	
	public BufferedImage getImage() {
		return img;
	}
	
	
	public int getTileheight() {
		return tileheight;
	}
	
	public int getTilewidth() {
		return tilewidth;
	}
}
