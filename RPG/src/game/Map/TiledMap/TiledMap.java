package game.Map.TiledMap;

import java.util.List;

public class TiledMap {
	
	private int height;
	private int width;
	
	private int tileheight;
	private int tilewidth;
	
	private String orientation;
	
	private List<TileSet> tilesets;
	private List<TiledLayer> layers;
	
	//INICIA O OBJETO 
	public void init() {
		tilesets.forEach(x-> x.init());
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
	
	public List<TileSet> getTilesets() {
		return tilesets;
	}
	
	public List<TiledLayer> getLayers() {
		return layers;
	}
	
}
