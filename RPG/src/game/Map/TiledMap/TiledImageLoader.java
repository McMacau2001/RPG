package game.Map.TiledMap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class TiledImageLoader {
	
	private BufferedImage image; 
	
	public BufferedImage loadImage(String path) {
		path = (System.getProperty("user.dir")+"/resources/rooms/"+path).replace("\\/", "\\");
		
		try {image = ImageIO.read(new File(path));
		} catch (IOException e) {e.printStackTrace();}
		
		return image;
	}

}
