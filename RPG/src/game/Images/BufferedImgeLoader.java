package game.Images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImgeLoader {

	private BufferedImage image;
	
	public BufferedImage loadImage(String path) throws IOException {
		path = (System.getProperty("user.dir")+"/resources/"+path).replace("/", "\\");
		image = ImageIO.read(new File(path));
		return image;
	}
}
