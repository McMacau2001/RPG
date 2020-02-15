package game.Entities.Player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import game.Entities.Entity;
import game.Game.Game;
import game.Images.BufferedImageLoader;
import game.Images.Sprite;
import game.Images.SpriteAnimation;
import game.Images.SpriteSheet;

public final class Player implements Entity {

	private double x;
	private double y;
	
	private double velx;
	private double vely;
	
	private BufferedImage image;
	
	private Sprite right;
	private Sprite left;
	private Sprite down;
	private Sprite up;
	
	private SpriteAnimation animation;

	public Player(Game game, double x, double y) {
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		image = ss.grabImage(2, 1);
		
		//CARREGAR OS SPRITES
		BufferedImageLoader loader = new BufferedImageLoader();
		
		right = new Sprite(loader.loadImage("walking_right.png"),3);
		left = new Sprite(loader.loadImage("walking_left.png"),3);
		down = new Sprite(loader.loadImage("walking_down.png"),3);
		up = new Sprite(loader.loadImage("walking_up.png"),3);
		
		animation = new SpriteAnimation(down, 4);
		animation.setActive(false);
	}

	@Override
	public void tick() {
		x+=velx;
		y+=vely;
		
		animation.runAnimation();
		
		//Update Animations
		if(velx == 0 && vely == 0) 
			animation.setActive(false);
		else if(velx < 0) 
			animation.setSprite(left);
		else if(velx > 0) 
			animation.setSprite(right);	
		else if(vely < 0) 
			animation.setSprite(up);
		else if(vely > 0) 
			animation.setSprite(down);
	}

	@Override
	public void render(Graphics g) {
		//g.drawImage(image, (int)x, (int)y, null);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.scale(2, 2);
		animation.drawAnimation(g, (int)x, (int)y, 0);
	}
	
	public void moveX(int x) {
		if(x != 0)
			this.vely = 0;
		this.velx = x;
	}
	
	public void moveY(int y) {
		if(y != 0)
			this.velx = 0;
		this.vely = y;
	}
	
}
