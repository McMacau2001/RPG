package game.Entities.Player;

import java.awt.Graphics;

import game.Entities.Entity;
import game.Game.Game;
import game.Images.ImageLoader;
import game.Images.SpriteImage;
import game.Images.SpriteAnimation;

public final class Player implements Entity {

	private Game game;
	
	private double x;
	private double y;
	
	private double velx;
	private double vely;
	
	private SpriteImage right;
	private SpriteImage left;
	private SpriteImage down;
	private SpriteImage up;
	
	private SpriteAnimation animation;

	public Player(Game game, double x, double y) {
		this.game = game;
		
		this.x = x;
		this.y = y;
		
		//CARREGAR OS SPRITES
		ImageLoader loader = new ImageLoader();
		
		right = new SpriteImage(loader.loadImage("player/walking_right.png"),3);
		left = new SpriteImage(loader.loadImage("player/walking_left.png"),3);
		down = new SpriteImage(loader.loadImage("player/walking_down.png"),3);
		up = new SpriteImage(loader.loadImage("player/walking_up.png"),3);
		
		animation = new SpriteAnimation(down, 4);
		animation.setActive(false);
	}

	@Override
	public void tick() {
		x+=velx;
		y+=vely;
		
		game.getGameCamera().centerOnLocation((int)x,(int) y);
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
		animation.drawAnimation(g, (int)x- game.getGameCamera().getxOffset(), (int)y- game.getGameCamera().getyOffset(), 0);
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
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
}
