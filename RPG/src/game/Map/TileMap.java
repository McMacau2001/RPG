package game.Map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import game.Images.SpriteSheet;
import game.Map.TiledMap.TiledMap;

public class TileMap {

	private TiledMap map;
	
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<BufferedImage> images = new ArrayList<BufferedImage>();
	
	public TileMap(TiledMap map) {
		this.map = map;
		
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
				
				
				tiles.add(new Tile(data[d], x, y));
				x++;
				
			}
			
		});
		
		//Load Images
		map.getTilesets().forEach(a-> {
			SpriteSheet ss = new SpriteSheet(a.getTiledsource().getImage());
			//BufferedImage[] images = new BufferedImage[a.getTiledsource().getTilecount()];
			

			int index = 0;
			for(int row = 0 ;  row < a.getTiledsource().getRows(); row++) {
				for(int col = 0 ;  col < a.getTiledsource().getColumns(); col++) {
					images.add(ss.grabImage(col * a.getTiledsource().getTilewidth(), row * a.getTiledsource().getTileheight(), a.getTiledsource().getTilewidth(), a.getTiledsource().getTileheight()));
					index++;
				}
			}
			
		});
		
	}
	
	public void render(Graphics g) {
		
		tiles.forEach(t-> {
			
			if(t.getImage()!=0)
				g.drawImage(images.get(t.getImage()-1), t.getX()*map.getTilewidth(), t.getY()*map.getTileheight(), map.getTilewidth(), map.getTileheight(), null);
		});
	}
	
}
