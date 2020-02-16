package game.Map.TiledMap;

public class TileLayer {

	private int id;
	private String name;
	private String type;
	
	private int[] data;
	
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private boolean visible;
	
	public TileLayer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int[] getData() {
		return data;
	}
}
