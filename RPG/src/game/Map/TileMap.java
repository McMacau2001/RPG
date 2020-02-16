package game.Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import game.Images.SpriteSheet;
import game.Map.Render.QuadTree;
import game.Map.TiledMap.TiledMap;

public class TileMap {

	private TiledMap map;
	private QuadTree qtree;
	
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<BufferedImage> images = new ArrayList<BufferedImage>();
	
	private List<Tile> rendertiles = new ArrayList<Tile>();
	
	public TileMap(TiledMap map) {
		this.map = map;
		
		this.qtree = new QuadTree(new Rectangle(0,0,map.getWidth()*map.getTilewidth(),map.getHeight()*map.getTileheight()), 6);
		
		//Load Layers
		map.getLayers().forEach(a-> {
			int[] data = a.getData();
			
			int x = 0;
			int y = 0;
			
			for(int d = 0 ; d<data.length; d++) {
				if(x>=map.getWidth()) {
					x= 0 ;
					y++;
				}
				
				Tile t = new Tile(data[d], x, y, map.getTilewidth(), map.getTileheight());
				//tiles.add(t);
				
				qtree.insert(t);
				x++;
				
			}
			
		});
		
		//Load Images
		map.getTilesets().forEach(a-> {
			SpriteSheet ss = new SpriteSheet(a.getTiledsource().getImage());
			
			int index = 0;
			for(int row = 0 ;  row < a.getTiledsource().getRows(); row++) {
				for(int col = 0 ;  col < a.getTiledsource().getColumns(); col++) {
					images.add(ss.grabImage(col * a.getTiledsource().getTilewidth(), row * a.getTiledsource().getTileheight(), a.getTiledsource().getTilewidth(), a.getTiledsource().getTileheight()));
					index++;
				}
			}
			
		});
		
	}
	
	public void setRendertiles(int x, int y) {
		rendertiles = qtree.query(new Rectangle(x-2*map.getTilewidth(), y-2*map.getTileheight(), map.getTilewidth()*7, map.getTileheight()*7), null);
	}
	
	public void render(Graphics g) {
		rendertiles.forEach(t-> {
			if(t.getImage()!=0)
				g.drawImage(images.get(t.getImage()-1), t.getX()*map.getTilewidth(), t.getY()*map.getTileheight(), map.getTilewidth(), map.getTileheight(), null);
		});
		
	}
	
}
