package game.Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import game.Main;
import game.Game.Game;
import game.Images.SpriteSheet;
import game.Map.Render.QuadTree;
import game.Map.TiledMap.TiledMap;

public class TileMap {

	private Game game;
	
	private TiledMap map;
	private QuadTree qtree;
	
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<BufferedImage> images = new ArrayList<BufferedImage>();
	
	private List<Tile> rendertiles = new ArrayList<Tile>();
	
	public TileMap(Game game, TiledMap map) {
		this.game = game;
		this.map = map;
		
		this.qtree = new QuadTree(new Rectangle(0,0,map.getWidth()*map.getTilewidth(),map.getHeight()*map.getTileheight()), 20);
		
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
		rendertiles = qtree.query(new Rectangle(
				(int)game.getGameCamera().getxOffset() - 25, 
				(int)game.getGameCamera().getyOffset() - 25, 
				(int)((Main.WIDTH * Main.SCALE) / Main.ZOOM) + 50, 
				(int)((Main.HEIGHT * Main.SCALE) / Main.ZOOM) + 50), null);
	}
	
	public void render(Graphics g) {
		rendertiles.forEach(t-> {
			if(t.getImage()!=0)
				g.drawImage(images.get(t.getImage()-1), 
						(int)(t.getX()*map.getTilewidth() - game.getGameCamera().getxOffset()), 
						(int)(t.getY()*map.getTileheight() - game.getGameCamera().getyOffset()), 
						map.getTilewidth(), 
						map.getTileheight(), null);
		});
		
	}
	
}
