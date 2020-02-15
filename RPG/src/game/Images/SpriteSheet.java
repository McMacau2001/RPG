package game.Images;

import java.awt.image.BufferedImage;

import game.Main;

public class SpriteSheet {

	private BufferedImage image;
	
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage grabImage(int col, int row) {
		
		BufferedImage img = image.getSubimage((col-1) * Main.SPRITESIZE,(col-1) * Main.SPRITESIZE, Main.SPRITESIZE, Main.SPRITESIZE);	
		return img;
	}
	
}
