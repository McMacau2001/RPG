package game.Images;

import java.awt.image.BufferedImage;

public class SpriteImage {
	
	private BufferedImage[] images;
	private int frames;
	private BufferedImage image;
	
	public SpriteImage(BufferedImage image, int frames) {
		this.image = image;
		this.frames = frames;
		this.images = new BufferedImage[frames];
		
		fillSprites();
	}
	
	public void fillSprites() {

		SpriteSheet ss = new SpriteSheet(image);
		int width = image.getWidth() / frames; 
		int height = image.getHeight();
		
		for (int i = 0, k = 0; i < frames; i++, k++)
			images[k] = ss.grabImage(width * i, 0, width, height);
	}
	
	public int getFrames() {
		return frames;
	}
	
	public BufferedImage[] getImages() {
		return images;
	}
	
}
