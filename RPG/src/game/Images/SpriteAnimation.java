package game.Images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteAnimation {

	private int speed;
	private int frames;
	

	private int index = 0;
	private int count = 0;

	private BufferedImage[] images;
	private BufferedImage currentImage;
	
	private boolean active;

	public SpriteAnimation(Sprite sprite, int speed) {
		this.speed = speed;
		
		frames = sprite.getFrames();
		images = sprite.getImages();
		active = true;
	}

	public void nextFrame() {
		if(!active && count == 0)return;
		
		currentImage = images[count];
		count++;

		if (count >= frames - 1) 
			count = 0;
	}

	public void runAnimation() {
		index++;
		
		if (index > speed) {
			index = 0;
			nextFrame();
		}

	}


	public void drawAnimation(Graphics g, double x, double y, int offset) {
		g.drawImage(currentImage, (int) x - offset, (int) y, null);
	}
	
	
	public void setSprite(Sprite sprite) {
		frames = sprite.getFrames();
		images = sprite.getImages();
		
		active = true;
	}

	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	
}