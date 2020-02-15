package game.Entities.Player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Entities.Entity;
import game.Game.Game;
import game.Images.SpriteSheet;

public final class Player implements Entity {

	private double x;
	private double y;
	
	private double velx;
	private double vely;
	
	private BufferedImage image;
	

	
	public Player(Game game, double x, double y) {
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		image = ss.grabImage(1, 1);
	}

	@Override
	public void tick() {
		x+=velx;
		y+=vely;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	public void moveX(int x) {
		this.velx = x;
	}
	
	public void moveY(int y) {
		this.vely = y;
	}
	
}
