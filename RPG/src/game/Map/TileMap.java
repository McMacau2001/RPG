package game.Map;

public class TileMap {

	private Tile[] basetiles;
	private Tile[] colidetiles;
	private Tile[] objecttiles;
	
	private String mappath;
	
	public TileMap(String mappath) {
		this.mappath = mappath;
	}
	
}
