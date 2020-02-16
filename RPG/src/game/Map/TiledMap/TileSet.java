package game.Map.TiledMap;

public class TileSet {

	private String firstgid;
	private String source;
	
	private TiledSetSource tiledsource;
	
	public void init() {
		TiledSetLoader loader = new TiledSetLoader();
		tiledsource = loader.loadTiledMap(source);
		tiledsource.init();
	}
	
	public String getFirstgid() {
		return firstgid;
	}
	
	public String getSource() {
		return source;
	}
	
	public TiledSetSource getTiledsource() {
		return tiledsource;
	}
	
}
