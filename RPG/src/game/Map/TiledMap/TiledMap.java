package game.Map.TiledMap;

import java.util.List;

public class TiledMap {
	
	private int height;
	private int width;
	
	private int tileheight;
	private int tilewidth;
	
	private String orientation;
	
	private List<TileSets> tilesets;
	private List<TileLayer> layers;
	
	public TiledMap() {

	}

	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public String getOrientation() {
		return orientation;
	}
	
	public int getTileheight() {
		return tileheight;
	}
	
	public int getTilewidth() {
		return tilewidth;
	}
	
	public List<TileSets> getTilesets() {
		return tilesets;
	}
	
	public List<TileLayer> getLayers() {
		return layers;
	}
}
